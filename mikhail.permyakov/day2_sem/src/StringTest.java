import static java.lang.System.out;


/**
 * Created by lab on 15.07.2017.
 */
public class StringTest {

    static String getAB(String s){
        s += "b";
        return s;
    }
    public static void main(String a[]){
        String s1 = "ab";
        String s2 = "ab";
        String s3 = "a";
        String s4 = getAB(s3);
        out.println("==: "+(s1==s2)+" equals: "+s1.equals(s2));
        out.println("==: "+(s1==s3)+" equals: "+s1.equals(s3));
        out.println("==: "+(s1==s4)+" equals: "+s1.equals(s4));
    }
}
