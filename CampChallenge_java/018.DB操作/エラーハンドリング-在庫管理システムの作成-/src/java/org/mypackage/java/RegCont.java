/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.java;

import java.io.Serializable;

/**
 *
 * @author kazuya
 */
public class RegCont implements Serializable {
    
    //フィールドを宣言(変数宣言)
    private String itemCont;
    private String labelCont;
    private int stockCont;
    
    public RegCont() {
    }
    
    public String getItem() {
        return itemCont; 
    }
    
    public String getLabel(){
        return labelCont;
    }
    
    public int getStock(){
        return stockCont;
    }
    
    public void setItem(String itemArgs){
        this.itemCont = itemArgs;
    }
    
    public void setLabel(String labelArgs){
        this.labelCont = labelArgs;
    }
    
    public void setStock(int stockArgs){
        this.stockCont = stockArgs;
    }
    
}
