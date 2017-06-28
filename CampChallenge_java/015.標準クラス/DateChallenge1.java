/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Java;

import java.util.Date;

/**
 *
 * @author kazuya
 */
public class DateChallenge1 {
    
    public static void main(String[] args){
    
        //2016年1月1日 0時0分0秒のタイムスタンプを作成
        Date date = new Date("2016/01/01 00:00:00");
        
        //タイムスタンプを表示
        System.out.println(date.getTime());
        
        
        
    }
    
}
