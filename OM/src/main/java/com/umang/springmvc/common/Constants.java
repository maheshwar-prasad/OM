package com.umang.springmvc.common;

public final class Constants {

	private Constants() {
		// hide me
	}

	public static final int FILESUBSTRLENGTH = 7;

	public static final String DATE_FORMAT = "dd-MM-yyyy";
	public static final String DATE_FORMAT_1 = "dd/MM/yyyy";
	public static final String DATE_FORMAT_2 = "dd MMMM yyyy";
	public static final String DATE_FORMAT_3 = "yyyy-MM-dd";

	public static final String ENVIRONMENT_TYPE_DEV = "DEV";
	public static final String ENVIRONMENT_TYPE_QA = "QA";
	public static final String ENVIRONMENT_TYPE_UAT = "UAT";
	public static final String ENVIRONMENT_TYPE_LIVE = "LIVE";

	public static final String PUB_TYPE_JOURNAL = "JOURNAL";
	public static final String PUB_TYPE_PROCEEDING = "PROCEEDING";

	public static final String STO = "STO";

	public static final String STATIC_CONTENT_FOLDER = "static";
	public static final String PAGE_CONTENT_FOLDER = "page";
	public static final String SECURE_CONTENT_FOLDER = "protected";
	public static final String SUPPLEMENTARY_FOLDER = "supp";
	public static final String JOURNALS_FOLDER = "journals";

	public static final String RATING_TYPE_NEWS = "News";

	public static final Integer CREATED_BY_APP = 1;

	public static final String REFERER = "_referer";

	public static final int CITATION_BUFFER_SIZE = 1;
	public static final String CITATION_FORMAT = "format";
	public static final String NEW_LINE = "\n";

	public static final String BUNDLE_KEY = "ApplicationResources";

	public static final String FILE_SEP = System.getProperty("file.separator");

	public static final String CONFIG = "appConfig";

	public static final String REGISTERED = "registered";

	//Common roles
	public static final String ADMIN_ROLE = "ROLE_ADMIN";
	public static final String USER_ROLE = "ROLE_USER";
	public static final String READER_ROLE = "ROLE_READER";
	public static final String CS_ROLE = "ROLE_CS";
	public static final String IA_ROLE = "ROLE_ISA";
	public static final String IR_ROLE = "ROLE_ISR";
	public static final String ROLE_INSR = "ROLE_INSR";
	/**
	 * The name of the available roles list, a request-scoped attribute when
	 * adding/editing a user.
	 */
	public static final String AVAILABLE_ROLES = "availableRoles";
	public static final String AVAILABLE_RULES = "availableRules";

	/* Librarian page  Constant */
	public static final String MARC_RECORD_SPECIALITY = "MARCRecordsbySpeciality";
	public static final String MARC_RECORD_JOURNAL = "MARCRecordByJournal";
	public static final String MARC_RECORD_ISBN = "MARCRecordByISBN";

	public static final String CONTENT_TYPE_CSV = "application/csv";

	/*Constant for SQL queries*/
	public static final String SELECT = "select ";
	public static final String FROM = " from ";
	public static final String WHERE = " where ";
	public static final String OR = " OR ";
	public static final String AND = " AND ";

	public static final String DEFAULT_LOCALE = "en_US";

	public static final String TEMPLATEPATH = "TemplatePath";
	public static final int ADDRESS_LENGTH = 150;
	public static final int ADDRESS_LOCALE = 100;

	public static final int ADDRESS_CITY_LENGTH = 50;
	public static final int ADDRESS_POSTAL_CODE = 15;
	public static final int ADDRESS_COUNTRY = 100;

	public static final int IP_MASK_255 = 255;
	public static final int IP_MASK_256 = 256;
	public static final int LOOP_INT_1_1 = -1;

