package com.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;

/**
 * 工具�?
 * @author liufei
 */
public final class Tools {
	
	
	/**
	 * 通过文件名获取http类型
	 * �?要将apptype文件放置在web-inf目录�?
	 * @param fileName
	 * @return 
	 */
	public static String getFileType(String fileName){
		if(webinfPath != null){
			if(typeList == null ){
				File file = new File(webinfPath+"/apptype.txt");
				StringBuffer sb = new  StringBuffer();
				try {
					Scanner scanner = new Scanner(file);
					while(scanner.hasNextLine()){
						sb.append(scanner.nextLine()+"\n");
					}
					typeList = sb.toString();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
			if(fileName != null && !"".equals(fileName.trim())){
				fileName = fileName.trim();
				Scanner scanner = new Scanner(typeList);
				while(scanner.hasNextLine()){
					String[] type = scanner.nextLine().split("=");
					if(fileName.endsWith(type[0])){
						return type[1];
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * 打印调试log信息
	 * @param obj  需要打印的内容
	 */
	public static void debug(Object obj){
		log(obj,LogMode.DEBUG);
	}
	/**
	 * 打印严重错误log信息
	 * @param obj  需要打印的内容
	 */
	public static void error(Object obj){
		log(obj,LogMode.ERR);
	}
	/**
	 * 打印log信息
	 * @param obj  需要打印的内容
	 */
	public static void info(Object obj){
		log(obj,LogMode.INFO);
	}
	/**
	 * 打印警告log信息
	 * @param obj  需要打印的内容
	 */
	public static void wing(Object obj){
		log(obj,LogMode.WING);
	}
	
	/**
	 * 打印log信息
	 * @param obj 需要打印的内容
	 * @param mode 通过什么模式打印 模式在LogMode枚举中定义
	 */
	public static void log(Object obj, LogMode mode){
		if(log == null){
			log = Logger.getLogger(Tools.class);
		}
		switch(mode){
			case DEBUG:
				log.debug(obj);
				break;
			case INFO:
				log.info(obj);
				break;
			case ERR:
				log.fatal (obj);
				break;
			case WING:
				log.warn(obj);
				break;
			default:
				break;
		}
	}
	
	
	/**
	 * 获取log4j的设置
	 * @param key 配置文件的键
	 * @return 获取的值
	 */
	public String getLog4jProperties(String key){
		
		File file = new File(webinfPath+"/classse/log4j.properties");
		
		try {
			
			FileInputStream fis = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fis);
			return properties.getProperty(key);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 设置log4j的设置
	 * @param key 配置文件的键
	 * @param value 配置文件的值
	 */
	public void setLog4jProperties(String key, String value){
		
		File file = new File(webinfPath+"/classse/log4j.properties");
		
		try {
			
			FileInputStream fis = new FileInputStream(file);
			
			Properties properties = new Properties();
			properties.load(fis);
			fis.close();
			properties.setProperty(key, value);
			FileOutputStream fos = new FileOutputStream(file);
			properties.store(fos, "");
			fos.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * web应用位置解析
	 * 要先在servlet或Listener中添加如下代
	 * String path = arg0.getServletContext().getRealPath("/WEB-INF");
     * Tools.setWebinfPath(path);
	 * @param path
	 */
	public static void setWebinfPath(String path){
		webinfPath = path;
	}
	
	
	
	private static String webinfPath = null;
	private static String typeList = null;
	
	private static Logger log = null;
	
	private Tools(){}
	
	
	
}



