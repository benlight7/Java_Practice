//String類別是read-only
//StringBuffer類別則可以r/w
//此程式為玩轉String的範例.

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class demo18_StringBuffer {
    public static void main(String args[]) throws Exception{
        // Declaration
        StringBuffer strbr = new StringBuffer();
        String getbr;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // User Input
        System.out.println("Please Input Sentences:");
        getbr = br.readLine();
        // 轉成String: str.toString()
        if(getbr.indexOf("我") < 0)
            System.out.println("沒有出現「我」字");
        else
            System.out.println("「我」字出現在第" + (getbr.indexOf("我")+1) + "個位置");
            //利用StringBuffer處理字串
            strbr.append("["+ getbr +"]" + "這句話是你剛剛Input的");
            System.out.println(strbr.toString());
            int position = getbr.indexOf("我")+1;
            strbr.setCharAt(position, '你'); //把'我'改成'你'
            System.out.println(strbr.toString());
            strbr.deleteCharAt(position); //刪除"你"
            System.out.println(strbr.toString());
            strbr.insert(position, "在下"); //在那個位置插入"在下"
            System.out.println(strbr.toString());


    }
}
