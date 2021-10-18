package week_2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Day_1 {
    public static void chromedriverSetup() {
        WebDriverManager.chromedriver().setup();
    }
    public static void initializeDriver(ChromeDriver driver) throws InterruptedException {
        driver.get("http://leaftaps.com/opentaps/control/main");
        Thread.sleep(2000);
    }

    public static WebElement getElement(String identifierType, String identifier, ChromeDriver driver){
        WebElement element = null;
        if(identifierType.equalsIgnoreCase("class")){
            element = driver.findElement(By.className(identifier));
        }else if(identifierType.equalsIgnoreCase("id")){
            element = driver.findElement(By.id(identifier));
        }else if(identifierType.equalsIgnoreCase("link-text")){
            element = driver.findElement(By.linkText(identifier));
        }
        return element;
    }
    public static void enterText(ChromeDriver driver,String identifierType,String identifier, String input){
        WebElement textBox = getElement(identifierType, identifier, driver );
        textBox.sendKeys(input);
    }
    public static void elementClick(ChromeDriver driver,String identifierType,String identifier){
        WebElement element = getElement(identifierType, identifier, driver );
        element.click();
    }
    public static void selectDropdown(ChromeDriver driver,String identifierType,String identifier, String value){
        Select dropdown = new Select(getElement(identifierType, identifier, driver ));
        dropdown.selectByVisibleText(value);
    }
    public static void loginPageOperations(ChromeDriver driver){
        enterText(driver, "class", "inputLogin", "Demosalesmanager");
        enterText(driver, "id", "password", "crmsfa");
        elementClick(driver, "class", "decorativeSubmit");
    }

    public static void homePageoperations(ChromeDriver driver) {
        elementClick(driver, "link-text", "CRM/SFA");
    }

    public static void navigateToLeadsForm(ChromeDriver driver) {
        elementClick(driver, "link-text", "Leads");
        elementClick(driver, "link-text", "Create Lead");
    }

    public static void fillContactInformation(ChromeDriver driver){
        enterText(driver, "id", "createLeadForm_primaryPhoneCountryCode", "91");
        enterText(driver, "id", "createLeadForm_primaryPhoneAreaCode", "08624");
        enterText(driver, "id", "createLeadForm_primaryPhoneNumber", "1234567890");
        enterText(driver, "id", "createLeadForm_primaryPhoneExtension", "9091");
        enterText(driver, "id", "createLeadForm_primaryEmail", "a@a.com");
        enterText(driver, "id", "createLeadForm_primaryWebUrl", "https://a.com");
    }
    public static void fillPrimaryAddress(ChromeDriver driver) throws InterruptedException {
        enterText(driver, "id", "createLeadForm_generalToName", "Karna Diwakar");
        enterText(driver, "id", "createLeadForm_generalAttnName", "Mr.");
        enterText(driver, "id", "createLeadForm_generalAddress1", "14/106-15");
        enterText(driver, "id", "createLeadForm_generalAddress2", "Vamulamitta");
        enterText(driver, "id", "createLeadForm_generalCity", "Gudur");
        selectDropdown(driver, "id", "createLeadForm_generalCountryGeoId","India");
        Thread.sleep(2000);
        selectDropdown(driver, "id", "createLeadForm_generalStateProvinceGeoId","ANDHRA PRADESH");
        enterText(driver, "id", "createLeadForm_generalPostalCode", "524101");
        enterText(driver, "id", "createLeadForm_generalCity", "01");
    }
    public static void fillLeadInformation(ChromeDriver driver){
        enterText(driver, "id", "createLeadForm_companyName", "Cybertech Systems & Software Limited");
        enterText(driver, "id", "createLeadForm_firstName", "Karna");
        enterText(driver, "id", "createLeadForm_lastName", "Diwakar");
        enterText(driver, "id", "createLeadForm_personalTitle", "Sri");
        selectDropdown(driver, "id", "createLeadForm_dataSourceId","Website");
        selectDropdown(driver, "id", "createLeadForm_marketingCampaignId","Road and Track");
        //enterText(driver, "id", "createLeadForm_birthDate", "13/7/90");
        enterText(driver, "id", "createLeadForm_annualRevenue", "100000000");
        selectDropdown(driver, "id", "createLeadForm_currencyUomId","INR - Indian Rupee");
        selectDropdown(driver, "id", "createLeadForm_industryEnumId","Computer Software");
        enterText(driver, "id", "createLeadForm_numberEmployees", "500");
        selectDropdown(driver, "id", "createLeadForm_ownershipEnumId","LLC/LLP");
        enterText(driver, "id", "createLeadForm_sicCode", "N/A");
        enterText(driver, "id", "createLeadForm_tickerSymbol", "N/A");
        enterText(driver, "id", "createLeadForm_description", "Lorem Ipsum");
        enterText(driver, "id", "createLeadForm_importantNote", "Lorem Ipsum");
        System.out.println(getElement("id", "createLeadForm_firstName",driver).getText());
        elementClick(driver, "class", "smallSubmit");
    }
    public static void fillLeadsForm(ChromeDriver driver) throws InterruptedException {
        fillContactInformation(driver);
        fillPrimaryAddress(driver);
        fillLeadInformation(driver);
    }

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        Day_1.initializeDriver(driver);
        Day_1.loginPageOperations(driver);
        Day_1.homePageoperations(driver);
        Day_1.navigateToLeadsForm(driver);
        Day_1.fillLeadsForm(driver);
        Thread.sleep(2000);
        System.out.println("Title of the resulting page is "+ driver.getTitle() );
        driver.quit();
    }

}
