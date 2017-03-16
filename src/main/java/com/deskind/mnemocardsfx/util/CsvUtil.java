
package com.deskind.mnemocardsfx.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.chart.XYChart;


public class CsvUtil {
    public static XYChart.Series getCsv(){
        //Trade parameters
        int deposit = 100;
        int bidInPercent = 2;
        double brokerInterest = 0.75;
        //end
        
        BufferedReader reader = null;
        XYChart.Series series = new XYChart.Series();

        
        try {
            reader = new BufferedReader(new FileReader(new File("signals.csv")));
            String line;
            while((line=reader.readLine())!=null){
                String[] arr = line.split(",");
                if(Integer.parseInt(arr[1])==1){
                    System.out.println("One");
                    deposit+=bidInPercent*brokerInterest;
                }else if(Integer.parseInt(arr[1])==0){
                    System.out.println("Zero");
                    deposit-=bidInPercent;
                }
                series.getData().add(new XYChart.Data(arr[0],new Integer(deposit)));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No such file!!!");
        } catch (IOException ex) {
            Logger.getLogger(CsvUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return series;
    }
}
