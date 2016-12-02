/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.tugraz.sa.gui;

import at.tugraz.sa.controller.DataHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FXMLDocumentController implements Initializable
{
    // Search function elements
    @FXML private TextField searchName;
    @FXML private TextField searchLat;
    @FXML private TextField searchLon;
    @FXML private Button searchBtn;
    @FXML private Button searchLessLon;
    @FXML private Button searchGreaterLon;
    @FXML private Button searchLessLat;
    @FXML private Button searchGreaterLat;

    @FXML
    private void handleSearchLessLon(ActionEvent event)
    {
      searchLessLon.setStyle("-fx-background-color: lightblue;");
      searchGreaterLon.setStyle(null);
    }

    @FXML
    private void handleSearchGreaterLon(ActionEvent event)
    {
      searchLessLon.setStyle(null);
      searchGreaterLon.setStyle("-fx-background-color: lightblue;");
    }

    @FXML private Label label;
    
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
    DataHandler handler = new DataHandler();

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
            //TODO: ADD connection to results
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
    //****************************************************************************************************************\\
    @FXML private TextField route;
    @FXML private TextField stop;
    @FXML private TextField longitude;
    @FXML private TextField latitude;
    @FXML private Button addStop;
    @FXML private TextArea feedback;

    @FXML
    private void handleAddButton(ActionEvent event)
    {
        if(route.getText().isEmpty() || stop.getText().isEmpty() || longitude.getText().isEmpty() || latitude.getText().isEmpty())
        {
            feedback.setText("Not all fields have been filled out, stop hasn't been added.");
        }
        else
        {
            //Adds Stop and line to mapping.csv
            handler.addStopToLine(route.getText(),stop.getText());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
