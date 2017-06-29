/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Java;

import java.util.*;

/**
 *
 * @author kazuya
 */
public class StringChallenge2 {
    
    public static void main(String[] args){
        
        //変数「madd」へメールアドレスを代入
        String mailadd = "automata@gmail.com  ";
        //変数の長さを確認
        System.out.println(mailadd.length());
        
        //文字列の前後の空白部分を削除
        mailadd = mailadd.trim();
        
        //文字列の長さを取得
        int mailaddLen = mailadd.length();
        System.out.println(mailaddLen);
        //「@」が何番目の位置にあるかを取得
        System.out.println(mailadd.indexOf("@"));
        //@以降の文字列を取得
        String domain = mailadd.substring(mailadd.indexOf("@") + 1, mailaddLen);
        System.out.println(domain);
               
    }
    
}
