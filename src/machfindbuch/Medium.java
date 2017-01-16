/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package machfindbuch;

/**
 *
 * @author matthias
 */
public class Medium {
    
    private Integer id; 
    private String typ; 
    private String datum;
    private String kommentar;

    public Medium() {
    }

    public Medium(Integer id, String typ, String datum, String kommentar) {
        this.id = id;
        this.typ = typ;
        this.datum = datum;
        this.kommentar = kommentar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }
    
}
