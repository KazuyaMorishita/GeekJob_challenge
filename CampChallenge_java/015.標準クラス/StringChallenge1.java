/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Java;

/**
 *
 * @author kazuya
 */
public class StringChallenge1 {
    
    public static void main(String[] args) {
        
        //文字列型の変数を宣言
        String name = "森下 和也";
        
        //文字列型、変数nameの文字の数を取得
        System.out.println("文字の数は「" +  + name.length() + "」です");
        //文字列、変数nameのバイト数を取得
        System.out.println("バイト数は「" + name.getBytes().length + "byte」です");
        
    } 
    
}
