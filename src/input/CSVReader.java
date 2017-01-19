/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import machfindbuch.MachFindbuch;
import machfindbuch.Person;

/**
 *
 * @author matthias
 */
public class CSVReader {

     public ObservableList readCSV(String path) {
         
         ObservableList liste = FXCollections.observableArrayList();

        //String CsvFile = path+"MachKorr2727UTF8.csv";
        String CsvFile = path+"Mach-Findbuch.csv";
        String FieldDelimiter = ":";

        BufferedReader br;

        try {

            br = new BufferedReader(new FileReader(CsvFile));

            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(FieldDelimiter, -1);
                Person person = new Person(fields[1], fields[5], fields[6], fields[9], fields[10], fields[15], fields[19],fields[19]);
                liste.add(person);

            }

        } catch (IOException ex) {
            Logger.getLogger(MachFindbuch.class.getName())
                    .log(Level.SEVERE, null, ex);

        }
        
        return liste;
    }

    
}
