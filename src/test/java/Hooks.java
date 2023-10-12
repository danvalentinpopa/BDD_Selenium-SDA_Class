import org.junit.AfterClass;
import org.junit.BeforeClass;

public class Hooks extends DriverFactory{

    @BeforeClass
    public void beforeScenario(){
        startBrowser();
    }

    @AfterClass
    public void afterScenario(){
        destroyDriver();
    }
}
