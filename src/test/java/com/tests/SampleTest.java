package com.tests;


import org.testng.annotations.Test;

import testBase.BaseTest;
import testBase.DriverFactory;

public class SampleTest extends BaseTest {

	public SampleTest() {
		// TODO Auto-generated constructor stub
	}
	@Test
	public void openLinkInNewTab() {
		DriverFactory.getInstance().getDriver().get("http://www.google.com");
		String title=DriverFactory.getInstance().getDriver().getTitle();
		System.out.println("title:"+title);
		//test comment
		
	}

}
