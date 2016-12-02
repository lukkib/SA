package at.tugraz.sa.gui;

import at.tugraz.sa.Filter;
import at.tugraz.sa.controller.DataHandler;
import at.tugraz.sa.controller.Planer;
import at.tugraz.sa.controller.StopController;
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

    @FXML private Button selectStartBtn;
    @FXML private Button selectTargetBtn;

    @FXML
    private void handleSelectStartBtn()
    {
      start.setText(searchResults.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void handleSelectTargetBtn()
    {
      target.setText(searchResults.getSelectionModel().getSelectedItem());
    }


    @FXML private Label label;

    //**************************************************************************
    @FXML private TextField start;
    @FXML private TextField target;
    @FXML private Button getRoutes;
    @FXML private ListView<String> routes;
    DataHandler handler = new DataHandler();
    StopController stopController = new StopController();

    @FXML
    private void handleActivityButtonAction(ActionEvent event)
      throws SQLException
    {
        String stop1;
        String stop2;
        stop1 = start.getText();
        stop2 = target.getText();
        List<String> results= new ArrayList<String>();
        List<String> out= new ArrayList<String>();
        Planer planer;
        StopController stopController = new StopController();
        if(stop1.isEmpty() || stop2.isEmpty())
        {
            //TODO:
            results.add("Enter Start and Target");
        }
        else
        {
            //TODO: ADD connection to results
            planer = new Planer(stopController.findStopIdByName(start.getText()),
              stopController.findStopIdByName(target.getText()));
            results = planer.findConnections(handler);
            for(int i = 0; i < results.size(); i++)
            {
                out.add(handler.getRoutebyID(results.get(i)));
            }
        }
        ObservableList<String> items = FXCollections.observableArrayList();
        for(int i = 0; i < results.size(); i++)
        {
            items.add(out.get(i));
        }
        routes.setItems(items);
    }
    //**************************************************************************
    @FXML private TextField route;
    @FXML private TextField stop;
    @FXML private Button addStop;
    @FXML private Label feedback;

    @FXML
    private void handleAddButton(ActionEvent event) throws SQLException
    {
        if(route.getText().isEmpty() || stop.getText().isEmpty())
        {
          feedback.setText("Fill out all fields to add stop.");
          return;
        }

        StopController stopController = new StopController();
        String stopId = stopController.findStopIdByName(stop.getText());
        if (stopId == null)
        {
            feedback.setText("Stop doesn't exist.");
        }
        else
        {
            feedback.setText(stop.getText() + " added to route " + route
              .getText() + " with ID " + stopId);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
    }
}
