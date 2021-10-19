package week_2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Assignment_Day_2 {
    /*public static void Assignment_1(){
        chromedriverSetup();
        ChromeDriver driver = new ChromeDriver();
        initializeDriver(driver, "https://en-gb.facebook.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        elementClick(driver, "xpath", "//a[@data-testid='open-registration-form-button']");
        enterText(driver, "xpath","//div[@id='fullname_field']//input[@name='firstname']", "Lorem");
        enterText(driver, "xpath","//div[@id='fullname_field']//input[@name='lastname']", "Lorem");
        enterText(driver, "xpath","//input[@name='reg_email__']", "9292929292");
        enterText(driver, "xpath","//div[@id='password_field']//input[@name='reg_passwd__']", "9292929292");
        selectDropdown(driver, "xpath", "//select[@name='birthday_day']", "13");
        selectDropdown(driver, "xpath", "//select[@name='birthday_month']", "Jul");
        selectDropdown(driver, "xpath", "//select[@name='birthday_year']", "1990");
        elementClick(driver, "xpath", "//span//input[@name='sex' and @value=1]");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        System.out.println("Test Successfull");
        driver.quit();
    }*/
    /*public static void Assignment_2(){
        chromedriverSetup();
        ChromeDriver driver = new ChromeDriver();
        initializeDriver(driver, "https://www.salesforce.com/in/form/signup/freetrial-sales/?d=70130000000Enyk");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        enterText(driver, "xpath","//input[@name='UserFirstName']", "Lorem");
        enterText(driver, "xpath","//input[@name='UserLastName']", "Lorem");
        enterText(driver,"xpath", "//input[@type='email' and @name='UserEmail']", "a@a.com");
        enterText(driver, "xpath", "//input[@type='text' and @name='CompanyName']", "Cybertech");
        enterText(driver, "xpath", "//input[@type='tel' and @name='UserPhone']", "9999999999");
        selectDropdown(driver, "xpath", "//select[@name='UserTitle']", "Sales Manager");
        selectDropdown(driver, "xpath", "//select[@name='CompanyEmployees']", "101 - 500 employees");
        selectDropdown(driver, "xpath", "//select[@name='CompanyCountry']", "India");
        try{
            driver.executeScript("arguments[0].click();", getElement("xpath", "//input[@type='checkbox' and @name='SubscriptionAgreement']", driver));
            //elementClick(driver, "xpath", "//input[@type='checkbox' and @name='SubscriptionAgreement']");
        }catch (Exception e){
            System.out.println(e);
        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        System.out.println("Test Successfull");
        driver.quit();
    }*/
    public static void Assignment_3(){

    }
    public static void Assignment_4(){
        chromedriverSetup();
        ChromeDriver driver = new ChromeDriver();
        initializeDriver(driver, "https://acme-test.uipath.com/login");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        enterText(driver, "xpath","//div[@class=\"controls\"]//input[@id=\"email\" and @name=\"email\"]", "kumar.testleaf@gmail.com");
        enterText(driver, "xpath", "//div[@class=\"controls\"]//input[@id=\"password\" and @name=\"password\"]", "leaf@12");
        elementClick(driver, "xpath", "//button[@type=\"submit\"]");
        System.out.println(driver.getTitle());
        elementClick(driver, "xpath", "//a[@href=\"https://acme-test.uipath.com/logout\"]");
        driver.close();
        System.out.println("Test Successfull");

    }
    public static void Assignment_5(){

    }
    public static void Assignment_6(){

    }


    public static void chromedriverSetup() {
        WebDriverManager.chromedriver().setup();
    }
    public static void initializeDriver(ChromeDriver driver, String url){
        driver.get(url);
        driver.manage().window().maximize();
    }
    public static WebElement getElement(String identifierType, String identifier, ChromeDriver driver){
        WebElement element = null;
        if(identifierType.equalsIgnoreCase("class")){
            element = driver.findElement(By.className(identifier));
        }else if(identifierType.equalsIgnoreCase("id")){
            element = driver.findElement(By.id(identifier));
        }else if(identifierType.equalsIgnoreCase("link-text")){
            element = driver.findElement(By.linkText(identifier));
        }else if(identifierType.equalsIgnoreCase("xpath")){
            element = driver.findElement(By.xpath(identifier));
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

    public static void main(String[] args) {
        Assignment_Day_2.Assignment_4();
    }
}
