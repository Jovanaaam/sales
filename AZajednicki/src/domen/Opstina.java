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
public class Opstina extends OpstiDomenskiObjekat{
    private String opstinaID;
    private String nazivOpstine;

    public Opstina() {
    }

    public Opstina(String opstinaID, String nazivOpstine) {
        this.opstinaID = opstinaID;
        this.nazivOpstine = nazivOpstine;
    }

   
      public Opstina(String opstinaID) {
        this.opstinaID = opstinaID;
       
    }


   @Override
    public String toString() {
        return nazivOpstine;
    }

    @Override
    public String vratiImeTabele() {
        return "opstina";
    }

    @Override
    public String vratiParametre() {
         return String.format("'%s','%s'", opstinaID, nazivOpstine);
    }

    @Override
    public String vratiPK() {
        return "opstinaID";
    }

    @Override
    public String vratiVrednostPK() {
        return opstinaID;
    }

    @Override
    public String vratiSlozenPK() {
      return null;
    }

    @Override
    public List<OpstiDomenskiObjekat> RSuListu(ResultSet rs) throws SQLException {
         List<OpstiDomenskiObjekat> opstine = new ArrayList<>();
        while (rs.next()) {
            String opstinaID1 = rs.getString("opstinaID");
            String nazivOpstine1= rs.getString("nazivOpstine");
           
            opstine.add(new Opstina(opstinaID1, nazivOpstine1));
        }
        return opstine;
    }

    @Override
    public String vratiUpdate() {
        return String.format("opstinaID='%s',nazivOpstine='%s'",opstinaID, nazivOpstine);
    }

    @Override
    public void postaviVrednostPK(String pk) {
       this.opstinaID = pk;
    }

    public String getOpstinaID() {
        return opstinaID;
    }

    public void setOpstinaID(String opstinaID) {
        this.opstinaID = opstinaID;
    }

    public String getNazivOpstine() {
        return nazivOpstine;
    }

    public void setNazivOpstine(String nazivOpstine) {
        this.nazivOpstine = nazivOpstine;
    }
    
    
}
