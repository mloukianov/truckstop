package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import models.vendor.VendorInfo;
import play.db.jpa.Model;

@Entity
public class Vendor extends Model {

    public String name;

    public String description;

    @OneToMany
    public List<Vehicle> venicles;

    @ManyToOne
    public Exchange exchange;

    @OneToOne
    public VendorInfo vendorInfo;

    public Integer vendorScore;
}
