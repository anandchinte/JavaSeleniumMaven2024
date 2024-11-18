package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class LoginStepDefinition {

    WebDriver driver;
    private static final Logger log = LogManager.getLogger(LoginStepDefinition.class);


    @Given("User Launch browser")
    public void openingUrl() throws Throwable{
        //Invoking Browswer
        System.setProperty("webdriver.chrome.driver", "src/test/java/driver/chromedriver");
        driver = new ChromeDriver();
//        //Method to Open Specified URL (website)
        driver.get("https://www.allegiantair.com/");


    }
    @When("User search for the flight")
    public void LoginSuccess() throws Throwable{


        //Wait method - Explicit
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='Popup__CloseIcon-sc-1kasz48-2 eKPgGA']")));
        WebElement pop_up_button = driver.findElement(By.xpath("//button[@class='Popup__CloseIcon-sc-1kasz48-2 eKPgGA']"));
        pop_up_button.click();
        //Getting the Web element
        WebElement logo = driver.findElement(By.xpath("//img[@class='Logo__StyledLogo-r4xlav-0 krIhwr']"));
        //Wait method - Explicit
        //WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(logo));
        //clicking departure
        WebElement departure_div = driver.findElement(By.xpath("//div[text()='Departure, airport']"));
        departure_div.click();
        //selection option from dropdown
        WebElement option_select = driver.findElement(By.xpath("//div[contains(text(),'Allentown (Lehigh Valley), PA (ABE)')]"));
        option_select.click();

        //clicking destination
        WebElement destination_div = driver.findElement(By.xpath("//div[text()='Destination, airport']"));
        destination_div.click();
        //selection option from dropdown
        WebElement des_option_select = driver.findElement(By.xpath("//div[contains(text(),'Daytona Beach / Sanford, FL (SFB)')]"));
        des_option_select.click();
        //clicking calendar icon
        Thread.sleep(10000);
        List<WebElement> calender_button = driver.findElements(By.xpath("//button[@class='DatePicker__DateFieldControl-iz35q0-0 gecfVU']"));
        calender_button.get(0).click();
        //selection from date
        WebElement from_date = driver.findElement(By.xpath("//div[@class='Box-s8oj9r-0 dLFASS']/div[1]/div/div[3]/button/div[text()='20']"));
        from_date.click();
        //selection To date
        WebElement to_date = driver.findElement(By.xpath("//div[@class='Box-s8oj9r-0 dLFASS']/div[2]/div/div[3]/button/div[text()='20']"));
        to_date.click();
        //clicking search button
        WebElement search_button = driver.findElement(By.xpath("//button[@data-hook='flight-search-submit']"));
        search_button.click();
        //wait for select flights
        WebDriverWait wait2 = new WebDriverWait(driver, 30);
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Select Flights']")));
        //GetFlight price
        Thread.sleep(10000);
        List<WebElement> flight_price = driver.findElements(By.xpath("//div[@data-hook='selected-flight']/div[2]/div[3]/div/div/div/div/div[2]/span"));
        log.info(flight_price.size());
        String departure_price_text = flight_price.get(0).getText();
        Double departure_price;
        departure_price = Double.parseDouble(departure_price_text.substring(1));
        System.out.println("Output"+ departure_price);
        String return_price_text = flight_price.get(1).getText();
        Double return_price;
        return_price = Double.parseDouble(return_price_text.substring(1));
        System.out.println("Output"+ return_price);
        WebElement select_flight_text = driver.findElement(By.xpath("//span[text()='Continue']"));
        Thread.sleep(10000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(0, 1000)");
        driver.findElement(By.xpath("//span[text()='Continue']")).click();
        Thread.sleep(10000);
        js.executeScript("javascript:window.scrollBy(0, 1000)");
        driver.findElement(By.xpath("//span[text()='Continue']")).click();
        Thread.sleep(10000);
        WebElement first_name = driver.findElement(By.id("adults.0.first-name"));
        first_name.sendKeys("Test");
        WebElement last_name = driver.findElement(By.id("adults.0.last-name"));
        last_name.sendKeys("Test");
        WebElement gender_male = driver.findElement(By.xpath("//span[text()='Male']"));
        gender_male.click();
        WebElement month_dropdown = driver.findElement(By.xpath("//div[text()='Month']"));
        month_dropdown.click();
        WebElement month_option_select = driver.findElement(By.xpath("//div[contains(text(),'August')]"));
        month_option_select.click();
        WebElement day_dropdown = driver.findElement(By.xpath("//div[text()='Day']"));
        day_dropdown.click();
        WebElement day_option_select = driver.findElement(By.xpath("//div[contains(text(),'13')]"));
        day_option_select.click();
        WebElement year_field = driver.findElement(By.id("adults.0.dob-year"));
        year_field.sendKeys("1990");
        js.executeScript("javascript:window.scrollBy(0, 1000)");
        driver.findElement(By.xpath("//span[text()='Continue']")).click();
        Thread.sleep(20000);
        js.executeScript("javascript:window.scrollBy(0, 1000)");
        driver.findElement(By.xpath("//a/span[text()='No thanks, skip seat selection.']")).click();
        Thread.sleep(20000);
        js.executeScript("javascript:window.scrollBy(0, 1000)");
        driver.findElement(By.xpath("//span[text()='Continue']")).click();
        List<WebElement> continue_buttons = driver.findElements(By.xpath("//button/span[text()='Continue']"));
        continue_buttons.get(1).click();
        Thread.sleep(20000);
        js.executeScript("javascript:window.scrollBy(0, 1000)");
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(20000);
        driver.findElement(By.xpath("//a/span[contains(text(),'hotel')]")).click();
        Thread.sleep(20000);
        js.executeScript("javascript:window.scrollBy(0, 1000)");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a/span[contains(text(),'transportation')]")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//button/img[@alt='closeIcon']")).click();
        Thread.sleep(30000);
        WebElement total_price = driver.findElement(By.xpath("//span[@data-hook='payment-page_trip_summary_amount']"));
        System.out.println("Output"+ total_price);
        Double total_flight_price;
        String total_flight_price_text = total_price.getText();
        total_flight_price = Double.parseDouble(total_flight_price_text.substring(1));
        System.out.println(total_flight_price);
        System.out.println(departure_price+return_price);
        assert total_flight_price == departure_price+return_price;
        driver.quit();
    }

}
