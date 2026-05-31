package Steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.PendingException;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class stepsDef extends Base {

    WebDriver driver;

    @Given("i am on the login page")
    public void i_am_on_the_login_page() {

//        driver = new ChromeDriver();
//        driver.get("https://ndosisimplifiedautomation.vercel.app/");
//        driver.manage().window().maximize();
//        driver.findElement(By.xpath("/html/body/div/div/nav/div[1]/div[3]/button")).click();

        homePage.clickLoginButton();
        loginPage.verifyLoginPageIsDisplayed();

    }

    @And("I enter email (.*)$")
    public void i_enter_email(String email) {
        //driver.findElement(By.id("login-email")).sendKeys(email);
        loginPage.enterEmail(email);
    }

    @And("I enter password (.*)$")
    public void i_enter_password(String password) {
        //driver.findElement(By.id("login-password")).sendKeys(password);
        loginPage.enterPassword(password);
    }

    @When("I click login button")
    public void i_click_login_button() {
        //driver.findElement(By.id("login-submit")).click();
        loginPage.clickLoginButton();
    }

    @Then("i should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
       // assert driver.findElement(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[4]/button/span[2]")).isDisplayed();
        dashboardPage.verifyDashboardPageIsDisplayed();
    }

    @And("I click on the logged in user")
    public void iClickOnTheLoggedInUser() {

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/nav/div[1]/div[3]/div/button")));
//
//        Actions actions = new Actions(driver);
//        actions.moveToElement(element).click().perform();

        dashboardPage.clickLoggedInUser();

    }
    @And("I click on the admin panel")
    public void iClickOnTheAdminPanel() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        //WebElement element1 = wait.until(visibilityOfElementLocated(By.xpath("//button[@class='nav-dropdown-item']//span[contains(text(),'Admin Panel')]")));
//        wait.until(visibilityOfElementLocated(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[3]/div/div/button[4]"))).click();
//       // element1.click();

        dashboardPage.clickAdminPanel();
    }

    @Then("I should be on the admin panel page")
    public void iShouldBeOnTheAdminPanelPage() {
        // Write code here that turns the phrase above into concrete actions
       assert driver.findElement(By.xpath("//*[@id=\"app-root\"]/div/div[3]/div/div[1]/p")).isDisplayed();

    }

    @And("I click on the groups tab")
    public void iClickOnTheGroupsTab() {
        // Write code here that turns the phrase above into concrete actions
//        driver.findElement(By.xpath("//div[@class='admin-sidebar ']//button[4]")).click();
        dashboardPage.clickGroupsOption();
    }

    @Then("I should be on the groups page")
    public void iShouldBeOnTheGroupsPage() {
        // Write code here that turns the phrase above into concrete actions
        //assert driver.findElement(By.xpath("(//h1[contains(text(),'\uD83D\uDCC1 Manage Groups')])[1]")).isDisplayed();

    }

    @And("I click on the create group button")
    public void iClickOnTheCreateGroupButton() {
        // Write code here that turns the phrase above into concrete actions
        //driver.findElement(By.xpath("//*[@id=\"app-root\"]/div/div[3]/div/div[2]/button")).click();

        dashboardPage.clickCreateNewGroup();
    }

    @And("I enter group name (.*)$")
    public void iEnterGroupNameGroupName(String groupName) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        dashboardPage.groupNameInput(groupName);

    }

    @And("I enter group description (.*)$")
    public void iEnterGroupDescriptionGroupDescription(String groupDescription) {
        // Write code here that turns the phrase above into concrete actions
        dashboardPage.groupDescriptionArea(groupDescription);
    }

    @And("I enter year (.*)$")
    public void iEnterYear(String year) {
        dashboardPage.enterGroupYear(year);
    }

    @And("I enter max capacity (.*)$")
    public void iEnterMaxCapacityMaxCapacity(String maxCapacity) {
        // Write code here that turns the phrase above into concrete actions
        dashboardPage.enterMaxCapacity(maxCapacity);
    }

    @And("I enter start date (.*)$")
    public void iEnterStartDateStartDate(String startDate) {
        // Write code here that turns the phrase above into concrete actions
        dashboardPage.enterStartDate(startDate);
    }

    @And("I enter end date (.*)$")
    public void iEnterEndDateEndDate(String endDate) {
        // Write code here that turns the phrase above into concrete actions
        dashboardPage.enterEndDate(endDate);
    }
//    @When("I click on the create group button")
//    public void iClickOnTheSubmitButton() {
//        dashboardPage.clickCreateNewGroup();
//
//    }

    @Then("i should see the group created successfully")
    public void iShouldSeeTheGroupCreatedSuccessfully() {
        // Write code here that turns the phrase above into concrete actions
    }

    @AfterStep
    public void addScreenshots(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshots = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshots, "image/png", "image");
        }
    }


}
