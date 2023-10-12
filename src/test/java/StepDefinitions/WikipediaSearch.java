package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WikipediaSearch {

    private WebDriver driver;

    @Before
    public void startDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Given("I am on the wikipedia search page")
    public void i_am_on_the_wikipedia_search_page() {
        driver.get("https://www.wikipedia.org/");
    }

    @When("I search for BDD")
    public void i_search_for_BDD() {

        WebElement searchInputField = driver.findElement(By.name("search"));
        searchInputField.sendKeys("BDD");
        searchInputField.submit();

    }

    @Then("the page title should start with BDD")
    public void the_page_title_should_start_with_BDD() {

        WebElement resultText = driver.findElement(By.id("firstHeading"));
        System.out.println("Search text is: " + resultText);
        Assert.assertEquals(resultText.getText(), "BDD");
        Assert.assertTrue(resultText.getText().startsWith("BDD"));

    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}
