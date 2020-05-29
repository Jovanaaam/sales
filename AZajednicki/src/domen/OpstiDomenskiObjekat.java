package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class OpstiDomenskiObjekat implements Serializable{
    
    public abstract String vratiImeTabele();
    public abstract String vratiParametre();
    public abstract String vratiPK();
    public abstract String vratiVrednostPK();
    public abstract String vratiSlozenPK();
    public abstract List<OpstiDomenskiObjekat> RSuListu(ResultSet rs) throws SQLException;
    public abstract String vratiUpdate();
    public abstract void postaviVrednostPK(String pk);
    
    private String stanje;

    public String getStanje() {
        return stanje;
    }

    public void setStanje(String stanje) {
        this.stanje = stanje;
    }
    
}
