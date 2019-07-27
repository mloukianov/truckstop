package models.ask;

import models.units.KolichestvoType;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Kolihestvo extends Model {

    @NotNull
    public Integer amount;

    @ManyToOne
    public KolichestvoType unit;
}
