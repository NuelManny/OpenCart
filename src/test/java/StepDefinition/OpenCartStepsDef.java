package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
//import org.junit.After;
//import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class OpenCartStepsDef {
    WebDriver driver;

    @Before
    public void initialize() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(45,TimeUnit.SECONDS);
    }


    @Given("i am on the website {string}")
    public void i_am_on_the_website(String Url) {
        driver.get(Url);

    }

    @Given("i click on {string} Drop Menu")
    public void i_click_on_drop_menu(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebElement myAccount = driver.findElement(By.xpath("(//*[normalize-space()='My Account'])[2]"));
        myAccount.click();

    }

    @Given("i click on {string} option")
    public void i_click_on_option(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebElement register = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        register.click();
//        WebElement clickAlert = driver.findElement(By.cssSelector("input[type='checkbox']"));
////        clickAlert.click();
        WebElement clickAlert = driver.findElement(By.xpath("//*[@type='checkbox']"));
        clickAlert.click();

//        @Given("i enter Account Details into mandatory field as {string}, {string}, {string}, {string}, and {string}")
//        public void i_enter_account_details_into_mandatory_field_as_and (String firstName, String lastName, String eMail, String telephone, String password){
//            // Write code here that turns the phrase above into concrete actions
//            WebElement fname = driver.findElement(By.id("input-firstname"));
//            fname.sendKeys(firstName);
//            WebElement lname = driver.findElement(By.id("input-lastname"));
//            lname.sendKeys(lastName);
//            WebElement email = driver.findElement(By.id("input-email"));
//            email.sendKeys(eMail);
//            WebElement passWord = driver.findElement(By.id("input-password"));
//            passWord.sendKeys(password);
//            WebElement email = driver.findElement(By.id("input-email"));
//            email.sendKeys(eMail);

        }

        @Given("i accept privacy policy")
        public void i_accept_privacy_policy () {
            // Write code here that turns the phrase above into concrete actions
            WebElement PrivacyPolicy = driver.findElement(By.cssSelector("input[type='checkbox']"));
            PrivacyPolicy.click();

        }

        @Given("i click on {string} button")
        public void i_click_on_button (String string){
            // Write code here that turns the phrase above into concrete actions
            WebElement ContinueButton = driver.findElement(By.cssSelector("button[type='submit']"));
            ContinueButton.click();

        }

        @Given("i verify that account was created succesfully")
        public void i_verify_that_account_was_created_succesfully () {
            // Write code here that turns the phrase above into concrete actions
            WebElement accountCreated = driver.findElement(By.linkText("Your Account Has Been Created!"));
            assertThat(accountCreated.isDisplayed(),is(equalTo(true)));



        }

        @Then("click on {string} button displayed in account success page.")
        public void click_on_button_displayed_in_account_success_page (String string){
            // Write code here that turns the phrase above into concrete actions

        }

        @After
        public void tearDown () throws IOException {
            takeScreenShot();
            driver.close();
            driver.quit();

        }

        private void takeScreenShot () throws IOException {
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(SrcFile, new File("target/screenshot" + System.currentTimeMillis() + ".png"));
        }

    @And("i enter Account Details into mandatory field as {string}, {string}, {string}, and {string}")
    public void iEnterAccountDetailsIntoMandatoryFieldAsAnd(String firstName, String lName, String eMail, String Password) {
        WebElement fname = driver.findElement(By.id("input-firstname"));
        fname.sendKeys(firstName);
        WebElement lname = driver.findElement(By.id("input-lastname"));
        lname.sendKeys(lName);
        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys(eMail);
        WebElement passWord = driver.findElement(By.id("input-password"));
        passWord.sendKeys(Password);
    }
}