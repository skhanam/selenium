package uk.co.ratedpeople;


/**
 * Available resources under v1 version of the API.
 * 
 * @author zsolt
 */
public interface Resources {

	//
	// Reference data resource
	//
	/**
	 * Available operations: GET
	 * 
	 * List of trade specialisation types (skill categories)
	 */
	public Resource TRADES = new Resource("v1/trades?viewable_by=TM");
	/**
	 * Available operations: GET
	 * 
	 * List of skills for a particular trade type
	 */
	public Resource SKILLS = new Resource("v1/trades/%s/jobTypes");
	/**
	 * Available operations: GET
	 * 
	 * Certification Body Details
	 */
	public Resource CERTIFICATION_BODIES = new Resource("v1/reference/certification_bodies");
	/**
	 * Available operations: GET
	 * 
	 * List of credit card types accepted
	 */
	public Resource CREDIT_CARD_TYPES = new Resource("v1/reference/credit_card_types");
	//
	// User specific resource
	//
	/**
	 * Available operations: GET
	 * 
	 * Gets user record including id, status, and access types.
	 */
	public Resource USER = new Resource("v1/user/%s");
	/**
	 * Available operations: PUT
	 * 
	 * Record the last login timestamp for a user
	 */
	public Resource LAST_LOGIN = new Resource("v1/user/%s/last_login");
	/**
	 * Available operations: GET
	 * 
	 * Returns a Polygon of Latitude/Longitude co-ordinate points, centred on
	 * the given postcode, with a radius of the given number of miles.
	 * 
	 * <ul>
	 * <li>Parameter 1: the postcode, spaces removed</li>
	 * <li>Parameter 2: the radius in miles (e.g. 1.0, 2.2)</li>
	 * </ul>
	 */
	public Resource POSTCODE_AREA_POLYGON = new Resource("v1/loc/%s/polygon?radius_miles=%s");
	//
	// tradesmen specific resource
	//
	/**
	 * Available operations: GET
	 * 
	 * A page of available Job-leads for the Tradesman.
	 */
	public Resource AVAILABLE_JOBS = new Resource("v1/tradesmen/%s/jobs/available%s");
	/**
	 * Available operations: DELETE
	 * 
	 * An available job lead for the tradesman
	 */
	public Resource AVAILABLE_JOB = new Resource("v1/tradesmen/%s/jobs/available/%s");
	/**
	 * Available operations: GET, PUT
	 * 
	 * The details of a Tradesman's Job.
	 */
	public Resource TRADESMAN_JOB_DETAILS = new Resource("v1/tradesmen/%s/jobs/%s/");
	/**
	 * Available operations: GET
	 * 
	 * Retrieves a page of Jobs purchased by the Tradesman.
	 */
	public Resource PURCHASED_JOB_ALERTS = new Resource("v1/tradesmen/%s/jobs/purchased%s");
	/**
	 * Available operations: POST
	 * 
	 * Whether the Customer has been e-mailed by the Tradesman.
	 */
	public Resource CUSTOMER_EMAIL = new Resource("v1/tradesmen/%s/jobs/%s/customer_mail");
	/**
	 * Available operations: GET, PUT
	 * 
	 * Gets the tradesman job matching preferences
	 */
	public Resource TRADESMAN_PREFS = new Resource("v1/tradesmen/%s/prefs");
	/**
	 * Available operations: GET, PUT
	 * 
	 * The tradesman job matching area
	 */
	public Resource TRADESMAN_WORK_AREA = new Resource("v1/tradesmen/%s/prefs/area");
	/**
	 * Available operations: GET, PUT
	 * 
	 * Skills for a tradesman
	 */
	public Resource TRADESMAN_SKILLS = new Resource("v1/tradesmen/%s/prefs/skills");
	/**
	 * Available operations: GET, PUT
	 * 
	 * Working area polygon for a particular tradesman
	 */
	public Resource TRADESMAN_WORK_AREA_POLYGON = new Resource("v1/tradesmen/%s/prefs/area/polygon");
	/**
	 * Available operations: GET, PUT
	 * 
	 * Tradesman's contact preferences such as mobile number, email, and
	 * marketing opt-in
	 */
	public Resource TRADESMAN_CONTACT_PREFS = new Resource("v1/tradesmen/%s/prefs/contact");
	/**
	 * Available operations: PUT
	 * 
	 * Tradesman's business contact details including first name, last name,
	 * mobile, landline.
	 */
	public Resource TRADESMAN_COMPANY_CONTACT_DETAILS = new Resource("v1/tradesmen/%s/company/contact_details");
	/**
	 * Available operations: GET
	 * 
	 * Certificates for a tradesman
	 */
	public Resource TRADESMAN_CERTIFICATES = new Resource("v1/tradesmen/%s/certificates");
	/**
	 * Available operations: POST
	 * 
	 * PartP Certificates for a tradesman
	 */
	public Resource TRADESMAN_PART_P_CERTIFICATES = new Resource("v1/tradesmen/%s/certificates/partp");
	/**
	 * Available operations: POST
	 * 
	 * Gas Safe Certificates for a tradesman
	 */
	public Resource TRADESMAN_GAS_SAFE_CERTIFICATES = new Resource("v1/tradesmen/%s/certificates/gassafe");
	/**
	 * Available operations: POST
	 * 
	 * Purchase Orders for a tradesman
	 */
	@Deprecated
	public Resource TRADESMAN_PURCHASE_ORDERS = new Resource("v1/tradesmen/%s/jobs/%s/purchase_orders");

