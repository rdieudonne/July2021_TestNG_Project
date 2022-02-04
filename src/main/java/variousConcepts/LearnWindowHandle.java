package variousConcepts;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class LearnWindowHandle {
	
	WebDriver driver;

	@BeforeClass
	public void init() {
		
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.yahoo.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void testWindowHandle() {
		
//		System.out.println(driver.getTitle());
//		String handle1 = driver.getWindowHandle();
//		System.out.println(handle1);
		
		driver.findElement(By.xpath("//*[@id=\"ybar-sbq\"]")).sendKeys("selenium");
		driver.findElement(By.xpath("//*[@id=\"ybar-search\"]")).click();
		
//		System.out.println(driver.getTitle());
//		String handle2 = driver.getWindowHandle();
//		System.out.println(handle2);
//		ctrl + /
//		ctrl + shift + /	//		ctrl + shift + \	multiple lines	

		driver.findElement(By.xpath(" //*[@id=\"web\"]/ol/li[3]/div/div[1]/h3/a")).click();
		
//		System.out.println(driver.getTitle());
		String handle3 = driver.getWindowHandle();
		System.out.println(handle3);
		
		Set<String> handles = driver.getWindowHandles();
		System.out.println(handles);
		
		for(String i : handles) {
			System.out.println(i);
			driver.switchTo().window(i);
		}
		
//		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//*[@id=\"main_navbar\"]/ul/li[3]/a/span")).click();
		
		driver.switchTo().window(handle3);
		System.out.println(driver.getTitle());
	}


}
