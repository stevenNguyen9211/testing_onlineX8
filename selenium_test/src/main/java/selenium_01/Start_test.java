package selenium_01;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Start_test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "src/main/resources/data/browser_driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.accorhotels.com/");
		Thread.sleep(8000);
		String getTitlePage = driver.getTitle();
		System.out.println(getTitlePage);
		JavascriptExecutor JS = (JavascriptExecutor) driver;
		WebElement footer = driver.findElement(By.id("footer"));
		JS.executeScript("arguments[0].scrollIntoView(true)", footer);
		JS.executeScript("document.getElementById('engine-container').scrollIntoView();");
		//JS.executeScript("document.getElementById('footer').scrollIntoView();");
		Thread.sleep(4000);
		driver.quit();
	}

}