	/**
	 * Available operations: POST
	 * 
	 * Purchase Orders for a tradesman. This one can throw a challenge.
	 */
	public Resource TRADESMAN_PURCHASE_ORDERS_V2 = new Resource("v2/tradesmen/%s/jobs/%s/purchase_orders");
	/**
	 * Available operations: PUT
	 * 
	 * A particular Purchase Order for a tradesman
	 */
	public Resource TRADESMAN_PURCHASE_ORDER = new Resource("v1/tradesmen/%s/jobs/%s/purchase_orders/%s");
	/**
	 * Available operations: GET
	 * 
	 * A validated card that will can be used to make purchases on behalf of
	 * tradesman by default
	 */
	public Resource TRADESMAN_DEFAULT_CREDIT_CARD = new Resource("v1/tradesmen/%s/payment_methods/credit_cards/default");
	/**
	 * Available operations: GET
	 * 
	 * The tradesman current credit card and any free leads that they have
	 */
	public Resource TRADESMAN_PAYMENT_METHODS = new Resource("v1/tradesmen/%s/payment_methods%s");
	/**
	 * Available operations: GET, POST
	 * 
	 * Resource representing rating request from tradesman to home owner
	 */
	public Resource RATING_REQUEST = new Resource("v1/tradesmen/%s/jobs/%s/rating_requests");
	/**
	 * Available operations: POST
	 * 
	 * Represents comments made about a job
	 */
	public Resource FEEDBACK_COMMENTS_ABOUT_JOB = new Resource("v1/tradesmen/%s/jobs/%s/feedback/comments");
	/**
	 * Available operations: GET
	 * 
	 * Resource representing a tradesman's ability to receive job alerts via sms
	 */
	public Resource SMS_ALERTS = new Resource("v1/tradesmen/%s/sms_alerts");
	/**
	 * Available operations: POST
	 * 
	 * The purchase orders for sms alert packs
	 */
	public Resource SMS_ALERTS_PURCHASE_ORDERS = new Resource("v1/tradesmen/%s/sms_alerts/purchase_orders");
	/**
	 * Available operations PUT Resource for updating Tradesman password
	 */
	public Resource TRADESMAN_PASSWORD = new Resource("v1/tradesmen/%s/password");
	/**
	 * Available operations: GET
	 * 
	 * Resource representing a tradesman's company details
	 */
	public Resource COMPANY = new Resource("v1/tradesmen/%s/company");
	/**
	 * Available operations : GET
	 * 
	 * List of reasons that a tradesman may be making a credit request
	 * 
	 */
	public Resource CREDIT_REQUEST_REASONS = new Resource("v1/reference/credit_request_reasons");
	/**
	 * Available operations : POST
	 * 
	 * A request for a free lead from the tradesman because they were unable to
	 * quote
	 * 
	 */
	public Resource CREDIT_REQUEST = new Resource("v1/tradesmen/%s/jobs/%s/credit_request");

