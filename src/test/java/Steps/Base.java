package Steps;

import Pages.DashboardPage;
import Pages.HomePage;
import Pages.LoginPage;
import Utils.browserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {

    browserFactory BrowserFactory = new browserFactory();
    final WebDriver driver = browserFactory.startBrowser("edge",
            "https://ndosisimplifiedautomation.vercel.app/");

    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
}
