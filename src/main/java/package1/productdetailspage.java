package package1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productdetailspage extends BasePage {

	@FindBy(xpath = "//*[@class='primary_block row']//i[@class='icon-twitter']")
    private WebElement tweet;

	@FindBy(xpath = "//*[@class='primary_block row']//i[@class='icon-facebook']")
    private WebElement share;

	// @FindBy(xpath = "//*[@class='primary_block
	// row']//*[@id='short_description_block']//p")
	@FindBy(xpath = "//*[@id='short_description_content']/p")
	private WebElement productdescription;

	public productdetailspage() {
		PageFactory.initElements(driver, this);
	}

	public WebElement gettweet() {
		return tweet;

	}

	public WebElement getshare() {
		return share;
	}

	public String getproductdescription() {
		return productdescription.getText().trim();
	}

}
