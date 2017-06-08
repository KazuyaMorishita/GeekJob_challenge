package org.mypackage.sample;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import org.camp.servlet.ResultData;
/**
 *
 * @author kazuya
 */
public class ResultData impliments Serializable{
    private Date d;
    private String luck;

    publick ResultData() {}

    public Date getD() {
        return d;
    }

    public void  setD(date D){
        this.d = d;
}

    public String getLuck(){
        return luck;
}


}