	public static final int LOOP_INT_0 = 0;
	public static final int LOOP_INT_1 = 1;
	public static final int LOOP_INT_2 = 2;
	public static final int LOOP_INT_3 = 3;
	public static final int LOOP_INT_4 = 4;
	public static final int LOOP_INT_5 = 5;
	public static final int LOOP_INT_6 = 6;
	public static final int LOOP_INT_7 = 7;
	public static final int LOOP_INT_8 = 8;
	public static final int LOOP_INT_9 = 9;
	public static final int LOOP_INT_10 = 10;
	public static final int LOOP_INT_11 = 11;
	public static final int LOOP_INT_12 = 12;
	public static final int LOOP_INT_13 = 13;
	public static final int LOOP_INT_14 = 14;
	public static final int LOOP_INT_15 = 15;
	public static final int LOOP_INT_16 = 16;
	public static final int LOOP_INT_17 = 17;
	public static final int LOOP_INT_18 = 18;
	public static final int LOOP_INT_19 = 19;
	public static final int LOOP_INT_20 = 20;
	public static final int LOOP_INT_21 = 21;
	public static final int LOOP_INT_22 = 22;
	public static final int LOOP_INT_23 = 23;
	public static final int LOOP_INT_24 = 24;
	public static final int LOOP_INT_25 = 25;
	public static final int LOOP_INT_26 = 26;
	public static final int LOOP_INT_27 = 27;
	public static final int LOOP_INT_28 = 28;
	public static final int LOOP_INT_29 = 29;

	//Constants used for Solr search
	public static final String DEFAULT_CHARSET = "UTF-8";
	public static final String SOLAR_QUERY_CONSTANT = "q";
	public static final String SOLR_FILTER_QUERY_CONSTANT = "fq";
	public static final String JASON_RETURN_CONSTANT = "wt";
	public static final String ROW_START_CONSTANT = "start";
	public static final String ROW_RETURN_CONSTANT = "rows";
	public static final String SOLR_HL_CONSTANT = "hl";
	public static final String SOLR_HL_CONSTANT_VALUE_TRUE = "true";
	public static final String SOLR_HL_CONSTANT_FL = "hl.fl";
	public static final String SOLR_HL_CONSTANT_FL_VALUE = "content,text";
	public static final String SOLR_HL_CONSTANT_FRAG = "hl.fragsize";
	//	public static final String SOLR_HL_CONSTANT_REQUIRED = "hl.requireFieldMatch";
	public static final String SOLR_HL_CONSTANT_FRAG_VALUE_500 = "500";
	public static final String SOLR_HL_CONSTANT_SNIP = "hl.snippets";
	public static final String SOLR_HL_CONSTANT_SNIP_VALUE_5 = "5";
	public static final String SOLR_HL_CONSTANT_PRE = "hl.simple.pre";
	public static final String SOLR_HL_CONSTANT_PRE_VALUE = "<strong style='background-color:#FFFF00'>";
	public static final String SOLR_HL_CONSTANT_POST = "hl.simple.post";
	public static final String SOLR_HL_CONSTANT_POST_VALUE = "</strong>";
	public static final String SOLR_QF_CONSTANT = "qf";
	public static final String SOLR_QF_CONSTANT_VALUE = "title^100  description^80 content^60 author";
	public static final String SOLR_PF_CONSTANT = "pf";
	public static final String SOLR_PF_CONSTANT_VALUE = "title^100  description^80 content^60 author";
	/*public static final String SOLR_DEFTYPE_CONSTANT = "defType";
	public static final String SOLR_EDISMAX_CONSTANT_VALUE = "edismax";*/
	public static final String SOLR_FACET = "facet";
	public static final String SOLR_FACET_ACTIVE = "on";
	public static final String SOLR_FACET_FIELD = "facet.field";
	public static final String SOLR_FACET_MIN_COUNT = "facet.mincount";
	public static final String SOLR_FACET_MIN_VALUE = "1";
	/*public static final String SOLR_FACET_JTITLE = "mainTitleFacet";*/
	public static final String SOLR_FACET_SUBJECT = "subjectFacet";
	public static final String SOLR_FACET_KEYWORD = "keywordsFacet";
	public static final String SOLR_FACET_AUTHOR = "authorFacet";
	public static final String SOLR_FACET_TITLE = "mainTitleFacet";
	public static final String SOLR_FACET_SUBJECT_CATEGORY = "subjectCategoryFacet";
	public static final String SOLR_FACET_DOCUMENT_TYPE = "documentTypeFacet";
	public static final String SOLR_FACET_PUB_YEAR = "pubYearFacet";
	public static final String SOLR_FACET_BOOK_TYPE = "typeFacet";
	public static final String SOLR_SORT = "sort";
	public static final String SOLR_SORT_RELEVENCE = "Relevance";
	public static final String SOLR_FILTER_QUERY_PUBYEAR = "pubYear";
	public static final String SOLR_FILTER_QUERY_KEYWORD = "keywords";
	public static final String SOLR_FILTER_QUERY_SUBJECTCATEGORY = "subjectCategory";
	public static final String SOLR_FILTER_QUERY_BOOK_TYPE = "type";
	public static final String SOLR_FILTER_QUERY_DOCUMENT_TYPE = "documentType";
	public static final String SOLR_FILTER_QUERY_SUBJECT = "subject";
	public static final String SOLR_FILTER_QUERY_AUTHOR = "author";
	public static final String SOLR_SORT_DEFAULT = "pub_date desc";
	public static final String SOLR_DOCUMENT_STATUS = "documentStatus";
	public static final String SOLR_CIPLASPECIALITY_GROUP = "ciplaGroup";
	public static final String SOLR_DOCUMENT_CODE = "documentCode";
	public static final String SOLR_DOCUMENT_FIRSTPAGE = "firstPage";
	public static final String SOLR_DOCUMENT_LASTPAGE = "lastPage";
	public static final String SOLR_DOCUMENT_PUBLISHERCODE = "publisherCode";
	public static final String SOLR_DOCUMENT_ONLINEPUBDATE = "onlinePubDate";
	public static final String SOLR_DOCUMENT_VOLUME = "volume";
	public static final String SOLR_DOCUMENT_ISSUE = "issue";
	public static final String SOLR_DOCUMENT_MAINTITLE = "mainTitle";
	public static final String JSON = "json";
	public static final String ROW_COUNT = "50000";
	public static final String REQ_TYPE_JASON = "application/json";
	public static final String RES_NO_DATA_FOUND = "NO DATA FOUND";

