package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjects {

	WebDriver driver = null;

	By btn_btnBlack = By.xpath(" //span[contains(@class, 'btn btnBlack')]");
	By pushdenied = By.xpath(
			"/html//div[@id='dengage-push-perm-slide']//div[@class='dn-slide-buttons horizontal']/button[@class='dn-slide-deny-btn']");
	By btnSignIn = By.className("btnSignIn");
	By email = By.id("email");
	By password = By.id("password");
	By loginbutton = By.id("loginButton");
	By girisyapbutton = By.xpath(
			"/html//header[@id='header']/div[@class='container']//div[@class='customMenu']/div[2]//a[@title='Giriþ Yap']");
	By searchbar = By.id("searchData");
	By favorite = By.xpath("//div[@id='view']/ul/li[3]/div//span[@title='Favorilere ekle']");
	By favoritelist = By.xpath("/html//header[@id='header']/div[@class='container']//div[@class='customMenu']/div[2]//a[@title='Favorilerim / Listelerim']");
	By favories = By.className("listItemTitle");
	By deletefavorite = By.className("deleteProFromFavorites");
	By page2 = By.xpath("/html//div[@id='contentListing']/div[@class='container']//div[@class='pagination']/a[2]");
	public PageObjects(WebDriver driver) {
		this.driver = driver;

	}

	public void clickbtn_btnBlack() throws Exception {
		driver.findElement(btn_btnBlack).click();

	}

	public void clickgirisyap() throws Exception {
		driver.findElement(girisyapbutton).click();
	}

	public void sendkeys(String mail, String pass) {
		driver.findElement(email).sendKeys(mail);
		driver.findElement(password).sendKeys(pass);
	}

	public void clickloginbutton() {

		driver.findElement(loginbutton).click();
	}

	public void clickpushdenied() {

		driver.findElement(pushdenied).click();
	}

	public void addfavorite() {

		driver.findElement(favorite).click();

	}

	public void scrollintoview(String scrollelement) {

		WebElement viewelement = driver.findElement(favorite);

	}

	public void searchbar(String text) {
		driver.findElement(searchbar).sendKeys(text);
		driver.findElement(By.xpath("/html//header[@id='header']//a[@title='ARA']/span[@class='icon iconSearch']"))
				.click();
	}
		
		public void clickfavoritelist() {

			driver.findElement(favoritelist).click();
			

		}	
		
		public void clickfavories() {

			driver.findElement(favories).click();
			
		}
			
			public void deletefavorite() {

				driver.findElement(deletefavorite).click();
				driver.findElement(By.xpath("/html/body/div[4]//span[@class='btn btnBlack confirm']")).click();
			
				

			}	
	public void clickpagetwo () {
		
		driver.findElement(page2).click();

	}

		}	



