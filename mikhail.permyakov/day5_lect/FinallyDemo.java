public class FinallyDemo {
  static void procA() {
    try {
      System.out.println("procA");
      throw new RuntimeException("Demo");
    } catch (Exception e ) {
      System.out.println("catch in procA");
      throw e;
    }
    finally {
      System.out.println("finally procA");
      throw new RuntimeException("Surprise!");
    }
  }
  static void procB() {
    try {
      System.out.println("procB");
      return;
    } finally {
      System.out.println("finally procB");
    }
  }
  static void procC() {
    try {
      System.out.println("procC");
      System.exit(0);
    }
    finally {
      System.out.println("finally procC");
    }
  }

 public static void main(String[] args) {
    try {
      procA();
    }
    catch (Exception ex) {
      System.out.println("Exception was caught");
      ex.printStackTrace(System.out);
    }
    procB();
    procC();
  }
}
