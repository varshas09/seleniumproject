package package1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject extends BasePage {

	// @FindBy(xpath = "//*[@id='block_top_menu']/ul//*[text()='Women']")
	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[1]/a")
	private WebElement women;

	// @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/*[text()='Dresses']")
	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/a")
	private WebElement dresses;

	// @FindBy(xpath =
	// "//*[@id='block_top_menu']/ul/li[3]/*[text()='T-shirts']")
	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[3]/a")
	private WebElement tshirts;

	@FindBy(xpath = "//*[@id='categories_block_left']/h2")
	private WebElement pageheader;

	@FindBy(xpath = "//*[@class='row']//*[@id='layered_block_left']/p")
	private WebElement tshirtsheader;

	@FindBy(id = "newsletter-input")
	private WebElement newsletter;

	@FindBy(xpath="//*[@id='newsletter_block_left']/div/form/div/button")
	private WebElement submitbutton;

	@FindBy(xpath = "//*[@id='columns']//p[@class='alert alert-success']")
	private WebElement alert;

	@FindBy(xpath = "//*[@id='columns']/p[@class='alert alert-danger']")
	private WebElement dangeralert;

	@FindBys(@FindBy(xpath = "//*[@class='product_list grid row']"))
	private List<WebElement> firstproduct;
	

	public HomePageObject() {
		PageFactory.initElements(driver, this);
	}

	public WebElement getwomen()

	{
		return women;
	}

	public WebElement getdresses() {
		return dresses;
	}

	public WebElement gettshirts() {
		return tshirts;

	}

	public String getpageheader() {
		return gettext(pageheader);

	}

	public String gettshirtsheader() {
		return gettext(tshirtsheader);
	}

	public void clickwomentab() {
		women.click();

	}

	public void clickdressestab() {
		dresses.click();

	}

	public void clicktshirtstab() {
		tshirts.click();
	}

	public void newslettertab() {
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView(true)", newsletter);
		newsletter.sendKeys("svarsha@gmail.com");
	}

	public void clicknewslettertab() {
		newsletter.click();
	}

	public void submitbutton() {
		submitbutton.click();
	}

	public String getnewsalert() {
		return gettext(alert);
	}

	public String getdangeralert() {
		return gettext(dangeralert);
	}
	
	public List<WebElement> getproducts()
	{
	return firstproduct;
	}
	public boolean veerifyaddtocart(WebElement parent)
	{
		return elementfound(parent.findElement(By.xpath(".//*[text()='add to cart']")));
		
	}
	public String getproductname(WebElement parent)
	{
		return parent.findElement(By.xpath(".//[@class='product-name']")).getText();
	}
	
	
}
