
package in.vtech.saucelab.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import in.vtech.saucelab.base.Base;
import in.vtech.saucelab.utility.ScreenshotUtility;

public class TestNGListener extends Base implements ITestListener {

	@Override
	public void onTestStart(ITestResult itr) {
		String testName = itr.getName();
		logger.info("TEST_START: " + testName);
	}

	@Override
	public void onStart(ITestContext testContext) {
		String suiteName = testContext.getName();
		logger.info("SUITE_START: " + suiteName);
	}

	@Override
	public void onFinish(ITestContext testContext) {
		String suiteName = testContext.getName();
		logger.info("SUITE_FINISH: " + suiteName);
	}

	@Override
	public void onTestSuccess(ITestResult itr) {
		String testName = itr.getName();
		logger.info("TEST_SUCCESS: " + testName);
	}

	@Override
	public void onTestFailure(ITestResult itr) {
		
		try {
			ScreenshotUtility.takeScreenshotAtEndOfTest();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		String testName = itr.getName();
		logger.error("TEST_FAILURE: " + testName);
	}

	@Override
	public void onTestSkipped(ITestResult itr) {
		String testName = itr.getName();
		logger.warn("TEST_SKIP: " + testName);
	}
}