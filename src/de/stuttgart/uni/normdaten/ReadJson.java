/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.stuttgart.uni.normdaten;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class ReadJson  {
    
    private ScriptEngine engine;
    //JSON lesen ohne externe libs . Siehe Adrian Bien. 
    public String readJSON(URL input) throws ScriptException {
        
        ScriptEngineManager sem = new ScriptEngineManager();
        this.engine = sem.getEngineByName("javascript");
        
        String viafid = "";
        StringBuffer json;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(input.openStream()))) {
            String inputLine;
            json = new StringBuffer();
            while ((inputLine = in.readLine()) != null) json.append(inputLine);
            
            String script = "Java.asJSONCompatible(" + json + ")";
            Object result = this.engine.eval(script);
            Map contents = (Map)result;
            viafid = (String) contents.get("viafID");
       
        }   catch (IOException ex) {
            Logger.getLogger(ReadJson.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return viafid;
    
    }
}    
