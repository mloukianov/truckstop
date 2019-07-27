package models.driver;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class DriverInfo extends Model {

    @NotNull
    public String name;

    public String description;
}
