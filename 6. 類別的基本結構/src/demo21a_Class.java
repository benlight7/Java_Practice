//2個類別的範例.
//Compile後會產生2個byte code檔(.class)

class rectangle{
    double width;
    double height;
    double area(){ return width * height; }
    double perimeter(){ return 2 * (width + height); }
}

public class demo21a_Class {
    public static void main(String args[]) throws Exception{
        rectangle rec1 = new rectangle();
        rectangle rec2 = new rectangle();
        // Set fields of class
        rec1.width = 10;
        rec1.height = 20;
        rec2.width = 10.5;
        rec2.height = 20.5;
        // Calculate area & perimeter of rectangles
        System.out.println("矩形1的面積為"+rec1.area()+" 周長為"+rec1.perimeter());
        System.out.println("矩形2的面積為"+rec2.area()+" 周長為"+rec2.perimeter());
    }
}
