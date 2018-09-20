package testNGPractise;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Practise_02 {
	public static WebDriver driver;
	public static WebDriverWait waitEx;

	@Test
	public void openFacebook() {
		driver.get("https://www.facebook.com");
		waitEx = new WebDriverWait(driver, 15);
		WebElement logo_facebook = driver.findElement(By.xpath("//i[contains(@class,'fb_logo')]"));
		waitEx.until(ExpectedConditions.visibilityOf(logo_facebook));
		String getTitle = driver.getTitle();
		assertTrue(getTitle.contains("Facebook"), "Verify the title of page contains Facebook");
	}
	
	@Test
	public void openInstagram() throws InterruptedException {
		driver.get("https://www.instagram.com");
		Thread.sleep(3000);
		String instagramTitle = driver.getTitle();
		assertTrue(instagramTitle.contains("Instagram"));
	}

	@BeforeMethod
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/data/browser_driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void afterTest() {
		driver.quit();
	}

}