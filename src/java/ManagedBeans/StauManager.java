/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Kommunikation.LookUp;
import interfaces.IRoutenService;
import interfaces.IStauService;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.NamingException;


/**
 *
 * @author peters
 */
@ManagedBean(name="StauManager")
@SessionScoped
public class StauManager implements Serializable{

    public void generiereStau() throws NamingException, IOException{
         IStauService dienst = (IStauService) new LookUp().doLookUp("java:global/Staugenerator-ejb/StauService"); 
         dienst.generiereStau();
    }
    
    
    public StauManager() {
    }
}
