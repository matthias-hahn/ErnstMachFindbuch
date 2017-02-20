/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.stuttgart.uni.model;


/**
 * Repräsentiert eine Person oder Insitution
 * @author matthias
 */
public class Person {
    
    // Empfänger oder Sender
    private String dmmID; 
    private String verfasser;
    private String empfänger; 
    private String name;
    private String verfasserPid;
    private String empfängerPid;
    private String datum; 
    private String koordinaten; 
    private String ort;

    public String getKoordinaten() {
        String coo = ""; 
        String[ ] cooArray = ort.split("~");
        if (cooArray.length > 1) {
            coo = cooArray[1].trim().replace("\"","");
        }
        return coo; 
    }

    public void setKoordinaten(String koordinaten) {
        this.koordinaten = koordinaten;
    }
 

    public String getDatum() {
        return datum.trim().replace("\"","");
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }
   
    
    public Person() {
        this.verfasser=""; 
        this.name="";
        
    }; 
    
    public Person(String dmmId, String verfasser, String verfasserPid, String empfänger, String empfängerPid, String datum, String ort, String koordianten) {
        this.dmmID=dmmId; 
        this.verfasser = verfasser;
        this.verfasserPid = verfasserPid;
        this.datum=datum; 
        this.empfänger=empfänger;
        this.empfängerPid=empfängerPid; 
        this.ort=ort; 
        this.koordinaten=koordinaten; 
        
    }
    
    
    

  

    public String getOrt() {
        
        String[ ] ortArray = ort.split("~");
        return ortArray[0].trim().replace("\"","");
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getDmmID() {
        return dmmID.trim().replace("\"","");
    }

    public void setDmmID(String dmmID) {
        this.dmmID = dmmID;
    }

    public String getVerfasserPid() {
        return verfasserPid.trim().replace("\"","");
    }

    public void setVerfasserPid(String verfasserPid) {
        this.verfasserPid = verfasserPid;
    }

    public String getEmpfängerPid() {
        return empfängerPid.trim().replace("\"","");
    }

    public void setEmpfängerPid(String empfängerPid) {
        this.empfängerPid = empfängerPid;
    }


    public String getVerfasser() {
        return verfasser.trim().replace("\"","");
    }

    public void setVerfasser(String verfasser) {
        this.verfasser = verfasser;
    }

    public String getEmpfänger() {
        return empfänger.trim().replace("\"","");
    }

    public void setEmpfänger(String empfänger) {
        this.empfänger = empfänger;
    }
   

    public String getName() {
        return name.trim().replace("\"","");
    }

    public void setName(String nachname) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" + "verfasser=" + verfasser + '}';
    }
    
    
    
    
    
}
