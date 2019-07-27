package models.ask;

import models.units.ObemType;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Obem extends Model {

    @NotNull
    public Integer amount;

    @ManyToOne
    public ObemType unit;
}
