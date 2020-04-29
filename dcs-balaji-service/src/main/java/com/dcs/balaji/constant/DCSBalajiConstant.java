package com.dcs.balaji.constant;

/**
 * 
 * @author deepakdubey
 * @since 26 December 2019
 * @version 1.0
 */
public interface DCSBalajiConstant {

	interface APIConstant {
		String PATH_PATTERN = "sales";
	}

	interface RequestPath {

		String CUST = "customer";

		String ITEM = "item";

		String ORDER = "order";

		String SALES_ORDER = "sales-order";

		String SALLER_PROFILE = "saller";

		String STOCK = "stock";

		String CATEGORY = "cattegory";

		String OFFER = "offer";

	}

	interface APIPath {

		String DOWNLOAD_FILE = "/download-file/{IMAGE-KEY}";

		String PUSH_ORDER = Symbol.SLASH + "push-order";

		String UPDATE_ORDER = Symbol.SLASH + "update-order";

		String CANCEL_ORDER = Symbol.SLASH + "cancel-order";

		String GET_ORDER = Symbol.SLASH + "get-order";

		String GET_OFFER = Symbol.SLASH + "get-offer";

		String GET_OTP = Symbol.SLASH + "get-otp" + Symbol.SLASH + "{MOB}";

		String VERIFY_OTP = Symbol.SLASH + "verify-otp" + Symbol.SLASH + "{OTP}" + Symbol.SLASH + "{MOB}";

		String GET_ITEMS = Symbol.SLASH + "get-items";

		String ORDER_STATUS = Symbol.SLASH + "get-order-status";

		String GET_CANCELATIONS = Symbol.SLASH + "get-cancel-by";

		String SALLER_UPDATE_ORDER = Symbol.SLASH + "saller" + Symbol.SLASH + "update-order";

		String SALLER_CANCEL_ORDER = Symbol.SLASH + "saller" + Symbol.SLASH + "cancel-order";

		String SALLER_GET_ORDER = Symbol.SLASH + "saller" + Symbol.SLASH + "get-order";

		String GET_ITEMS_BY_CAT = Symbol.SLASH + "get-items" + Symbol.SLASH + "{" + Word.CAT_ID + "}";

		String SAVE_CONSIGNEE = Symbol.SLASH + "save-consignee";

		String UPDATE_CONSIGNEE = Symbol.SLASH + "update-consignee";

		String GET_CONSIGNEE = Symbol.SLASH + "get-consignee" + Symbol.SLASH + "{MOB}";

		String GET_CUSTOMER = Symbol.SLASH + "get-customer" + Symbol.SLASH + "{MOB}";

		String PUSH_CONSIGNEE_IMAGE = Symbol.SLASH + "upload-consignee-image";
	}

	interface Symbol {

		String SLASH = "/";

		String SPACE = " ";

	}

	interface Word {

		String ORDER_NUMBER = "ORDER-NO";

		String ID = "id";

		String STATUS = "status";

		String STRING_A = "A";

		String CAT_ID = "cat-id";

	}

	interface Regex {

	}

	interface ExceptionMessage {

	}

	interface ExceptionCode {

	}

	interface Header {

		String ACCEPT = "Accept";

		String AUTH_TOKEN = "AUTH_TOKEN";

		String CONTENT_TYPE = "Content-Type";

		String CUST_EMAIL = "CUST-EMAIL";

		String CUST_MOB = "CUST-MOB";

		String ORDER_NO = "ORDER-NO";

		String ORDER_STATUS = "ORDER-STATUS";

	}

}
