//功能類似範本
//abstract之父類別其method可以宣告為prototype
//繼承之子類別再去implement這個method

//Hint: constructor(int a1, String s1)與constructor(int a2, String s2)被視為一樣
//Solution: 將其中一個參數順序調換, 如constructor(String s2, int a2)即可


abstract class abstract_shape {
    protected String name;
    protected double length, width, height;

    //長方形建構元
    public abstract_shape(String name, double length, double width) {
        this.name = name;
        this.length = length;
        this.width = width;
    }

    //三角形建構元
    public abstract_shape(double width, double height, String name) {
        this.name = name;
        this.width = width;
        this.height = height;
    }

    //function
    abstract double area();

    abstract double perimeter();
}

class rectangle_abstract extends abstract_shape {
    public rectangle_abstract(String name, double length, double width) {
        super(name, length, width);
    }

    double area() {
        return length * width;
    }

    double perimeter() {
        return 2 * (length + width);
    }
}

class equaltriangle_abstract extends abstract_shape {
    public equaltriangle_abstract(double width, double height, String name) {
        super(width, height, name);
    }

    double area() {
        return (width * height) / 2;
    }

    double perimeter() {
        return 3 * width;
    }
}

public class Abstract {
    public static void main(String args[]) throws Exception {
        rectangle_abstract r = new rectangle_abstract("長方形1", 5, 4);
        equaltriangle_abstract t = new equaltriangle_abstract(5, 4, "全等三角形1");
        System.out.println(r.name + "之面積為" + r.area() + ", 周長為" + r.perimeter());
        System.out.println(t.name + "之面積為" + t.area() + ", 周長為" + t.perimeter());
    }
}
