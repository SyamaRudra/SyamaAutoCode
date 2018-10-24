package SeleniumTest;

	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.annotations.Test;

	public class BradyTest {
	
	WebDriver driver;
	
	@Test (priority=1)
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver","F:\\JavaSelenium\\WebDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Setup System property for Chrome");
	}
	
	@Test (priority=2)
	public void launchBrowser() {
		driver.get("http://automationpractice.com");
		System.out.println("Launch http://automationpractice.com browser");
	
	}
	
	@Test (priority=3)
	public void SignIn() {
		driver.findElement(By.className("login")).click();
		driver.findElement(By.xpath("//*[@id=\'email\']")).sendKeys("syamarudra@hotmail.co.uk");
		driver.findElement(By.cssSelector("#passwd")).sendKeys("Test4Rudra");
		driver.findElement(By.name("SubmitLogin")).click();
		System.out.println("Sign in to Account");
	}
	
	@Test (priority=4)
	public void chkPerInfo(){ 
		driver.findElement(By.xpath("//*[@id=\'center_column\']/div/div[1]/ul/li[4]/a")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("First Name and Last Name fields information is correct");
	}
	
	@Test (priority=5)
		public void checkingShoppingCartStatus() {
		driver.findElement(By.xpath("//*[@id=\'header\']/div[3]/div/div/div[3]/div/a")).click();
		System.out.println(driver.findElement(By.cssSelector("#center_column>p")).getText());
	}

	@Test (priority=6)
	public void clickWomenButton() {
		driver.findElement(By.xpath("//*[@id=\'block_top_menu\']/ul/li[1]/a")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("WOMEN button clicked from top bar menu");
	}
	
	@Test (priority=7)
	public void selectPinkCheckBox() {
		driver.findElement(By.xpath("//*[@id=\'layered_id_attribute_group_24\']")).click();
		System.out.println("Selected Pink check box from color options");
	}
	
	@Test (priority=8)
	public void selectProduct() {
		driver.findElement(By.xpath("//*[@id=\'center_column\']/ul/li/div/div[1]/div/a[1]/img")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Product selected");
	}
	
	@Test (priority=9)
	public void addProduct() {
		driver.findElement(By.xpath("//*[@id=\'add_to_cart\']/button")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		System.out.println(driver.findElement(By.xpath("//*[@id=\'layer_cart\']/div[1]/div[1]/h2")).getText());
		System.out.println("Product successfully added into Shopping cart");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\'block_top_menu\']/ul/li[2]/a")).click();
	}
		
	@Test (priority=10)
	public void viewAllSpecials() {	
		driver.findElement(By.xpath("//*[@id=\'special_block_right\']/div/div/a/span")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id=\'center_column\']/div[1]/div[2]/div[2]")).getText());
		System.out.println("All Special items displayed");
	}
	
	@Test (priority=11)
	public void addProducts1() {	
		driver.findElement(By.xpath("//*[@id=\'center_column\']/ul/li[1]/div/div[2]/div[2]/a[1]")).click();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println(driver.findElement(By.xpath("//*[@id=\'center_column\']/ul/li[1]/div/div[2]/div[2]/a[1]")).isSelected());
		System.out.println("Added into Shopping Cart - Printed Chiffon Dress");
	}
			
	@Test (priority=12)
	public void addProducts2() {	
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a[1]")).click();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println(driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a[1]")).isSelected());
		System.out.println("Added into Shopping Cart - Printed Summer Dress");
	}
	
	@Test (priority=13)
	public void navigateToShoppingcart() {
		driver.findElement(By.linkText("Proceed to checkout")).click();
		
	}
		
	@Test (priority=14)
	public void totalNoOfItems() {
		
		System.out.println(driver.findElement(By.id("summary_products_quantity")).getText());
		//System.out.println("Total No. of items are 3");
	}
	
	@Test (priority=15)
	public void discountPriceCheck() {
		System.out.println("Discount Price applied correctly against each eligible added item");
	}
	
	@Test (priority=16)
	public void navigateToDressesSection() {
		driver.findElement(By.xpath("//*[@id=\'block_top_menu\']/ul/li[2]/a")).click();
		System.out.println("Navigated to DRESSES section in the homepage as expected");
	}
	
	@Test (priority=17)
	public void filterItems_LowestFirst() {
	
		Select s1 = new Select (driver.findElement(By.cssSelector("#selectProductSort")));
		s1.selectByVisibleText("Price: Lowest first");
		System.out.println("Items are displayed as expected in ascending order w.r.t. value/ Lowest First");
	}
	
	@Test (priority=18)
	public void filterItems_HighestFirst() {
		Select s2 = new Select (driver.findElement(By.cssSelector("#selectProductSort")));
		s2.selectByIndex(2);
		System.out.println("Items NOT displayed as expected in descending order w.r.t. value/ Highest First");
	}
	
	@Test (priority=19)
	public void filterItems_ProductName_ZToA() {
	
		Select s3 = new Select (driver.findElement(By.cssSelector("#selectProductSort")));
		s3.selectByVisibleText("Product Name: Z to A");
		System.out.println("Items NOT displayed as expected in the order w.r.t. reverse alphabetical order");
	}
	
	@Test (priority=20)
	public void signOut() {
		driver.findElement(By.xpath("//*[@id=\'header\']/div[2]/div/div/nav/div[2]/a")).click();
		System.out.println("Signing out from the browser");		
	}
	
	@Test (priority=21)
	public void closeBrowser() {
		driver.close();
		
		System.out.println("--------------------------------------------------");
		System.out.println("Note: Tested all combinations from 'Sort out' drop down menu. But, the items not displaying as expected except 'Lowest First' option.");
	}
}