/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.navigation;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

/**
 *
 * @author mariusbrederlow
 */
@ManagedBean(name = "NavigationBean")
@SessionScoped

public class NavigationBean implements Serializable {

    /*
 * Der String pageToDisplay enthaelt immer die Seite, die aktuell im center-panel angezeigt wird.
 */
    public NavigationBean() {
    }

private String pageToDisplay = "RoutenService.xhtml";

  public String getPageToDisplay(){      
      return this.pageToDisplay;
  }

  public void setPageToDisplay(String pageToDisplay){
      this.pageToDisplay = pageToDisplay;
  }







}
