/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.stuttgart.uni.machfindbuch;

import de.uni.stuttgart.input.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.script.ScriptException;
import de.stuttgart.uni.model.Person;
import de.stuttgart.uni.normdaten.ConvertID;
import de.stuttgart.uni.normdaten.URLConnection;
import de.stuttgart.uni.normdaten.ReadJson;
import de.stuttgart.uni.normdaten.Statistik;

/**
 * Stellt das Findbuch des DMM zu Ernst Mach als JavaFX Tabelle dar.
 *
 * @author matthias
 */
public class MachFindbuch extends Application {
    
    private static final boolean statistik = false;

    private final TableView<Person> table = new TableView<>();

    private ObservableList<Person> liste
            = FXCollections.observableArrayList();
    
    private final String path = "/home/matthias/NetBeansProjects/MachFindbuch/data/";
    //private final String path = "";

    /**
     *
     * @param primaryStage
     */
    public void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setScene(new Scene(root));
    }

    @Override
    public void start(Stage primaryStage) {
        init(primaryStage);
        primaryStage.setTitle("Findbuch Ernst Mach - Matthias Hahn, Uni Stuttgart, Projektseminar");

        // Parent Layout 
        VBox parent = new VBox();
        parent.setSpacing(25);
        parent.setPadding(new Insets(20.0, 20.0, 20.0, 20.0));

        Label label = new Label("Findbuch zu Ernst Mach");
        label.setFont(new Font("Arial", 30));
        parent.getChildren().add(label);

        TextField searchField = new TextField();
        searchField.setMaxWidth(200);
        //searchField.setText("Verfasser und Ort");
        parent.getChildren().add(searchField);

        //Tabellendefinition
        TableColumn<Person, String> dmmColumn = new TableColumn<>("DMM ID");
        dmmColumn.setMinWidth(50);
        dmmColumn.setCellValueFactory(new PropertyValueFactory<>("dmmID"));

        TableColumn<Person, String> verfasserColumn = new TableColumn<>("Verfasser");
        verfasserColumn.setMinWidth(200);
        verfasserColumn.setCellValueFactory(new PropertyValueFactory<>("verfasser"));

        TableColumn<Person, String> vpidColumn = new TableColumn<>("Verfasser PND");
        vpidColumn.setMinWidth(150);
        vpidColumn.setCellValueFactory(new PropertyValueFactory<>("verfasserPid"));

        TableColumn<Person, String> empfängerColumn = new TableColumn<>("Empfänger");
        empfängerColumn.setMinWidth(200);
        empfängerColumn.setCellValueFactory(new PropertyValueFactory<>("empfänger"));

        TableColumn<Person, String> epidColumn = new TableColumn<>("Empfänger PND");
        epidColumn.setMinWidth(150);
        epidColumn.setCellValueFactory(new PropertyValueFactory<>("empfängerPid"));

        TableColumn<Person, String> datumColumn = new TableColumn<>("Datum");
        datumColumn.setMinWidth(100);
        datumColumn.setCellValueFactory(new PropertyValueFactory<>("datum"));

        TableColumn<Person, String> ortColumn = new TableColumn<>("Ort");
        ortColumn.setMinWidth(150);
        ortColumn.setCellValueFactory(new PropertyValueFactory<>("ort"));
        
        TableColumn<Person, String> koordinatenColumn = new TableColumn<>("Koordinaten");
        koordinatenColumn.setMinWidth(200);
        koordinatenColumn.setCellValueFactory(new PropertyValueFactory<>("koordinaten"));

        CSVReader csv = new CSVReader(); 
        liste = csv.readCSV(path);
        
        
        FilteredList<Person> filteredData = new FilteredList<>(liste, p -> true);
        // Todo Filter fuer das Searchfield
        // 2. Set the filter Predicate whenever the filter changes.
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (person.getVerfasser().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches first name.
                } else if (person.getOrt().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (person.getDatum().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }    
                return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Person> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(table.comparatorProperty());

        table.setItems(sortedData);
        table.getColumns().addAll(dmmColumn, verfasserColumn, vpidColumn, empfängerColumn, epidColumn, ortColumn, datumColumn,koordinatenColumn);

       
        
        parent.getChildren().addAll(table);

        

        Label footnote = new Label("Anzahl der Eintr\u00e4ge im Findbuch:  " + String.valueOf(liste.size()));
        footnote.setFont(new Font("Arial", 20));
        parent.getChildren().add(footnote);
         
        if (statistik) {
                
            try {
                Statistik stat = new Statistik();
                ConvertID conversion = new ConvertID();
                HashSet<String> verfasserids = stat.groupVerfasserPND(liste);
                Map<String, String> verfasserViaf = conversion.pndtoviaf(verfasserids);
                for (Entry e : verfasserViaf.entrySet()) {
                    System.out.println(e.getValue() + "|" + e.getKey());
                }    
            } catch (IOException | ScriptException ex) {
                Logger.getLogger(MachFindbuch.class.getName()).log(Level.SEVERE, null, ex);
            }
        }           
           
           


        Scene scene = new Scene(parent, 1280, 800);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    } 
   
}
    
  
