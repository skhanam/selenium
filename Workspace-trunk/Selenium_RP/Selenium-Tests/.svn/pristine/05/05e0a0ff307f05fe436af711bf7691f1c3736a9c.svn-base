package uk.co.ratedpeople.test.functional.selenium.test.profiles;

import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.test.profiles.AddingAndRemovingTagLinesProfileAndHeroImages;

public class AddingAndDeletingProfileImagesTest extends TestScript{

	private AddingAndRemovingTagLinesProfileAndHeroImages profileSite; 
	
	@BeforeClass
	public void beforeClass() throws IOException {
		profileSite = new AddingAndRemovingTagLinesProfileAndHeroImages(this.context);
	}

	@Test(enabled=true) 
	public void addingAndDeletingProfileImagesTest()throws Exception {
		profileSite.AddingAndDeletingProfileImage();
		
}
}