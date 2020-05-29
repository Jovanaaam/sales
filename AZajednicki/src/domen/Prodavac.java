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
public class Prodavac extends OpstiDomenskiObjekat{
    private String prodavacID;
    private String imePrezime;
    private String brojTelefona;
    private String adresa;
   
    private Opstina opstina;

    public Prodavac() {
    }

    public Prodavac(String prodavacID, String imePrezime, String brojTelefona, String adresa, Opstina opstina) {
        this.prodavacID = prodavacID;
        this.imePrezime = imePrezime;
        this.brojTelefona = brojTelefona;
        this.adresa = adresa;
        this.opstina = opstina;
    }
    public Prodavac(String prodavacID, String imePrezime, String brojTelefona, String adresa, String opstinaID) {
        this.prodavacID = prodavacID;
        this.imePrezime = imePrezime;
        this.brojTelefona = brojTelefona;
        this.adresa = adresa;
        this.opstina = new Opstina(opstinaID);
    }

    public Prodavac(String prodavacID) {
        this.prodavacID = prodavacID;
    }

    @Override
    public String toString() {
        return imePrezime + " Opstina: " + opstina.getNazivOpstine();
    }

    public String getProdavacID() {
        return prodavacID;
    }

    public void setProdavacID(String prodavacID) {
        this.prodavacID = prodavacID;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Opstina getOpstina() {
        return opstina;
    }

    public void setOpstina(Opstina opstina) {
        this.opstina = opstina;
    }

    @Override
    public String vratiImeTabele() {
       return "prodavac";
    }

    @Override
    public String vratiParametre() {
       return String.format("'%s','%s','%s','%s','%s'", prodavacID, imePrezime, brojTelefona, adresa, opstina.getOpstinaID());
    }

    @Override
    public String vratiPK() {
        return "prodavacID";
    }

    @Override
    public String vratiVrednostPK() {
       return prodavacID;
    }

    @Override
    public String vratiSlozenPK() {
       return null;
    }

    @Override
    public List<OpstiDomenskiObjekat> RSuListu(ResultSet rs) throws SQLException {
           List<OpstiDomenskiObjekat> prodavci = new ArrayList<>();
        while (rs.next()) {
            String prodavacID1 = rs.getString("prodavacID");
            String imePrez = rs.getString("imePrezime");
            String brojTele = rs.getString("brojTelefona");
            String adresa1 = rs.getString("adresa");
            String opstinaID1 = rs.getString("opstinaID");
            prodavci.add(new Prodavac(prodavacID1, imePrez, brojTele, adresa1, opstinaID1));
        }
        return prodavci;
    }

    @Override
    public String vratiUpdate() {
      return String.format("prodavacID='%s',imePrezime='%s',brojTelefona='%s',adresa='%s',opstinaID='%s'", prodavacID,imePrezime,brojTelefona, adresa,opstina.getOpstinaID());
    }

    @Override
    public void postaviVrednostPK(String pk) {
       this.prodavacID = pk;
    }
  
   
}
