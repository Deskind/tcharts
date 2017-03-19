
package com.deskind.mnemocardsfx.util;

import com.deskind.mnemocardsfx.data.InformationNode;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;


public class CsvUtil {
    //Method for making an information node
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
    
    public static XYChart.Series getCsv(String path, int deposit, int betSize, double brokerInterest){
        

        BufferedReader reader = null;
        XYChart.Series series = new XYChart.Series();

        
        try {
            reader = new BufferedReader(new FileReader(new File(path)));
            String line;
            while((line=reader.readLine())!=null){
                String[] arr = line.split(",");
                if(Integer.parseInt(arr[1])==1){
                    System.out.println("One");
                    deposit+=brokerInterest*brokerInterest;
                }else if(Integer.parseInt(arr[1])==0){
                    System.out.println("Zero");
                    deposit-=brokerInterest;
                }
                XYChart.Data<String, Number> data = new XYChart.Data(arr[0],new Integer(deposit));
                data.setNode(new InformationNode(String.valueOf(deposit)));
                series.getData().add(data);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No such file!!!");
        } catch (IOException ex) {
            Logger.getLogger(CsvUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return series;
    }
}
