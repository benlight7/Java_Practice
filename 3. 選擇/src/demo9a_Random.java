// Random() function in JAVA
import java.util.*;

public class demo9a_Random {
    public static void main(String args[]) throws Exception{
        Random randomG = new Random();
        int x = randomG.nextInt(52); // x will be one of 0~51
        System.out.println("Random number x = " + x);
    }
}
