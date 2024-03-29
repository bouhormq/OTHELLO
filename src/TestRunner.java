import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
public class TestRunner {

    public static void main(String[] args) {
            
        Result result = JUnitCore.runClasses(BoardTest.class, OthelloTest.class);
        for (Failure failure : result.getFailures()) System.out.println(failure.toString());
        if (result.wasSuccessful()) System.out.println("El test ha ido bien");
        else System.out.println("El test ha ido mal");

    }
}