/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package normdaten;

import java.io.IOException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javax.script.ScriptException;
import machfindbuch.MachFindbuch;
import machfindbuch.Person;

/**
 *
 * @author matthias
 */
public class Statistik {
    
    
    /**
     * Iteriert über die gesamte Liste und und schreibt die Namen der Verfasser in ein Hashset.
     * Damit ist jeder Eintrag nur einmal vorhanden. 
     */
    public HashSet groupVerfasser(ObservableList<Person> liste) { 
    
        HashSet verfasser = new HashSet();
        int i = 0;
        
        if (liste.size() > 0) {

            while (i < liste.size()) {
                
                if (liste.get(i).getVerfasser().length()> 1) {
                    verfasser.add(liste.get(i).getVerfasser());
                }
                
                i++;    
            }
        }
        
        return verfasser;
    }  
    
    
     /**
     * Iteriert über die gesamte Liste und und schreibt die Namen der Verfasser in ein Hashset
     * deren PND in der Liste steht. Diese Liste ist daher kleiner als die unter groupVerfasser.
     * Die Methode liefert <verfassername>|<verfasserPID>. Dieses HashSet kann verwendet werden
     * um die PND nach viaf zu konvertieren. 
     * Damit ist jeder Eintrag nur einmal vorhanden. 
     * @param liste
     * @return 
     */
    public HashSet<String> groupVerfasserPND(ObservableList<Person> liste) { 
    
        HashSet<String> verfasserPND = new HashSet();
        int i = 0;
        
        if (liste.size() > 0) {

            while (i < liste.size()) {
                
                if (liste.get(i).getVerfasserPid().length()> 1) {
                    verfasserPND.add(liste.get(i).getVerfasser() +"|" + liste.get(i).getVerfasserPid());
                }
                
                i++;    
            }
        }
        
        return verfasserPND;
    }                
    
}
