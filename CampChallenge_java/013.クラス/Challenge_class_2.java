/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

/**
 *
 * @author kazuya
 */
class Test {

    public int num1 = 0;
    public int num2 = 0;

    public void setnum(int a, int b) {
        this.num1 = a;
        this.num2 = b;
    }

    public void pw() {
        System.out.println(num1 + num2);
    }
}

class Ntest extends Test {
    public void clear() {
        setnum(0, 0);
    }
}

public class Challenge_class_1 {
    public static void main(String[] args) {
        //インスタンスを生成
        Ntest test = new Ntest();
        test.setnum(3, 5);
        test.pw();
        test.clear();
        test.pw();
    }
}
