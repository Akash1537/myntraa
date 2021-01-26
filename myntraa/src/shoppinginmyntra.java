import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class shoppinginmyntra {

	
@Test
public void myntralogin() throws Exception{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\cpe\\workspace\\Google\\chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.myntra.com/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	Actions act = new Actions(driver);
	WebElement element = driver.findElement(By.className("desktop-main"));
	act.moveToElement(element).build().perform();
	driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/nav/div/div[1]/div/div/div/div/li[5]/ul/li[11]")).click();
	driver.findElement(By.xpath("//*[@id=\"desktopSearchResults\"]/div[2]/section/ul/li[11]/a/div[1]/div/div/div/picture/img")).click();
	
	Set<String>windows = driver.getWindowHandles();
	Iterator<String> itr = windows.iterator();
	String mainwindow = itr.next();
	String newWindow = itr.next();
	driver.switchTo().window(newWindow);
	
	String price = driver.findElement(By.xpath("//*[@id=\"mountRoot\"]/div/div/div/main/div[2]/div[2]/div[1]/p[1]/span[1]/strong")).getText();
	System.out.println("Price:    "  + price);
	price = price.replaceAll("[^\\d]", "");
	if(Integer.parseInt(price)>10)
System.out.println("Price is more than rupees 10");
	else
		System.out.println("Price is less rupees than 10");
	
	WebElement addButton = driver.findElement(By.xpath("//*[@id=\"mountRoot\"]/div/div/div/main/div[2]/div[2]/div[3]/div/div[1]"));
	if
	(addButton.isDisplayed())
		System.out.println("Add to bag Button is displayed");
	else
		System.out.println("Add to bag Button is not displayed");
}
}