package com.example.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TestNG_ToDoGroup {

	public static String status = "passed";

	@Test
	public void test_Selenium4_ToDoApp_Test1() throws InterruptedException, MalformedURLException {

		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
				DesiredCapabilities.chrome());
		driver.manage().window().maximize();

	}

}