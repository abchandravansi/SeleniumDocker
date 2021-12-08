package com.makemytrip.pages;

import org.openqa.selenium.By;

import com.makemytrip.Base.BasePage;

public class MakeTripHomePage extends BasePage {

	By makemytrip_logo = By.xpath("//img[@src='//imgak.mmtcdn.com/pwa_v3/pwa_hotel_assets/header/mmtLogoWhite.png']");

	By myBiz_logo = By.xpath("//span[@class='appendRight10 landingSprite myBizIcon']");
	By introductionmybiz = By.xpath("//p[@class='whiteText']");
	By makemytripforbusiness = By.xpath("//p[@class='font10 whiteText']");

	By suitcase_icon = By.xpath("//span[@class='landingSprite myTripsIcon appendRight10']");
	By my_trips_text = By.xpath("//p[@class='whiteText appendBottom3 font11']");
	By manage_your_bookings = By.xpath("//p[@class='userPerText']");

	By my_icon_on_login_button = By
			.xpath("//span[@class='userNameIcon whiteText makeFlex perfectCenter latoBlack appendRight10']");

	By login_Signup_best_practices = By
			.xpath("//p[@class='login__earn font18 latoBlack appendBottom20 defaultCursor textCenter']");
	By login_Signup_easily_with = By
			.xpath("//p[@class='font12 lightGreyText textCenter latoBold appendBottom15 defaultCursor']");
	By Google_Option = By.xpath("//span[@class='font14 darkGreyText latoBold']");
	By Login_with_phone_email = By
			.xpath("//p[@class='font14 latoBold blackText appendBottom5 cursorPointer makeRelative']");

	By login_create_accont_text = By.xpath("//p[contains(text(),'Login or Create Account')]");

	By CountryLanguageCurrency = By
			.xpath("//li[@class='makeFlex column makeRelative vrtlCenter conCurLang geoSwitcher']");

	
	public void launch_home_page() {
		getDriver().get(prop.getProperty("homepage_url"));
		getDriver().manage().window().maximize();
	}
	
	
	public boolean makemytrip_logo_visible() {
		return getDriver().findElement(makemytrip_logo).isDisplayed();
	}

	public boolean myBiz_logo() {
		return getDriver().findElement(myBiz_logo).isDisplayed();
	}

	public boolean introductionmybiz() {
		return getDriver().findElement(introductionmybiz).isDisplayed();
	}

	public boolean makemytripforbusiness() {
		return getDriver().findElement(makemytripforbusiness).isDisplayed();
	}

	public boolean suitcase_icon() {
		return getDriver().findElement(suitcase_icon).isDisplayed();
	}

	public boolean my_trips_text() {
		return getDriver().findElement(my_trips_text).isDisplayed();
	}

	public boolean manage_your_bookings() {
		return getDriver().findElement(manage_your_bookings).isDisplayed();
	}

	public boolean my_icon_on_login_button() {
		return getDriver().findElement(my_icon_on_login_button).isDisplayed();
	}

	public boolean login_create_accont_text() {
		return getDriver().findElement(login_create_accont_text).isDisplayed();
	}

	public String login_Signup_best_practices_text() {
		return getDriver().findElement(login_Signup_best_practices).getText();
	}

	public String login_Signup_easily_with_text() {
		return getDriver().findElement(login_Signup_easily_with).getText();
	}

	public String Google_Option_text() {
		return getDriver().findElement(Google_Option).getText();
	}

	public String Login_with_phone_email() {
		return getDriver().findElement(Login_with_phone_email).getText();
	}

	public boolean CountryLanguageCurrency() {
		return getDriver().findElement(CountryLanguageCurrency).isDisplayed();
	}

	public void click_the_logo_check_reload() {
		getDriver().findElement(makemytrip_logo).click();
	}

	public String getPageTitle() {
		getDriver().get("https://www.makemytrip.com/");
		getDriver().manage().window().maximize();
		return getDriver().getTitle();
	}

}
