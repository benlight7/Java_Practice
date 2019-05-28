// Data type Transformation: String -> Double
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class demo4_String_To_Double{
    public static void main(String args[]) throws Exception {
        String getbr;
        double radius, area;
        double pi = 3.14159;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please Input Circle Radius: d");
        getbr = br.readLine();

        // String -> Double
        radius = Double.parseDouble(getbr);

        area = pi * radius * radius;
        System.out.println("Circle Area = " + area);

    }
}