	public static final String GET = "Get";
	public static final String POST = "Post";
	public static final String PUT = "Put";
	public static final String DELETE = "Delete";

	public static final int STRATEGY_CHECKER_FREE = 1;
	public static final int STRATEGY_CHECKER_OPEN = 2;
	public static final int STRATEGY_CHECKER_STD = 3;
	public static final int STRATEGY_CHECKER_USER = 4;
	public static final int STRATEGY_CHECKER_IP = 5;
	public static final int STRATEGY_CHECKER_NOCHECKER = 6;
	public static final String CONTENT_PATH = "path";

	public static final String CART = "CART";

	//Alert constants
	public static final String ALERT_TYPE_JOURNAL = "journal";
	public static final String ALERT_TYPE_SUBJECT = "subject";
	public static final String SUBJECT_ALERTS = "subject_alerts";
	public static final String JOURNAL_ALERTS = "journal_alerts";
	public static final String CATEGORY_ALERTS = "eTOC_alerts";

	public static final String DISPLAY_STATUS_INACTIVE = "0";
	public static final String DISPLAY_STATUS_ACTIVE = "1";
	public static final String DISPLAY_STATUS_DELETED = "2";

	public static final String ARTIFACT_STATUS_IN_PROGRESS = "In Progress";
	public static final String ARTIFACT_STATUS_STAGING = "Staging";
	public static final String ARTIFACT_STATUS_LIVE = "Live";

	//Constants for Journal specific setting name
	public static final String SETTING_NAME_DESC = "description";
	public static final String SETTING_NAME_JCODEALIAS = "jCodeAlias";
	public static final String SETTING_NAME_OVERVIEW = "overview";
	public static final String SETTING_NAME_READERSHIP = "ReaderShip";

	public static final String SETTING_NAME_MANUSCRIPT = "manuscript";
	public static final String SETTING_NAME_ABSTRAT_INDEX = "abstract_index";
	public static final String SETTING_NAME_SUBTITLE = "subtitle";
	public static final String SETTING_NAME_E_COMMERCE_URL = "e_commerce_url";

