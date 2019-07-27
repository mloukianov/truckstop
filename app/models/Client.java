package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Client extends Model {

    @ManyToOne
    public User user;

    public String name;

    public String description;

    @ManyToOne
    public Exchange exchange;
}
