package com.qa.opencart.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants
{
	public static final String LOGGIN_PAGE_TITLE="Account Login";
	public static final String LOGIN_PAGE_URL_FRACTION = "route=account";
	public static final int DEFAULT_TIME_OUT = 9;
	public static final String ACCOUNTS_PAGE_TITLE ="My Account";
	public static final Object IMAC_IMAGE_COUNT = 3;
	public static final String LOGIN_ERROR_MSG ="No match for E-Mail Address and/or Password";
	public static final String REGISTER_SUCCESS_MESG = "Your Account Has Been Created!";
	public static final String REGISTER_SHETT_NAME = "registration";
	public static String TEST_DATA_SHEET_PATH;
	
	public  static List<String> getExpectedAccSecList()
	{
		List<String>expList = new ArrayList<String>();
		expList.add("My Account");
		expList.add("My Orders");
		expList.add("My Affiliate Account");
		expList.add("Newsletter");
		return expList;
	}

}
