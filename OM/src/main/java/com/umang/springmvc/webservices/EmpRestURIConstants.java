package com.umang.springmvc.webservices;

public class EmpRestURIConstants {
	public static final String DUMMY_EMP = "/rest/user/dummy";
	public static final String GET_EMP = "/rest/emp/{id}";
	public static final String GET_ALL_EMP = "/user/emps";
	public static final String CREATE_EMP = "/rest/user/create";
	public static final String DELETE_EMP = "/rest/user/delete/{id}";
	public static final String GET_OTP = "/rest/user/otp/{id}/{userid}";
	public static final String GET_USR = "/rest/user/{id}";
	public static final String GET_USRCREATE = "/createUser/rest/user/{mobNo}/{userType}/{name}/{address}";
	public static final String DELETE_USR = "/activeUser/rest/user/delete/{id}";
	public static final String EDIT_USR = "/activeUser/editUser/{id}";
	public static final String ITEM_TYPE = "/itemType/{name}/{status}";
	public static final String DELETE_ITEM = "/apiItems/rest/item/delete/{id}";
	public static final String GET_ITEMLIST = "/rest/item/category/{category}";
	public static final String EDIT_ITEM = "/apiItems/editItem/{itemid}";
	public static final String DELETE_ORDER = "/order/delete/{id}";
	public static final String CANCEL_ORDER = "/order/cancel/{orderNo}";
	public static final String DELETE_CUSTOMER = "/apiCustomer/rest/customer/delete/{custid}";
	public static final String ADD_CART = "/addCart/{productId}/{productPrce}";
	public static final String DELETE_CARD = "/deleteCart/{cartId}";
	public static final String updateUserPermission = "/permissionUpdate/{userId}/{status}/{routing}";
	public static final String CLIENT_EDIT_ITEM = "/clientItems/editItem/{itemid}";

}
