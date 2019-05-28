//class中，static變數, static方法會被各個object一起共用 >>> 可用來節省記憶體空間
//因此，不可使用this關鍵字，因為this指向一個object，而Static變數指向一個class

class player_static{
    private static int object_counter = 0; //record how many object is declared
    public player_static(){
        object_counter++;
    }
    public static void show_class_cnt(){
        System.out.println("目前有"+object_counter+"個物件被建立了");
    }
}

public class a10d_Static {
    public static void main(String args[]) throws Exception{
        player_static[] p = new player_static[4];
        for(int i=0;i<4;i++){
            p[i] = new player_static();
            p[i].show_class_cnt();
        }
    }
}
