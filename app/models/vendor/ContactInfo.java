package models.vendor;

import play.db.jpa.Model;

import javax.persistence.Entity;

@Entity
public class ContactInfo extends Model {

    public String fio;

    public String phone;

    public String email;

    public String address;
}
