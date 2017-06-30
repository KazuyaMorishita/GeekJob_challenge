/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Java;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.*;

/**
 *
 * @author kazuya
 */
public class FOpnChallenge3 {
    
    //enumを定義
    public enum Bord {

        NOVEMBER,
        YESNOWBORD,
        Gentem

    }

    public static void main(String[] args) {

        //Fileクラスを使用し、ファイルを開く
        File logfp = new File("C:\\Users\\kazuya\\Desktop\\log.txt");

        //Dateクラスをインスタンス化
        Date date = new Date();

        //日付を文字列に変更するためSimpleDateFormatをインスタンス化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        //ハンドリングエラーを設定
        try {

            //log.txtへ日時と「開始」という文字列を書き込む
            FileWriter stratlog = new FileWriter(logfp, true);
            stratlog.write(sdf.format(date) + "\r\n開始\r\n");
            stratlog.close();
            
            //YESNOWBORDの場合に表示
            Bord bord = Bord.YESNOWBORD;

            switch (bord) {
                
                case NOVEMBER:
                    System.out.println("Artiste");
                    break;
                case YESNOWBORD:
                    System.out.println("basic");
                    break;
                case Gentem:
                    System.out.println("Gentem");
                    break;

            }

            //log.txtへ日時と「終了」という文字列を書き込む
            FileWriter endlog = new FileWriter(logfp, true);
            endlog.write(sdf.format(date) + "\r\n終了\r\n");
            endlog.close();
            
            //ファイルの読み込み
            FileReader logfr = new FileReader(logfp);
            
            //効率的に読み出す
            BufferedReader logbr = new BufferedReader(logfr);
            
            //BufferedReaderクラスのreadLineメソッドを変数に格納
            String logstr = logbr.readLine();
            
            //log.txt内を一行ずつ表示
            while (logstr != null){
                System.out.println(logstr);
                logstr = logbr.readLine();
            }

        } catch (IOException ex) {

            Logger.getLogger(FOpnChallenge3.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

}
