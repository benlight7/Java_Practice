//子類別中如果有與父類別同名且同參數型態的method，將取代父類別中該method
//這種特徵稱為Overriding

//final關鍵字的用途
//class：當宣告在類別上時，該類別就無法被繼承！
//method：當一個函數被宣告為final時，則繼承他的子類別無法Overriding
//field：當一個變數被宣告為final時，意思是他是一個常數，是無法被修改的。


class shape{
    public double getArea(int length, int height){
        return length*height;
    }
}

class triangle extends shape{
    public double getArea(int length, int height){
        return (length*height)/2;
    }
}

public class Overriding {
    public static void main(String args[]) throws Exception{
        shape s = new shape();
        triangle t = new triangle();
        System.out.println("長方形5cm x 4cm面積為"+s.getArea(5, 4));
        System.out.println("三角形5cm x 4cm面積為"+t.getArea(5, 4));
    }
}
