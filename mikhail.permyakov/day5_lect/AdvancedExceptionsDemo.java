import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Collection;
import java.util.Collections;
import java.util.Observer;

/**
 * Created with IntelliJ IDEA.
 * User: vsev
 * Date: 12.03.14
 * Time: 17:36
 * To change this template use File | Settings | File Templates.
 */
class MyException extends Exception {
    MyException() {
    }
    MyException(String message) {
        super(message);
    }
    MyException(String message, Throwable cause) {
        super(message, cause);
    }
    MyException(Throwable cause) {
        super(cause);
    }
    public void doIt() {}
}
class AnotherException extends MyException {
    AnotherException() {
    }
    AnotherException(String message) {
        super(message);
    }
    AnotherException(String message, Throwable cause) {
        super(message, cause);
    }
    AnotherException(Throwable cause) {
        super(cause);
    }
    public void doAnother() {}
}

class OneMoreException extends MyException {
    OneMoreException(){super();}
    OneMoreException(String arg) {super(arg);}
    public void doMore() {}
}
class Curious implements AutoCloseable {
    @Override
    public void close () throws Exception {
        System.out.println("Curious.close()");
        throw new Exception("Curious.close exception - this is gonna be suppressed");
    }
    public void readData() throws Exception {
        throw new Exception ("readData failed!");
    }
}
public class AdvancedExceptionsDemo {
    void doIt( boolean b) throws Exception {
        if (b) {
            throw new AnotherException();
        } else {
            throw new OneMoreException("asd");
        }
    }
    public static void main(String args[]) {
        AdvancedExceptionsDemo a = new AdvancedExceptionsDemo();
        try {
            a.doIt(true);

        } catch (AnotherException | OneMoreException ex) {
           ex.doIt();

        } catch (Exception ex) {
        }
        //Observer
        try (
            FileInputStream fis = new FileInputStream("abc.txt");
            FileInputStream fis2 = new FileInputStream("def.dat");
        ) {
           //fis = new FileInputStream("abc.txt");
        }  catch (IOException ioex) {

        } finally {
           //Integer.valueOf()
            //if ( fis != null)  try { fis.close();}catch(Exception e) {}
        }
        try (Curious c = new Curious ()){
            c.readData();
        } catch (Exception ex) {
            System.out.println("ex: "+ex);
            System.out.println("suppressed: " + ex.getSuppressed()[0].toString());
        } finally {
            System.out.println("finally");
        }
    }
}