package Week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class frame_assignment4 {

	public static void main(String[] args) throws IOException {
		
		/*
		 * Assignment 4:
------------
http://leafground.com/pages/frame.html
1.Take the the screenshot of the click me button of first frame
2.Find the number of frames
  - find the Elements by tagname - iframe
  - Store it in a list
  - Get the size of the list. (This gives the count of the frames visible to the main page)
		 */
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40 ,TimeUnit.SECONDS);
		WebElement frame1 = driver.findElementByXPath("//div[@id='wrapper']//iframe");
		driver.switchTo().frame(frame1);
		driver.findElementByXPath("//button[text()='Click Me']").click();
		File src =driver.getScreenshotAs(OutputType.FILE);
		File des =new File("./snaps/seat1.png");
		FileUtils.copyFile(src, des);
		driver.switchTo().defaultContent();
		List<WebElement> totalframes = driver.findElements(By.tagName("iframe"));
	      System.out.println("Total number " + totalframes.size());
	      driver.quit();
		
		

	}

}
