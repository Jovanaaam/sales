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
public class Proizvod extends OpstiDomenskiObjekat{
    private String proizvodID;
    private String nazivProizvoda;
    private double nabavnaCena;
    private double prodajnaCena;

    public Proizvod() {
    }
 public Proizvod(String proizvodID) {
        this.proizvodID = proizvodID;
    }
    public Proizvod(String proizvodID, String nazivProizvoda, double nabavnaCena, double prodajnaCena) {
        this.proizvodID = proizvodID;
        this.nazivProizvoda = nazivProizvoda;
        this.nabavnaCena = nabavnaCena;
        this.prodajnaCena = prodajnaCena;
    }

    public double getProdajnaCena() {
        return prodajnaCena;
    }

    public void setProdajnaCena(double prodajnaCena) {
        this.prodajnaCena = prodajnaCena;
    }

  

    public String getNazivProizvoda() {
        return nazivProizvoda;
    }

    public void setNazivProizvoda(String nazivProizvoda) {
        this.nazivProizvoda = nazivProizvoda;
    }

    public double getNabavnaCena() {
        return nabavnaCena;
    }

    public void setNabavnaCena(double nabavnaCena) {
        this.nabavnaCena = nabavnaCena;
    }

    @Override
    public String vratiImeTabele() {
        return "proizvod";
    }

    @Override
    public String vratiParametre() {
        return String.format("'%s','%s','%s','%s'", proizvodID, nazivProizvoda, nabavnaCena, prodajnaCena);
    }

    @Override
    public String vratiPK() {
        return "proizvodID";
    }

    @Override
    public String vratiVrednostPK() {
        return proizvodID;
    }

    @Override
    public String vratiSlozenPK() {
       return null;
    }

    @Override
    public List<OpstiDomenskiObjekat> RSuListu(ResultSet rs) throws SQLException {
         List<OpstiDomenskiObjekat> proizvodi = new ArrayList<>();
        while (rs.next()) {
            String proizvodID1 = rs.getString("proizvodID");
            String nazivProizvoda1 = rs.getString("nazivProizvoda");
            double nabavnaCena1= rs.getDouble("nabavnaCena");
            double prodajnaCena1 = rs.getDouble("prodajnaCena");
     
            proizvodi.add(new Proizvod(proizvodID1, nazivProizvoda1, nabavnaCena1, prodajnaCena1));
        }
        return proizvodi;
    }

    @Override
    public String vratiUpdate() {
        return String.format("proizvodID='%s',nazivProizvoda='%s',nabavnaCena='%s',prodajnaCena='%s'", proizvodID, nazivProizvoda, nabavnaCena, prodajnaCena);
    }

    @Override
    public void postaviVrednostPK(String pk) {
        this.proizvodID = pk;
    }

    public String getProizvodID() {
        return proizvodID;
    }

    public void setProizvodID(String proizvodID) {
        this.proizvodID = proizvodID;
    }
    
    
}
