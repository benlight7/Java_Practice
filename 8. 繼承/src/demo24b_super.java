//super()必須寫在子類別建構元的第一行 line 74
//this(參數)可放在沒有參數的建構元裡，當作預設選用 line 18

import java.util.Random;

class player_super{
    int[] card = new int[13]; //13 cards
    private static String[][] card_style = {{"梅花", "方塊", "愛心", "黑桃"},
                                            {"Club", "Diamonds", "Hearts", "Spades"},
                                            {"花", "塊", "心", "桃"},
                                            {"C", "D", "H", "S"}};
    int card_style_name; //表示要選用哪一種card_style

    int card_cnt;


    public player_super(){
        this(1); //預設選用card_style[1]
        for(int i=0;i<this.card.length;i++){
            this.card[i] = -1; //洗牌，-1表示玩家沒有這張牌
        }
        this.card_cnt = 0;
    }
    public player_super(int cpt){ //選用card_style的建構元
        card_style_name = cpt;
        for(int i=0;i<this.card.length;i++){
            this.card[i] = -1; //洗牌，-1表示玩家沒有這張牌
        }
        this.card_cnt = 0;
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
        return this.card_style[card_style_name][this.card[id]/13]+num;
    }
    public void set_card(int id, int X){
        this.card[id] = X;
        this.card_cnt++;
    }
    //Overloading
    public void set_card(int X){
        for(int i=0;i<13;i++){
            if (this.card[i] == -1){ //那個位置沒有牌
                this.card[i] = X;
                this.card_cnt++;
                break; //發完牌就可以跳出去了
            }
        }
    }

}

class p21_super extends player_super{
    int card_total_value;
    int ace_num = 0; //record有幾張A，因為A可以算成1也可以算成11

    public p21_super(){
        this.card_total_value = 0;
    }
    public p21_super(int card_style_name){
        super(card_style_name); //強制執行父類別中具有參數的建構元
        this.card_total_value = 0;
    }
    public boolean stop(){
        return (this.card_total_value>17); //>17可以停止發牌(21點規則)
    }
    public int card_num(){ /*用來記錄目前發了多少張牌*/
        return card_cnt;
    }
    public int count_value(int mission){
        if(card[mission]%13 >= 9)
            this.card_total_value += 10;//10, J, Q, K 都算10點
        else if(card[mission]%13 == 0){
            this.ace_num++; //Ace多一張
            this.card_total_value += 1; //先把Ace算成1
        }
        else
            this.card_total_value += (card[mission]%13+1); //2-9

        return this.card_total_value;
    }
    public void ace(){
        while (this.card_total_value<21 && this.ace_num>0){
            this.card_total_value += 10; //把其中一張A從1改算成11
            if(this.card_total_value<=21) this.ace_num -= 1; //沒爆
            else{ //爆掉的話
                this.card_total_value -= 10;
                break;
            }
        }
    }
}

public class demo24b_super{
    private static boolean[] GivenCard = new boolean[52]; // False: Card isn't given | True: Card given
    private static Random rdm = new Random();// Random()

    public static void main(String args[]) throws Exception{
        //Initialization, no card has been given in the beginning
        for(int i=0;i<52;i++) GivenCard[i] = false;
        //4 player
        p21_super[] p = new p21_super[4]; //先配置空間給array
        for(int i=0;i<p.length;i++) p[i] = new p21_super(i); //給每個player不同的card_style
        //Give Card
        for(int mission=0;mission<5;mission++){ //最多發5張就可以過5關了
            System.out.println("Mission "+mission);
            for(int id=0;id<p.length;id++){
                if(!p[id].stop()){
                    give_card_by_player(p[id]);
                    System.out.println("第"+(id+1)+"家要牌得到["+p[id].show(mission)+"], 目前"+p[id].count_value(mission)+"點, "+"總共有"+p[id].card_num()+"張牌");
                }
                else
                    System.out.println("第"+(id+1)+"家不要牌了");

                //Final mission, re-calculate Ace's value
                if(mission == 4)
                    p[id].ace();
            }
        }
        //Show Result
        System.out.println("-----Final Result-----");
        for(int id=0;id<p.length;id++){
            System.out.print("Player "+(id+1)+"牌如下: ");
            show_card_by_player(p[id]);
            show_result_by_player(p[id]);

        }
        //Restore Memory by assign NULL pointer
        for(int i=0;i<p.length;i++) p[i] = null;
    }
    public static void give_card_by_player(p21_super p){
        int x = rdm.nextInt(52);
        while (GivenCard[x]) x = rdm.nextInt(52); //Card given, so must give a new card
        p.set_card(x); //Record player's card info
        GivenCard[x] = true;
    }
    public static void show_card_by_player(p21_super p){
        for(int i=0;i<5;i++)
            if(p.card[i]!=-1) System.out.print(p.show(i)+",");
        System.out.println();
    }
    public static void show_result_by_player(p21_super p){
        System.out.print("積點為"+p.card_total_value);
        if(p.card_total_value>21)
            System.out.print(", 爆掉了！！\n");
        else if(p.card_num()==5)
            System.out.print(", 恭喜過五關！！\n");
        else
            System.out.println();
    }
}
