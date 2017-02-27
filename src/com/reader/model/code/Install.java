package com.reader.model.code;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class Install {
	
	public void getLog4jProperties(String path){
		File file = new File(path+"/log4j.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			
			Properties properties = new Properties();
			
			properties.load(fis);
			
			Set<Entry<Object, Object>> set = properties.entrySet();
			
			for(Entry<Object, Object> i : set){
				System.out.println(i.getKey()+":"+i.getValue());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
