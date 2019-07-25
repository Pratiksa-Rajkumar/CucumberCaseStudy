package skeleton;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs {
	static WebDriver driver;
	@Given("User process to registration page")
	public void user_process_to_registration_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selium 3.0\\Selium 3.0\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		driver.findElement(By.partialLinkText("SignUp")).click();
	}

	@When("user enters username {string}")
	public void user_enters_username(String un) {
	    driver.findElement(By.name("userName")).sendKeys(un);
	}

	@When("user enters firstname {string} And lastname {string}")
	public void user_enters_firstname_And_lastname(String fn, String ln) {
	   driver.findElement(By.name("firstName")).sendKeys(fn);
	   driver.findElement(By.name("lastName")).sendKeys(ln);
	}

	@When("enters password {string} And confirmpassword {string}")
	public void enters_password_And_confirmpassword(String pwd, String cpwd) {
		 driver.findElement(By.name("password")).sendKeys(pwd);
		   driver.findElement(By.name("confirmPassword")).sendKeys(cpwd);
	}

	@When("choose gender {string}")
	public void choose_gender(String string) {
	   driver.findElement(By.xpath("//input[@value='Female']")).click();
	}

	@When("enter the username {string}")
	public void enter_the_username(String mail) {
		driver.findElement(By.name("emailAddress")).sendKeys(mail);
	}

	@When("mobile number {string} And DOB {string}")
	public void mobile_number_And_DOB(String num, String db) {
		driver.findElement(By.name("mobileNumber")).sendKeys(num);
		   driver.findElement(By.name("dob")).sendKeys(db);
	}

	@When("address {string}")
	public void address(String add) {
		driver.findElement(By.name("address")).sendKeys(add);
	}

	@When("security question {string}")
	public void security_question(String sq) {
		driver.findElement(By.name("securityQuestion")).sendKeys(sq);
	}

	@When("answer {string}")
	public void answer(String ans) {
		driver.findElement(By.name("answer")).sendKeys(ans);
	}

	@Then("clicks register button")
	public void clicks_register_button() {
		driver.findElement(By.name("Submit")).click();
	}

	
	
	/*public void loginpage() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selium 3.0\\Selium 3.0\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		driver.findElement(By.partialLinkText("SignIn")).click();
	}*/
	
	@Given("Enter registered username{string}")
	public void enter_registered_username(String uname) {
		driver.findElement(By.name("userName")).sendKeys(uname);
	}
	@And("Enter registered password {string}")
	public void password1(String pass) {
		
		driver.findElement(By.id("password")).sendKeys(pass);
		
	}
	@Then("clicks login button")
	public void loginbtn() {
		driver.findElement(By.name("Login")).click();
	}
	
	@And("Search the product {string}")
	public void search_the_product(String pro) throws InterruptedException {
		WebElement search=driver.findElement(By.name("products"));
		Actions a=new Actions(driver);
		a.sendKeys(search,pro).build().perform();
		//Thread.sleep(2000);
		a.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		//Thread.sleep(3000);
		
	}
	@And("proceed to payment without adding items in the cart")
	public void proceed_to_payment_without_adding_items_in_the_cart() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
		driver.findElement(By.partialLinkText("Cart")).click();
		driver.findElement(By.xpath("//*[@id=\"cart\"]/tbody/tr/td[5]/form/input[2]")).click();

	}

}