	//Constants for Book specific setting name
	public static final String SETTING_NAME_REVIEW_TYPE_DOODY = "Doody";
	public static final String SETTING_NAME_REVIEW_TYPE_OTHER = "Other";
	public static final String SETTING_NAME_REVIEW_TYPE = "review_type";
	public static final String SETTING_NAME_REVIEW_FILE_NAME = "review_file_name";
	public static final String REVIIEW_FOLDER = "review";

	//Constants for Editor specific setting name
	public static final String SETTING_NAME_FIELD_OF_INTEREST = "fields_of_interest";
	public static final String SETTING_NAME_RECENT_PUBLICATION = "recent_publications";

	//Constants for Supplementary file information
	public static final String INFO_TYPE_HOME = "Home";
	public static final String INFO_TYPE_PUBLISHER = "Publisher";
	public static final String INFO_TYPE_JOURNAL = "Journal";
	public static final String INFO_TYPE_PROCEEDING = "Proceeding";
	public static final String INFO_TYPE_ARTICLE = "Article";
	public static final String INFO_TYPE_METRICS = "Metrics";
	public static final String INFO_TYPE_BOOK = "Book";
	public static final String INFO_TYPE_BOOKCASE = "BookCase";
	public static final String INFO_TYPE_CASE = "Case";
	public static final String INFO_TYPE_VIDEO = "Video";
	public static final String INFO_TYPE_VIDEOATLAS = "Video Atlas";
	public static final String INFO_TYPE_CHAPTER = "Chapter";
	public static final String INFO_TYPE_MIXED = "Mixed";
	public static final String INFO_TYPE_ISSUE = "Issue";
	public static final String INFO_TYPE_BOOK_SERIES = "BookSeries";
	public static final String INFO_TYPE_VDOATLAS = "VIDEOATLAS";

	//PIWIK search constants
	public static final String SEARCH_MODULE_API = "API";
	public static final String SEARCH_METHOD_URL = "Actions.getPageUrls";
	public static final String SEARCH_METHOD_TITLES = "Actions.getPageTitles";
	public static final String SEARCH_FLAT = "1";
	public static final String SEARCH_EXPANDED = "1";
	public static final String SEARCH_PERIOD_YEAR = "year";
	public static final String SEARCH_PERIOD_MONTH = "month";
	public static final String SEARCH_PERIOD_WEEK = "week";
	public static final String SEARCH_PERIOD_RANGE = "range";
	public static final String SEARCH_PERIOD_DATE = "date";
	public static final String SEARCH_DATE_TODAY = "today";
	public static final String SEARCH_DATE_LAST_1 = "last1";
	public static final String SEARCH_DATE_LAST_2 = "last2";
	public static final String SEARCH_DATE_LAST_3 = "last3";
	public static final String AUTHORIZATION = "Authorization";
	public static final String BEARER = "Bearer";
	public static final String BASIC = "Basic";
	public static final String GRANT_TYPE = "grant_type";

	public static final String CLIENT_CREDENTIALS = "client_credentials";
	public static final String STATIC_PAGE_KEY_ABOUT_US = "About-Us";
	public static final String STATIC_PAGE_KEY_OPEN_ACCESS = "Open-Access";
	public static final String STATIC_PAGE_KEY_CONTACT_US = "Contact-Us";

	public static final String CORRESP_AUTHOR = "Y";
	public static final String SHOW_ON_UI_JOURNAL = "Y";

	// check video availability
	public static final String VIDEO_AVAILABILITY = "Y";
	public static final String VIDEO_NOT_AVAILABILITY = "N";
	//Constants for Issue cover Page
	public static final String COVER_PAGE_FILENAME = "fileName";
	public static final String ISSUE_SHOW_COVER_PAGE = "showCoverPage";
	public static final String ISSUE_SHOW_COVER_PAGE_VALUE = "1";

	//Constants for firstLogin Status
	public static final String FIRST_LOGIN_STATUS = "Y";

	//Constant for AddThis service data
	public static final String ADD_THIS_SHARE_MEDIA_MONTH = "month";
	public static final String ADD_THIS_SHARE_SERVICE = "Service";
	public static final String ADD_THIS_SHARE_COUNT = "Count";
	public static final String ADD_THIS_OTHER_SHARES = "Email";

