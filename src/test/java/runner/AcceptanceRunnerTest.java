package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import static common.Common.printMethodName;


@CucumberOptions(
        features = {"src/test/resources/acceptancetests/"},
        glue = {"teststepdefs"},
        plugin = {"io.qameta.allure.cucumber2jvm.AllureCucumber2Jvm"}
        )

public class AcceptanceRunnerTest extends AbstractTestNGCucumberTests {

    @BeforeClass
    public static void setUp(){
        printMethodName();

    }

    @AfterClass
    public static void tearDown(){
        printMethodName();

    }
}
