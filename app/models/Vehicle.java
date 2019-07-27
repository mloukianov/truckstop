package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import models.doc.StrakhovkaTS;
import models.doc.VehicleDocument;
import models.driver.DriverInfo;
import models.sprav.*;
import play.db.jpa.Model;

import java.util.List;

@Entity
public class Vehicle extends Model {

    public String name;

    public String description;

    public String yearManufactured;

    @ManyToOne
    public KuzovType kuzovType;

    @ManyToOne
    public KolichestvoOsej kolichestvoOsej;

    @ManyToOne
    public OsevayaNagruzka osevayaNagruzka;

    @ManyToOne
    public KolesnayaFormula kolesnayaFormula;

    @ManyToOne
    public Gruzopodemnost gruzopodemnost;

    @ManyToOne
    public KuzovKuzovType kuzovKuzovType;

    @ManyToOne
    public FormaSobstvennosti formaSobstvennosti;

    @OneToOne
    public StrakhovkaTS strakhovkaTS;

    @ManyToOne
    public DriverInfo driver;

    @OneToMany
    public List<VehicleDocument> vehicleDocs;
}
