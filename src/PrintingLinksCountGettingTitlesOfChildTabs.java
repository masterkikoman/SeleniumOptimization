import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintingLinksCountGettingTitlesOfChildTabs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kalmazan\\AutomationDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.foodpanda.ph/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//1. Finding all Links counts in a given page
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//2. Finding all Links on footer
		//3. Creating driver scope
		WebElement footer = driver.findElement(By.xpath("//*[@class='othercountries']"));
		System.out.println(footer.findElements(By.tagName("a")).size());
		
		//4. Getting links per column
		WebElement popularCuisines = driver.findElement(By.xpath("//div/ul[@class='home-cuisines__list']"));
		//driver.findElement(By.xpath("//li[@class='home-cuisines__list__item']"));
		Integer size = driver.findElements(By.xpath("//li[@class='home-cuisines__list__item']")).size();
		System.out.println(size);
		for (int i = 0 ; i < size ; i++) {
			List<WebElement> cuisine = popularCuisines.findElements(By.xpath("//li[@class='home-cuisines__list__item']/a"));
			String c = cuisine.get(i).getText();
			
			if (i<=5)
			{
				
			System.out.println("First Column : "+c );	
			//5. Opening multiple window in a tab
			String clickOnLink = Keys.chord(Keys.CONTROL,Keys.ENTER);
			cuisine.get(i).sendKeys(clickOnLink);
				
						
			} 
			
			else if ((i > 5) && (i <= 11)) {
				
				System.out.println("Second Column : "+c );
				
			}
			
			else if ((i > 11) && (i <=18)) {
				
				System.out.println("Third Column  : "+c);
			} 
			
			else {
				
				System.out.println("Fourth Column : "+c);
			}
			
			
		}
		
		//Switch driver to separate window
		Set<String> titles = driver.getWindowHandles();//6 total
		Iterator<String> it = titles.iterator();
			
			while(it.hasNext()) {
				
				driver.switchTo().window(it.next());
				
				System.out.println(driver.getTitle());
			}

		
		
	}
}

