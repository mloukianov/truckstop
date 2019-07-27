package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Bid extends Model {

    @ManyToOne
    public Ask ask;

    public String name;

    @ManyToOne
    public Vendor vendor;

    public Date created;

    public Integer amount;
}
