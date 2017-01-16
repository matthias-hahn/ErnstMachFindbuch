/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package machfindbuch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import machfindbuch.Person;




/**
 * Stellt das Findbuch des DMM zu Ernst Mach als JavaFX Tabelle dar.
 * @author matthias
 */
public class MachFindbuch extends Application {
    
    private final TableView<Person> table = new TableView<>();
 
    private final ObservableList<Person> liste
            = FXCollections.observableArrayList();
    
    
    /**
     *
     * @return
     */
    //public ObservableList<Person> getPerson() {
        
    //    liste.add(new Person("Empfänger","Ernst","Mach",123456));
    //    liste.add(new Person("Sender","Joseph","Petzoldt",234561));
    //    return liste;
        
    //}
    


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
        primaryStage.setTitle("Findbuch Ernst Mach");
        
        // Parent Layout 
        VBox parent = new VBox();
        parent.setSpacing(25);
        parent.setPadding(new Insets(20.0,20.0,20.0,20.0));
        
        //Tabellendefinition
        TableColumn<Person, String> dmmColumn = new TableColumn<>("DMM ID");
        dmmColumn.setMinWidth(50);
        dmmColumn.setCellValueFactory(new PropertyValueFactory<>("dmmID"));
        
        TableColumn<Person, String> verfasserColumn = new TableColumn<>("Verfasser");
        verfasserColumn.setMinWidth(200);
        verfasserColumn.setCellValueFactory(new PropertyValueFactory<>("verfasser"));
        
        TableColumn<Person, String> vpidColumn = new TableColumn<>("Verfasser PID");
        vpidColumn.setMinWidth(100);
        vpidColumn.setCellValueFactory(new PropertyValueFactory<>("verfasserPid"));
        
        TableColumn<Person, String> empfängerColumn = new TableColumn<>("Empfänger");
        empfängerColumn.setMinWidth(200);
        empfängerColumn.setCellValueFactory(new PropertyValueFactory<>("empfänger"));
        
        TableColumn<Person, String> epidColumn = new TableColumn<>("Empfänger PID");
        epidColumn.setMinWidth(150);
        epidColumn.setCellValueFactory(new PropertyValueFactory<>("empfängerPid"));
        
        TableColumn<Person, String> datumColumn = new TableColumn<>("Datum");
        datumColumn.setMinWidth(200);
        datumColumn.setCellValueFactory(new PropertyValueFactory<>("datum"));
        
        TableColumn<Person, String> ortColumn = new TableColumn<>("Ort");
        ortColumn.setMinWidth(200);        
        ortColumn.setCellValueFactory(new PropertyValueFactory<>("ort"));
        
        table.setItems(liste);
        table.getColumns().addAll(dmmColumn, verfasserColumn, vpidColumn, empfängerColumn, epidColumn, ortColumn, datumColumn);
        
        Label label = new Label("Findbuch zu Ernst Mach");
        label.setFont(new Font("Arial", 30));
        parent.getChildren().add(label);
       
        parent.getChildren().addAll(table);
        
        Scene scene = new Scene(parent, 1280, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
        readCSV();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
    private void readCSV() { 
        
        String CsvFile = "/home/matthias/NetBeansProjects/MachFindbuch/data/MachKorr2727UTF8.csv";
        String FieldDelimiter = ";";
 
        BufferedReader br;
        
        try {
            
             br = new BufferedReader(new FileReader(CsvFile));
 
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(FieldDelimiter, -1);
                Person person = new Person(fields[1], fields[5], fields[6], fields[9], fields[10], fields[15], fields[19]);
                liste.add(person);
 
            } 
            
        } catch(IOException ex) {
                    Logger.getLogger(MachFindbuch.class.getName())
                    .log(Level.SEVERE, null, ex);
            
        }
    }    
    
}
