/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package normdaten;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author matthias
 */
public class URLConnection {
    
  // Singelton!
  private static URLConnection instance;
  // Verhindere die Erzeugung des Objektes über andere Methoden
  private URLConnection () {}
  // Eine Zugriffsmethode auf Klassenebene, welches dir '''einmal''' ein konkretes 
  // Objekt erzeugt und dieses zurückliefert.
  // Durch 'synchronized' wird sichergestellt dass diese Methode nur von einem Thread 
  // zu einer Zeit durchlaufen wird. Der nächste Thread erhält immer eine komplett 
  // initialisierte Instanz.
  public static synchronized URLConnection getInstance () {
    if (URLConnection.instance == null) {
      URLConnection.instance = new URLConnection ();
    }
    return URLConnection.instance;
  }
  

    
    public static URL getURL(String pnd) {
        
      try {
          String url = "http://viaf.org/viaf/sourceID/DNB|"+pnd+"/justlinks.json";
          URL viaf = new URL(url);
          
          return viaf;
      } catch (MalformedURLException ex) {
          Logger.getLogger(URLConnection.class.getName()).log(Level.SEVERE, null, ex);
      }
      
      return null; 
      
    }
    
    
}
