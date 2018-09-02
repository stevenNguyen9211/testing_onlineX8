package selenium_01;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Demo_SeleniumGit {
	
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		// TODO Auto-generated method stub
		String Node = "http://192.168.1.5:5555/wd/hub";
		String URLPage = "http://www.DemoQA.com";
		System.setProperty("webdriver.gecko.driver", "src/main/resources/data/browser_driver/geckodriver.exe");
		DesiredCapabilities caps = new DesiredCapabilities().firefox();
		driver = new RemoteWebDriver(new URL(Node), caps);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URLPage);
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
