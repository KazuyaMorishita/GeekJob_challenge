/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Java;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author kazuya
 */
public class DateChallenge2 {
    
    public static void main(String[] args){
        
        //現在の日付を作成
        Date date = new Date();
        
        //SimpleDateFormatクラスをインスタンス化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        
        //日付を文字列に変換し表示
        System.out.println(sdf.format(date));
    
    }
    
}
