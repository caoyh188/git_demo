package com.ceshi.add;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;


import com.ceshi.utils.DB2Util;
import com.ceshi.utils.DBUtil;

public class Test {
	
	static void insertdefinition()  throws SQLException, IOException {
		String aids[] = {"0000a096-210f-498d-a9dd-e385a53dd5e8","0000bb66-bbc5-4cb2-99e3-d295f551486d","0000efd7-7d08-49b0-a9e3-5e44ae066771","00014457-3b34-4f6b-80b0-bd1d0944baeb","0001589f-4182-458d-8fb9-bf4e20a4ac29","0002997f-ea44-4873-b28c-4d9e94576fac","000a1faa-419c-4ee5-bce8-a2536e5d9fbc","000a81f2-dc8e-4b29-b0f9-619abbb6e38a","000e0c66-84c2-41cf-9ff0-6177495200d8","000ff5a2-1da7-4cfc-9a7d-436deb390691","001015bb-06ca-49bc-a37d-d5e0ae2ca27a","00146e05-6b0b-4696-8a67-e75cbf49380b","001596ae-ec1e-43dc-a778-811bbed4bb31","001682bc-462b-42ed-a8b8-1eaac03e27ef","00177570-b9ae-474c-a733-5480173ec944","0020670e-8029-4083-94e4-a661072b5493","00206726-a0a6-4d9e-afa7-8db0c2120e72","00215936-3e08-4364-91d6-2c12c9d23c8a","0025244b-d3ee-489a-af32-3160e0831146","00252452-7b49-4239-b232-866c097c6a1c","00271503-b394-43c1-a88d-5782b57790d2","0027856b-88c4-42df-863f-1db517114d93","002850a6-a56e-4601-b517-1643326f3698","002e9ce9-1b3b-4657-bbfe-14b718b36338","0035585c-1a66-4f56-9d9d-4e0b87296907","006625a8-eb10-4a9d-863e-e413ec9e93af","00788446-fd0d-45fb-aeca-4790f5396a7b","0087572f-21ba-4c98-b779-83e1f88213ff","0089936d-206a-479f-9718-dd01d5596056","0097e954-8107-4eb9-9f9b-cb9b381837e1","009e5a1d-6a88-49c9-9ae5-a338930782ab","00ad93d8-3392-4403-9aee-0480a26b4363","00cb6f86-62a3-493a-be2d-12502c65a423","00ccc3ce-0959-4378-9397-cb8c0f8466cb","00ddf8e0-50ae-4948-a417-938cb40996d4","00e89b10-6011-4c75-80e2-a4c49f200a81","015930c7-92c8-4213-a786-d2d149bbc00a"};
		String enames[] = {"3333333","dasdasdas","董春成恻恻恻1","aaaaaaaaa","dongha","测试注册","共和国海关","线下测试","钢结构加工","是是是是","企业试用8888","wuahhahahah","给我个访问","csacascsac","pppp11","jahsfkh","龙门镖局镖镖必达","测试线下订单","测试测试113333333","aaaa","hdusadhaus","谭跃发测试企业3","dongcc890","测试嗖嗖嗖","梧桐爱爱爱","huhuhu","sadasdas","fbhask","企业试用55555","百度度","董春成测试购买权限","发售股份代号","Hhuu","董春成测试456","99999","测试订单状态","dongcc456"};
		String orgids[] = {"9ad2dc2c-6906-45c9-9243-b1939188a545","67473a76-8195-4e7c-956f-b90f990f8abd","555fbf18-ea1e-4147-a2c2-6b173ba5e897","55ff6633-fd67-45f2-a2fa-c2893e53fc70","320b6c20-d8d7-4d41-af22-130a85f410d3","0fb564e7-2348-41e6-befa-6edb5ec1dfbd","45a4f10e-646f-4a4e-bf05-47804168a00b","08504c49-1503-4b3c-abfc-f5d91022c34c","0970720c-81fb-42c5-97e5-7b08c844c9a6","2c7d5732-cadf-4e7b-9fa2-0a81887b4036","803fe8c6-8fca-426a-8098-6bb973472dca","3d561f4c-f240-4b11-9987-1056262a4ebc","860087ff-e5cf-43f4-8964-356fc7e922b7","8bacd019-7e29-4e06-ba4b-ec5007f73627","3e94defd-7a18-4793-86d2-dc5400866c0b","8932d430-1806-4607-8792-16a8b68e2a12","023fe0d2-f4c9-4817-96df-226ea11e2e7d","5f7e5cd7-ec91-4990-93d9-88448a1a4dad","1c7da363-20a0-4b09-adbf-40882fa9f428","48d15cce-be2c-417a-bd32-429253b2c9fb","520b0b7c-f81f-4af4-afa0-080620997bbe","4ebbea4d-ca7c-4937-8069-42bea685215b","4ab61be4-a383-47c0-8e2d-89f37d429d2f","4961af01-39a0-49b5-8565-4ea3a6ce076f","2f4da987-8f7d-45d7-8e13-74f4be85af61","549cd1f6-5024-4b97-bce1-1ea66492c219","36448406-b4c3-4f43-9b6f-44e1f3c72e0f","807ba08d-0120-4263-8a5f-c227cb8eeb4a","6b888cb3-1220-4ec1-9364-f1d0d462a6d8","518df6b8-fd74-476b-95d6-45b531b1c7e0","7e60585d-f102-403e-b850-3930fb9fa358","69bf32f8-fe27-49b2-b43a-453b3b087b13","0b77d6f4-c475-45a0-b847-0f77d45ad9d1","09e7f810-8ccb-48b2-950b-205d2768b430","6d8d7fd3-3fff-4b4c-954b-0413ba85fb75","8306584f-7d8a-4bd5-872f-4f21dbf59e1a","5095300e-eb08-458f-805b-c9474a80a7c2"};

		
		System.out.println("aids========" + aids.length);
		System.out.println("enames========" + enames.length);
		System.out.println("orgids========" + orgids.length);

		String sql = " INSERT INTO t_lbs_definition(DEFINITION_ID,BIND_KEY,BIND_TYPE,CREATE_DATE,CREATE_USER,DEFINITION_NAME,EQUIP_NUM,UPDATE_DATE,UPDATE_USER,VALID_FLAG,EQUIP_ID,MODE_ID,MONITOR_STATE,FENCE_ID,PROPERTIES,KEY1,KEY2,KEY3) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection connection = DB2Util.getConnection();
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		
		for (int i = 0; i < orgids.length; i++) {
			
			prepareStatement.setString(1, aids[i]);
			prepareStatement.setString(2, "");
			prepareStatement.setString(3, "");
			Timestamp x = new Timestamp(new Date().getTime());
			prepareStatement.setTimestamp(4, x );
			prepareStatement.setString(5, aids[i]);
			prepareStatement.setString(6, enames[i]);
			prepareStatement.setString(7, aids[i]);
			prepareStatement.setTimestamp(8, x);
			prepareStatement.setString(9, "1");
			prepareStatement.setString(10, "");
			prepareStatement.setString(11, "");
			prepareStatement.setString(12, "0");
			prepareStatement.setString(13, "1");
			prepareStatement.setString(14, "");
			prepareStatement.setString(15, "{\"phone\":\"15827443502\"}");
			prepareStatement.setString(16, aids[i]);
			prepareStatement.setString(17, orgids[i]);
			prepareStatement.setString(18, "");
			prepareStatement.execute();
		}
		
		prepareStatement.close();
		connection.close();
		
	}
	
