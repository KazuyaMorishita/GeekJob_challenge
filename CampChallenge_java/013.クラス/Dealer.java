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
public class Dealer extends Human {

    ArrayList<Integer> cards = new ArrayList<Integer>();

    //初期処理
    public Dealer() {

        //トランプが54枚になるまで繰り返し
        for (int i = 1; i <= 13; i++) {
            for (int j = 1; j <= 4; j++) {
                //要素の中身を追加

                if (i == 11) {
                    cards.add(10);
                } else if (i == 12) {
                    cards.add(10);
                } else if (i == 13) {
                    cards.add(10);
                } else {
                    cards.add(i);
                }
                
            }
        }
        //繰り返し処理で生成された54枚のトランプをシャフル
        Collections.shuffle(cards);
    }
    
    //プレイ開始時の処理として手札を2枚引き、引いた番号を削除する
    public ArrayList<Integer> deal() {
        ArrayList<Integer> dealcard = new ArrayList<Integer>();
        //cardsの中に入っている0番目の要素を取得し、取得したcrdsの0番目の要素を削除する。その処理を2回繰り返す。
        for (int i = 1; i <= 2; i++) {
            dealcard.add(cards.get(0));
            cards.remove(0);
        }
        //dealcardの中に戻り値として呼び出し元に返す 
        return dealcard;
    }
    //0番目の要素を取得して取得した要素を削除する。

    public ArrayList<Integer> hit() {
        ArrayList<Integer> hitcard = new ArrayList<Integer>();
        hitcard.add(cards.get(0));
        cards.remove(0);
        return hitcard;
    }

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
    
