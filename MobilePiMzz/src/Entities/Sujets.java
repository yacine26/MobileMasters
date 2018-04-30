/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Yacine
 */
public class Sujets {
    private int id;
    public String sujet ;

    public Sujets(int id, String sujet) {
        this.id = id;
        this.sujet = sujet;
    }

    public Sujets(String sujet) {
        this.sujet = sujet;
    }

    public Sujets(int id) {
        this.id = id;
    }

    public Sujets() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }
    
    
    
}
