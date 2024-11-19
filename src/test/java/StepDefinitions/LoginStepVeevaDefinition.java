package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;


import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginStepVeevaDefinition {

    WebDriver driver;
    private static final Logger log = LogManager.getLogger(LoginStepVeevaDefinition.class);


    @Given("User Launch browser window")
    public void user_launch_browsertest() throws Throwable{
        //Invoking Browser
        System.setProperty("webdriver.chrome.driver", "src/test/java/driver/chromedriver");
        driver = new ChromeDriver();
//        //Method to Open Specified URL (website)
        driver.get("https://rtsm-val.veeva.com/VEV-901/");


    }
    @When("User Opens Subject Menu")
    public void LoginSuccess() throws Throwable{


        //Wait method - Explicit
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@id='header_imgVLogic']")));

        //Getting the Web element
        WebElement userID = driver.findElement(By.xpath("//input[@id='txtLogin']"));
        userID.sendKeys("kandulavus@gmail.com");

        WebElement pass = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        pass.sendKeys("Balakrishna1");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginButton.click();


        //Wait method - Explicit
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='lblHeading']")));

        WebElement firstMenu = driver.findElement(By.xpath("//table[@class='gridnormal']/tbody/tr[1]/td/a"));
        firstMenu.click();

        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

        String winHandleBefore = driver.getWindowHandle();
        // Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        WebElement viewInformLink = driver.findElement(By.xpath("//div[@id='pnlTasks']/table/tbody/tr/td/table/tbody/tr[2]/td[2]/a"));
        viewInformLink.click();

        // Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        WebElement siteNum = driver.findElement(By.xpath("//div[@id='pnlSubject']/table/tbody/tr[1]/td[2]/span"));
        siteNum.getText();
        System.out.println(siteNum.getText());

        WebElement subID = driver.findElement(By.xpath("//div[@id='pnlSubject']/table/tbody/tr[2]/td[2]/span"));
        subID.getText();
        System.out.println(subID.getText());

        WebElement dob = driver.findElement(By.xpath("//div[@id='pnlSubject']/table/tbody/tr[3]/td[2]/span"));
        dob.getText();
        System.out.println(dob.getText());

        WebElement sex = driver.findElement(By.xpath("//div[@id='pnlSubject']/table/tbody/tr[4]/td[2]/span"));
        sex.getText();
        System.out.println(sex.getText());

        WebElement randID = driver.findElement(By.xpath("//div[@id='pnlSubject']/table/tbody/tr[5]/td[2]/span"));
        randID.getText();
        System.out.println(randID.getText());

        WebElement previousTreatment = driver.findElement(By.xpath("//div[@id='pnlSubject']/table/tbody/tr[6]/td[2]/span"));
        previousTreatment.getText();
        System.out.println(previousTreatment.getText());

        WebElement severity = driver.findElement(By.xpath("//div[@id='pnlSubject']/table/tbody/tr[7]/td[2]/span"));
        severity.getText();
        System.out.println(severity.getText());

        WebElement cohort = driver.findElement(By.xpath("//div[@id='pnlSubject']/table/tbody/tr[8]/td[2]/span"));
        cohort.getText();
        System.out.println(cohort.getText());

        WebElement status = driver.findElement(By.xpath("//div[@id='pnlSubject']/table/tbody/tr[9]/td[2]/span"));
        status.getText();
        System.out.println(status.getText());


        WebElement statusDate = driver.findElement(By.xpath("//div[@id='pnlSubject']/table/tbody/tr[10]/td[2]/span"));
        statusDate.getText();
        System.out.println(statusDate.getText());

        driver.switchTo().window(winHandleBefore);

        WebElement adminMenu = driver.findElement(By.xpath("//table[@id='navbar_navMenu']/tbody/tr/td[9]/table/tbody/tr/td/a"));

        Actions actions = new Actions(driver);
        actions.moveToElement(adminMenu).build().perform();

        WebElement inventoryMenu = driver.findElement(By.xpath("//a[text()='Inventory']"));
        inventoryMenu.click();

        TakesScreenshot ts = (TakesScreenshot)driver;
        File file = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("./ScreenShot_Folder/Test1_Login.jpg"));



        driver.quit();
    }

}
