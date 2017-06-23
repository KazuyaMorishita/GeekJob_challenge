/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.java;

import java.util.*;

/**
 *
 * @author kazuya
 */
public class User extends Human {

    //最終的なカードの合計値を計算するメソッド
    @Override
    //mayCardsの要素数を取得し、要素数分の値の合計値を計算
    public Integer open() {
        Integer fsum = 0;
        for (int i = 0; i < myCards.size(); i++) {
            fsum = fsum + myCards.get(i);
        }
    return fsum;
    }
    
    //手札をセットするメソッド
    @Override
    //引数の要素数を計算しmyCardsへ要素数分の要素の値を追加する
    public void setCard(ArrayList<Integer> set) {
        for (int i = 0; i < set.size(); i++) {
            myCards.add(set.get(i));
        }
    }
    
    //現在の手札の合計値を比較し条件を満たす場合にはtrueを戻り値として呼び出し元に返す
    @Override
    public boolean checkSum() {
        Integer sum = 0;
    //myCardsの要素数を取得
        for (int i = 0; i < myCards.size(); i++) {
            
            //myCardsの中身の合計値を計算
            sum = sum + myCards.get(i);
            
        }
        
        if (sum <= 17) {
            return true;
        }
            return false;
    }
    
}
    
