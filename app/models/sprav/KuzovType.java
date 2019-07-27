package models.sprav;


import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class KuzovType extends Model {

    @NotNull
    public String name;

    public String description;
}
