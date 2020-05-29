/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class StavkaProdaje extends OpstiDomenskiObjekat{
    private String stavkaID;
    private ObavljenaProdaja obavljenaProdaja;
    private int rb;
    private double kolicina;
    private double iznos;
    private String jm;
    private Proizvod proizvod;
    public StavkaProdaje() {
    }

    public StavkaProdaje(String stavkaID, ObavljenaProdaja obavljenaProdaja, int rb, double kolicina, double iznos, String jm, Proizvod proizvod) {
        this.stavkaID = stavkaID;
        this.obavljenaProdaja = obavljenaProdaja;
        this.rb = rb;
        this.kolicina = kolicina;
        this.iznos = iznos;
        this.jm = jm;
        this.proizvod = proizvod;
    }
      public StavkaProdaje(String stavkaID, String prodajaID, int rb, double kolicina, double iznos, String jm, String proizvodID) {
        this.stavkaID = stavkaID;
        this.obavljenaProdaja = new ObavljenaProdaja(prodajaID);
        this.rb = rb;
        this.kolicina = kolicina;
        this.iznos = iznos;
        this.jm = jm;
        this.proizvod = new Proizvod(proizvodID);
    }
    public StavkaProdaje(int rb, double kolicina, double iznos, String jm, Proizvod proizvod) {
        this.rb = rb;
        this.kolicina = kolicina;
        this.iznos = iznos;
        this.jm = jm;
        this.proizvod = proizvod;
    }

      public StavkaProdaje(String stavkaID, int rb, double kolicina, double iznos, String jm, Proizvod proizvod) {
        this.stavkaID = stavkaID;

        this.rb = rb;
        this.kolicina = kolicina;
        this.iznos = iznos;
        this.jm = jm;
        this.proizvod = proizvod;
    }
   

   

   
    public String getJm() {
        return jm;
    }

    public void setJm(String jm) {
        this.jm = jm;
    }

   
    public ObavljenaProdaja getObavljenaProdaja() {
        return obavljenaProdaja;
    }

    public void setObavljenaProdaja(ObavljenaProdaja obavljenaProdaja) {
        this.obavljenaProdaja = obavljenaProdaja;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public double getKolicina() {
        return kolicina;
    }

    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }

    public String getStavkaID() {
        return stavkaID;
    }

    public void setStavkaID(String stavkaID) {
        this.stavkaID = stavkaID;
    }

    @Override
    public String vratiImeTabele() {
        return "stavka_prodaje";
    }

    @Override
    public String vratiParametre() {
         return String.format("'%s','%s','%s','%s','%s','%s','%s'", stavkaID, obavljenaProdaja.getProdajaID(),rb, kolicina, iznos, jm, proizvod.getProizvodID());
    }

    @Override
    public String vratiPK() {
        return null;
    }

    @Override
    public String vratiVrednostPK() {
        return null;
    }

    @Override
    public String vratiSlozenPK() {
        return String.format("stavkaID='%s' AND prodajaID='%s'", stavkaID, obavljenaProdaja.getProdajaID());
    }

    @Override
    public List<OpstiDomenskiObjekat> RSuListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> stavke = new ArrayList<>();
        while (rs.next()) {
            String stavkaID1 = rs.getString("stavkaID");
            String prodajaID1 = rs.getString("prodajaID");
            int rb1 = rs.getInt("rb");
            double kolicina1 = rs.getDouble("kolicina");
            double iznos1 = rs.getDouble("iznos");
              String jm1 = rs.getString("jm");
            String proizvodID1 = rs.getString("proizvodID");
            stavke.add(new StavkaProdaje(stavkaID1, prodajaID1, rb1, kolicina1, iznos1, jm1, proizvodID1));
        }
        return stavke;
    }

    @Override
    public String vratiUpdate() {
         return String.format("stavkaID='%s',prodajaID='%s',rb='%s',kolicina='%s',iznos='%s',jm='%s',proizvodID='%s'", stavkaID, obavljenaProdaja.getProdajaID(),rb, kolicina, iznos, jm, proizvod.getProizvodID());
    }

    @Override
    public void postaviVrednostPK(String pk) {
        
    }
    
    
}
