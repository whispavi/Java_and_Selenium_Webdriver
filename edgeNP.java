import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;


public class edgeNP extends Data {

     private By btnCreate = By.xpath("//div[@class = 'navbar-collapse collapse d-sm-inline-flex flex-sm-row-reverse']" +
            "//a[@class = 'nav-link text-dark']");
     private By inputEmail = By.xpath("//div[@class = 'form-group']//input[@class = 'form-control']");
     private By btnRegister = By.xpath("//div[@class = 'createDiv width-100perc']//button[@class = " +
             "'btn btn-red btn-primary btnPassCreate width-100perc']");
     private By getErrorText = By.xpath("//div[@class = 'form-group']//span[@class = " +
             "'text-danger field-validation-error']");
     private By btnCopyEmail = By.id("pre_copy");
     private By btnRegOnDevice = By.xpath("//div[@class = 'this-device-link']//button[@class = " +
             "'text-button increase-size']");
     private By btnContinue = By.xpath("//div[@class = 'no-qr-block']//button[@class = " +
             "'primary-button']");
     private By btnSignUp = By.xpath("//div[@class = 'action-buttons']//button[@class = " +
             "'secondary-button ng-star-inserted']");
     private By btnSignIn = By.xpath("//div[@class = 'action-buttons']//button[@class = " +
             "'primary-button ng-star-inserted']");
     private By inputEmailNP = By.id("mat-input-6");
     private By inputCheckBox = By.id("mat-checkbox-1-input");

     private By btnContinueNP = By.xpath("//div[@class = 'mat-form-field-wrapper ng-tns-c94-10']//button[@class = " +
             "'primary-button create-profile-button']");



    @Test //work with Pre***
    public void edgenp () throws InterruptedException {

          System.setProperty("webdriver.edge.driver", "C:\\Users\\***");
          WebDriver driver = new EdgeDriver();
          Data getDate = new Data();
          driver.get(getDate.getUrlPS);
          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
          WebDriverWait wait = new WebDriverWait(driver, 1000);


          //full open window
          //driver.manage().window().maximize();
          driver.findElement(btnCreate).click();

          //open the new tab
          driver.switchTo().newWindow(WindowType.TAB).get("https://tempmail.plus/ru/#!");

          driver.findElement(btnCopyEmail).click();

          sleep(2000);

          //open new tab
        ArrayList<String> newTab = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(0));

          driver.findElement(inputEmail).sendKeys(Keys.LEFT_CONTROL + "v");
          driver.findElement(btnRegister).click();
          sleep(3000);
          driver.findElement(btnRegOnDevice).click();
          driver.findElement(btnContinue).click();
          //sleep(2000);


     }

     @Test //negative testing email
     public void negEdgenp() {

          System.setProperty("webdriver.edge.driver", "C:\\Users\\***");
          WebDriver driver = new EdgeDriver();
          Data getDate = new Data();

          driver.get(getDate.getUrlPS);
          //driver.manage().window().maximize(); - if need full open window
          driver.findElement(btnCreate).click();
          driver.findElement(inputEmail).sendKeys(getDate.email);
          driver.findElement(btnRegister).click();

          String getError = driver.findElement(getErrorText).getText();

          Assert.assertEquals("The Email field is not a valid e-mail address.", getError);
     }


    @Test //work with No***
    public void edgesitenp () throws InterruptedException {

        System.setProperty("webdriver.edge.driver", "C:\\Users\\***");
        WebDriver driver = new EdgeDriver();
        Data getDate = new Data();
        driver.get(getDate.getUrl);


        //full open window
        //driver.manage().window().maximize();
        driver.findElement(btnSignUp).click();

        //open the new tab
        driver.switchTo().newWindow(WindowType.TAB).get("https://tempmail.plus/ru/#!");

        driver.findElement(btnCopyEmail).click();

        sleep(2000);

        //open new tab
        ArrayList<String> newTab = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(0));

        driver.findElement(inputEmailNP).sendKeys(Keys.LEFT_CONTROL + "v");
        //check the checkbox
        driver.findElement(inputCheckBox).click();

        driver.findElement(btnContinueNP).click();
        sleep(3000);
        
    }



}
