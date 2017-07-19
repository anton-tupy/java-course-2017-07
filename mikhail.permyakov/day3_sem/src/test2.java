/**
 * Created by lab on 16.07.2017.
 */
public class test2 {
    static void unflow(boolean flag){
        final int k;
        if (flag){
            k = 3;
            System.out.println(k);
        };
//        if (!flag){
//            k = 4;
//            System.out.println(k);
//        }
    }

    public static void main(String[] args) {
        unflow(false);
    }
}