	public static final int CACHEEXPIRY_INHOURS_1 = 1;
	public static final int CACHEEXPIRY_INHOURS_12 = 12;
	public static final int CACHEEXPIRY_INHOURS_24 = 24;
	public static final int CACHEEXPIRY_IN_1_WEEK = 168;

	public static final String NEWS_FEATURE_COMPANY = "company";

	public static final int TEXT_LENGTH_60 = 60;
	public static final int TEXT_LENGTH_200 = 200;
	public static final String ELLIPSIS = "...";
	public static final String ELLIPSIS_WITH_PARANTH = "(..)";

	public static final String HOME_NEWS_CONTENT_LENGTH = "207";

	public static final String ARTICLE_STRATEGY_TYPE_OPEN = "Open";
	public static final String ARTICLE_STRATEGY_TYPE_FREE = "Free";
	public static final String ARTICLE_STRATEGY_TYPE_PAID = "Paid";
	public static final String ARTICLE_STRATEGY_TYPE_STD = "Standard";
	public static final String ARTICLE_STRATEGY_TYPE_SUBSCRIBED = "Subscribed";

	public static final String ARTICLE_PURCHASE_TYPE_PPV = "Pay Per View";
	public static final String ARTICLE_PURCHASE_TYPE_PERIOD_BASED = "Period Based";

	public static final String SUBSCRIPTION_TYPE_INDIVIDUAL = "Individual";
	public static final String SUBSCRIPTION_TYPE_INSTITUTIONAL = "Institutional";

	public static final String SUBSCRIPTION_SOURCE_ALL = "ALL";
	public static final String SUBSCRIPTION_SOURCE_IP = "IP";
	public static final String SUBSCRIPTION_SOURCE_REF = "Referral";
	public static final String SUBSCRIPTION_SOURCE_USER = "User";
	public static final String SUBSCRIPTION_SOURCE_TOKEN = "Token";

	//Constant for Menu Category
	public static final String INSTITUTE = "INS";
	public static final String INDIVIDUAL = "IND";

	//Constant for Menu Type
	public static final String CUSTOM_URL = "CUSTOM_URL";
	public static final String STATIC_PAGE = "STATIC_PAGE";

	//Rest service Parameters detail
	public static final String LOGIN_SESSION_TOKEN = "session";
	public static final String LOGIN_LOGIN_TOKEN = "login_token";
	public static final String HEADER_X_CSRF_TOKEN = "X-CSRF-TOKEN";
	public static final String NO_SESSION_COOKIE = "no_session_cookie";

	public static final String REF_IP_STATUS_APPROVED = "Approved";
	public static final String REF_IP_STATUS_BLOCKED = "Blocked";
	public static final String REF_IP_STATUS_DECLINE = "Decline";
	public static final String REF_IP_STATUS_PENDING = "Pending";
	public static final String REF_IP_STATUS_UNBLOCK = "Unblock";

	public static final String CONTENT_BUNDLE_USER_TYPE_ID_ANONYMOUS = "1";
	public static final String CONTENT_BUNDLE_USER_TYPE_ID_REGISTERED = "2";
	public static final String CONTENT_BUNDLE_USER_TYPE_ID_SUBSCRIBED = "3";

	public static final String CONTENT_BUNDLE_CONTENT_TYPE_ID_INDIVIDUAL = "1";
	public static final String CONTENT_BUNDLE_CONTENT_TYPE_ID_INSTITUTIONAL = "2";

	public static final String ARTICLE_VERSION_AOP = "aop";
	public static final String ARTICLE_VERSION_VOR = "vor";
	public static final String ARTICLE_VERSION_PRINT = "print";

	public static final String AUTHOR_SETTINGS_AFFILIATION = "affiliation";
	public static final String AUTHOR_SETTINGS_ROLE = "role";
	public static final String AUTHOR_SETTINGS_URI = "uri";

