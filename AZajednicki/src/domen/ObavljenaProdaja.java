/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class ObavljenaProdaja extends OpstiDomenskiObjekat{
    private String prodajaID;
    private Date datumProdaje;
    private double ukupanIznosProdaje;
    private Prodavac prodavac;
    private ArrayList<StavkaProdaje> listaStavki;

    public ObavljenaProdaja() {
    }
 public ObavljenaProdaja(String prodajaID) {
        this.prodajaID = prodajaID;
        
    }
    public ObavljenaProdaja(String prodajaID, Date datumProdaje, double ukupanIznosProdaje, Prodavac prodavac, ArrayList<StavkaProdaje> listaStavki) {
        this.prodajaID = prodajaID;
        this.datumProdaje = datumProdaje;
        this.ukupanIznosProdaje = ukupanIznosProdaje;
        this.prodavac = prodavac;
        this.listaStavki = listaStavki;
    }
   
    
     public ObavljenaProdaja(String prodajaID, Date datumProdaje, double ukupanIznosProdaje, String prodavacID, ArrayList<StavkaProdaje> listaStavki) {
        this.prodajaID = prodajaID;
        this.datumProdaje = datumProdaje;
        this.ukupanIznosProdaje = ukupanIznosProdaje;
        this.prodavac =  new Prodavac(prodavacID);
        this.listaStavki = listaStavki;
    }
       public ObavljenaProdaja(String prodajaID, Date datumProdaje, double ukupanIznosProdaje, String prodavacID) {
        this.prodajaID = prodajaID;
        this.datumProdaje = datumProdaje;
        this.ukupanIznosProdaje = ukupanIznosProdaje;
        this.prodavac =  new Prodavac(prodavacID);
 
    }

    public String getProdajaID() {
        return prodajaID;
    }

    public void setProdajaID(String prodajaID) {
        this.prodajaID = prodajaID;
    }

    public Date getDatumProdaje() {
        return datumProdaje;
    }

    public void setDatumProdaje(Date datumProdaje) {
        this.datumProdaje = datumProdaje;
    }

    public double getUkupanIznosProdaje() {
        return ukupanIznosProdaje;
    }

    public void setUkupanIznosProdaje(double ukupanIznosProdaje) {
        this.ukupanIznosProdaje = ukupanIznosProdaje;
    }

    public Prodavac getProdavac() {
        return prodavac;
    }

    public void setProdavac(Prodavac prodavac) {
        this.prodavac = prodavac;
    }

    public ArrayList<StavkaProdaje> getListaStavki() {
        return listaStavki;
    }

    public void setListaStavki(ArrayList<StavkaProdaje> listaStavki) {
        this.listaStavki = listaStavki;
    }

    @Override
    public String vratiImeTabele() {
       return "obavljena_prodaja";
    }

    @Override
    public String vratiParametre() {
         java.sql.Date datumSQL = new java.sql.Date(datumProdaje.getTime());
        return String.format("'%s','%s','%s','%s'", prodajaID, datumSQL, ukupanIznosProdaje, prodavac.getProdavacID());
    }

    @Override
    public String vratiPK() {
        return "prodajaID";
    }

    @Override
    public String vratiVrednostPK() {
        return prodajaID;
    }

    @Override
    public String vratiSlozenPK() {
        return null;
    }

    @Override
    public List<OpstiDomenskiObjekat> RSuListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> prodaje = new ArrayList<>();
        while (rs.next()) {
            String prodajaID1 = rs.getString("prodajaID");
            Timestamp dat = rs.getTimestamp("datumProdaje");
            double ukupno = rs.getDouble("ukupanIznosProdaje");
            String prodavacID1 = rs.getString("prodavacID");
            
            prodaje.add(new ObavljenaProdaja(prodajaID1, dat, ukupno, prodavacID1));
        }
        return prodaje;
    }

    @Override
    public String vratiUpdate() {
         return String.format("prodajaID='%s',datum='%s',ukupno='%s',prodavacID='%s'", prodajaID, datumProdaje,ukupanIznosProdaje,prodavac.getProdavacID());
    }

    @Override
    public void postaviVrednostPK(String pk) {
       this.prodajaID = pk;
    }
    
     
    
    
    
   
}
