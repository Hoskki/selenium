package stepDefinitions;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;


public class RegistrationSteps {
    WebDriver driver;

    @Before
    public void setUp() {
       // System.setProperty("webdriver.gecko.driver", "C:\\Users\\d_man\\IdeaProjects\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("User is on registration page")
    public void user_is_on_registration_page() {
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
    }

    @When("User enters valid details")
    public void user_enters_valid_details() {
        driver.findElement(By.id("dp")).sendKeys("06/04/1982");
        driver.findElement(By.id("member_firstname")).sendKeys("Test");
        driver.findElement(By.id("member_lastname")).sendKeys("User");
        driver.findElement(By.id("member_emailaddress")).sendKeys("testuser42@example.com");
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys("testuser42@example.com");
        driver.findElement(By.id("signupunlicenced_password")).sendKeys("Password123");
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys("Password123");

        WebElement termsCheckbox = driver.findElement(By.id("sign_up_25"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", termsCheckbox);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", termsCheckbox);

        WebElement codeOfConductCheckbox = driver.findElement(By.id("sign_up_26"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", codeOfConductCheckbox);

        WebElement agreeToEthics = driver.findElement(By.id("fanmembersignup_agreetocodeofethicsandconduct"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", agreeToEthics);

        driver.findElement(By.name("join")).click();
    }

    @Then("Account should be created successfully")
    public void account_should_be_created_successfully() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement confirmationHeader = driver.findElement(By.xpath("//h5[contains(text(), 'Your Basketball England Membership Number is')]"));
        Assert.assertTrue(confirmationHeader.isDisplayed());
    }

    @When("User omits last name")
    public void user_omits_last_name() {
        driver.findElement(By.id("dp")).sendKeys("06/04/1982");
        driver.findElement(By.id("member_firstname")).sendKeys("Test");
        //driver.findElement(By.id("member_lastname")).sendKeys("User");
        driver.findElement(By.id("member_emailaddress")).sendKeys("testuser@example.com");
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys("testuser@example.com");
        driver.findElement(By.id("signupunlicenced_password")).sendKeys("Password123");
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys("Password123");

        WebElement termsCheckbox = driver.findElement(By.id("sign_up_25"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", termsCheckbox);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", termsCheckbox);

        WebElement codeOfConductCheckbox = driver.findElement(By.id("sign_up_26"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", codeOfConductCheckbox);

        WebElement agreeToEthics = driver.findElement(By.id("fanmembersignup_agreetocodeofethicsandconduct"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", agreeToEthics);

        driver.findElement(By.name("join")).click();
    }

    @Then("Error message should be displayed for missing last name")
    public void error_message_should_be_displayed_for_missing_last_name() {
        WebElement errorMessage = driver.findElement(By.id("member_lastname__label"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @When("User enters mismatching passwords")
    public void user_enters_mismatching_passwords() {
        driver.findElement(By.id("dp")).sendKeys("06/04/1982");
        driver.findElement(By.id("member_firstname")).sendKeys("Test");
        driver.findElement(By.id("member_lastname")).sendKeys("User");
        driver.findElement(By.id("member_emailaddress")).sendKeys("testuser@example.com");
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys("testuser@example.com");
        driver.findElement(By.id("signupunlicenced_password")).sendKeys("Password123");
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys("Passord123");

        WebElement termsCheckbox = driver.findElement(By.id("sign_up_25"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", termsCheckbox);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", termsCheckbox);

        WebElement codeOfConductCheckbox = driver.findElement(By.id("sign_up_26"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", codeOfConductCheckbox);

        WebElement agreeToEthics = driver.findElement(By.id("fanmembersignup_agreetocodeofethicsandconduct"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", agreeToEthics);

        driver.findElement(By.name("join")).click();
    }

    @Then("Error message should be displayed for password mismatch")
    public void error_message_should_be_displayed_for_password_mismatch() {
        WebElement errorMessage = driver.findElement(By.id("signupunlicenced_confirmpassword"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @When("User does not accept terms and conditions")
    public void user_does_not_accept_terms_and_conditions() {
        driver.findElement(By.id("dp")).sendKeys("06/04/1982");
        driver.findElement(By.id("member_firstname")).sendKeys("Test");
        driver.findElement(By.id("member_lastname")).sendKeys("User");
        driver.findElement(By.id("member_emailaddress")).sendKeys("testuser@example.com");
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys("testuser@example.com");
        driver.findElement(By.id("signupunlicenced_password")).sendKeys("Password123");
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys("Password123");

        WebElement termsCheckbox = driver.findElement(By.id("sign_up_25"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", termsCheckbox);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", termsCheckbox);

        WebElement codeOfConductCheckbox = driver.findElement(By.id("sign_up_26"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", codeOfConductCheckbox);
        driver.findElement(By.name("join")).click();
    }

    @Then("Error message should be displayed for terms not accepted")
    public void error_message_should_be_displayed_for_terms_not_accepted() {
        WebElement errorMessage = driver.findElement(By.id("generalErrors"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}