/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author Korisnik
 */
public class Zahtev implements Serializable{
    private Operacija operacija;
    private Object parametar;
    private Object parametar1;
    
    public Operacija getOperacija() {
        return operacija;
    }

    public void setOperacija(Operacija operacija) {
        this.operacija = operacija;
    }

    public Object getParametar() {
        return parametar;
    }

    public void setParametar(Object parametar) {
        this.parametar = parametar;
    }

    public Object getParametar1() {
        return parametar1;
    }

    public void setParametar1(Object parametar1) {
        this.parametar1 = parametar1;
    }
    
    
}
