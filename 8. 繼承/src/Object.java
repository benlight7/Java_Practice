//Object是所有類別最原始的老祖宗

//常用三個method:
//Class getClass():取得所屬的類別
//Boolean equals(Object obj):是否為同一物件
//String toString()：轉成字串

class obj1{
    final double pi = 3.14;
}

class obj2 extends obj1{
    final double pi = 3.1415;
}

public class Object {
    public static void main(String args[]) throws Exception{
        obj1 o1_0 = new obj1();
        obj1 o1_1 = new obj1();
        obj2 o2 = new obj2();
        System.out.println("o1_0與o1_1相等嗎?"+o1_0.equals(o1_1)+", o1_0與o2相等嗎?"+o1_0.equals(o2));
        System.out.println("o1_0屬於"+o1_0.getClass()+", o2屬於"+o2.getClass());
        System.out.println("o1_0轉字串"+o1_0.toString()+", o1_1轉字串"+o1_1.toString());
    }
}
