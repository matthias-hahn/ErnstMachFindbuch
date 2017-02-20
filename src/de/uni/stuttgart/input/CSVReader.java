/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uni.stuttgart.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import de.stuttgart.uni.machfindbuch.MachFindbuch;
import de.stuttgart.uni.model.Datensatz;
import de.stuttgart.uni.model.Person;
import java.util.ArrayList;

/**
 *
 * @author matthias
 */
public class CSVReader {
    
       /**
        * Liest die Ausgangskorrespondenz von Hentschel Excels
        * 1 Ort:
        * 2 Datum:
        * 3 Empfänger:
        * 4 Empfängerort:
        * 5 GND- Nummer Empfänger:
        * 6 LCC- Nummer Empfänger:
        * 7 Web NDL Authorities- Nummer Empfänger:
        * 8 VIAF- Nummer Empfänger:
        * 9 Umfang:
        * 10 Seiten- zahl:
        * 11 Form des Originals:
        * 12 Anlage:
        * 13 Sprache:
        * 14 Quelle I:
        * 15 Seite Quelle I*:
        * 16 Quelle II:
        * 17 Seite Quelle II:
        * 18 Quelle III:
        * 19 Seite Quelle III:
        * 20 Standort lt. Quelle I:
        * 21 Standort lt. Quelle II:
        * 22 Standort lt. Quelle III:
        * 23 Standort- institution lt. Quelle I:
        * 24 Standort- institution lt. Quelle II:
        * 25 Standort- institution lt. Quelle III:
        * 26 Signatur lt. Quelle I:
        * 27 Signatur lt. Quelle II:
        * 28 Signatur lt. Quelle III:
        * 29 Art der Publi- kation lt. Quelle I:
        * 30 Art der Publi- kation lt. Quelle II:
        * 31 Art der Publi- kation lt. Quelle III:
        * 32 Anmerkung Nr.:
        * @param path
        * @return 
        */
       public ArrayList readHentschelAusgangCSV(String path) { 
        
        ArrayList<Datensatz> liste = new ArrayList<Datensatz>(); 
        //String CsvFile = path+"Mach-Findbuch.csv";
        String CsvFile = path + "Hentschel_Ausgang.csv";
        String FieldDelimiter = ":";

        BufferedReader br;

        try {

            br = new BufferedReader(new FileReader(CsvFile));

            String line;
            
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(FieldDelimiter, -1);
                Datensatz daten = new Datensatz(
                        fields[0], //Ort
                        "",        //Koordinaten
                        fields[1], //Datum
                        "Mach, Ernst", //Verfasser
                        fields[4], // GND
                        fields[5], // LCC
                        fields[6], // NDL
                        fields[7], // Viaf
                        fields[3], // Empfangsort
                        fields[8], // Umfang
                        fields[9],
                        fields[10],
                        fields[11],
                        fields[12],
                        fields[13],
                        fields[14],
                        fields[15],
                        fields[16],
                        fields[17],
                        fields[18],
                        fields[19],
                        fields[20],
                        fields[21],
                        fields[22],
                        fields[23],
                        fields[24],
                        fields[25],
                        fields[26],
                        fields[27],
                        fields[28],
                        fields[29],
                        fields[30],
                        fields[31],
                        "",
                        fields[2]// Empfänger
                );
                liste.add(daten);

            }

        } catch (IOException ex) {
            Logger.getLogger(CSVReader.class.getName())
                    .log(Level.SEVERE, null, ex);

        }
       return liste; 
    }
    
    
    
    /**
     * Deserialisiert das Excel von Hentschel und erzeugt Liste mit 
     * Objekten, die dann mit der Liste unten angeglichen wird. 
     * Für die Eingehende Korrepondenz
     * Datensatz braucht eine equals Methode.
     * 1 Ort:
     * 2 Datum:
     * 3 Verfasser:
     * 4 GND- Nummer Verfasser:
     * 5 LCC- Nummer Verfasser:
     * 6 Web NDL Authorities- Nummer Verfasser:
     * 7 VIAF- Nummer Verfasser:
     * 8 Empfängerort:
     * 9 Umfang:
     * 10 Seiten- zahl:
     * 11 Form des Originals:
     * 12 Anlage:
     * 13 Sprache:
     * 14 Quelle I:
     * 15 Seite Quelle I*:
     * 16 Quelle II:
     * 17 Seite Quelle II:
     * 18 Quelle III:
     * 19 Seite Quelle III:
     * 20 Standort lt. Quelle I:
     * 21 Standort lt. Quelle II:
     * 22 Standort lt. Quelle III:
     * 23 Standort- institution lt. Quelle I:
     * 24 Standort- institution lt. Quelle II:
     * 25 Standort- institution lt. Quelle III:
     * 26 Signatur lt. Quelle I:
     * 27 Signatur lt. Quelle II:
     * 28 Signatur lt. Quelle III:
     * 29 Art der Publi- kation lt. Quelle I:
     * 30 Art der Publi- kation lt. Quelle II:
     * 31 Art der Publi- kation lt. Quelle III:
     * 32 Anmerkung Nr.
     * @param path
     * @return 
     */
    
    public ArrayList readHentschelCSV(String path) { 
        
        ArrayList<Datensatz> liste = new ArrayList<Datensatz>(); 
        //String CsvFile = path+"Mach-Findbuch.csv";
        String CsvFile = path + "Hentschel_Eingang.csv";
        String FieldDelimiter = ":";

        BufferedReader br;

        try {

            br = new BufferedReader(new FileReader(CsvFile));

            String line;
            
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(FieldDelimiter, -1);
                Datensatz daten = new Datensatz(
                        fields[0], "", 
                        fields[1], fields[2], 
                        fields[3],fields[4],fields[5],fields[6],
                        fields[7],fields[8],fields[9],fields[10],
                        fields[11],fields[12],fields[13],fields[14],
                        fields[15],fields[16],fields[17],fields[18],
                        fields[19],fields[20],fields[21],fields[22],
                        fields[23],fields[24],fields[25],fields[26],
                        fields[27],fields[28],fields[29],fields[30],
                        fields[31],"","Mach, Ernst");
                liste.add(daten);

            }

        } catch (IOException ex) {
            Logger.getLogger(CSVReader.class.getName())
                    .log(Level.SEVERE, null, ex);

        }
        
        return liste; 
    }
    
    /**
     * Methode liest das Findbuch des DMMS fuer die Hentschel Darstellung.
     * @param path
     * @return 
     */
    public ArrayList readDMMCSVforMapping(String path) { 
        
        ArrayList<Datensatz> liste = new ArrayList<Datensatz>(); 
        String CsvFile = path+"MachKorr2727UTF8_4.csv";
        String FieldDelimiter = ":";

        BufferedReader br;

        try {

            br = new BufferedReader(new FileReader(CsvFile));

            String line;
            
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(FieldDelimiter, -1);
                Datensatz daten = new Datensatz(
                        fields[13], fields[13], 
                        fields[9], fields[1], 
                        fields[2],"","","",
                        "",fields[7],fields[14],"",
                        fields[17],fields[15],"","",
                        "","","","",
                        "","","","",
                        "","","","",
                        "","","","",
                        "",fields[0],fields[4]);
                liste.add(daten);

            }

        } catch (IOException ex) {
            Logger.getLogger(CSVReader.class.getName())
                    .log(Level.SEVERE, null, ex);

        }
        
        
        return liste; 
        
    }

    
    /**
     * Methode liest das Findbuch des DMMs für die JavaFX Anwendung
     * @param path
     * @return 
     */
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
                /**
                 * [1] = DMM ID
                 * [5] = verfasser
                 * [6] = verfasser PND
                 * [9] = Datum
                 * [10] = empfänger
                 * [15] = empfänger PND
                 * [19] = ort
                 * [19] = koordinaten (wird gesplittet)
                 * 
                 */
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
