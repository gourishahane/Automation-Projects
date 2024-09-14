package demo.wrappers;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */
    public static void enterText(WebElement element,String text){
        try{
            
            element.clear();
            element.sendKeys(text);
            String getNameText=element.getAttribute("value");
        if(getNameText.equals(text)){
            System.out.println("Text entered successfully. "+getNameText);
        }else{
            throw new Exception("Text entry failed");
        }
        

        }catch(Exception e){
            System.out.println("Exception occurred while entering text" +e.getMessage());
            e.getStackTrace();

        }
    }

    public static String getEpochTimeAsString(){
        long epoch = System.currentTimeMillis()/1000;
        String epochString=String.valueOf(epoch);
        return epochString;
    }

    public static void selectRadioButton(ChromeDriver driver,WebElement element){
        try{
            
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView()",element);
            element.click();
            System.out.println("Radion button selected successfully: "+element.getText());

        }catch(Exception e){
            System.out.println("Radio button selection failed" + e.getMessage());
            e.getStackTrace();
        }
        
    }

    public static void selectCheckBox(ChromeDriver driver,WebElement element){
        try{
            
            if (!element.isSelected()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
                element.click();
                System.out.println("Checkbox selected successfully.");
            } else {
                System.out.println("Checkbox is already selected.");
            }

        }catch(Exception e){
            System.out.println("Check-box selection failed" + e.getMessage());
            e.getStackTrace();
        }
        
    }

    public static void clickOnElement(ChromeDriver driver,WebElement element){
        try{
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();",element);
            System.out.println("Element is clicked");
        }catch(Exception e){
            System.out.println("Exception occurred while clicking on element" + e.getMessage());
            e.getStackTrace();
        }
    }

    public static void dropDownClick(ChromeDriver driver,String text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try{
            WebElement dropDownOption=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'QXL7Te')]/div/span[text()='"+text+"']")));
            dropDownOption.click();
            System.out.println("Dropdown option selected");
        }catch(Exception e){
            System.out.println("Exception occurred while selecting dropdown option" + e.getMessage());
            e.getStackTrace();
        }
    }
    
    public static String getDateSevenDaysAgo(){
        LocalDate currentDate=LocalDate.now();
        LocalDate dateMinusSevenDays=currentDate.minusDays(7);
        DateTimeFormatter fomatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate=dateMinusSevenDays.format(fomatter);
        return formattedDate;
    }






}
