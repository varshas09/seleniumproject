package package2;

import org.testng.Assert;
import org.testng.annotations.Test;

import package1.BasePage;
import package1.HomePageObject;
import package1.dressespageobject;
import package1.productdetailspage;

public class productdetailspagetest {

	productdetailspage productdetails;
	BasePage bp;
	 //HomePageObject homepage;
	 dressespageobject dressespage;
	 
	public productdetailspagetest() {
		productdetails = new productdetailspage();
		bp = new HomePageObject();
		//homepage = new HomePageObject();
        dressespage=  new dressespageobject();
	}

	@Test
	public void verifyproductdetails() {
		//homepage.clickdressestab();
		dressespage.clickproduct();
		String description = productdetails.getproductdescription();
		Assert.assertTrue(description.length()<250);	
	}
	@Test
	public void verifysocialsite()
	{
		
		
		Assert.assertTrue(productdetails.elementfound(productdetails.gettweet()));
		Assert.assertTrue(productdetails.elementfound(productdetails.getshare()));
		//Assert.assertTrue(productdetails.gettweet().isDisplayed());
		//Assert.assertTrue(productdetails.getshare().isDisplayed());
	}
	

}