	//Date option range
	public static final String FILTER_BY_LASTWEEK = "LW";
	public static final String FILTER_BY_LASTMOTNH = "LM";
	public static final String FILTER_BY_LAST6MOTNH = "L6M";
	public static final String FILTER_BY_LASTYEAR = "LY";
	public static final String FILTER_BY_DATE_RANGE = "SD";
	public static final String HOUR_MINUTES_SECONDS = "T00:00:00Z";
	public static final String FILTER_BY_ALLDATE = "All Dates";

	public static final String LAST_WEEK = "Last Week";
	public static final String LAST_MONTH = "Last Month";
	public static final String LAST_SIX_MONTH = "Last 6 Month";
	public static final String LAST_YEAR = "Last Year";
	public static final String ALL_DATE = "All Dates";
	public static final String FROM_DATE = "From Date:";
	public static final String TO_DATE = "To Date:";
	public static final String ALL_JOURNALS = "All Journals";

	public static final String PAYMENT_STATUS_SUCCESS = "SUCCESS";
	public static final String PAYMENT_STATUS_FAIL = "FAIL";

	public static final String REDIRECT_ARTICLE_YES = "yes";
	public static final String CHANGED_JOURNAL_ID = "0";

	//Transaction
	public static final String TRANSACTION_INITIATED = "INITIATED";
	public static final String TRANSACTION_SUCCESS = "SUCCESS";
	public static final String TRANSACTION_FAILED = "FAILED";
	public static final String TRANSACTION_DECLINED = "DECLINED";
	public static final String TRANSACTION_REFUND = "REFUND";
	public static final String TRANSACTION_FAILED_TRY_AGAIN = "Transaction failed, Please try again";

	public static final Object ENVIRONMENT_TYPE_STAGING_YES = "yes";
	public static final Object ENVIRONMENT_TYPE_STAGING_NO = "no";

	public static final Object STATIC_PAGE_STATUS_APPROVED = "APPROVED";
	public static final Object STATIC_PAGE_STATUS_PENDING = "PENDING";

	public static final String ITEM_ALREADY_SUBSCRIBED = "ITEM_ALREADY_SUBSCRIBED";

	public static final String ARTICLE_PATH = "abstract";
	public static final String ARTICLE_FULLTEXT_PATH = "fulltext";
	public static final String ABS_PATH = "abs";
	public static final String FULL_PATH = "full";

	//cookie
	public static final String SHIBBOLETH_IDENTITY_HEADER = "ajp_shib-identity-provider";
	public static final String OPENATHENS_ORGANISATION_HEADER = "ajp_organisationNum";
	public static final String COOKIES_TARGET_URL = "referelUrlShibboleth";
	public static final String COOKIE_CARTITEM = "COOKIE_CARTITEM";
	public static final String SHIBBOLETH_ENTITY_ID = "SHROMPIBAYSOLPRCOLLEITGEHIDOFPRNUOV";

	//search action
	public static final String TITLE_ASC = "titleAscending";
	public static final String TITLE_DESC = "titledescending";
	public static final String DATE_ASC = "datesTypeAsc";
	public static final String DATE_DESC = "datesTypeDesc";
	public static final String TITLE_RELEVANCE = "relevance";
	public static final String PAGINATION_FIRST = "&lt&ltfirst";
	public static final String PAGINATION_LAST = "last&gt&gt;";
	public static final String PAGINATION_PREVIOUS = "&ltprev";
	public static final String PAGINATION_NEXT = "next&gt;";
	public static final String JOURNAL_ALL = "all";
	public static final String DATE_INDEX = ":";
	public static final String USE_AMAZON_S3_TRUE = "true";
	public static final String IMG_FOLDER = "img";
	public static final String INSTITUTION_FOLDER = "institution";
	public static final String LAST_ID = "lastId";
	public static final String FIRST_ID = "firstId";
	public static final String SEARCH_START_COUNT = "0";
	public static final String SEARCH_END_COUNT = "10";
	public static final String SEARCH_END_COUNT_FIVE = "5";
	/*public static final String JOURNAL_TITLE_FACET = "mainTitleFacet";*/
	/*public static final String KEYWORD_FACET = "keywordsFacet";
	public static final String AUTHOR_FACET = "authorFacet";*/

	/*public static final String SUBJECT_FACET = "subjectFacet";*/

