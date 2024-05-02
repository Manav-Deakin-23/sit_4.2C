package sit707_week2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void bunnings_login(String username, String password) throws IOException {
        // Step 1: Locate chrome driver folder in the local drive.
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\manav\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Step 2: Use above chrome driver to open up a chromium browser.
        System.out.println("Fire up chrome browser.");
        WebDriver driver = new ChromeDriver();

        System.out.println("Driver info: " + driver);

        sleep(2);

        // Load Bunnings login page
        driver.get("https://www.bunnings.com.au/login");
        driver.manage().window().maximize();

        // Find username input field and enter username
        WebElement usernameInput = driver.findElement(By.id("okta-signin-username"));
        usernameInput.sendKeys(username);

        // Find password input field and enter password
        WebElement passwordInput = driver.findElement(By.id("okta-signin-password"));
        passwordInput.sendKeys(password);

        // Find login button and click
        WebElement loginButton = driver.findElement(By.id("okta-signin-submit"));
        loginButton.click();

        // Take screenshot after login attempt
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:\\Users\\manav\\Desktop\\Selenium Screenshot\\Bunnings_Login_Attempt.png"));

        // Sleep a while to observe the result
        sleep(5);

        // Close the browser
        driver.quit();
    }
}
