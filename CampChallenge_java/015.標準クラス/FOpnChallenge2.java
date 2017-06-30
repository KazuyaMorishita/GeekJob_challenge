/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Java;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kazuya
 */
public class FOpnChallenge2 {

    public static void main(String[] args) {

        //Fileクラスを使用し、ファイルを開く
        File fp = new File("C:\\Users\\kazuya\\Desktop\\FOpnChallenge.txt");

        //ハンドリングエラーを設定
        //FileWriterを宣言
        //FileWriter fw;
        try {

//            //FileWriterをインスタンス化
//            fw = new FileWriter(fp, true);
//            //ファイルに書き込み
//            fw.write("自己紹介\r\nわたしの名前は森下和也です\r\nよろしくお願いします。\r\n");
//            //ファイルを閉じる
//            fw.close();

            //ファイルから読み出す処理を実装している、FileReaderクラスをインスタンス化
            FileReader fr = new FileReader(fp);

            //BufferReaderクラスをインスタンス化
            BufferedReader br = new BufferedReader(fr);

            String str = br.readLine();
            //表示
            while (str != null) {
                System.out.println(str);
                str = br.readLine();
            }

            br.close();

        } catch (IOException ex) {

            Logger.getLogger(FOpnChallenge1.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

}
