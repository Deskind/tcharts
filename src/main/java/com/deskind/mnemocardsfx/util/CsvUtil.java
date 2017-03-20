
package com.deskind.mnemocardsfx.util;

import com.deskind.mnemocardsfx.data.InformationNode;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;


public class CsvUtil {
    /**Method for making an information node. The node itself is a stack pane 
    with a label*/
        public static Node makeNode(final String s){
            final StackPane stackPane = new StackPane();
            stackPane.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Label l = new Label("Hellooooo");
                stackPane.getChildren().add(l);
            }      
            }); 
            return stackPane;
        }
    //end
    
    /**The method for processing csv file and generating XYChar.Series object*/
    public static XYChart.Series getCsv(String path, double deposit, double betSize, double brokerInterest){
        
        BufferedReader reader;
        XYChart.Series<String, Number> series = new XYChart.Series();
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        
        brokerInterest/=100;
        
        try {
            reader = new BufferedReader(new FileReader(new File(path)));
            String line;
            while((line=reader.readLine())!=null){
                String[] arr = line.split(",");
                if(Integer.parseInt(arr[1])==1){
                    System.out.println("One");
                    deposit+=brokerInterest*betSize;
                }else if(Integer.parseInt(arr[1])==0){
                    System.out.println("Zero");
                    deposit-=betSize;
                }
                String s = decimalFormat.format(deposit);
                String ss = s.replace(",", ".");
                XYChart.Data<String, Number> data = new XYChart.Data(arr[0], deposit);
                data.setNode(new InformationNode(decimalFormat.format(deposit)));
                series.getData().add(data);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No such file!!!");
        } catch (IOException ex) {
            Logger.getLogger(CsvUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("!!!!!!!!!!The method successfully returned!!!!!!!!!!!!!");
        return series;
    }
    //end
}
