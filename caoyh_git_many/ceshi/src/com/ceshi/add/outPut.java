/** 
 * <pre>项目名称:ceshi 
 * 文件名称:outPut.java 
 * 包名:com.ceshi.add 
 * 创建日期:2015年5月18日上午9:54:02 
 * Copyright (c) 2015,  All Rights Reserved.</pre> 
 */  
package com.ceshi.add;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.ceshi.utils.DBUtil;

/** 
 * <pre>项目名称：ceshi    
 * 类名称：outPut    
 * 类描述：    
 * 创建人：caoyh  
 * 创建时间：2015年5月18日 上午9:54:02    
 * 修改备注：       
 * @version </pre>    
 */
public class outPut {

	public static void output() throws IOException{
		String filenameTemp = "D:/ceshi.dat"; 
		File filename = new File(filenameTemp); 
		FileOutputStream fileOutputStream = new FileOutputStream(filenameTemp);
		if (!filename.exists()) { 
		    filename.createNewFile(); 
		} 
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"utf-8"); 
		BufferedWriter bw = new BufferedWriter(outputStreamWriter); 
		
		for(int i=0;i<80000;i++){
			String randomUUID=getUUID().substring(0,24);
			
		}
		
		
		
		 bw.flush();
		 bw.close();
		 outputStreamWriter.close(); 
		 fileOutputStream.close(); 
	}
	
	 public static String getUUID(){   
	        String s = UUID.randomUUID().toString();   
	        //去掉“-”符号   
	        return s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24);   
	  }   
	 
	 
	 
	 static void check() throws SQLException, IOException {

			String file = "D:/aid/keys.dat";
			String file1 = "D:/aid/mongo.dat";
			FileReader fileReader = new FileReader(file);
			BufferedReader br = new BufferedReader(fileReader);
			
			FileWriter fileWriter=new FileWriter(file1);

			
			int i = 1;
			String s = null;
			while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行
			
				String randomUUID=getUUID().substring(0,24);
				String inserString= "aaaaa  "+ randomUUID + " eee " + s +"  bbbb  " + s + "  ccc";
				    fileWriter.write(inserString + "\r\n");
				i++;
				System.out.println(inserString);
				System.out.println("-------------" + i);
			}
			br.close();
			fileWriter.flush();
			fileWriter.close();
	

		}
	 
	 
	public static void main(String[] args) {
//			try {
//				output();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		
			try {
				check();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
//		System.out.println(getUUID().substring(0,24));
	}
	
	
	
	
	
	
}
