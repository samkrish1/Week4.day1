package Week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		
		// TODO Auto-generated method stub
		/*
		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		 * 
		 * 2. Enter UserName and Password Using Id Locator
		 * 
		 * 3. Click on Login Button using Class Locator
		 * 
		 * 4. Click on CRM/SFA Link
		 * 
		 * 5. Click on contacts Button
		 * 	
		 * 6. Click on Merge Contacts using Xpath Locator
		 * 
		 * 7. Click on Widget of From Contact
		 * 
		 * 8. Click on First Resulting Contact
		 * 
		 * 9. Click on Widget of To Contact
		 * 
		 * 10. Click on Second Resulting Contact
		 * 
		 * 11. Click on Merge button using Xpath Locator
		 * 
		 * 12. Accept the Alert
		 * 
		 * 13. Verify the title of the page
		 */
	
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElementByXPath("//a[contains (text(),'Merge Contacts')]").click();
		driver.findElementByXPath("(//img[@alt='Lookup'])[1]").click();
		Set<String> W1 = driver.getWindowHandles();
		List<String> W2 = new ArrayList<String>(W1);
		W2.get(1);
		driver.switchTo().window(W2.get(1));
		driver.findElement(By.linkText("12381")).click();
		driver.findElementByXPath("(//img[@alt='Lookup'])[2]").click();
		Set<String> W3 = driver.getWindowHandles();
		List<String> W4 = new ArrayList<String>(W3);
		W4.get(1);
		driver.switchTo().window(W4.get(1));
		driver.findElement(By.linkText("12384")).click();
		driver.findElement(By.linkText("Merge")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		alert.accept();
		System.out.println(driver.getTitle());
		
		
		
		
	}

}
