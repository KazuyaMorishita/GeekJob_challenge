package jums;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 画面系の処理や表示を簡略化するためのヘルパークラス。定数なども保存されます
 * @author hayashi-s
 */
public class JumsHelper {
    
    //トップへのリンクを定数として設定
    private final String homeURL = "index.jsp";
    private final String searchURL = "search.jsp";
    private final String searchResultURL = "searchresult.jsp";
    private final String ResultDetailURL = "resultdetail.jsp";
    
    public static JumsHelper getInstance(){
        return new JumsHelper();
    }
    
    //トップへのリンクを返却
    public String home(){
        return "<a href=\"" + homeURL + "\">トップへ戻る</a>";
    }
    
    public String toSerch(){
        return "<a href=\"" + searchURL + "\">検索画面へ戻る</a>";
    }
    
    public String toSerchResult(){
        return "<a href=\"" + searchResultURL + "\">検索結果画面へ戻る</a>";
    }
    public String toResultDetail(){
        return "<a href=\"" + ResultDetailURL + "\">詳細画面へ戻る</a>";
    }
    
    /**
     * 入力されたデータのうち未入力項目がある場合、チェックリストにしたがいどの項目が
     * 未入力なのかのhtml文を返却する
     * @param chkList　UserDataBeansで生成されるリスト。未入力要素の名前が格納されている
     * @return 未入力の項目に対応する文字列
     */
    public String chkinput(ArrayList<String> chkList){
        String output = "";
        for(String val : chkList){
                if(val.equals("name")){
                    output += "名前";
                }
                if(val.equals("year")){
                    output +="年";
                }
                if(val.equals("month")){
                    output +="月";
                }
                if(val.equals("day")){
                    output +="日";
                }
                if(val.equals("type")){
                    output +="種別";
                }
                if(val.equals("tell")){
                    output +="電話番号";
                }
                if(val.equals("comment")){
                    output +="自己紹介";
                }
                output +="が未記入です<br>";
            }
        return output;
    }
    
    /**
     * 種別は数字で取り扱っているので画面に表示するときは日本語に変換
     * @param i
     * @return 
     */
    public String exTypenum(int i) {
        switch(i){
            case 1:
                return "営業";
            case 2:
                return "エンジニア";
            case 3:
                return "その他";
        }
        return "";
    }

     /**
     * DBからタイムスタンプ型で取得した値をformatしミリ秒を切り捨てるためのメソッド
     * ミリ秒を切り捨てて画面に表示させたい時に使用する
     * @param i
     * @return 
     */
    public String exTimestamp (Timestamp newdate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String newDate = sdf.format(newdate);
        return newDate;
    }
    
     /**
     * DBから受け取ったBirthdayのデータを年・月・日で分割するメソッド
     * ユーザー側で表示する際に使用
     * @param i
     * @return 
     */
    
    public int exYear (Date birArgs) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        int year = Integer.parseInt(sdf.format(birArgs));
        return year;
    }
    public int exMonth (Date birArgs){
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        int month = Integer.parseInt(sdf.format(birArgs));
        return month;
    }
    public int exDay (Date birArgs){
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        int day = Integer.parseInt(sdf.format(birArgs));
        return day;
    }
    
}
