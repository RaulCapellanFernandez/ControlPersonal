/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgsource;

/**
 *
 * @author Cape
 */
public class Cuenta {
    private double saldoTotal;
    
    public Cuenta(double saldoTotal){
        this.saldoTotal = saldoTotal;
    }

    public double getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(double saldoTotal) {
        this.saldoTotal = saldoTotal;
    }
    
}

