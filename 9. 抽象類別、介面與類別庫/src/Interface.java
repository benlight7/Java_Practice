// Hint:
// 1. Methods declared inside interface are, implicitly "public"
// 2. Variables declared inside interface are,  implicitly "public static final" (constants).

interface Math {
    void show(); //印出答案

    void add(int m, int n);//+

    void sub(int m, int n);//-

    void mul(int m, int n);//×

    void div(int m, int n);//÷
}

class Compute implements Math {
    private int result;

    public void show() {
        System.out.println(this.result);
    }

    public void add(int m, int n) {
        this.result = m + n;
    }

    public void sub(int m, int n) {
        this.result = m - n;
    }

    public void mul(int m, int n) {
        this.result = m * n;
    }

    public void div(int m, int n) {
        this.result = m / n;
    }
}

public class Interface {
    public static void main(String args[]) throws Exception {
        Compute c = new Compute();
        c.add(5, 2);
        c.show();
        c.sub(5, 2);
        c.show();
        c.mul(5, 2);
        c.show();
        c.div(5, 2);
        c.show();
    }
}
