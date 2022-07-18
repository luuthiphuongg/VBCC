package com.sat.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.sat.driver.DriverManager;

public class Utils {
    public static void hardWait(int timeout){
        try {
            Thread.sleep(timeout);
        } catch (Exception e) {
            // pass
        }
    }

    public static void hardWait(){
        hardWait(3000);
    }

//     public static void scrollToElement(WebElement webElement) {
//         ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElement);
//         hardWait(500);
//     }

//     public static void newTab() {
//         JavascriptExecutor jse = (JavascriptExecutor) DriverManager.getDriver();
//         jse.executeScript("window.open()");
//         hardWait(500);

//         ArrayList<String> tabs = new ArrayList<String>(DriverManager.getDriver().getWindowHandles());
//         DriverManager.getDriver().switchTo().window(tabs.get(1));
//     }



//     public static void hover(WebElement webElement) {
//         Actions action = new Actions(DriverManager.getDriver());

//         action.moveToElement(webElement);
//         action.build().perform();
//         hardWait(500);
//     }

//     public static void acceptAlert() {
        
//         DriverManager.getDriver().switchTo().alert().accept();
//     }

//     public static String autoStringDateTime(){
//         // Create object of SimpleDateFormat class and decide the format
//         DateFormat dateFormat = new SimpleDateFormat(" MM/dd/yyyy HH:mm:ss");

//         //get current date time with Date()
//         Date date = new Date();
 
//         // Now format the date
//         String date1= dateFormat.format(date);
//         return date1;
//     }

//     static final int TIMEOUT = 10;
//     private static WebDriver driver;

// public static void checkGone(String id) {
//     FluentWait<WebDriver> wait = new WebDriverWait(driver, TIMEOUT)
//             .ignoring(StaleElementReferenceException.class);

//     DriverManager.getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//     try {
//         wait.until(ExpectedConditions.numberOfElementsToBe(By.id(id), 0));
//     } finally {
//         resetTimeout();
//     }
// }

// static void resetTimeout() {
//     DriverManager.getDriver().manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
// }
}

