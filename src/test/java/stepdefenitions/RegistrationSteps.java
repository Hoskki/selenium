import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public static void main(String[] args) {

}

//public class RegistrationSteps {
    WebDriver driver;


    @BeforeEach
    public void setUp() {

    }

    @Given("User is on registration page")
    public void user_is_on_registration_page() {
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
    }

    @When("User enters valid details")
    public void user_enters_valid_details() {
        driver.findElement(By.id("firstName")).sendKeys("Test");
        driver.findElement(By.id("lastName")).sendKeys("User");
        driver.findElement(By.id("email")).sendKeys("testuser@example.com");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("confirmPassword")).sendKeys("Password123");
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("submit")).click();
    }

    @Then("Account should be created successfully")
    public void account_should_be_created_successfully() {
        WebElement successMessage = driver.findElement(By.id("successMessage"));
        Assert.assertTrue(successMessage.isDisplayed());
    }

    @When("User omits last name")
    public void user_omits_last_name() {
        driver.findElement(By.id("firstName")).sendKeys("Test");
        driver.findElement(By.id("email")).sendKeys("testuser@example.com");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("confirmPassword")).sendKeys("Password123");
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("submit")).click();
    }

    @Then("Error message should be displayed for missing last name")
    public void error_message_should_be_displayed_for_missing_last_name() {
        WebElement errorMessage = driver.findElement(By.id("lastNameError"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @When("User enters mismatching passwords")
    public void user_enters_mismatching_passwords() {
        driver.findElement(By.id("firstName")).sendKeys("Test");
        driver.findElement(By.id("lastName")).sendKeys("User");
        driver.findElement(By.id("email")).sendKeys("testuser@example.com");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("confirmPassword")).sendKeys("WrongPassword");
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("submit")).click();
    }

    @Then("Error message should be displayed for password mismatch")
    public void error_message_should_be_displayed_for_password_mismatch() {
        WebElement errorMessage = driver.findElement(By.id("passwordMismatchError"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @When("User does not accept terms and conditions")
    public void user_does_not_accept_terms_and_conditions() {
        driver.findElement(By.id("firstName")).sendKeys("Test");
        driver.findElement(By.id("lastName")).sendKeys("User");
        driver.findElement(By.id("email")).sendKeys("testuser@example.com");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("confirmPassword")).sendKeys("WrongPassword");
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("submit")).click();
    }

    @Then("Error message should be displayed for terms not accepted")
    public void error_message_should_be_displayed_for_terms_not_accepted() {
        WebElement errorMessage = driver.findElement(By.id("termsError"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @AfterAll
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
