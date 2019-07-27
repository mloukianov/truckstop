package notifiers;

import models.User;
import play.libs.Codec;
import play.mvc.Mailer;

public class Mails extends Mailer {

    public static void confirmation(User user) {

        String uuid = Codec.UUID();
        user.uuid = uuid;
        user.save();

        setFrom("Registration <register@truckslot.com>");
        setSubject("Confirm your registration at TruckSlot");
        addRecipient(user.email);
        send(user, uuid);
    }


    public static void welcome(User user) {

        setFrom("Registration <register@truckslot.com>");
        setSubject("Welcome to TruckSlot!");
        addRecipient(user.email);
        send(user);
    }


    public static void forgotPassword(User user) {

        String uuid = Codec.UUID();
        user.uuid = uuid;
        user.save();

        setFrom("Registration <register@truckslot.com>");
        setSubject("Reset your password at www.truckslot.com");
        addRecipient(user.email);
        send(user, uuid);
    }


    public static void unlockAccount(User user) {

        String uuid = Codec.UUID();
        user.uuid = uuid;
        user.save();

        setFrom("Registration <register@truckslot.com>");
        setSubject("Reset your password at www.truckslot.com");
        addRecipient(user.email);
        send(user, uuid);
    }
}
