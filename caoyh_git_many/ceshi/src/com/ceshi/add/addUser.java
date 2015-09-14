package com.ceshi.add;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ceshi.utils.DB2Util;
import com.ceshi.utils.DBUtil;

public class addUser {
	
	static List enterprise = enterprise();
	public static void main(String[] args) {
		Connection connection = DB2Util.getConnection();
		PreparedStatement prepareStatement;
		System.out.println(enterprise.get(0));
		int count = 70*1000+1;
		Date date = new Date(115,3,10);
		Date date1 = new Date(215,4,10);
		
		String sql = " insert into t_fw_um_account(id,name,login_id,login_pwd,email,create_time,create_account_id,is_enable,expiration_time,cipher,token,last_update_time,last_update_account_id,last_login_time,is_leader) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String ss = "SET FOREIGN_KEY_CHECKS = 0";
		String ss1 = "SET FOREIGN_KEY_CHECKS = 0";
		String sql1 = "insert into t_fw_um_account_org_map(account_id,ORG_ID) values(?,?)";
		String sql2 = "insert into t_fw_um_account_role_map(account_id,role_id) values(?,?)";
		
//		 BufferedWriter bw= null;
		 try {
			 for (int i = 70; i < 100; i++) {
					String filenameTemp = "D:/ceshi/"+enterprise.get(i).toString()+".dat"; 
					File filename = new File(filenameTemp); 
					FileOutputStream fileOutputStream = new FileOutputStream(filenameTemp);
					if (!filename.exists()) { 
					    filename.createNewFile(); 
					} 
					OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"utf-8"); 
					BufferedWriter bw = new BufferedWriter(outputStreamWriter); 
					
					
					String filenameTemp1 = "D:/org/"+enterprise.get(i).toString()+".dat"; 
					File filename1 = new File(filenameTemp1); 
					FileOutputStream fileOutputStream1 = new FileOutputStream(filenameTemp1);
					if (!filename1.exists()) { 
						filename1.createNewFile(); 
					} 
					OutputStreamWriter outputStreamWriter1 = new OutputStreamWriter(fileOutputStream1,"utf-8"); 
					BufferedWriter bw1 = new BufferedWriter(outputStreamWriter1); 

					
//					bw = new BufferedWriter(new FileOutputStream(filenameTemp));
				 for (int j = 0; j < 1000; j++) {
					    connection.setAutoCommit(false); 
						prepareStatement = connection.prepareStatement(sql);
						String randomUUID = UUID.randomUUID().toString();
						prepareStatement.setString(1, randomUUID);
						prepareStatement.setString(2, "王亚哲"+count);
						prepareStatement.setString(3, "wangyz"+count);
						prepareStatement.setString(4, "96e79218965eb72c92a549dd5a330112");
						prepareStatement.setString(5, "wangyz"+count+"@mapbar.com");
						prepareStatement.setDate(6,date);
						prepareStatement.setString(7, enterprise.get(i).toString());
						prepareStatement.setInt(8, 0);
						prepareStatement.setDate(9, date1);
						prepareStatement.setString(10, "111111");
						prepareStatement.setString(11, "");
						prepareStatement.setDate(12, date);
						prepareStatement.setString(13, "");
						prepareStatement.setDate(14, null);
						prepareStatement.setInt(15, 1);
						prepareStatement.executeUpdate();
						connection.commit();	
						String str="王亚哲"+count;
						bw.write(str+"\r\n");
						bw1.write(randomUUID+"\r\n");
//						bw.write(str+"\r\n");
						count++;
						org_account(sql1,randomUUID,i);
						for (int h = 0; h < 1; h++) {
							connection.setAutoCommit(false); 
							prepareStatement = connection.prepareStatement(sql2);
							prepareStatement.setString(1, randomUUID);
							prepareStatement.setString(2, "94136f96-bfff-4834-a8e9-6e7cbf4125ae");
							prepareStatement.execute();
							connection.commit();
							for (int g = 0; g < 1; g++) {
								connection.setAutoCommit(false); 
								prepareStatement = connection.prepareStatement(sql2);
								prepareStatement.setString(1, randomUUID);
								prepareStatement.setString(2, "57308f56-57db-42e5-bf2d-fe02f69831e9");
								prepareStatement.execute();
								connection.commit();
							}
						}
				}
				 bw.flush();
				 bw.close();
				 outputStreamWriter.close(); 
				 fileOutputStream.close(); 
				 bw1.flush();
				 bw1.close();
				 outputStreamWriter1.close(); 
				 fileOutputStream1.close(); 
			}
			    	
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
	}
	
	public static void org_account(String sql1,String randomUUID,int i) throws SQLException{
		    Connection connection1 = DB2Util.getConnection();
		    PreparedStatement prepareStatement1;
			connection1.setAutoCommit(false); 
			prepareStatement1 = connection1.prepareStatement(sql1);
			prepareStatement1.setString(1, randomUUID);
			String string = enterprise.get(i).toString();
			prepareStatement1.setString(2, string);
			prepareStatement1.execute();
			connection1.commit();
	}
	public static List enterprise(){
		Connection connection = DBUtil.getConnection();
        String sql = "select enterprise_id from t_enterprise_client";
        PreparedStatement prepareStatement;
        List list = new ArrayList();
		try {
			prepareStatement = connection.prepareStatement(sql);
			ResultSet r = prepareStatement.executeQuery();
			while(r.next()){
				String id = r.getString("enterprise_id");
				list.add(id);
				System.out.println(id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} 
		
		return list;
		
	}
}