	static void Inser() throws SQLException, IOException {

		
		String file = "D:/aid/keys.dat";
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);

		String sql = " INSERT INTO t_atten_rule_target(TARGET_ID,RULE_ID,TARGET_TYPE,CREATE_ACCOUNT_ID) values(?,?,?,?)";
		Connection connection = DB2Util.getConnection();
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		int i = 1;
		String s = null;
		while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行
			
			prepareStatement.setString(1, s);
			prepareStatement.setString(2, "4028800c4c470b5c014c503c02270173");
			prepareStatement.setString(3, "account");
			prepareStatement.setString(4, "");
			prepareStatement.execute();
			i++;
			System.out.println("-------------" + i);
		}
		br.close();
		prepareStatement.close();
		connection.close();

	}
	
	static void check() throws SQLException, IOException {

		String file = "D:/aid/keys.txt";
		String file1 = "D:/aid/orgid.dat";
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		
		FileWriter fileWriter=new FileWriter(file1);

		String sql = " Select ORG_ID from t_fw_um_account_org_map where ACCOUNT_ID=?";
		Connection connection = DBUtil.getConnection();
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		int i = 1;
		String s = null;
		while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行
			prepareStatement.setString(1, s);
			ResultSet executeQuery = prepareStatement.executeQuery();
			if(executeQuery.next())
			    fileWriter.write(executeQuery.getString(1)+ "\r\n");
			i++;
			System.out.println("-------------" + i);
		}
		br.close();
		fileWriter.flush();
		fileWriter.close();
		prepareStatement.close();
		connection.close();

	}
	
	public static void main(String[] args) throws SQLException, IOException {
		
		Inser();
//		check();
	}

