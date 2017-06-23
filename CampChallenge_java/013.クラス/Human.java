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
abstract public class Human{
    //カードの合計値を計算するメソッド
    abstract public Integer open();
    //手札をセットするメソッド
    abstract public void setCard(ArrayList<Integer> set);
    //手札の合計値と21を比較
    abstract public boolean checkSum();
    //手札
    public ArrayList<Integer> myCards = new ArrayList<Integer>();
}
