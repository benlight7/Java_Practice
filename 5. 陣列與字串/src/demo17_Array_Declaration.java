//Array
//Using JAVA內建Array排序函數

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class demo17_Array_Declaration {
    public static void main(String args[]) throws Exception{
        // 輸入有多少個學生
        String getbr;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please Input how many student: ");
        getbr = br.readLine();
        // 浮點數分數陣列宣告
        int student_num = Integer.parseInt(getbr);
        float score[] = new float[student_num]; // float score[]; score=new float[student_num]
        // 輸入分數
        for(int i=0;i<student_num;i++){
            System.out.println("請輸入第"+(i+1)+"位學生的成績:");
            score[i] = Float.parseFloat(br.readLine());
        }
        // JAVA內建Array排序函數
        Arrays.sort(score);
        // 印出名次
        for(int i=score.length-1;i>=0;i--){
            System.out.println("第"+ (score.length-i) + "名為" + score[i] + "分");
        }
        /* 二維陣列的2d-length: s[1].length
            int s[][] = {{1,2}, {3,4,5}};
            System.out.println(s[1].length); //輸出: 3
        */

    }
}
