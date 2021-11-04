package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @author: Prakash Narkhede
 * @Youtube: https://www.youtube.com/automationtalks
 * @LinkedIn: https://www.linkedin.com/in/panarkhede89/
 */
public class TestRetryAnalyzer implements IRetryAnalyzer {

	int counter = 1;
	int retryMaxLimit = Integer.valueOf(PropertiesOperations.getPropertyValueByKey("retryCount"));

	public boolean retry(ITestResult result) {
		if (counter < retryMaxLimit) {
			counter++;
			return true;
		}
		return false;
	}

	/*
	 * @Override public boolean retry(ITestResult result) {
	 * if(counter<retryMaxLimit) { counter++; return true; } return false; }
	 */

}
