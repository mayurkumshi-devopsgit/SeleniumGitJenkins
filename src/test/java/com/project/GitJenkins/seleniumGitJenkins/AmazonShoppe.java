package com.project.GitJenkins.seleniumGitJenkins;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonShoppe

{
	WebDriver driver;
	
	
@BeforeTest
public void loadSite()
{
	ChromeOptions options = new ChromeOptions();
	options.addArguments("disable-notifications");
	System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	driver = new ChromeDriver(options);
	driver.get("https://www.myntra.com/");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	
}

@Test
public void Login() throws Exception
{
    
    Random rand = new Random();
    
	WebElement element = driver.findElement(By.xpath("//span[@class='desktop-userTitle' and text() = 'Profile']"));
	Actions action = new Actions(driver);
	action.moveToElement(element).build().perform();
	 
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("//a[@class='desktop-linkButton' and text()='Sign up']")).click();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.findElement(By.name("email")).sendKeys("test.user"+rand.nextInt(100)+"@gmail.com");
	driver.findElement(By.name("password")).sendKeys("Login@123");
	
    int mobile = 0;
	StringBuilder sb = new StringBuilder();
	for(int num = 0; num<10;num++)
	{
	
	mobile = rand.nextInt(10); 	
	
		  if(num == 10)
		  break;
		  sb = sb.append(mobile);
	} 

	driver.findElement(By.name("mobile")).sendKeys(""+sb);
	driver.findElement(By.id("male")).click();
	driver.findElement(By.xpath("//button[@class='register-register-button']")).click();
	Thread.sleep(10000);
	ChromeOptions options = new ChromeOptions();
	options.addArguments("disable-notifications");
}

@Test
public void getMenuNames()
{
		
		
		List<WebElement> menulist = driver.findElements(By.xpath("//a[@data-type='navElements']"));

		int count = menulist.size();
		System.out.println(" Elements " + count);
		
		
		System.out.println("Printing the names of the Menus ");
		
//		List<WebElement> menulistname = driver.findElements(By.xpath("//a[@data-group]"));
//		Iterator<WebElement> iterator = menulistname.iterator();
//		while(iterator.hasNext())
//		{
//			menulistname.add(iterator.next());
//		}
//		
//		System.out.println(" "+menulistname);
	
}

@Test
public void addItems()
{
	List <WebElement> categories = driver.findElements(By.className("desktop-categoryName"));
	int categorycount = categories.size();
	System.out.println(" Categories "+categorycount);
	WebElement element = driver.findElement(By.xpath("//a[@data-reactid='21'  and text()='Men']"));
	Actions action = new Actions(driver);
	action.moveToElement(element).build().perform();
	driver.findElement(By.xpath("//li//a[@data-reactid='30' and text()='T-Shirts']")).click();
	
	boolean value = false;
	if(driver.findElement(By.xpath("//input[@type='checkbox' and @value='Roadster']")).isSelected())
	{
		value = true;
		driver.findElement(By.xpath("//input[@type='checkbox' and @value='Roadster']")).click();
		System.out.println("Roadster Selected");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
}
	
@AfterTest()

	public void close()
	{
		driver.close();
	}
}
	

