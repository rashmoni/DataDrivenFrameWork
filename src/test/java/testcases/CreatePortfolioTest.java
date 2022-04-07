package testcases;

import org.testng.annotations.Test;

import keywords.ApplicationKeywords;

public class CreatePortfolioTest {
	
	
	
	@Test
	public void createPortfolioTest(){
		
		ApplicationKeywords app = new ApplicationKeywords();
		
		app.openBrowser("chrome");
		app.navigate("url");
		app.type("username_id","rashudey9851@gmail.com");
		app.type("password_id","Read@1234");
		app.validateElementPresent("login_submit_id");
		app.click("login_submit_id");
		app.select(null, null);
		app.getText(null);
	}

}
