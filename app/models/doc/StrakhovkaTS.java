package models.doc;

import models.sprav.StrakhovkaTSType;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class StrakhovkaTS extends Model {

    public String description;

    @ManyToOne
    public StrakhovkaTSType strakhovkaTSType;

}
