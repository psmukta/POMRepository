package superTechPOMTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import superTechPOMPages.SuperTechMainPage;

public class STMainTest extends STTestBase {
	
		@Test(priority=0)
	public void GetTextTest() throws Exception {
		SuperTechMainPage STMP=PageFactory.initElements(driver, SuperTechMainPage.class);
		String Text1=STMP.getText();
		}
		@Test(priority=1)
		public void RadioButtontest() {
			SuperTechMainPage STMP=PageFactory.initElements(driver, SuperTechMainPage.class);
		STMP.radioButton("female");
		}
		@Test(priority=2)
		public void CheckBoxTest() {
		SuperTechMainPage STMP=PageFactory.initElements(driver, SuperTechMainPage.class);
		STMP.countCheckBox();
		STMP.VarifyCheckBox();
		}
		@Test(priority=3)
		public void DropDpwnTest() {
		SuperTechMainPage STMP=PageFactory.initElements(driver, SuperTechMainPage.class);
		STMP.selectDay();
		STMP.selectFruit();
		STMP.selectMonth();
		}
		@Test(priority=4)
		public void DoubleClickTest() {
		SuperTechMainPage STMP=PageFactory.initElements(driver, SuperTechMainPage.class);
		STMP.doubleClick();
		}
		@Test(priority=5)
		public void SubMenutest() throws InterruptedException {
		SuperTechMainPage STMP=PageFactory.initElements(driver, SuperTechMainPage.class);
		STMP.subMenuHandle();
		}
		@Test(priority=6)
		public void LinkTest() throws Exception {
		SuperTechMainPage STMP=PageFactory.initElements(driver, SuperTechMainPage.class);
		STMP.linkCount();
		}
	}
	
	


