// User Input String
import java.io.*;
public class demo3_Input_String {
    public static void main(String args[]) throws Exception{
        String getbr;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please Input your Name:");
        getbr = br.readLine();
        System.out.println("Hello!" + getbr + "^_^");
    }
}
