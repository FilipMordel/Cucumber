package stepdefinitions;

import cucumber.api.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class QloappsSteps {
    private WebDriver driver;

    @Given("an open browser with(.*)")
    public void openBrowser(String website) {
// Skonfiguruj sterownik przeglądarki
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();
        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Przejdź do Google
        driver.get("https://qloapps.coderslab.pl/pl/logowanie?back=my-account");
    }

    @When("an (.*) is entered in input field")
    public void enterKeyword(String keyword) {
        // Znajdź element wprowadzania tekstu na podstawie jego nazwy
        WebElement element = driver.findElement(By.name("email_create"));
        // Wyczyść tekst zapisany w elemencie
        element.clear();
        // Wpisz informacje do wyszukania
        element.sendKeys("janek@kowalski.pl");
        // Prześlij formularz
        element.submit();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("entered personal information")
    public void personalInformation(){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement firstName = driver.findElement(By.id("customer_firstname"));
        firstName.clear();
        firstName.sendKeys("Janek");

        WebElement lastName = driver.findElement(By.id("customer_lastname"));
        lastName.clear();
        lastName.sendKeys("Kowalski");

        WebElement password = driver.findElement(By.id("passwd"));
        password.clear();
        password.sendKeys("Abc123");
        password.submit();
    }




    @And("zamykanie przeglądarki")
    public void closeBrowser() {
        driver.quit();
    }
}