//	static List enterprise = enterprise();
//
//	public static void main1(String[] args) {
//		Connection connection = DB2Util.getConnection();
//		PreparedStatement prepareStatement;
//		System.out.println(enterprise.get(0));
//		int count = 40 * 1000 + 1;
//		Date date = new Date(115, 3, 10);
//		Date date1 = new Date(215, 4, 10);
//
//		String sql = " insert into t_fw_um_account(id,name,login_id,login_pwd,email,create_time,create_account_id,is_enable,expiration_time,cipher,token,last_update_time,last_update_account_id,last_login_time,is_leader) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//		String ss = "SET FOREIGN_KEY_CHECKS = 0";
//		String ss1 = "SET FOREIGN_KEY_CHECKS = 0";
//		String sql1 = "insert into t_fw_um_account_org_map(account_id,ORG_ID) values(?,?)";
//		String sql2 = "insert into t_fw_um_account_role_map(account_id,role_id) values(?,?)";
//
//		// BufferedWriter bw= null;
//		try {
//			for (int i = 40; i < 70; i++) {
//				String filenameTemp = "D:/ceshi/"
//						+ enterprise.get(i).toString() + ".dat";
//				File filename = new File(filenameTemp);
//				FileOutputStream fileOutputStream = new FileOutputStream(
//						filenameTemp);
//				if (!filename.exists()) {
//					filename.createNewFile();
//				}
//				OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
//						fileOutputStream, "utf-8");
//				BufferedWriter bw = new BufferedWriter(outputStreamWriter);
//
//				String filenameTemp1 = "D:/org/" + enterprise.get(i).toString()
//						+ ".dat";
//				File filename1 = new File(filenameTemp1);
//				FileOutputStream fileOutputStream1 = new FileOutputStream(
//						filenameTemp1);
//				if (!filename1.exists()) {
//					filename1.createNewFile();
//				}
//				OutputStreamWriter outputStreamWriter1 = new OutputStreamWriter(
//						fileOutputStream1, "utf-8");
//				BufferedWriter bw1 = new BufferedWriter(outputStreamWriter1);
//
//				// bw = new BufferedWriter(new FileOutputStream(filenameTemp));
//				for (int j = 0; j < 1000; j++) {
//					connection.setAutoCommit(false);
//					prepareStatement = connection.prepareStatement(sql);
//					String randomUUID = UUID.randomUUID().toString();
//					prepareStatement.setString(1, randomUUID);
//					prepareStatement.setString(2, "王亚哲" + count);
//					prepareStatement.setString(3, "wangyz" + count);
//					prepareStatement.setString(4,
//							"96e79218965eb72c92a549dd5a330112");
//					prepareStatement.setString(5, "wangyz" + count
//							+ "@mapbar.com");
//					prepareStatement.setDate(6, date);
//					prepareStatement.setString(7, enterprise.get(i).toString());
//					prepareStatement.setInt(8, 0);
//					prepareStatement.setDate(9, date1);
//					prepareStatement.setString(10, "111111");
//					prepareStatement.setString(11, "");
//					prepareStatement.setDate(12, date);
//					prepareStatement.setString(13, "");
//					prepareStatement.setDate(14, null);
//					prepareStatement.setInt(15, 1);
//					prepareStatement.executeUpdate();
//					connection.commit();
//					String str = "王亚哲" + count;
//					bw.write(str + "\r\n");
//					bw1.write(randomUUID + "\r\n");
//					// bw.write(str+"\r\n");
//					count++;
//					org_account(sql1, randomUUID, i);
//					for (int h = 0; h < 1; h++) {
//						connection.setAutoCommit(false);
//						prepareStatement = connection.prepareStatement(sql2);
//						prepareStatement.setString(1, randomUUID);
//						prepareStatement.setString(2,
//								"94136f96-bfff-4834-a8e9-6e7cbf4125ae");
//						prepareStatement.execute();
//						connection.commit();
//						for (int g = 0; g < 1; g++) {
//							connection.setAutoCommit(false);
//							prepareStatement = connection
//									.prepareStatement(sql2);
//							prepareStatement.setString(1, randomUUID);
//							prepareStatement.setString(2,
//									"57308f56-57db-42e5-bf2d-fe02f69831e9");
//							prepareStatement.execute();
//							connection.commit();
//						}
//					}
//				}
//				bw.flush();
//				bw.close();
//				outputStreamWriter.close();
//				fileOutputStream.close();
//				bw1.flush();
//				bw1.close();
//				outputStreamWriter1.close();
//				fileOutputStream1.close();
//			}
//
//		} catch (SQLException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			try {
//				connection.rollback();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}
//	}
//
//	public static void org_account(String sql1, String randomUUID, int i)
//			throws SQLException {
//		Connection connection1 = DB2Util.getConnection();
//		PreparedStatement prepareStatement1;
//		connection1.setAutoCommit(false);
//		prepareStatement1 = connection1.prepareStatement(sql1);
//		prepareStatement1.setString(1, randomUUID);
//		String string = enterprise.get(i).toString();
//		prepareStatement1.setString(2, string);
//		prepareStatement1.execute();
//		connection1.commit();
//	}
//
//	public static List enterprise() {
//		Connection connection = DBUtil.getConnection();
//		String sql = "select enterprise_id from t_enterprise_client";
//		PreparedStatement prepareStatement;
//		List list = new ArrayList();
//		try {
//			prepareStatement = connection.prepareStatement(sql);
//			ResultSet r = prepareStatement.executeQuery();
//			while (r.next()) {
//				String id = r.getString("enterprise_id");
//				list.add(id);
//				System.out.println(id);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			try {
//				connection.rollback();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}
//
//		return list;
//
//	}
//
//	public static List<Object> enterprise2() {
//		Connection market = DBUtil.getConnection();
//		Connection work = DB2Util.getConnection();
//		String sql = "select * from t_enterprise_client";
//		String sql1 = " INSERT INTO t_fw_um_org(ID,PARENT_ID,NAME,DESCRIPTION,CREATE_TIME,CREATE_ACCOUNT_ID,IS_ENABLE,PATH,PATH,LAST_UPDATE_ACCOUNT_ID) values(";
//		PreparedStatement prepareStatement;
//		PreparedStatement prepareStatement2;
//		// List list = new ArrayList();
//		try {
//			prepareStatement = market.prepareStatement(sql);
//			prepareStatement2 = work.prepareStatement(sql1);
//			ResultSet r = prepareStatement.executeQuery();
//			while (r.next()) {
//				// String id = r.getString("enterprise_id");
//				// list.add(id);
//				sql1 += r.getString("org_id") + ",";
//				sql1 += "'',";
//				sql1 += r.getString("enterprise_name") + ",";
//				sql1 += "'',";
//				sql1 += r.getString("approval_time") + ",";
//				sql1 += "d1f767f6-77bc-48fd-9717-f38c12abb1e8,";
//				sql1 += "0,";
//				sql1 += r.getString("org_id") + "/,";
//				sql1 += r.getString("org_id") + ",";
//				sql1 += r.getString("org_id") + ",";
//				sql1 += r.getString("org_id") + ",";
//
//				prepareStatement2.executeQuery();
//
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			try {
//				market.rollback();
//				work.rollback();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}
//
//		return null;
//
//	}
}
