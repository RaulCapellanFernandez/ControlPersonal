/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgsource;

import java.util.Date;

/**
 *
 * @author Cape
 */
public class Dinero {
    private Date fecha;
    private float precio;
    boolean ingreso;//Si es True es gasto si es False es ingreso
    boolean tarjeta;//Si es True tarjeta si no efectivo
    String whatIs;
   
    public Dinero(float precio,boolean tarjeta, boolean gasto, String whatIs){
        this.precio = precio;
        this.ingreso = gasto;
        this.whatIs = whatIs;
        this.tarjeta = tarjeta;
    }

    public boolean isTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(boolean tarjeta) {
        this.tarjeta = tarjeta;
    }

    public Date getFecha() {
        return fecha;
    }

    public float getPrecio() {
        return precio;
    }

    public boolean isIngreso() {
        return ingreso;
    }

    public String getWhatIs() {
        return whatIs;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setIngreso(boolean ingreso) {
        this.ingreso = ingreso;
    }

    public void setWhatIs(String whatIs) {
        this.whatIs = whatIs;
    }
   
    
    
}
