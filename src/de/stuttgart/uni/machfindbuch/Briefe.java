/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.stuttgart.uni.machfindbuch;

import de.stuttgart.uni.model.Datensatz;
import de.uni.stuttgart.input.CSVReader;
import java.util.ArrayList;

/**
 * Main Class um die Briefe der Excel Sheets zusammenzuführen. 
 * @author matthias
 */
public class Briefe {
    
    final static String path = "/home/matthias/NetBeansProjects/MachFindbuch/data/";
    
    public static void main(String[] args) {
        
        CSVReader reader = new CSVReader();
       
        // Lesen der Datensätze DMM
        ArrayList<Datensatz> dmm = reader.readDMMCSVforMapping(path);
        // Lesen Eingang Hentschel
        //ArrayList<Datensatz> hentschel = reader.readHentschelCSV(path);
        // Lesen Ausgang Hentschel
        ArrayList<Datensatz> hentschel_aus = reader.readHentschelAusgangCSV(path);
        
        //output
        ArrayList<Datensatz> dubletten = new ArrayList<Datensatz>();

        
        // Vergleich der Datensätze dmm und hentschel. 
        int i=0; 
        for (Datensatz dmmItem: dmm) {
            //System.out.println("Processing: " + dmmItem.toString());
            for (Datensatz hItem: hentschel_aus) {
                if(dmmItem.equals(hItem)) { 
                    i++;
                    // Dublette gefunden - merge inhalte
                    System.out.println("Dublette H=DMM: " + hItem.toString() + " = " + dmmItem.toString());
                    dubletten.add(hItem);
                    // löschen der Dubletten aus DMM Liste - besser wäre mergen.
                    //dmm.remove(dmm);
                    
                } 
            }
        }
        
        System.out.println("Anzahl gefundener Dubletten: " + i);
        
        //Integriere Hentschel Liste in DMM ohne Dubletten
        dmm.addAll(hentschel_aus);
        
        
        System.out.println("DMM ID|Ort|Koordinaten|Datum|Verfasser|PND/GND|LCC|NDL|ViaF|Empfänger|Empfänger Ort|"
                + "Art|Seitenzahl|Form des Original|Anlage|Sprache|Quelle 1|Seiten Quelle 1|"
                + "Quelle 2| Seiten Quelle 2| Quelle 3| Seiten Quelle 3| Standort Quelle 1|"
                + "Standort Quelle 2|Standort Quelle 3| Institution Quelle 1|"
                + "Insitution Quelle 2|Insitution Quelle 3|Signatur Quelle 1|"
                + "Signatur Quelle 2|Signatur Quelle 3|Publikationart Quelle 1|"
                + "Publikationsart Quelle 2|Publikationsart Quelle 3|Anmerkung");
       
        for (Datensatz item: dmm) {
            System.out.println(
                    item.getDmmid() + "|" +
                    item.getOrt()+ "|" + 
                    item.getKoordinaten()+"|"+ 
                    item.getDatum() + "|" + 
                    item.getVerfasser()+ "|" + 
                    item.getGnd() + "|" +
                    item.getLcc() + "|" +
                    item.getNdl() + "|" +
                    item.getViaf() + "|" +
                    item.getEmpfänger() +"|"+
                    item.getEmpfänger_ort() +"|"+
                    item.getUmfang() + "|" +
                    item.getSeitenzahl() +"|" +
                    item.getForm_des_originals() +"|" +
                    item.getAnlage() +"|" +
                    item.getSprache() +"|" +
                    item.getQuelle_1() +"|" +
                    item.getSeite_quelle_1() +"|" +
                    item.getQuelle_2()  +"|" +
                    item.getSeite_quelle_2() +"|" +
                    item.getQuelle_3()+"|" + 
                    item.getSeite_quelle_3() +"|" + 
                    item.getStandort_quelle_1() +"|" +
                    item.getSeite_quelle_2() +"|" +
                    item.getStandort_quelle_3() +"|" +
                    item.getInstitution_quelle_1() +"|" +
                    item.getInstitution_quelle_2() +"|" +
                    item.getInstitution_quelle_3() +"|" +
                    item.getSignatur_quelle_1() +"|" +
                    item.getSignatur_quelle_2() +"|" +
                    item.getSignatur_quelle_3() +"|" +
                    item.getPublikationsart_quelle_1() +"|" +
                    item.getPublikationsart_quelle_2() +"|" +
                    item.getPublikationsart_quelle_3() +"|" +
                    item.getAnmerkung_nr()
                    );
        }
        
        
    }
    
}
