package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class SpotContract extends Model {

    @ManyToOne
    public Client client;

    @ManyToOne
    public Vendor vendor;

    public String name;

    public String description;
}
