package models.vendor;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class VendorInfo extends Model {

    public String adresRegistratsii;

    public String INN;

    public String fioPodpisanta;

    @OneToMany
    public List<ContactInfo> contacts;
}
