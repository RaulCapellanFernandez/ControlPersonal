/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkginterface;

import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import pkgsource.Cuenta;
import pkgsource.Dinero;

/**
 *
 * @author Cape
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private PieChart pieChart;
    @FXML
    private PieChart pieChart1;
    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;
    @FXML
    private LineChart<?, ?> LineChart;
    
public double saldoBanco;
    private DateFormat dformat = null;
    
    public List<Dinero> transacciones = new ArrayList<Dinero>();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        rellenaArray();
        
        rellenarLineChart();
        rellenarPieCahrt() ;
       
    }
   
    private void rellenaArray(){
        
        Cuenta saldo = new Cuenta(saldoBanco);
        float precio =10;
        //Transacciones
       Dinero t1 =new Dinero( precio, false, false, "Mi mierda");
       Dinero t2 =new Dinero( precio, true, true, "Mi mierda");
       /*Dinero t3 =new Dinero(parseLocalDate("24/02/2018 17:00:00"), precio, false, true, "Mi mierda");
       Dinero t4 =new Dinero(parseLocalDate("24/02/2018 17:00:00"), precio, false, false, "Mi mierda");
       Dinero t5 =new Dinero(parseLocalDate("24/02/2018 17:00:00"), precio, true, true, "Mi mierda");
       Dinero t6 =new Dinero(parseLocalDate("24/02/2018 17:00:00"), precio, false, true, "Mi mierda");
       Dinero t7 =new Dinero(parseLocalDate("24/02/2018 17:00:00"), precio, true, false, "Mi mierda");
       Dinero t8 =new Dinero(parseLocalDate("24/02/2018 17:00:00"), precio, true, true, "Mi mierda");
       Dinero t9 =new Dinero(parseLocalDate("24/02/2018 17:00:00"), precio, true, false, "Mi mierda");
       Dinero t10 =new Dinero(parseLocalDate("24/02/2018 17:00:00"), precio, true, true, "Mi mierda");
       Dinero t11 =new Dinero(parseLocalDate("24/02/2018 17:00:00"), precio, true, true, "Mi mierda");
       Dinero t12 =new Dinero(parseLocalDate("24/02/2018 17:00:00"), precio, true, false, "Mi mierda");
       Dinero t13 =new Dinero(parseLocalDate("24/02/2018 17:00:00"), precio, true, true, "Mi mierda");
       Dinero t14 =new Dinero(parseLocalDate("24/02/2018 17:00:00"), precio, true, true, "Mi mierda");
       Dinero t15 =new Dinero(parseLocalDate("24/02/2018 17:00:00"), precio, true, true, "Mi mierda");
       Dinero t16 =new Dinero(parseLocalDate("24/02/2018 17:00:00"), precio, true, true, "Mi mierda");
       Dinero t17 =new Dinero(parseLocalDate("24/02/2018 17:00:00"), precio, true, true, "Mi mierda");
       Dinero t18 =new Dinero(parseLocalDate("24/02/2018 17:00:00"), precio, true, true, "Mi mierda");
       Dinero t19 =new Dinero(parseLocalDate("24/02/2018 17:00:00"), precio, true, false, "Mi mierda");*/
       
        //Añade las transacciones al arrayList
       transacciones.add(t1);
       transacciones.add(t2);
       /*transacciones.add(t3);
       transacciones.add(t4);
       transacciones.add(t5);
       transacciones.add(t6);
       transacciones.add(t7);
       transacciones.add(t8);
       transacciones.add(t9);
       transacciones.add(t10);
       transacciones.add(t11);
       transacciones.add(t12);
       transacciones.add(t13);
       transacciones.add(t14);
       transacciones.add(t15);
       transacciones.add(t16);
       transacciones.add(t17);
       transacciones.add(t18);
       transacciones.add(t19);*/
       
    }
    private void rellenarPieCahrt(){
       float gast = 0,ingres = 0; 
       float tarj = 0, cash = 0;
        //Rellena el pie chart de gastos e ingresos
        for (Dinero transaccione : transacciones) {
            if (transaccione.isIngreso() == true) 
                ingres = ingres + transaccione.getPrecio();
            else 
                gast = gast + transaccione.getPrecio();
            
        }
        //Rellena el pie chart de tarjeta y cash
        for (Dinero transaccione : transacciones) {
            if (transaccione.isTarjeta() == true) 
                tarj++;
            else 
                cash++;
        }
       //Crea el pie chart 
       ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
        new PieChart.Data("Gastado", gast),
        new PieChart.Data("Ingresado", ingres));
        ObservableList<PieChart.Data> pieChartData1 = FXCollections.observableArrayList(
        new PieChart.Data("Tarjeta", tarj),
        new PieChart.Data("Efectivo", cash));
        
        //Introduce la vartiable en el pie chart
        pieChart.setData(pieChartData1);
        pieChart1.setData(pieChartData); 
    }
   private void rellenarLineChart(){
       XYChart.Series series = new XYChart.Series();
       series.setName("Ingresos");
       series.getData().add(new XYChart.Data("Enero",23));
       series.getData().add(new XYChart.Data("Febrero",23));
       series.getData().add(new XYChart.Data("Marzo",23));
       series.getData().add(new XYChart.Data("Abril",23));
       series.getData().add(new XYChart.Data("Mayo",23));
       series.getData().add(new XYChart.Data("Junio",23));
       series.getData().add(new XYChart.Data("Julio",23));
       series.getData().add(new XYChart.Data("Agosto",23));
       series.getData().add(new XYChart.Data("Septiembre",23));
       series.getData().add(new XYChart.Data("Octubre",23));
       series.getData().add(new XYChart.Data("Noviembre",23));
       series.getData().add(new XYChart.Data("Diciembre",23));
       
       XYChart.Series series1 = new XYChart.Series();
       series1.setName("Gastos");
       series1.getData().add(new XYChart.Data("Enero",2));
       series1.getData().add(new XYChart.Data("Febrero",2));
       series1.getData().add(new XYChart.Data("Marzo",2));
       series1.getData().add(new XYChart.Data("Abril",2));
       series1.getData().add(new XYChart.Data("Mayo",2));
       series1.getData().add(new XYChart.Data("Junio",2));
       series1.getData().add(new XYChart.Data("Julio",2));
       series1.getData().add(new XYChart.Data("Agosto",2));
       series1.getData().add(new XYChart.Data("Septiembre",2));
       series1.getData().add(new XYChart.Data("Octubre",2));
       series1.getData().add(new XYChart.Data("Noviembre",2));
       series1.getData().add(new XYChart.Data("Diciembre",2));
       
       LineChart.getData().addAll(series);
       LineChart.getData().addAll(series1);
   }
    
}