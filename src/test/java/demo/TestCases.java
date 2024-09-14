package demo;

import org.checkerframework.checker.units.qual.m;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.logging.Level;



// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
    ChromeDriver driver;

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */
    @Test
    public void testCase01(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        

try{
        String googleFormUrl="https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform?pli=1";
        if(!driver.getCurrentUrl().equals(googleFormUrl)){
            driver.get(googleFormUrl);
            System.out.println("User is navigated to Google Form");
        }

        
        Thread.sleep(3000);
        WebElement nameField=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text'][1]")));
        System.out.println("wait 1");
        Wrappers.enterText(nameField, "Crio Learner");


        WebElement practisingAutomationElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@aria-label='Your answer']")));
        System.out.println("wait 2");
        String practisingAutomationText="I want to be the best QA Engineer!";
        String epochTimeString=Wrappers.getEpochTimeAsString();
        Wrappers.enterText(practisingAutomationElement, practisingAutomationText+" "+epochTimeString);
        


        List<WebElement> radioButtons=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='nWQGrd zwllIb']")));
        System.out.println("wait 3");
        for (WebElement radioButton : radioButtons) {
            String radioButtonText=radioButton.getText();
            if(radioButtonText.contains(radioButtonText)){
                Wrappers.selectRadioButton(driver,radioButton);
                Thread.sleep(3000);
                break;
            }
        }


        List<WebElement> checkBoxOptions=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='eBFwI']")));
        System.out.println("wait 4");
        List<String> optionsToSelect = List.of("Java", "Selenium", "TestNG");
        for (WebElement checkBoxOption : checkBoxOptions) {
            String checkBoxOptionText=checkBoxOption.getText();
            for (String option : optionsToSelect) {
            if(checkBoxOptionText.contains(option)){
                Wrappers.selectCheckBox(driver,checkBoxOption);
                break;
            }
        }
        }

        WebElement dropDoWebElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'jgvuAb ybOdnf cGN2le ')]/div/div[@class='ry3kXd']")));
        System.out.println("wait 4");
        Wrappers.clickOnElement(driver, dropDoWebElement);
        Wrappers.dropDownClick(driver, "Ms");


        WebElement dateInput=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='date']")));
        System.out.println("wait 5");
        String dateFormatString=Wrappers.getDateSevenDaysAgo();
        Wrappers.enterText(dateInput, dateFormatString);
        System.out.println("Date entered: "+dateFormatString);

        WebElement hourElement=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@aria-label='Hour']")));
        System.out.println("wait 6");
        Wrappers.enterText(hourElement, "07");

        WebElement minuteElement=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@aria-label='Minute']")));
        System.out.println("wait 6");
        Wrappers.enterText(minuteElement, "30");


        WebElement submitButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Submit']")));
        Wrappers.clickOnElement(driver, submitButton);

        WebElement confirmationMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Thanks for your response, Automation Wizard!']")));
        String confirmationMessageText=confirmationMessage.getText();
        if(confirmationMessageText.contains("Thanks for your response, Automation Wizard!")){
            System.out.println("Success message displayed: "+confirmationMessageText);
        }else{
            System.out.println("Success message is NOT displayed.");
        }



        
      




}catch(Exception e){
        System.out.println("Automation for filling a google form failed "+ e.getMessage());
        e.getStackTrace();
    }

    }

     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}