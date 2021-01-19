package apsiyonProject;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.PageObjects;

public class AllSteps {

	WebDriver driver;

	private static String PAGE_URL = "https://www.n11.com/";

	@Test
	public void allcase() throws Exception {

		System.setProperty("webdriver.chrome.driver",
		"C:\\Users\\efdal.gunbay\\eclipse-workspace\\apsiyonProject\\drivers\\chromedriver.exe");

		driver = new ChromeDriver();

		PageObjects PageObject = new PageObjects(driver);

		// Navigate the Page
		driver.get(PAGE_URL);

		// Maximize window
		driver.manage().window().maximize();

		//Check the page
		String expectedUrl = "https://www.n11.com/";
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, expectedUrl, "Page is not opened");
		
		//click kvkk
		PageObject.clickbtn_btnBlack();
	
		//Clear localstorage for webpush
		LocalStorage local = ((WebStorage) driver).getLocalStorage();
		local.setItem("dengage_webpush_last_a", "denied");
		local.clear();
		sleep(10000);
		
		//clickwebpush
		PageObject.clickpushdenied();
		
		//clickgirisyap
		PageObject.clickgirisyap();
		sleep(3000);
		
		//fill mail and email
		PageObject.sendkeys("jexin83122@sofiarae.com","123456abc");
		sleep(3000);
		
		//clickloginbutton
		PageObject.clickloginbutton();
		sleep(3000);
		
		//Fill searchbar with parameters
		PageObject.searchbar("samsung");
		sleep(3000);

		//Make a list all products and check contains samsung first page element
		List<WebElement> Elementsfirst = driver.findElements(By.className("productName"));

		for (WebElement elements : Elementsfirst) {
			assertTrue(elements.getText().contains("Samsung"));
		}
		
		//Scroll buttom of the page
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		//Click Page 2
		PageObject.clickpagetwo();
		sleep(5000);
		
		//Check the right page for 2. page
		String secondpageurl = driver.getCurrentUrl();
		String expectedsecondpageurl = "https://www.n11.com/arama?q=samsung&pg=2";
		Assert.assertEquals(secondpageurl, expectedsecondpageurl);
		
		
		//Make a list all products and check contains samsung second page element
		List<WebElement> Elementssecond = driver.findElements(By.className("productName"));

		for (WebElement elements : Elementssecond) {
			assertTrue(elements.getText().contains("Samsung"));
		}
		
		// Go back to first page
		driver.navigate().back();
		sleep(5000);

		//Scroll webpage until find 3. products on list
		WebElement trhidfavorite = driver.findElement(By.xpath("//div[@id='view']/ul/li[3]/div//span[@title='Favorilere ekle']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(trhidfavorite);
		actions.perform();

		//click favorite button
		PageObject.addfavorite();
		
		//Get dataposition that clicked element
		String dataposition = driver.findElement(By.xpath("//div[@id='view']/ul/li[3]/div"))
		.getAttribute("data-position");
		
		//Parse string dataposition to int
		int i = Integer.parseInt(dataposition);
		System.out.println(i);
		
		//check element if it is 3. element get productid to compare in favorilist.
		if (i == 3) {

			String productid = driver.findElement(By.xpath("//div[@id='view']/ul/li[3]/div")).getAttribute("id");
			System.out.println(productid);

		}
		
		//else print dataposition
		else {

			System.out.println("3. sýradaki ürün deðil" + dataposition);
		}
		
		
		String productid = driver.findElement(By.xpath("//div[@id='view']/ul/li[3]/div")).getAttribute("id");

		
		//Scroll top of the page
		js.executeScript("window.scrollBy(0,0)");
		
		//Mouse over the loginmenu element
		Actions action = new Actions(driver);
		WebElement loginmenu = driver.findElement(By.xpath("/html//header[@id='header']/div[@class='container']//div[@class='customMenu']/div[2]/div[@class='myAccount']/a[1]"));
		action.moveToElement(loginmenu).perform();
		driver.findElement(By.id("login")).click();
		
		//Click Favorite list //Check the page
		PageObject.clickfavoritelist();
		sleep(3000);
		
		//Check the page by tittle
		String expectedtittlefavoritelist=driver.getTitle();
		String actualtitlefavoritelist = "Ýstek Listem - n11.com";
		Assert.assertEquals(actualtitlefavoritelist, expectedtittlefavoritelist);
		
		//Click favories in page
		PageObject.clickfavories();
		sleep(3000);

		//Check the page
		String expectedfavorieslink = "https://www.n11.com/hesabim/istek-listelerim";
		String actualfavorieslink= driver.getCurrentUrl();
		Assert.assertEquals(actualfavorieslink, expectedfavorieslink);
		
		//describe favoriteproduct as element
		WebElement favoriteproduct = driver.findElement(By.xpath("//div[@id='view']/ul/li/div"));
		
		//get product id favorite product
		
		String favoriteproductid = favoriteproduct.getAttribute("id");
		
		Assert.assertEquals(productid, favoriteproductid);
		
		
		Boolean result = favoriteproduct.isDisplayed();
		assertFalse(result);
		
		
		
	}
	

	@After
	public void tearDown() {
		driver.quit();

	}

	// Method for sleep
	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			e.printStackTrace();

		}
	}

}
