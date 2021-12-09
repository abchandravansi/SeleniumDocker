package com.makemytrip.TestCases;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.makemytrip.Base.BasePage;
import com.makemytrip.pages.MakeTripHomePage;
import com.makemytrip.util.RetryAnalyzer;
import com.makemytrip.util.RetryTestListener;


@Listeners(RetryTestListener.class)
public class MakeTripHomePageTest extends BasePage {

	MakeTripHomePage makeTriphomepage = new MakeTripHomePage();


	@BeforeTest
	public void setup() throws MalformedURLException {
		BasePage.setDriver("firefox");
	}
	
	@Test
	public void launch_home_page() {
		makeTriphomepage.launch_home_page();
	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void CheckingPageTitle() {
		Assert.assertEquals(makeTriphomepage.getPageTitle(), prop.getProperty("titleofpage"));

	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void CheckMakeMyTripLogoIsVisible() {

		Assert.assertEquals(makeTriphomepage.makemytrip_logo_visible(), true);
	}

	@Test(retryAnalyzer = RetryAnalyzer.class,dependsOnMethods = "launch_home_page")
	public void CheckMyBizLogo() {
		Assert.assertEquals(makeTriphomepage.myBiz_logo(), true);
	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void IntroductionMyBizText() {
		Assert.assertEquals(makeTriphomepage.introductionmybiz(), true);
	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void MakeMyTripForBusiness() {
		Assert.assertEquals(makeTriphomepage.makemytripforbusiness(), true);
	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void MyTripText() {
		Assert.assertEquals(makeTriphomepage.my_trips_text(), true);

	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void SuitcaseIcon() {
		Assert.assertEquals(makeTriphomepage.suitcase_icon(), true);
	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void Manage_Your_Booking() {
		Assert.assertEquals(makeTriphomepage.manage_your_bookings(), true);
	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void MyIconOnLoginButton() {
		Assert.assertEquals(makeTriphomepage.my_icon_on_login_button(), true);
	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void Login_Signup_Best_Practices_Text() {
		Assert.assertEquals(makeTriphomepage.login_Signup_best_practices_text(), prop.getProperty("login_signup"));
	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void Login_Signup_Easily_With_Text() {
		Assert.assertEquals(makeTriphomepage.login_Signup_easily_with_text(), prop.getProperty("login_signup_easily"));
	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void Google_Option_Text() {
		Assert.assertEquals(makeTriphomepage.Google_Option_text(), prop.getProperty("Google_text"));
	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void Login_with_phone_email() {
		Assert.assertEquals(makeTriphomepage.Login_with_phone_email(), prop.getProperty("login_with_phone_email"));
	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void CountryLanguageCurrency() {
		Assert.assertEquals(makeTriphomepage.CountryLanguageCurrency(), true);
	}


	@AfterTest
	public void teardown() {
		BasePage.closeBrowser();
	}
}
