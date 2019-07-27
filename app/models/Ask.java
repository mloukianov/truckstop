package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import models.ask.AskInformation;
import play.db.jpa.Model;

@Entity
public class Ask extends Model {

    @ManyToOne
    public Client client;

    @ManyToOne
    public MasterContract mssterContract;

    public Date created;

    @OneToMany
    public List<Bid> bids;

    @OneToOne
    public AskInformation askInfo;

}
