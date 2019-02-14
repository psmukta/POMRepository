package superTechPOMPages;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class SuperTechMainPage {
	WebDriver driver;
	
	public SuperTechMainPage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH,using="//*[@id=\"fullbody\"]/h3" ) WebElement Text;
	@FindBy(how=How.XPATH,using=".//*[@id='form4']/input[2]") WebElement RadioButton;
	@FindBy(how=How.XPATH,using="html/body/div[2]/form[3]/input") WebElement CheckBox;
	 @FindBy(how=How.XPATH,using=".//*[@id='form5']/select[1]") WebElement FruitsDropDown;
	@FindBy(how=How.XPATH,using=".//*[@id='form5']/select[2]") WebElement MonthsDropDown;
	@FindBy(how=How.XPATH,using=".//*[@id='form5']/select[3]") WebElement DaysDropDown;
	@FindBy(how=How.XPATH,using="//*[@id=\"fullbody\"]/button[1]") WebElement DoubleClick;
	@FindBy(how=How.LINK_TEXT,using="Social Media") WebElement Menu;
	@FindBy(how=How.PARTIAL_LINK_TEXT,using="Goo") WebElement Submenu;
	@FindBy(how=How.TAG_NAME,using="a") WebElement Link;
	
	public String getText() {
		System.out.println("Text is :" +Text.getText());
		return Text.getText();
		
	}
	public void radioButton(String sex) {
		if(sex.equalsIgnoreCase("male")) {
			//System.out.println("male");
		 	}
		else if (sex.equalsIgnoreCase("female")) {
			//System.out.println("female");
		}
		else {
			//System.out.println("none");
		}
		 RadioButton.click();
	}
	public int countCheckBox() {
		List<WebElement> CheckBox=driver.findElements(By.xpath("html/body/div[2]/form[3]/input"));
		int TotalCheckBox=CheckBox.size();
		System.out.println("Size  :"+TotalCheckBox);
		return TotalCheckBox;
	}
	public void VarifyCheckBox() {
		Boolean CheckBox1=CheckBox.isSelected();
		if(CheckBox1==true) {
			System.out.println("selected");
		}
		else {
			System.out.println("not selected");
		}
	}
	
		public void selectFruit() {
			Select FruitDropDown= new Select (FruitsDropDown);
			FruitDropDown.selectByVisibleText("Apple");
			//System.out.println("Fruits is "+FruitDropDown);
		}
		public void selectMonth() {
			Select MonthDropDown= new Select (MonthsDropDown);
			MonthDropDown.selectByVisibleText("April");
			//System.out.println("Month is"+MonthDropDown);
		}
		public void selectDay() {
			Select DayDropDown= new Select (DaysDropDown);
			DayDropDown.selectByVisibleText("Sunday");
			//System.out.println("Day is "+DayDropDown);
		}
	
	
	public void doubleClick() {
		JavascriptExecutor jse=((JavascriptExecutor)driver);
		jse.executeScript("window.scrollBy(0, -1500)");
		Actions act=new Actions(driver);
		act.doubleClick(DoubleClick).build().perform();	
	}
	public void subMenuHandle() throws InterruptedException {
		Actions act=new Actions(driver);
		act.moveToElement(Menu).build().perform();
		Thread.sleep(3000);
		Submenu.click();
	}
	public void linkCount() throws Exception {
		List<WebElement> Links=driver.findElements(By.tagName("a"));
		int Link=Links.size();
		System.out.println("Total links are :"+Link);
		for(int i=0;i<Link;i++) {
			String url=Links.get(i).getAttribute("href");
			
			System.out.println( "Links are  :"+i +"."+Links.get(i).getText()+url);
			verifyActiveLinks(url);
		}
	}
	
	public static void verifyActiveLinks(String linkurl) throws Exception {
		URL url=new URL(linkurl);
		HttpURLConnection huc=(HttpURLConnection)url.openConnection();
		huc.setConnectTimeout(3000);
		huc.connect();
		if(huc.getResponseCode()==200) {
			System.out.println(linkurl+"-"+huc.getResponseMessage());
		}
		else if(huc.getResponseCode()==404) {
			System.out.println(linkurl+"-"+huc.getResponseMessage());
		}
		else if(huc.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND) {
			System.out.println(linkurl+"-"+huc.getResponseMessage());
		}
		else {
			System.out.println("URL is not correct");
		}
		
		}
	
	
	
}
