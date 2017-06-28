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
public class DateChallenge4 {
    
    public static void main(String[] args){
    
        //2015年1月1日 0時0分0秒のタイムスタンプを作成
        Date date1 = new Date("2015/01/01 00:00:00");
        
        //2015年12月31日 23時59分59秒のタイムスタンプを作成
        Date date2 = new Date("2015/12/31 23:59:59");
        
        //2015年1月1日 0時0分0秒と2015年12月31日 23時59分59秒との差を表示
        System.out.println(date2.getTime() - date1.getTime());
        
    
    }
    
}
