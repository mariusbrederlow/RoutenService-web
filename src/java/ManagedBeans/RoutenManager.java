/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Kommunikation.LookUp;
import entities.Knoten;
import interfaces.IRoutenService;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.NamingException;


/**
 *
 * @author mariusbrederlow
 */
@ManagedBean(name="RoutenManager")
@SessionScoped
public class RoutenManager implements Serializable {
private List<Knoten> pfad;
private List<Knoten> knotenliste;
private List<String> test;
private String standort;
private String zielort;
private Knoten quelle;
private Knoten ziel;

    
    
    public RoutenManager() throws NamingException, IOException {
       
        IRoutenService dienst = (IRoutenService) new LookUp().doLookUp("java:global/RoutenService-ejb/RoutenService"); 
      knotenliste=dienst.getKnotenListe();
        System.out.println(knotenliste);
    }

 public void test() throws NamingException, IOException{
      System.out.println(standort);
      System.out.println(zielort);
 }
    
    public void setzeOrte() throws NamingException, IOException{
        IRoutenService dienst = (IRoutenService) new LookUp().doLookUp("java:global/RoutenService-ejb/RoutenService"); 
        if(!"0".equals(standort) && !"0".equals(zielort)){
            dienst.setStandort(standort);
            dienst.setZielort(zielort);
        }
        
    }
    
    public void berechneWeg() throws NamingException, IOException{
         IRoutenService dienst = (IRoutenService) new LookUp().doLookUp("java:global/RoutenService-ejb/RoutenService"); 
        
         pfad=dienst.getSchnellsterWeg(standort,zielort);
    }


    public List<Knoten> getKnotenliste() {
        return knotenliste;
    }

    public void setKnotenliste(List<Knoten> knotenliste) {
        this.knotenliste = knotenliste;
    }

    public Knoten getQuelle() {
        return quelle;
    }

    public void setQuelle(Knoten quelle) {
        this.quelle = quelle;
    }

    public Knoten getZiel() {
        return ziel;
    }

    public void setZiel(Knoten ziel) {
        this.ziel = ziel;
    }

    public List<String> getTest() {
        return test;
    }

    public void setTest(List<String> test) {
        this.test = test;
    }

    public List<Knoten> getPfad() {
        return pfad;
    }

    public void setPfad(List<Knoten> pfad) {
        this.pfad = pfad;
    }

    

    public String getStandort() {
        return standort;
    }

    public void setStandort(String standort) {
        this.standort = standort;
    }

    public String getZielort() {
        return zielort;
    }

    public void setZielort(String zielort) {
        this.zielort = zielort;
    }



}
