/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletAl;

/**
 *
 * @author pauva
 */
public class Alumno {
    String nom;
    int codi;
private String assignatures="", tutories="";

    public String getAssignatures() {
        return assignatures;
    }

    public Alumno() {
    }

    public void setAssignatures(String assignatures) {
        this.assignatures +=""+ assignatures + ", " ;
    }
    
    public String getTutories() {
        return tutories;
    }

    public void setTutories(String tutories) {
        this.tutories +=""+  tutories+ ", ";
    }
    public Alumno(String nom, int codi) {
        this.nom = nom;
        this.codi = codi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    @Override
    public String toString() {
        return  nom ;
    }
    
}