	/**
	 * Available operations : POST
	 * 
	 * A request for a callback from the tradesman because they were unable to
	 * quote
	 * 
	 */
	public Resource CALLBACK_REQUEST = new Resource("v1/tradesmen/%s/jobs/%s/callback_request");
	/**
	 * Available operations : PUT
	 * 
	 * A request for call update message for a tradesman
	 * 
	 */
	public Resource TERMS_CHANGED_ACCEPTED_REQUEST = new Resource("v1/tradesmen/%s/bulletin/read/%s");
	/**
	 * Available operations : GET
	 * 
	 * List of job budgets that jobs may have against them e.g. Under £100.
	 */
	public Resource JOB_BUDGETS = new Resource("v1/jobBudgets");
	/**
	 * Available operations: GET
	 * 
	 * List of addresses which exist in the given postcode.
	 */
	public Resource POSTCODE_ADDRESSES = new Resource("v1/postcode/%s/addresses");
	/**
	 * Available operations: GET
	 * 
	 * Get a list of the invoices a tradesman has.
	 */
	public Resource TRADESMAN_INVOICE_LIST = new Resource("v1/tradesmen/%s/invoice%s");
	/**
	 * Available operations: GET
	 * 
	 * get a pdf of the invoice a tradesman has.
	 */
	public Resource TRADESMAN_INVOICE_PDF = new Resource("v1/tradesmen/%s/invoice/%s/pdf");
	/**
	 * Available operations: GET
	 * 
	 * Get account information of a tradesman
	 */
	public Resource TRADESMAN_ACCOUNT_SUMMARY = new Resource("v1/tradesmen/%s/account/summary");
	/**
	 * Available operations: GET
	 * 
	 * Get debt information of a tradesman
	 */
	public Resource TRADESMAN_ACCOUNT_DEBT = new Resource("v1/tradesmen/%s/account/debt");
	/**
	 * Available operations: POST
	 * 
	 * Settle debt
	 */
	public Resource TRADESMAN_ACCOUNT_DEBT_SETTLEMENT_ORDER = new Resource("v1/tradesmen/%s/account/debt/settlement_orders");
	/**
	 * Available operations: PUT
	 * 
	 * Update settlement orders.
	 */
	public Resource TRADESMAN_ACCOUNT_DEBT_SETTLEMENT_ORDER_UPDATE = new Resource("v1/tradesmen/%s/account/debt/settlement_orders/%s");
	/**
	 * Available operations: DELETE
	 * 
	 * Deletes a given certificate of the tradesman
	 */
	public Resource TRADESMAN_DELETE_CERTIFICATE = new Resource("v1/tradesmen/%s/certificates/%s");

	/**
	 * Resource for retrieving and updating tag line for tradesman profile
	 * Available operations : PUT, GET
	 */
	public Resource TRADESMAN_PROFILE_TAGLINE = new Resource("v1/tradesmen/%s/profile/tagline");

	/**
	 * Profile Image Resource Available operations : PUT, GET, DELETE
	 */
	public Resource TRADESMAN_PROFILE_IMAGE = new Resource("v1/tradesmen/%s/profile/profile_image");

