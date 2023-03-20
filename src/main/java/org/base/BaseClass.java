package org.base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

public class BaseClass implements BaseAPI {
    protected RemoteWebDriver driver = null;
    long maxWait = 30;
    long timeOut = 30;
    WebDriverWait wait = null;



    @Override
    public void setUp(Browser browser, String url) {
        switch (browser) {
            case CHROME:
                ChromeOptions co = new ChromeOptions();
                co.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(co);
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case SAFARI:
                driver = new SafariDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            default:
                System.err.println("Browser not defined");
                break;
        }
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
        wait = new WebDriverWait(driver, Duration.ofSeconds(maxWait));
    }

    @Override
    public void close() {
        driver.close();
    }


    @Override
    public WebElement element(Locators locators, String text) {
        switch (locators) {
            case id:
                return driver.findElement(By.id(text));
            case name:
                return driver.findElement(By.name(text));
            case xpath:
                return driver.findElement(By.xpath(text));
            case tagName:
                return driver.findElement(By.tagName(text));
            case linkText:
                return driver.findElement(By.linkText(text));
            case classname:
                return driver.findElement(By.className(text));
            case cssSelector:
                return driver.findElement(By.cssSelector(text));
            case partialLinkText:
                return driver.findElement(By.partialLinkText(text));
            default:
                System.out.println("Element not found");
                break;
        }
        return null;
    }

    @Override
    public void switchToFrames(int i) {
        try {
            driver.switchTo().frame(i);
        }catch (NoSuchFrameException e){
            e.printStackTrace();
        }

    }

    @Override
    public void Alerts(String type, String text) {
        Alert alert = driver.switchTo().alert();
        switch (type.toLowerCase()) {
            case "simple":
                alert.accept();
                break;
            case "confirm":
                alert.dismiss();
                break;
            case "prompt":
                alert.sendKeys(text);
                break;
            default:
                System.err.println("Alert Not Found");
                break;
        }
        alert.accept();
    }

    @Override
    public void switchToWindow(int i) {
        try {
            Set<String> windowHandles = driver.getWindowHandles();
            ArrayList<String> list = new ArrayList<>(windowHandles);
            driver.switchTo().window(list.get(i));
        }catch (NoSuchWindowException e){
            e.printStackTrace();
        }

    }

    @Override
    public void selectByIndex(WebElement element, int i) {
        WebElement webElement = isElementVisible(element);
        new Select(webElement).selectByIndex(i);
    }

    @Override
    public void selectByText(WebElement element, String text) {
        WebElement webElement = isElementVisible(element);
        new Select(webElement).selectByVisibleText(text);
    }

    @Override
    public void selectByValue(WebElement element, String value) {
        WebElement webElement = isElementVisible(element);
        new Select(webElement).selectByValue(value);
    }

    @Override
    public void click(WebElement element) {
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        webElement.click();
    }

    @Override
    public void type(WebElement element, String data) {
        WebElement webElement = isElementVisible(element);
        webElement.clear();
        webElement.sendKeys(data);
    }

    @Override
    public void typeAndEnter(WebElement element, String data, Keys keys) {
        WebElement webElement = isElementVisible(element);
        webElement.clear();
        webElement.sendKeys(data, keys);
    }

    private WebElement isElementVisible(WebElement element) {
        WebElement webElement = wait
                .withMessage("Element not found")
                .until(ExpectedConditions.visibilityOf(element));
        return webElement;
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    @Override
    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    @Override
    public boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    @Override
    public boolean isMultiply(WebElement element) {
        return new Select(element).isMultiple();
    }

    @Override
    public void quit() {
        driver.quit();
    }
    @Override
    public File setTakesScreenshot(String element) {
        TakesScreenshot takesScreenshot = driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File("./test-output/"+File.separator+element+".png");
        try {
            FileHandler.copy(source, destination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return destination;
    }
}
