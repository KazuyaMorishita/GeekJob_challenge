/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.java;

import java.io.Serializable;
import java.util.*;
import java.sql.*;

/**
 *
 * @author kazuya
 */
public class RS_itemList implements Serializable {

    private ResultSet rsData;

    public RS_itemList() {
    }

    public void setRsdata(ResultSet rs) {
        this.rsData = rs;
    }

    public ResultSet getRsdata() {
        return rsData;
    }

}
