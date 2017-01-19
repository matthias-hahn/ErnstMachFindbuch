/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package normdaten;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptException;
import machfindbuch.MachFindbuch;

/**
 *
 * @author matthias
 */
public class ConvertID {
    
    /**
     * Konvertiert eine PND in eine Viaf über den Webservice der viaf.org
     * viaf.org liefert ein JSON Dokument zurück. 
     * @param verfasser 
     */
    public Map pndtoviaf(HashSet<String> verfasserPND) throws IOException, ScriptException {
    
        ReadJson json = new ReadJson();
        Map<String,String> verfasser = new HashMap(); 
        String vafid = "";
        String pnd;
        int i = 0;
            
        if (verfasserPND.size() > 0) {
           
            for (String entry : verfasserPND) {
                
                int index1 = entry.indexOf("|");
                pnd = entry.substring(index1+1);
                System.out.println("====> PND: " + i + "   " + pnd); 
                if (pnd.length()==9) {
                    URL url  = URLConnection.getURL(pnd);
                    if (url != null) vafid = json.readJSON(url);
                } else { 
                    vafid="";
                }
                verfasser.put(vafid,entry);
                i++;
                System.out.println("====> VAFID: " + i + "   " + vafid);    
            }
            
        } 
        return verfasser;
    }
}    
