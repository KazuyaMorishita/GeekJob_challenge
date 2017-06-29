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
public class StringChallenge3 {

    public static void main(String[] args) {

        //文字列変数を宣言
        String str = "きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます";
        
        //指定文字をを取得
        str = str.replace("U", "う");
        str = str.replace("I", "い");
        System.out.println(str);

    }

}
