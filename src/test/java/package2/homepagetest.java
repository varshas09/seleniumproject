package package2;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import package1.BasePage;
import package1.HomePageObject;

public class homepagetest {
	HomePageObject homepage;
	BasePage bp;

	public homepagetest() {
		homepage = new HomePageObject();
		bp = new HomePageObject();

	}

	@Test
	public void verifytab1() {
		Assert.assertTrue(homepage.getwomen().isDisplayed());
		Assert.assertTrue(homepage.getdresses().isDisplayed());
		Assert.assertTrue(homepage.gettshirts().isDisplayed());
	}

	@Test
	public void verifytab2() {
		homepage.clickwomentab();
		Assert.assertTrue(homepage.getpageheader().equals("WOMEN"));
		homepage.clickdressestab();
		Assert.assertTrue(homepage.getpageheader().equals("DRESSES"));
		homepage.clicktshirtstab();
		Assert.assertTrue(homepage.gettshirtsheader().equals("CATALOG"));
	}

	@Test
	public void verifynewslettertab() {
		homepage.clicknewslettertab();
		homepage.newslettertab();
		homepage.submitbutton();
		Assert.assertTrue(
				homepage.getnewsalert().equals("Newsletter : You have successfully subscribed to this newsletter."));

	}

	@Test
	public void verifyaddtocartforproduct() {
		List<WebElement> products = homepage.getproducts();
		for (WebElement pdt : products) {
			Assert.assertTrue(homepage.veerifyaddtocart(pdt),
					"failed:add to cart button not present" + homepage.getproductname(pdt));

		}

	}

}
