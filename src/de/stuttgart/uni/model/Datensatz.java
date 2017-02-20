/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.stuttgart.uni.model;

import java.util.Objects;

/**
 * Repräsentiert einen Datensatz von Prof. Dr. Hentschel
 * @author matthias
 */
public class Datensatz {
    
    private String dmmid;
    // Koordinaten gibts bei Henstschel nicht, ich schreib sie dennoch raus. 
    private String koordinaten; 
    // DMM Feld 13
    private String ort; 
    // DMM Feld 9
    private String datum;
    // DMM Feld 1
    private String verfasser; 
    // DMM Feld 2 wenn leer dann Feld 3
    private String gnd;
    private String lcc; 
    private String ndl;
    private String viaf;
    private String empfänger_ort;
    // DMM Feld 14
    private String umfang; 
    private String seitenzahl; 
    private String form_des_originals;
    // DMM Feld 17
    private String anlage;
    // DMM Feld 15
    private String sprache; 
    private String quelle_1;
    private String seite_quelle_1;
    private String quelle_2;
    private String seite_quelle_2;
    private String quelle_3;
    private String seite_quelle_3;
    private String standort_quelle_1;
    private String standort_quelle_2;
    private String standort_quelle_3;
    private String institution_quelle_1; 
    private String institution_quelle_2;
    private String institution_quelle_3;
    private String signatur_quelle_1; 
    private String signatur_quelle_2;
    private String signatur_quelle_3;
    private String publikationsart_quelle_1; 
    private String publikationsart_quelle_2;
    private String publikationsart_quelle_3;
    private String anmerkung_nr; 
    private String empfänger; 

    public void setEmpfänger(String empfänger) {
        this.empfänger = empfänger;
    }

    public String getEmpfänger() {
        return empfänger;
    }

