import org.junit.AfterClass;
import org.junit.Before;
import Utilities.DriverManager;

public class BaseTest {
    @Before
    public void setup(){
        DriverManager.getDriver().get("https://www.saucedemo.com/");
        DriverManager.getDriver().manage().window().maximize();

    }

    @AfterClass
    public static void cleanUp(){
        DriverManager.getDriver().close();

    }

}