	/**
	 * Profile Hero Image Resource Available operations : PUT, GET, DELETE
	 */
	public Resource TRADESMAN_HERO_IMAGE = new Resource("v1/tradesmen/%s/profile/hero_image");

	/**
	 * Profile Resource Available operations : GET
	 */
	public Resource TRADESMAN_PROFILE = new Resource("v1/tradesmen/%s/profile");

	/**
	 * Resource for adding Gallery Images Available operations : POST
	 */
	public Resource TRADESMAN_GALLERY_IMAGES = new Resource("v1/tradesmen/%s/gallery_images");

	/**
	 * Resource for getting all the images of a tradesman Available operations :
	 * GET
	 */
	public Resource TRADESMAN_IMAGES = new Resource("v1/tradesmen/%s/images%s");

	/**
	 * Resource for updating image description of a tradesman Available
	 * operations : PUT
	 */
	public Resource TRADESMAN_IMAGE_DESCRIPTION = new Resource("v1/tradesmen/%s/images/%s/description");

	/**
	 * Resource for performing actions on specific tradesman image Available
	 * operations: DELETE parameters: tradesmanUserId, and imageId
	 */
	public Resource TRADESMAN_IMAGE = new Resource("v1/tradesmen/%s/images/%s");

	/**
	 * Resource for obtaining unanswered questions.
	 */
	public Resource DIY_QUESTIONS_TM_UNANSWERED = new Resource("v1/tradesmen/%s/diy/questions/unanswered%s");

	/**
	 * Resource for obtaining unanswered questions.
	 */
	public Resource DIY_QUESTIONS_TM_ANSWERED = new Resource("v1/tradesmen/%s/diy/questions/answered%s");

	/**
	 * All (enabled) DIY-Advice Question Categories.
	 */
	public Resource DIY_QUESTION_CATEGORIES_ALL = new Resource("v1/diy/category");

	/**
	 * Resource for obtaining a single question
	 */
	public Resource DIY_QUESTION = new Resource("v1/tradesmen/%s/diy/questions/view/%s");

	/**
	 * Resource for posting a reply to a DIY Question
	 */
	public Resource DIY_QUESTION_RESPONSE = new Resource("v1/tradesmen/%s/diy/questions/%s/responses");

	/**
	 * Minimal Tradesman DIY Preferences, checked per-HTTP Request
	 */
	public Resource DIY_PREFS_MINIMAL = new Resource("v1/tradesmen/%s/prefs/diy/minimal");

	/**
	 * Tradesman's configured DIY-Advice Categories
	 */
	public Resource DIY_PREFS_TM_CATEGORIES = new Resource("v1/tradesmen/%s/prefs/diy/categories");

	/**
	 * Count of Unanswered Questions
	 */
	public Resource DIY_QUESTIONS_TM_UNANSWERED_COUNT = new Resource("v1/tradesmen/%s/diy/questions/unanswered/count%s");

	/**
	 * Count of Answered Questions
	 */
	public Resource DIY_QUESTIONS_TM_ANSWERED_COUNT = new Resource("v1/tradesmen/%s/diy/questions/answered/count%s");

	/**
	 * Available operations: GET
	 * 
	 * Get bulletin for a tradesman
	 */
	public Resource TRADESMAN_BULLETIN = new Resource("v1/tradesmen/%s/bulletin");

	/**
	 * Available operations: GET
	 * 
	 * Get messages for a tradesman
	 */
	public Resource TRADESMAN_JOB_CHALLENGES = new Resource("v1/tradesmen/%s/job/%s/challenges");

	class Resource {

		private final String uri;

		public Resource(final String uri) {
			this.uri = uri;
		}

		public String getUri() {
			return this.uri;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((this.uri == null) ? 0 : this.uri.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			Resource other = (Resource) obj;
			if (this.uri == null) {
				if (other.uri != null) {
					return false;
				}
			} else if (!this.uri.equals(other.uri)) {
				return false;
			}
			return true;
		}
	}

}
