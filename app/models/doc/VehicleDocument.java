package models.doc;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class VehicleDocument extends Model {

    @NotNull
    public String name;

    public String description;

    public String fileUrl;
}
