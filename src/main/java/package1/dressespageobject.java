package package1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class dressespageobject extends BasePage {
	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/a")
	private WebElement dresses;

	@FindBy(xpath = "//*[@id='ul_layered_id_attribute_group_1']/li[1]/label")
	private WebElement smallsize;

	@FindBy(xpath = "//*[@id='ul_layered_id_attribute_group_1']/li[2]/label")
	private WebElement mediumsize;

	@FindBy(xpath = "//*[@id='ul_layered_id_attribute_group_1']/li[3]/label")
	private WebElement largesize;

	@FindBy(xpath = "//*[@class='heading-counter']")
	private WebElement txtproductheader;

	@FindBys(@FindBy(xpath = "//*[@class='product_list grid row']"))
	private List<WebElement> firstproduct;

	@FindBys(@FindBy(xpath = "//*[@class='product-image-container']"))
	private List<WebElement> allproducts;

	@FindBy(xpath = "//*[@id='center_column']/ul/li[1]/div/div[1]/div/a[1]/img")
	private WebElement product;

	@FindBy(xpath = "//*[@id='center_column']/ul/li[1]/div/div[2]/div[2]/a[1]/span")
	private WebElement addtocart;
	
	@FindBy(xpath="//*[@class='clearfix']/div/h2/i")
	private WebElement productimage;
	
	@FindBy(xpath="//*[@id='list']//i[@class='icon-th-list']")
	private WebElement list;
	
	@FindBys(@FindBy(xpath="//*[@class='product-container']")) 
	//@FindBys(@FindBy(xpath="//*[@class='product-container']//h5/a"))
	private List<WebElement> products;
	
	@FindBy(xpath="//*[@id='layer_cart']//div[2]//span/span/i")
	private WebElement gobacktodressespage;
	
	//@FindBys(@FindBy(xpath="//*[@id='center_column']/ul/li[3]/div/div/div[3]/div/div/span[3]"))
	//private List<WebElement> discountprice;
	
	public dressespageobject() {
		PageFactory.initElements(driver, this);
	}

	public void clickdressestab() {
		dresses.click();

	}

	public WebElement getsmallsize() {
		return smallsize;
	}

	public WebElement getmediumsize() {
		return mediumsize;
	}

	public WebElement getlargesize() {
		return largesize;
	}

	public int getproductnumberfromheader() {
		String text = txtproductheader.getText();
		String[] arr = text.split(" ");
		String textnumber = arr[2];
		int number = Integer.parseInt(textnumber);
		return number;

	}

	public int getproductcount() {
		return allproducts.size();
	}
	
	public void clickproduct()
	{
		product.click();
	}

	public void clickaddtocart() {
		Actions ac = new Actions(driver);
		ac.moveToElement(product).build().perform();
		addtocart.click();
	}
	
	
	public String getproductimage()
	{
		return productimage.getText().trim();
	}
	
	public void clicklist()
	{
		list.click();
	}
	public List<WebElement> getproducts()
	{
		return products;
	}
	public boolean discountprice(WebElement parent)
	{
		return elementfound(parent.findElement(By.xpath(".//*[@class='discount']")));
	}
	public boolean oldprice(WebElement parent)
	{
		return elementfound(parent.findElement(By.xpath(".//*[@class='old-price product-price']")));
	}
	public WebElement gobacktodressespage()
	{
		return gobacktodressespage;
	}

	
}
