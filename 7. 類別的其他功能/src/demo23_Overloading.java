//展示Overloading
//fraction(int X) & fraction(double X)

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class demo23_Overloading {
    public static void main(String args[]) throws Exception{
        String str;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            System.out.println("Input a number for fraction:");
            //User Input
            str = br.readLine();
            //check Int or Double
            if(str.indexOf(".") < 0){
                int num = Integer.parseInt(str);
                System.out.println(num+"階乘為"+fraction(num));
            }
            else{
                Double num = Double.parseDouble(str);
                System.out.println(num+"階乘為"+fraction(num));
            }
        }
    }
    private static int fraction(int X){
        int ans = 1;
        if (X<=1)
            ans = 1;
        else
            ans = X * fraction(X-1);
        return ans;
    }
    private static int fraction(double X){
        //Double -> Int
        int INT = (int)X;

        int ans = 1;
        if (INT<=1)
            ans = 1;
        else
            ans *= INT * fraction(INT-1);
        return ans;

    }
}
