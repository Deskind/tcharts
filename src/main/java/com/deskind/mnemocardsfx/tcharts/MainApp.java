package com.deskind.mnemocardsfx.tcharts;

import com.deskind.mnemocardsfx.util.CsvUtil;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();

//    final CategoryAxis xAxis = new CategoryAxis();
//    final NumberAxis yAxis = new NumberAxis();
//    
//    final LineChart<String,Number> lineChart = new LineChart<String,Number>(xAxis,yAxis);
//    
//    Scene scene  = new Scene(lineChart,800,600);
//    lineChart.getData().add(CsvUtil.getCsv());
//
//    stage.setScene(scene);
//    stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
