class Test
{
  public void doIt() throws Exception{
      throw new Exception("doIt");
  }
  public void doAnother() throws Exception {
      doIt();
  }
  public void letsDoIt() throws Exception {
    try {
        doAnother();
    } catch (Exception e) {
        System.out.println("first   printStackTrace:");
        e.printStackTrace(System.out);
        System.out.println("local context in catch:");
        Throwable t = new Throwable();
        t.fillInStackTrace();
        t.printStackTrace(System.out);
        System.out.println("Throw it again...");
        //throw new Exception(e);
        e.fillInStackTrace();
       //throw new Exception(e);
       throw e;
    } finally {
        System.out.println("letsDoIt finally.");
    }
  }
}
public class ExceptionTest {
public static void main(String[] args) {
    Test t = new Test();
    try {
 //     int i = 0;
 //    int j = 10/i;
   
      t.letsDoIt();
    } catch (Exception e) {
      System.out.println("localized: "+e.getLocalizedMessage());  
      System.out.println("Second printStackTrace:");
      e.printStackTrace(System.out);
      //e.getCause().printStackTrace(System.out);
    }
  }
}
