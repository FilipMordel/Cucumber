package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage {
    private static WebDriver driver;

    public AddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(name = "address1")
    WebElement addressInput;

    @FindBy(name= "city")
    WebElement cityInput;

    @FindBy(name = "postcode")
    WebElement postcodeInput;

    @FindBy(css = ".btn.btn-primary.form-control-submit")
    WebElement submitAddressInfo;

    @FindBy(css = ".alert.alert-success")
    WebElement successInformation;

    public void addAddress(String address, String city, String postcode){
        addressInput.click();
        addressInput.clear();
        addressInput.sendKeys(address);

        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys(city);

        postcodeInput.click();
        postcodeInput.clear();
        postcodeInput.sendKeys(postcode);

        submitAddressInfo.click();
    }

    public String getUpdateInformation() {
        return successInformation.getText();
    }
}