	public static final String MASQUERADE_TARGET_URL = "masqueradeTargetUrl";
	public static final String MASQUERADE_USER = "masqueradeuser";
	public static final String USERNAME = "username";
	public static final String DOI_PREFIX = "10.7748/";
	public static final String PAIR_TOKEN_VALUE = "SSSERPairtokenvalue";
	public static final String INSTITUTE_CODE = "institute_code";
	public static final String SCOPE = "scope";
	public static final String AUTHENTICATION_TYPE = "SSSAFNTSDRFLMTRESFGHJKK77788899LFCHJK";
	public static final String USE_OPENATHENS = "true";
	public static final String PAIRTOKEN = "PAIRTOKEN";
	public static final String SHIBBOLETH = "SHIBBOLETH";
	public static final String OPENATHENS = "OPENATHENS";
	public static final String HTTPREFFERER = "HTTPREFFRER";
	public static final String AUTHENTICATED_VALUE = "SSSSTRFEGHTYUHHHJKSGHSAGFHGSXFAHGSFGHAS";

	public static final String PAYMENT_SUCCESS_STRING_REPLACE = "<p><font face=\"Arial\" color=\"green\"><strong>";
	public static final String PAYMENT_SUCCESS_STRING_SPLIT = "</strong></font></p>";

	public static final String DATE_0000_00_00 = "0000-00-00";
	public static final String BOOK_FOLDER = "books";
	public static final String COLLECTIONS_FOLDER = "collections";
	public static final String ARTICLE_REDIRECT = "articleRedirect";
	public static final String SUPP_INFO_TYPE_MCQ = "Mcq";
	public static final String DEVICE = "devicetype";
	public static final String SESSION = "sessionid";
	public static final String NUMBER_SESSION_CREATED_IN_MINUTES = "session_created_limit";
	public static final String SESSION_DURATION_IN_MINUTES = "session_duration_limit";
	public static final String NUMBER_ACTION_FROM_IP = "user_action_limit";
	public static final String NUMBER_DEVICE_FROM_IP = "user_device_limit";
	public static final String NUMBER_PDF_DOWNLOADED_IN_SESSION = "download_session_limit";

	/* Events Types constants */
	public static final String EVENT_TYPE_EVENT = "Event";
	public static final String EVENT_TYPE_SEMINAR = "Seminar";
	public static final String EVENT_TYPE_CONFERENCE = "Conference";
	public static final String EVENT_FOR_JAYPEE = "JAYPEE";

	public static final String EDITOR_IN_CHIEF = "Editor-in-Chief";

	public static final String CONTENT_TYPE_NOTE = "Note";
	public static final String CONTENT_TYPE_BOOKMARK = "Bookmark";

	public static final String ANNOTATION_TYPE_HIGHLIGHT = "Highlight";
	public static final String ANNOTATION_TYPE_ANNOTATION = "Annotation";

	public static final String IS_CIPLA = "Y";

	public static final String USER_TYPE = "CIPLA";

	public static final String SUBSCRIPTION_TYPE_PERPETUAL = "PERPETUAL";
	public static final String SUBSCRIPTION_TYPE_PERIOD_BASED = "PERIOD_BASED";
	public static final String SUBSCRIPTION_TYPE_INSTRIAL = "INSTRIAL";

	public static final String JOURNAL_LOGO = "journal_logo1";
	public static final String SOCIETY_LOGO = "journal_logo2";
	public static final String SOCIETY_LOGO1 = "journal_logo3";

	public static final String ANONYMOUS = "Anonymous";

	public static final String DAILY = "DAILY";
	public static final String WEEKLY = "WEEKLY";
	public static final String MONTHLY = "MONTHLY";
	public static final String CUSTOMER_TYPE = "customerType";
	public static final String USED = "Y";
	public static final String NOT_USED = "N";
//	public static final String SUNPHARMA = "SUNPHARMA";
//	public static final String JAYPEE = "jaypee";
//	public static final String CIPLA = "cipla";

	public static final String ENDOCRINE = "Endocrine";
	public static final String ENTPHARMA = "Entpharma";
	public static final String ORGANSPHARMA = "Organspharma";
}
