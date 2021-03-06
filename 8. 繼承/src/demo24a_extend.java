//子類別extend父類別
//子類別「不能」使用父類別的「private」成員(fields & methods)
//子類別也繼承父類別的建構元，new子類別時會先執行父類別中沒有參數的建構元

//利用繼承寫一個java的21點程式
//利用this關鍵字，來註明class自己本身宣告的成員(如此可與extend的成員做區分)
//this通常指代當前對象，super通常指代父類, 若子類別與父類別有相同名稱之成員時, 可加以區分
//protected成員可以讓自己 & 繼承自己的子類別使用，兼顧安全與方便性

import java.util.Random;

class player_extend{
    protected int[] card = new int[13]; //13 cards
    private String[] card_style = {"梅花", "方塊", "愛心", "黑桃"}; //4 style
    protected int card_cnt;

    public player_extend(){
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
        return this.card_style[this.card[id]/13]+num;
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

class p21 extends player_extend{
    int card_total_value;
    int ace_num = 0; //record有幾張A，因為A可以算成1也可以算成11

    public p21(){
        this.card_total_value = 0;
    }
    public boolean stop(){
        return (this.card_total_value>17); //>17可以停止發牌(21點規則)
    }
    public int card_num(){ /*用來記錄目前發了多少張牌*/
        return super.card_cnt;
    }
    public int count_value(int mission){
        if(super.card[mission]%13 >= 9)
            this.card_total_value += 10;//10, J, Q, K 都算10點
        else if(super.card[mission]%13 == 0){
            this.ace_num++; //Ace多一張
            this.card_total_value += 1; //先把Ace算成1
        }
        else
            this.card_total_value += (super.card[mission]%13+1); //2-9

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

public class demo24a_extend{
    private static boolean[] GivenCard = new boolean[52]; // False: Card isn't given | True: Card given
    private static Random rdm = new Random();// Random()

    public static void main(String args[]) throws Exception{
        //Initialization, no card has been given in the beginning
        for(int i=0;i<52;i++) GivenCard[i] = false;
        //4 player
        p21[] p = new p21[4]; //先配置空間給array
        for(int i=0;i<p.length;i++) p[i] = new p21(); //在配置空間給每個object
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
    public static void give_card_by_player(p21 p){
        int x = rdm.nextInt(52);
        while (GivenCard[x]) x = rdm.nextInt(52); //Card given, so must give a new card
        p.set_card(x); //Record player's card info
        GivenCard[x] = true;
    }
    public static void show_card_by_player(p21 p){
        for(int i=0;i<5;i++)
            if(p.card[i]!=-1) System.out.print(p.show(i)+",");
        System.out.println();
    }
    public static void show_result_by_player(p21 p){
        System.out.print("積點為"+p.card_total_value);
        if(p.card_total_value>21)
            System.out.print(", 爆掉了！！\n");
        else if(p.card_num()==5)
            System.out.print(", 恭喜過五關！！\n");
        else
            System.out.println();
    }
}
