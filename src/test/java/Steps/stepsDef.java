package Steps;

import io.cucumber.java.After;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class stepsDef {

    WebDriver driver;

    @Given("i am on the login page")
    public void i_am_on_the_login_page() {

        driver = new ChromeDriver();
        driver.get("https://ndosisimplifiedautomation.vercel.app/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/div/div/nav/div[1]/div[3]/button")).click();

    }

    @And("I enter email (.*)$")
    public void i_enter_email(String email) {
        driver.findElement(By.id("login-email")).sendKeys(email);
    }

    @And("I enter password (.*)$")
    public void i_enter_password(String password) {
        driver.findElement(By.id("login-password")).sendKeys(password);
    }

    @When("I click login button")
    public void i_click_login_button() {
        driver.findElement(By.id("login-submit")).click();
    }

    @Then("i should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        assert driver.findElement(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[4]/button/span[2]")).isDisplayed();
    }

    @And("I click on the logged in user")
    public void iClickOnTheLoggedInUser() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class,'user-pill')]")));

        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();

    }
    @And("I click on the admin panel")
    public void iClickOnTheAdminPanel() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element1 = wait.until(visibilityOfElementLocated(By.xpath("//button[@class='nav-dropdown-item']//span[contains(text(),'Admin Panel')]")));
        element1.click();
    }

    @Then("I should be on the admin panel page")
    public void iShouldBeOnTheAdminPanelPage() {
        // Write code here that turns the phrase above into concrete actions
        assert driver.findElement(By.xpath("(//p[contains(text(),\"Welcome back, Admin! Here's an overview of your pl\")])[1]")).isDisplayed();

    }

    @And("I click on the groups tab")
    public void iClickOnTheGroupsTab() {
        // Write code here that turns the phrase above into concrete actions
    }

    @And("I click on the create group button")
    public void iClickOnTheCreateGroupButton() {
        // Write code here that turns the phrase above into concrete actions
    }

    @And("I enter group name (.*)$")
    public void iEnterGroupNameGroupName(String groupName) {
        // Write code here that turns the phrase above into concrete actions
    }

    @And("I enter group description (.*)$")
    public void iEnterGroupDescriptionGroupDescription(String groupDescription) {
        // Write code here that turns the phrase above into concrete actions
    }

    @And("I enter year (.*)$")
    public void iEnterYear(int year) { }

    @And("I enter max capacity (.*)$")
    public void iEnterMaxCapacityMaxCapacity(int maxCapacity) {
        // Write code here that turns the phrase above into concrete actions
    }

    @And("I enter start date (.*)$")
    public void iEnterStartDateStartDate(String startDate) {
        // Write code here that turns the phrase above into concrete actions
    }

    @And("I enter end date (.*)$")
    public void iEnterEndDateEndDate(String endDate) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("i should see the group created successfully")
    public void iShouldSeeTheGroupCreatedSuccessfully() {
        // Write code here that turns the phrase above into concrete actions
    }

    @After
    public void closeBrowser(){
        //driver.quit();
    }


}
