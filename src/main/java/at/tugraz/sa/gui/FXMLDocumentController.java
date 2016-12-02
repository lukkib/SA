/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.tugraz.sa.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    //****************************************************************************************************************\\
    @FXML private TextField start;
    @FXML private TextField target;
    @FXML private Button getRoutes;
    @FXML private ListView<String> routes;

    @FXML
    private void handleActivityButtonAction(ActionEvent event)
    {
        String stop1;
        String stop2;
        stop1 = start.getText();
        stop2 = target.getText();
        List<String> results= new ArrayList<String>();
        if(stop1.isEmpty() || stop2.isEmpty())
        {
            //TODO:
            results.add("Enter Start and Target");

        }
        else
        {
            results.add("Route1");
            results.add("Route2");
            results.add("Route2");
            results.add("Route2");
            results.add("Route2");
            results.add("Route2");
            results.add("Route2");
            results.add("Route2");
            results.add("Route2");
            results.add("Route2");
            results.add("Route2");
        }
        ObservableList<String> items =FXCollections.observableArrayList();
        for(int i = 0; i < results.size(); i++)
        {
            items.add(results.get(i));
        }
        routes.setItems(items);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
