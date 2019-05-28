//在new這個類別時，將會執行這個Constructor Method(與類別同名)，且不可以有回傳值
//Constructor Method也可以Overloading
//若沒有寫Constructor Method，會呼叫內定寫好的(即不做任何事)

//利用類別寫一個發撲克牌程式

import java.util.Random;

class player{
    private int[] card = new int[13]; //13 cards
    private String[] card_style = {"梅花", "方塊", "愛心", "黑桃"}; //4 style

    public player(){
        for(int i=0;i<this.card.length;i++){
            this.card[i] = -1; //洗牌，-1表示玩家沒有這張牌
        }
    }
    public String show(int id){
        String num;
        switch (this.card[id]%13){
            case 10:
                num = "J";
                break;
            case 11:
                num = "Q";
                break;
            case 12:
                num = "K";
                break;
            default:
                num = Integer.toString(this.card[id]%13+1);
                break;
        }
        return this.card_style[this.card[id]/13]+num;
    }
    public void set_card(int id, int X){
        this.card[id] = X;
    }

}

public class a10b_Constructor {
    public static void main(String args[]) throws Exception{
        //4 player
        player[] p = new player[4]; //先配置空間給array
        for(int i=0;i<p.length;i++) p[i] = new player(); //在配置空間給每個object
        //Initialization
        boolean[] GivenCard = new boolean[52]; // False: Card isn't given | True: Card given
        for(int i=0;i<GivenCard.length;i++) GivenCard[i] = false;
        //Randomized give card to 4 player
        Random rdm = new Random();// Random()
        for(int id=0;id<p.length;id++) {
            for (int i=0;i<13;i++) {
                int x = rdm.nextInt(52);
                while (GivenCard[x]) x = rdm.nextInt(52); //Card given, so must give a new card
                p[id].set_card(i, x); //Record player's card info
                GivenCard[x] = true;
            }
        }
        //Show Card Info Summary
        for(int id=0;id<p.length;id++){
            System.out.println("Player "+(id+1)+"牌如下:");
            for(int i=0;i<13;i++)
                System.out.println(p[id].show(i));
        }
    }
}
