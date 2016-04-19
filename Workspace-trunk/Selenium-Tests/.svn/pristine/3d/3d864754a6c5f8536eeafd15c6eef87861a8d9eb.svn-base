package uk.co.ratedpeople.test.functional.selenium.lumberjack;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;


/**
 * 
 * @author ruhulla.mohammad
 */
public class LJPaginationTest extends TestScript {

	private LumberJack ljPagination;
	private final String POSTCODE = "SW1E 6AU";
	private final String USER = "pagination.test@ratedtrades.com";

	@BeforeClass
	public void beforeClass() {
		ljPagination = new LumberJack(context, scriptUtilities);
	
	}

	@Test(enabled = true) 
	public void lgPaginationTest() throws Exception {
		ljPagination.paginationTest(USER, POSTCODE);
			
	}
}