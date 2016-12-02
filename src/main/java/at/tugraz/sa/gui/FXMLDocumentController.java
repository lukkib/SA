/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.tugraz.sa.gui;

import at.tugraz.sa.controller.DataHandler;
import at.tugraz.sa.Filter;

import at.tugraz.sa.model.generated.tables.records.StopsRecord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.SQLException;
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
    @FXML private ListView<String> searchResults;

    @FXML
    private void handleSearchLessLon(ActionEvent event)
    {
      searchGreaterLon.setId("");
      searchGreaterLon.setStyle(null);
      searchLessLon.setId("<");
      searchLessLon.setStyle("-fx-background-color: lightblue;");
    }

    @FXML
    private void handleSearchGreaterLon(ActionEvent event)
    {
      searchLessLon.setId("");
      searchLessLon.setStyle(null);
      searchGreaterLon.setId(">");
      searchGreaterLon.setStyle("-fx-background-color: lightblue;");
    }

    @FXML
    private void handleSearchLessLat(ActionEvent event)
    {
      searchGreaterLat.setId("");
      searchGreaterLat.setStyle(null);
      searchLessLat.setId("<");
      searchLessLat.setStyle("-fx-background-color: lightblue;");
    }

    @FXML
    private void handleSearchGreaterLat(ActionEvent event)
    {
      searchLessLat.setId("");
      searchLessLat.setStyle(null);
      searchGreaterLat.setId(">");
      searchGreaterLat.setStyle("-fx-background-color: lightblue;");
    }

    @FXML
    private void handleSearchBtn(ActionEvent event)
    {
      searchResults.getItems().clear();
      String lonMode = searchLessLon.getId().equals("<") ? "<" :
        searchGreaterLon.getId();
      String latMode = searchLessLat.getId().equals("<") ? "<" :
        searchGreaterLat.getId();

      try
      {
        Filter filter = new Filter(searchName.getText(), searchLon.getText(),
          searchLat.getText(), lonMode, latMode);

        List<StopsRecord> records = filter.start();

        ObservableList<String> items = FXCollections.observableArrayList();
        for (StopsRecord sr : records)
        {
          items.add(sr.getName());
        }
        searchResults.setItems(items);
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
      catch (Exception e) // TODO Add custom exception
      {
        System.err.println("TODO: Throw custom exception or handle invalid " +
          "mode!");
      }
    }

    @FXML private Label label;

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
