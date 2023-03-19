package org.base;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.File;

public interface BaseAPI {
    /**
     * This will launch the given browser with given URL
     */
    void setUp(Browser browser,String url);

    /**
     * This will quit the browser
     */
    void close();

    /**
     * This is find the elements in the webpage with help of locators
     * @return - will return a Web element
     */
    WebElement element(Locators locators,String text);

    /**
     * This is used to switch between the frames in the Web Page
     */
    void switchToFrames(int i);

    /**
     * This is used to handle the Alerts in the webpage
     */
    void Alerts(String type,String text);

    /**
     * This is used to switch between windows in window handling
     */
    void switchToWindow(int i);

    /**
     * This is used to select the options in the drop down menu using index
     */
    void selectByIndex(WebElement element,int i);

    /**
     * This is used to select the options in the drop down menu using Text
     */
    void selectByText(WebElement element,String text);

    /**
     * This is used to select the options in the drop down menu using Value
     */
    void selectByValue(WebElement element,String value);

    /**
     * This is used to perform click actions
     */
    void click(WebElement element);

    /**
     * This is used to send the values to the text box and perform enter key action
     */
    void typeAndEnter(WebElement element, String data, Keys keys);

    /**
     * This is used to send the values to the text box
     * @param element - element to be found
     * @param data - values to be sent
     */
    void type(WebElement element, String data);

    /**
     * This will fetch the current title of the webpage
     */
    String getTitle();

    /**
     * This will fetch the current URL of the webpage
     */
    String getCurrentURL();

    /**
     * This is used to check whether the web elements are present or not
     */
    boolean isDisplayed(WebElement element);

    /**
     * This is used to check the drop down list is allowing to select multiple values
     * @param element
     * @return
     */
    boolean isMultiply(WebElement element);

    /**
     * This is used to quit to driver
     */
    void quit();
    File setTakesScreenshot(String element);

}
