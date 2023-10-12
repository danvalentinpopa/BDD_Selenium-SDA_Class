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

public class LoginWithInvalidCredentials {


    private WebDriver driver;

    @Before
    public void startDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("User is on login page")
    public void user_is_on_login_page() {

        driver.get("https://qa-practice.netlify.app/auth_ecommerce.html");

    }

    @When("user enters invalid {} and {}")
    public void user_enters_invalid_username_and_password(String user, String pass) {

        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys(user);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(pass);
    }

    @And("the submit button is pressed")
    public void the_submit_button_is_pressed() {

        WebElement submitButton = driver.findElement(By.id("submitLoginBtn"));
        submitButton.click();

    }

    @Then("error message is displayed")
    public void error_message_is_displayed() {

        WebElement errorText = driver.findElement(By.id("message"));
        Assert.assertTrue(errorText.getText().startsWith("Bad credentials!"));
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

}
