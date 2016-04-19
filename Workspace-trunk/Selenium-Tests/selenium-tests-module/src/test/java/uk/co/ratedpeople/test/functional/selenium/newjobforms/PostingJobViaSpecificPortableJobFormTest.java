package uk.co.ratedpeople.test.functional.selenium.newjobforms;


	import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.newjobforms.PostingJobViaSpecificPortableJobForm;

    public class PostingJobViaSpecificPortableJobFormTest extends TestScript{
    	private PostingJobViaSpecificPortableJobForm sPJActions;
		
		@BeforeClass
		public void beforeClass() throws Exception {
			sPJActions = new PostingJobViaSpecificPortableJobForm(this.context);
		}

		@Test(enabled=false) 
		public void postJobSpecificJobFormTest() throws Exception {
			sPJActions.postingJobViaSpecificJobForm();
			
			
		}

}
