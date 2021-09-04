package Week4.day1;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames_assigment3{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40 ,TimeUnit.SECONDS);
		WebElement frame1 = driver.findElementByXPath("//iframe[@id='frame1']");
		driver.switchTo().frame(frame1);
		driver.findElementByXPath("//body//input[@type='text']").sendKeys("Hello");
		
		WebElement frame2 = driver.findElementByXPath("//iframe[@id='frame3']");
		driver.switchTo().frame(frame2);
		driver.findElementByXPath("//body//input[@type='checkbox']").click();
		driver.switchTo().defaultContent();
		WebElement frame3 = driver.findElementByXPath("//iframe[@id='frame2']");
		driver.switchTo().frame(frame3);
		WebElement drop1 = driver.findElementByXPath("//select//option[text()='Avatar']");
		drop1.click();
	}

}
