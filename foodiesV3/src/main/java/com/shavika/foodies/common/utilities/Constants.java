package com.shavika.foodies.common.utilities;

import java.io.File;

import com.shavika.foodies.api.exception.ShavikaAppException;

public class Constants {

	public static final int LOGIN_TYPE = 1;
	public static final int REGISTERATION_TYPE = 2;
	public static final int FORGOTPASSWORD_TYPE = 3;
	public static final int ID_DELETED = 0;
	public static final int STATUS_CODE_SUCCESS = 0;
	public static final int STATUS_CODE_ERROR = 100;
	public static final int STATUS_CODE_NO_DATA_FOUND = 101;
	public static final int STATUS_CODE_TABLE_NOT_CREATE = 102;

	public static final String STATUS_MSG_LOGIN_SUCCESS = "Successfully Loged-In.";
	public static final String STATUS_MSG_LOGIN_FAIL = "Log-In Failed, Try again.";
	public static final String STATUS_MSG_REGISTER_SUCCESS = "Registeration is successfull, Login again.";
	public static final String STATUS_MSG_REGISTER_FAIL = "Registeration is Failed, Try again.";
	public static final String STATUS_MSG_FORGOT_SUCCESS = "Your Username/Password is mailed to registred e-mail, check the mail and login again.";
	public static final String STATUS_MSG_FORGOT_FAIL = "Registeration is Failed, Try again.";

	/* --- CUSTOMER STATUS --- */
	public final static String CUSTOMER_REGISTRED = "REG";
	public final static String CUSTOMER_CONFIRMED = "CNF";

	/* --- ORDER STATUS--- */
	public final static String ORDER_PLACED = "PLCD";
	public final static String ORDER_INISIATED = "INIT";
	public final static String ORDER_CONFIRMED = "CNFD";
	public final static String ORDER_DELIVERED = "DLRD";
	public final static String ORDER_RECEIVED = "RCVD";
	public final static String ORDER_CANCELED = "CNLD";
	public final static String ORDER_REJECTED = "RJKD";

	/* --- IMAGE FILE NAME SUFFIX--- */
	public final static String IMG_FILE_SUFFIX_BREAKFAST = "_bfst";
	public final static String IMG_FILE_SUFFIX_LUNCH = "_luch";
	public final static String IMG_FILE_SUFFIX_DINNER = "_dinr";
	/* --- ORDER NOT APPLICABLE --- */
	public final static String NOT_APPLICABLE = "N/A";

	public final static String[] ORDER_STATUS_ARRY = new String[] { ORDER_INISIATED, ORDER_CONFIRMED, ORDER_REJECTED,
			ORDER_DELIVERED };

	public final static String IMAGE_FILE_PATH = "/resources/assets/menuimage/";

	public static int getImageFileCount(String name, String rootpath) throws ShavikaAppException {
		String _path = rootpath + Constants.IMAGE_FILE_PATH + File.separator;
		int count = 0;
		File directory = new File(_path);
		File[] fList = directory.listFiles();
		for (File file : fList) {
			String fileNamewithoutext = file.getName().substring(0, file.getName().indexOf("."));
			if (name.toLowerCase().equals(fileNamewithoutext.toLowerCase())) {
				count++;
			}
		}
		return count;
	}

	public static int clearImageIfExist(String name, String rootpath) throws ShavikaAppException {
		String _path = rootpath + Constants.IMAGE_FILE_PATH + File.separator;
		int count = 0;
		if (getImageFileCount(name, rootpath) > 0) {
			File directory = new File(_path);
			File[] fList = directory.listFiles();
			for (File file : fList) {
				String fileNamewithoutext = file.getName().substring(0, file.getName().indexOf("."));
				if (name.toLowerCase().equals(fileNamewithoutext.toLowerCase())) {
					if (file.delete()) {
						count++;
					}
				}
			}
		}
		return count;
	}

	public static String getImageFileByname1(String name, String rootpath) throws ShavikaAppException {
		String _path = rootpath + Constants.IMAGE_FILE_PATH + File.separator;
		String foundfilename = NOT_APPLICABLE;
		File directory = new File(_path);
		File[] fList = directory.listFiles();
		for (File file : fList) {
			String fileNamewithoutext = file.getName().substring(0, file.getName().indexOf("."));
			if (name.toLowerCase().equals(fileNamewithoutext.toLowerCase())) {
				System.out.println("==>" + file.getName() + " / " + fileNamewithoutext);
				foundfilename = file.getAbsolutePath();
				break;
			}
		}
		return foundfilename;
	}

	public static String getImageFileByUniqueid(String name, String rootpath) throws ShavikaAppException {
		String _path = rootpath + Constants.IMAGE_FILE_PATH + File.separator;
		String foundfilename = NOT_APPLICABLE;
		File directory = new File(_path);
		File[] fList = directory.listFiles();
		for (File file : fList) {
			String fileNamewithoutext = file.getName().substring(0, file.getName().indexOf("."));
			if (name.toLowerCase().equals(fileNamewithoutext.toLowerCase())) {
				System.out.println("==>" + file.getName() + " / " + fileNamewithoutext);
				foundfilename = file.getName();
				break;
			}
		}
		return foundfilename;
	}

	public static void main(String[] args) throws Exception {
		String path = "D:\\1.mboraiah\\1.SHAVIKA\\Development\\foodie_application\\sourceCode\\github-backup\\foodiesV3\\src\\main\\webapp\\resources\\assets\\images\\";

		File directory = new File(path);
		// get all the files from a directory
		File[] fList = directory.listFiles();
		for (File file : fList) {
			String fileNamewithoutext = file.getName().substring(0, file.getName().indexOf("."));
			System.out.println("==>" + file.getName() + " / " + fileNamewithoutext);
		}

	}

}
