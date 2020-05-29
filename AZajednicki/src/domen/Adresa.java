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
public class Adresa extends OpstiDomenskiObjekat{
    private String adresaID;
    private String naziv;
    private String broj;
    private Opstina opstina;

    public Adresa() {
    }

    public Adresa(String adresaID, String naziv, String broj, Opstina opstina) {
        this.adresaID = adresaID;
        this.naziv = naziv;
        this.broj = broj;
        this.opstina = opstina;
    }
      public Adresa(String adresaID, String naziv, String broj, String opstinaID) {
        this.adresaID = adresaID;
        this.naziv = naziv;
        this.broj = broj;
        this.opstina = new Opstina(opstinaID);
    }

    public Opstina getOpstina() {
        return opstina;
    }

    public void setOpstina(Opstina opstina) {
        this.opstina = opstina;
    }

  

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }
 public String getAdresaID() {
        return adresaID;
    }

    public void setAdresaID(String adresaID) {
        this.adresaID = adresaID;
    }
    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String vratiImeTabele() {
       return "adresa";
    }

    @Override
    public String vratiParametre() {
       return String.format("'%s','%s','%s','%s'", adresaID,naziv,broj,opstina.getOpstinaID());
    }

    @Override
    public String vratiPK() {
        return "adresaID";
    }

    @Override
    public String vratiVrednostPK() {
       return adresaID;
    }

    @Override
    public String vratiSlozenPK() {
        return null;
    }

    @Override
    public List<OpstiDomenskiObjekat> RSuListu(ResultSet rs) throws SQLException {
         List<OpstiDomenskiObjekat> adrese = new ArrayList<>();
        while(rs.next()){
            String adresaID1 = rs.getString("adresaID");
            String naziv1 = rs.getString("naziv");
            String broj1 = rs.getString("broj");
            String opstinaID1 = rs.getString("opstinaID");
            adrese.add(new Adresa(adresaID1, naziv1, broj1, opstinaID1));
        }
        return adrese;
    }

    @Override
    public String vratiUpdate() {
       return String.format("adresaID='%s', naziv='%s', broj='%s', opstinaID = '%s'", adresaID, naziv, broj, opstina.getOpstinaID());
    }

    @Override
    public void postaviVrednostPK(String pk) {
      this.adresaID = pk;
    }

   
    
    
    
    
    
}
