package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginWithValidCredentials {

    private WebDriver driver;

    @Before
    public void startDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Given("user is on login page")
    public void user_is_on_login_page() {

        driver.get("https://qa-practice.netlify.app/auth_ecommerce.html");

    }

    @When("user enters valid {} and {}")
    public void user_enters_valid_username_and_password(String user, String pass) {

        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys(user);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(pass);
    }
    @And("clicks on login button")
    public void clicks_on_login_button() {

        WebElement submitButton = driver.findElement(By.id("submitLoginBtn"));
        submitButton.click();

    }
    @Then("use is navigated to the homepage")
    public void use_is_navigated_to_the_homepage() {

        WebElement resultText = driver.findElement(By.className("section-header"));
        Assert.assertTrue(resultText.getText().startsWith("SHOPPING"));
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

}
