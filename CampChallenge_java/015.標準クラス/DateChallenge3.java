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
public class DateChallenge3 {
    
    public static void main(String[] args){
        
        // 今日の日付作成
        Date date = new Date();
    
        //2016年11月4日 10時0分0秒のタイムスタンプを作成
        SimpleDateFormat sdf = new SimpleDateFormat("2016/11/04 10:00:00");
        
        //年-月-日 時:分:秒で表示
        System.out.println(sdf.format(date));
        
    }
    
}