    public void setKoordinaten(String koordinaten) {
        this.koordinaten = koordinaten;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public void setVerfasser(String verfasser) {
        this.verfasser = verfasser;
    }

    public void setGnd(String gnd) {
        this.gnd = gnd;
    }

    public void setLcc(String lcc) {
        this.lcc = lcc;
    }

    public void setNdl(String ndl) {
        this.ndl = ndl;
    }

    public void setViaf(String viaf) {
        this.viaf = viaf;
    }

    public void setEmpfänger_ort(String empfänger_ort) {
        this.empfänger_ort = empfänger_ort;
    }

    public void setUmfang(String umfang) {
        this.umfang = umfang;
    }

    public void setSeitenzahl(String seitenzahl) {
        this.seitenzahl = seitenzahl;
    }

    public void setForm_des_originals(String form_des_originals) {
        this.form_des_originals = form_des_originals;
    }

    public void setAnlage(String anlage) {
        this.anlage = anlage;
    }

    public void setSprache(String sprache) {
        this.sprache = sprache;
    }

    public void setQuelle_1(String quelle_1) {
        this.quelle_1 = quelle_1;
    }

    public void setSeite_quelle_1(String seite_quelle_1) {
        this.seite_quelle_1 = seite_quelle_1;
    }

    public void setQuelle_2(String quelle_2) {
        this.quelle_2 = quelle_2;
    }

    public void setSeite_quelle_2(String seite_quelle_2) {
        this.seite_quelle_2 = seite_quelle_2;
    }

    public void setQuelle_3(String quelle_3) {
        this.quelle_3 = quelle_3;
    }

    public void setSeite_quelle_3(String seite_quelle_3) {
        this.seite_quelle_3 = seite_quelle_3;
    }

    public void setStandort_quelle_1(String standort_quelle_1) {
        this.standort_quelle_1 = standort_quelle_1;
    }

    public void setStandort_quelle_2(String standort_quelle_2) {
        this.standort_quelle_2 = standort_quelle_2;
    }

    public void setStandort_quelle_3(String standort_quelle_3) {
        this.standort_quelle_3 = standort_quelle_3;
    }

    public void setInstitution_quelle_1(String institution_quelle_1) {
        this.institution_quelle_1 = institution_quelle_1;
    }

    public void setInstitution_quelle_2(String institution_quelle_2) {
        this.institution_quelle_2 = institution_quelle_2;
    }

    public void setInstitution_quelle_3(String institution_quelle_3) {
        this.institution_quelle_3 = institution_quelle_3;
    }

    public void setSignatur_quelle_1(String signatur_quelle_1) {
        this.signatur_quelle_1 = signatur_quelle_1;
    }

    public void setSignatur_quelle_2(String signatur_quelle_2) {
        this.signatur_quelle_2 = signatur_quelle_2;
    }

    public void setSignatur_quelle_3(String signatur_quelle_3) {
        this.signatur_quelle_3 = signatur_quelle_3;
    }

    public void setPublikationsart_quelle_1(String publikationsart_quelle_1) {
        this.publikationsart_quelle_1 = publikationsart_quelle_1;
    }

    public void setPublikationsart_quelle_2(String publikationsart_quelle_2) {
        this.publikationsart_quelle_2 = publikationsart_quelle_2;
    }

    public void setPublikationsart_quelle_3(String publikationsart_quelle_3) {
        this.publikationsart_quelle_3 = publikationsart_quelle_3;
    }

    public void setAnmerkung_nr(String anmerkung_nr) {
        this.anmerkung_nr = anmerkung_nr;
    }
    
     public String getKoordinaten() {
        String coo = koordinaten; 
        String[ ] cooArray = ort.split("~");
        if (cooArray.length > 1) {
            coo = cooArray[1].trim().replace("\"","");
        }
        return coo;
    }
    

    public String getOrt() {
        String[ ] ortArray = ort.split("~");
        return ortArray[0].trim().replace("\"","");
    }

    public String getDatum() {
        return datum.trim();
    }

    public String getVerfasser() {
        return verfasser.trim();
    }

    public String getGnd() {
        return gnd.trim();
    }

    public String getLcc() {
        return lcc.trim();
    }

    public String getNdl() {
        return ndl.trim();
    }

    public String getViaf() {
        return viaf.trim();
    }

    public String getEmpfänger_ort() {
        return empfänger_ort.trim();
    }

    public String getUmfang() {
        return umfang.trim();
    }

    public String getSeitenzahl() {
        return seitenzahl.trim();
    }

    public String getForm_des_originals() {
        return form_des_originals.trim();
    }

    public String getAnlage() {
        return anlage.trim();
    }

    public String getSprache() {
        return sprache.trim();
    }

    public String getQuelle_1() {
        return quelle_1.trim();
    }

    public String getSeite_quelle_1() {
        return seite_quelle_1.trim();
    }

    public String getQuelle_2() {
        return quelle_2.trim();
    }

    public String getSeite_quelle_2() {
        return seite_quelle_2.trim();
    }

    public String getQuelle_3() {
        return quelle_3.trim();
    }

    public String getSeite_quelle_3() {
        return seite_quelle_3.trim();
    }

    public String getStandort_quelle_1() {
        return standort_quelle_1.trim();
    }

    public String getStandort_quelle_2() {
        return standort_quelle_2.trim();
    }

    public String getStandort_quelle_3() {
        return standort_quelle_3.trim();
    }

    public String getInstitution_quelle_1() {
        return institution_quelle_1.trim();
    }

    public String getInstitution_quelle_2() {
        return institution_quelle_2.trim();
    }

    public String getInstitution_quelle_3() {
        return institution_quelle_3.trim();
    }

    public String getSignatur_quelle_1() {
        return signatur_quelle_1.trim();
    }

    public String getSignatur_quelle_2() {
        return signatur_quelle_2.trim();
    }

    public String getSignatur_quelle_3() {
        return signatur_quelle_3.trim();
    }

    public String getPublikationsart_quelle_1() {
        return publikationsart_quelle_1.trim();
    }

    public String getPublikationsart_quelle_2() {
        return publikationsart_quelle_2.trim();
    }

    public String getPublikationsart_quelle_3() {
        return publikationsart_quelle_3.trim();
    }

    public String getAnmerkung_nr() {
        return anmerkung_nr.trim();
    }
    
    public void setDmmid(String dmmid) {
        this.dmmid = dmmid;
    }

    public String getDmmid() {
        return dmmid;
    }

    public Datensatz(String ort, String koordinaten, String datum, String verfasser, String gnd, String lcc, String ndl, String viaf, String empfänger_ort, String umfang, String seitenzahl, String form_des_originals, String anlage, String sprache, String quelle_1, String seite_quelle_1, String quelle_2, String seite_quelle_2, String quelle_3, String seite_quelle_3, String standort_quelle_1, String standort_quelle_2, String standort_quelle_3, String institution_quelle_1, String institution_quelle_2, String institution_quelle_3, String signatur_quelle_1, String signatur_quelle_2, String signatur_quelle_3, String publikationsart_quelle_1, String publikationsart_quelle_2, String publikationsart_quelle_3, String anmerkung_nr, String dmmid, String empfänger) {
     
        this.ort = ort;
        this.koordinaten = koordinaten;
        this.datum = datum;
        this.verfasser = verfasser;
        this.gnd = gnd;
        this.lcc = lcc;
        this.ndl = ndl;
        this.viaf = viaf;
        this.empfänger = empfänger;
        this.empfänger_ort = empfänger_ort;
        this.umfang = umfang;
        this.seitenzahl = seitenzahl;
        this.form_des_originals = form_des_originals;
        this.anlage = anlage;
        this.sprache = sprache;
        this.quelle_1 = quelle_1;
        this.seite_quelle_1 = seite_quelle_1;
        this.quelle_2 = quelle_2;
        this.seite_quelle_2 = seite_quelle_2;
        this.quelle_3 = quelle_3;
        this.seite_quelle_3 = seite_quelle_3;
        this.standort_quelle_1 = standort_quelle_1;
        this.standort_quelle_2 = standort_quelle_2;
        this.standort_quelle_3 = standort_quelle_3;
        this.institution_quelle_1 = institution_quelle_1;
        this.institution_quelle_2 = institution_quelle_2;
        this.institution_quelle_3 = institution_quelle_3;
        this.signatur_quelle_1 = signatur_quelle_1;
        this.signatur_quelle_2 = signatur_quelle_2;
        this.signatur_quelle_3 = signatur_quelle_3;
        this.publikationsart_quelle_1 = publikationsart_quelle_1;
        this.publikationsart_quelle_2 = publikationsart_quelle_2;
        this.publikationsart_quelle_3 = publikationsart_quelle_3;
        this.anmerkung_nr = anmerkung_nr;
        this.dmmid = dmmid;
    }

    @Override
    public String toString() {
        return "Datensatz{"+ "ort=" + ort + ", datum=" + datum + ", verfasser=" + verfasser + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Datensatz other = (Datensatz) obj;
       // if (!Objects.equals(this.ort, other.ort)) {
       //     return false;
       // }
        if (!Objects.equals(this.datum, other.datum)) {
            return false;
        }
        if (!Objects.equals(this.verfasser, other.verfasser)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
