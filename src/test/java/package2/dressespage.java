package package2;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import package1.BasePage;
import package1.HomePageObject;
import package1.dressespageobject;

public class dressespage {

	dressespageobject dressespage;
	BasePage bp;

	HomePageObject homepage;
	WebDriver driver;

	public dressespage() {
		dressespage = new dressespageobject();
		bp = new dressespageobject();
		homepage = new HomePageObject();
	}

	@BeforeTest
	public void launchBrowser() {
		System.out.println("launching firefox browser");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
	}

	@BeforeMethod
	public void verifydressescheckbox() {
		dressespage.clickdressestab();
		// Assert.assertTrue(dressespage.getpageheader().equals("DRESSES"));
		Assert.assertTrue(dressespage.getsmallsize().isDisplayed());
		Assert.assertTrue(dressespage.getmediumsize().isDisplayed());
		Assert.assertTrue(dressespage.getlargesize().isDisplayed());
	}

	@Test(priority = 0)
	public void verifyproductcount() {
		dressespage.clickdressestab();
		// int actual = dressespage.getproductnumberfromheader();
		// int expected = dressespage.getproductcount
		Assert.assertTrue(dressespage.getproductnumberfromheader() == dressespage.getproductcount(),
				"failed:count mismatched");
	}

	@Test(priority = 2)
	public void verifyproductaddedtab() {
		dressespage.clickdressestab();
		dressespage.clickaddtocart();
		Assert.assertTrue(dressespage.getproductimage().equals("Product successfully added to your shopping cart"));
	}

	@Test(priority = 1)
	public void verifydiscountprice() {
		dressespage.clickdressestab();
		dressespage.clicklist();
		List<WebElement> product = dressespage.getproducts();
		for (WebElement pdts : product) {
			if (dressespage.discountprice(pdts) == true) {
				Assert.assertTrue(dressespage.oldprice(pdts), "old price exists");

			}
		}
	}

/*	@AfterMethod
	public void gobacktodressespage() {
		dressespage.gobacktodressespage().click();
		Assert.assertTrue(homepage.getpageheader().equals("WOMEN"));
	}   

	@AfterTest
	public void terminatebrowser() {
		driver.quit();
	}   */

}
