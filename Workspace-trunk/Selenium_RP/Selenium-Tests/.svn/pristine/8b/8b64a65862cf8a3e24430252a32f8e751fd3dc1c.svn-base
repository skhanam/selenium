package uk.co.ratedpeople.test.functional.selenium.test.profiles;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

public class AddTagDeleteProfileHeroImages extends TestScriptUtilities {
	private WebDriver driver;
	private final String imageFolderPath;
	private final String heroImagePath2;
	private final String heroImagePath3;
	private static final Logger LOGGER = Logger.getLogger(AddTagDeleteProfileHeroImages.class.getName());
	private final String baseURL= "https://tradesmen.preprod/tradesman/profile-site";
	
	public AddTagDeleteProfileHeroImages(SeleniumTestContext context) {
		super(context);
		driver = context.driver;
		imageFolderPath = context.getTestImageFolderPath(); 	    	
		LOGGER.log(Level.INFO, "imageFolderPath="+imageFolderPath);
		
		heroImagePath2 = imageFolderPath + File.separator + "profile" + File.separator + "hero-photo.jpg";
		heroImagePath3 = imageFolderPath + File.separator + "profile" + File.separator + "hero-photo.jpg";
	}
	
	public void AddingDeletingProfileAndHeroImages() throws Exception {
		WebDriverWait wait = new WebDriverWait(context.driver, 50);
		goTo(baseURL); // "https://tradesmendev.uk.ratedpeople/tradesman/profile-site"//https://tpweb/tradesman/profile-site
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_username"))).sendKeys("integration.test@ratedtrades.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_password"))).sendKeys("password");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login__login"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tag_line"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tag_line"))).sendKeys("We are a family owned bathroom specialist company with over 25 years of experience, providing bespoke installations.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tag_line_button"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tag-line-confirmation"))).getText();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imageUpload"))).sendKeys(heroImagePath2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profile-image-crop-submit"))).click();
		driver.findElement(By.cssSelector("form#hero_image_form > table.wwFormTable tbody tr td > input#imageUpload")).sendKeys(heroImagePath3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hero-image-crop-submit"))).click();
	}

}