//用來說明JAVA的傳值呼叫

public class demo21_Pass_Value {
    public static void main(String args[]) throws Exception{
        /* int */
        int A=10, ans=0;
        System.out.println("呼叫Increment函數前 A= "+A+" ans= "+ans);
        ans = Increment(A);
        System.out.println("呼叫Increment函數後 A= "+A+" ans= "+ans);
        /* StringBuffer */
        StringBuffer str = new StringBuffer("這是一個測試");
        System.out.println("呼叫InsertString函數前 str= "+str);
        StringBuffer result = InsertString(str);
        System.out.println("呼叫InsertString函數後 str= "+str);

    }
    public static int Increment(int X){
        System.out.println("呼叫函數中，處理前 X= "+X);
        X += 1;
        System.out.println("呼叫函數中，處理後 X= "+X);
        return X;
    }
    public static StringBuffer InsertString(StringBuffer S){
        System.out.println("呼叫函數中，處理前 S= "+S);
        S.insert(0,"這是新增的句子!");
        System.out.println("呼叫函數中，處理後 S= "+S);
        return S;
    }

}
