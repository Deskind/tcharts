package com.deskind.mnemocardsfx.tcharts;

import com.deskind.mnemocardsfx.util.CsvUtil;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FXMLController implements Initializable {
    
    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    private Button chooseFileBtn;

    @FXML
    private Label label;
    
    @FXML
    private LineChart<String, Number> lineChart;
    
    @FXML
    private TextField depositField;

    @FXML
    private TextField betField;
    
    @FXML
    private TextField brokerInterest;

    @FXML
    void handleButtonAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(new Stage());

        lineChart.setTitle("Profit Chart");
        lineChart.setVisible(true);
        lineChart.getData().add(CsvUtil.getCsv(file.getPath(), Double.parseDouble(depositField.getText()), 
                                                               Double.parseDouble(betField.getText()),
                                                               Double.parseDouble(brokerInterest.getText()))); 
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lineChart.setVisible(false);
    }    
}
