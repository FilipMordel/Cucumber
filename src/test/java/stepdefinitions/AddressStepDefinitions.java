package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AddressPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class AddressStepDefinitions {
    AddressPage addressPage;
    WebDriver driver;


    @Given("^User is logged in the address page$")
    public void userIsLoggedInTheAddressPage() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("michal.dobrzycki@coderslab.pl", "CodersLab");
    }

    @When("^User goes to AddressPage$")
    public void userGoesToAddressPage() {
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=address");
    }

    @And("^User adds and saves new (.*), (.*) and (.*)$")
    public void userAddsAndSavesNewAddressCityAndPostcode(String address, String city, String postcode) {
        addressPage = new AddressPage(driver);
        addressPage.addAddress(address, city, postcode);
    }

    @Then("^User sees \"([^\"]*)\"$")
    public void userSees(String actionMessage) {
        Assert.assertEquals(actionMessage, addressPage.getUpdateInformation());
    }

}
