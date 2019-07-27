package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Transient;

import play.data.validation.Email;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;
import play.libs.Codec;

@Entity
public class User extends Model {

    public static final String CREATED = "CREATED";
    public static final String CONFIRMED = "CONFIRMED";
    public static final String PROFILE = "PROFILE";
    public static final String VERIFIED = "APPROVED";

    public static final int MAX_LOGIN_ATTEMPTS = 6;


    @Required
    @Email
    public String email;

    public String name;

    public String description;

    @Transient
    public String password;

    public String uuid;

    public String stage = CREATED;

    public Date createdDate;

    public Integer failedLoginAttempts = 0;

    public Boolean locked = false;

    public void setPassword(String password) {
        this.password = password;
        this.passwordHash = Codec.hexMD5(password);
    }

    public String getPassword() {
        return this.password;
    }

    @Required
    @MinSize(8)
    public String passwordHash;

    public String resetToken;


    /**
     * Used to return user for given email and password (password internally hashed to MD5)
     * Returns null, if user is not found; first found User otherwise
     *
     * @param email  user email
     * @param password  user password
     *
     * @return
     */
    public static User connect(String email, String password) {

        if (User.count("byEmail", email) > 0) {

            User user = User.find("byEmail", email).first();

            if (User.count("byEmailAndPasswordHash", email, Codec.hexMD5(password)) == 0) {
                user.failedLoginAttempts = user.failedLoginAttempts + 1;
                if (user.failedLoginAttempts > MAX_LOGIN_ATTEMPTS) {
                    user.locked = true;
                    user.save();
                    return null;
                }
            } else {
                user.failedLoginAttempts = 0;
            }

            user.save();
        }

        return User.find("byEmailAndPasswordHash", email, Codec.hexMD5(password)).first();
    }
}
