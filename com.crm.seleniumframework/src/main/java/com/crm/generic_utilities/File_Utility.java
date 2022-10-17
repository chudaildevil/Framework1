package com.crm.generic_utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class File_Utility {
	/**
	 * This method is used to launch the application
	 * @param Key
	 * @return
	 * @throws Throwable
	 * @author Divya
	 */
	
	public String getPropertyKeyValue(String Key) throws Throwable
	{
		
		//FileInputStream fis= new FileInputStream("./common_data.properties");
		FileInputStream fis= new FileInputStream(ipathConstant.PROPERTYFILE_PATH);
		Properties pro= new Properties();
		pro.load(fis);
		String value = pro.getProperty(Key);
		return  value;
		
	}


}
