package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class DashboardPage {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"app-main-content\"]/section/div[1]/h2")
    WebElement dashboardHeading_xpath;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyDashboardPageIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(visibilityOf(dashboardHeading_xpath));
        dashboardHeading_xpath.isDisplayed();
    }

    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[3]/div/button//*[@id=\"app-root\"]/nav/div[1]/div[3]/div/button")
    WebElement loggedInUser_xpath;

   @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[3]/div/div/button[4]")
    WebElement adminPanel_xpath;

   @FindBy(xpath = "(//p[contains(text(),\"Welcome back, Admin! Here's an overview of your pl\")])[1]")
    WebElement adminPanelParagraph_xpath;

    public void clickLoggedInUser() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(visibilityOf(loggedInUser_xpath));
        loggedInUser_xpath.click();
    }

    public void clickAdminPanel() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(visibilityOf(adminPanel_xpath));
        adminPanel_xpath.click();
    }

    public void verifyAdminPanelPageIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(visibilityOf(adminPanelParagraph_xpath));
        adminPanel_xpath.isDisplayed();
    }
}

