package in.vtech.saucelab.utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import in.vtech.saucelab.base.Base;

public class ScreenshotUtility extends Base {

	public static void takeScreenshotAtEndOfTest() throws IOException {
		// convert WebDriver instance to TakesScreenshot instance
		TakesScreenshot screenshot = (TakesScreenshot) driver;

		// call getScreenshotsAs method to create image file
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);

		String projectPath = System.getProperty("user.dir");

		// Store the file path in string variable
		String filePath = projectPath + "/screenshots/"

				+ LocalDate.now() + "-" + System.currentTimeMillis() + ".png";

		// move image file to new destination
		// copy file at destination
		File destinationFile = new File(filePath);
		FileUtils.copyFile(sourceFile, destinationFile);
		logger.error("SCREENSHOT_SAVED_AT: " + filePath);
	}
}
