//利用object作為方法的參數

import java.util.Random;

public class a10f_ClassParameter_Method {
    private static boolean[] GivenCard = new boolean[52]; // False: Card isn't given | True: Card given
    private static Random rdm = new Random();// Random()

    public static void main(String args[]) throws Exception{
        //Initialization, no card has been given in the beginning
        for(int i=0;i<52;i++) GivenCard[i] = false;
        //4 player
        player[] p = new player[4]; //先配置空間給array
        for(int i=0;i<p.length;i++) p[i] = new player(); //在配置空間給每個object
        //Give Card
        for(int id=0;id<p.length;id++)
            give_card_by_player(p[id]);
        //Show Card
        for(int id=0;id<p.length;id++){
            System.out.println("Player "+(id+1)+"牌如下:");
            show_card_by_player(p[id]);
        }
        //Restore Memory by assign NULL pointer
        for(int i=0;i<p.length;i++) p[i] = null;
    }
    public static void give_card_by_player(player p){
        for (int i=0;i<13;i++) {
            int x = rdm.nextInt(52);
            while (GivenCard[x]) x = rdm.nextInt(52); //Card given, so must give a new card
            p.set_card(i, x); //Record player's card info
            GivenCard[x] = true;
        }
    }
    public static void show_card_by_player(player p){
        for(int i=0;i<13;i++)
            System.out.println(p.show(i));
    }
}
