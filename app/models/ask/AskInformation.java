package models.ask;

import models.sprav.TipGruza;
import models.sprav.Upakovka;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class AskInformation extends Model {

    @ManyToOne
    public TipGruza tipGruza;

    @ManyToOne
    public Upakovka upakovka;

    @OneToOne
    public Kolihestvo koluchestvo;

    @OneToOne
    public Obem obem;

    public String adresPogruzki;

    public String adresVygruzki;

    public String additionalInfo;
}
