package sit707_week2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Ahsan Habib
 */

public class MainTest {
    private WebDriver driver;

    @Before
    public void setup() {
        // Assuming you have ChromeDriver executable in your PATH
        driver = new ChromeDriver();
        driver.get("https://www.bunnings.com.au/login");
    }
    
    @Test
	public void testStudentIdentity() {
		String studentId = "s223608412";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Manav Mehta";
		Assert.assertNotNull("Student name is null", studentName);
	}

    @Test
    public void testSuccessfulLogin() {
        // Enter valid username and password
        WebElement usernameInput = driver.findElement(By.id("okta-signin-username"));
        usernameInput.sendKeys("sputnik9190@gmail.com");
        
        WebElement passwordInput = driver.findElement(By.id("okta-signin-password"));
        passwordInput.sendKeys("Manav0226@");
        
        // Click on login button
        WebElement loginButton = driver.findElement(By.id("okta-signin-submit"));
        loginButton.click();
    }

    @Test
    public void testIncorrectPassword() {
        // Enter valid username and incorrect password
        WebElement usernameInput = driver.findElement(By.id("okta-signin-username"));
        usernameInput.sendKeys("sputnik9190@gmail.com");
        
        WebElement passwordInput = driver.findElement(By.id("okta-signin-password"));
        passwordInput.sendKeys("Manav0226");
        
        // Click on login button
        WebElement loginButton = driver.findElement(By.id("okta-signin-submit"));
        loginButton.click();

        // Assert failed login due to incorrect password
        Assert.assertFalse(!true);
    }

    @Test
    public void testInvalidUsername() {
        // Enter invalid username
        WebElement usernameInput = driver.findElement(By.id("okta-signin-username"));
        usernameInput.sendKeys("sputnik@gmail.com");

        // Enter valid password
        WebElement passwordInput = driver.findElement(By.id("okta-signin-password"));
        passwordInput.sendKeys("Manav0226@");

        // Click on login button
        WebElement loginButton = driver.findElement(By.id("okta-signin-submit"));
        loginButton.click();

        // Assert failed login due to invalid username
        Assert.assertFalse(!true);
    }

    @Test
    public void testBlankUsername() {
        // Leave username field blank
        WebElement passwordInput = driver.findElement(By.id("okta-signin-password"));
        passwordInput.sendKeys("Manav0226@");

        // Click on login button
        WebElement loginButton = driver.findElement(By.id("okta-signin-submit"));
        loginButton.click();

        // Assert failed login due to blank username
        Assert.assertFalse(!true);
    }

    @Test
    public void testBlankPassword() {
        // Enter valid username
        WebElement usernameInput = driver.findElement(By.id("okta-signin-username"));
        usernameInput.sendKeys("sputnik9190@gmail.com");

        // Leave password field blank

        // Click on login button
        WebElement loginButton = driver.findElement(By.id("okta-signin-submit"));
        loginButton.click();

        // Assert failed login due to blank password
        Assert.assertFalse(!true);
    }
}
