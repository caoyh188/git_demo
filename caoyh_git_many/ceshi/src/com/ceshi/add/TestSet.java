/** 
 * <pre>项目名称:ceshi 
 * 文件名称:TestSet.java 
 * 包名:com.ceshi.add 
 * 创建日期:2015年7月12日下午4:22:50 
 * Copyright (c) 2015,  All Rights Reserved.</pre> 
 */  
package com.ceshi.add;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import com.ceshi.bean.User;

/** 
 * <pre>项目名称：ceshi    
 * 类名称：TestSet    
 * 类描述：    
 * 创建人：caoyh  
 * 创建时间：2015年7月12日 下午4:22:50    
 * 修改备注：       
 * @version </pre>    
 */
public class TestSet {

	public static void getList(){
		List list = new ArrayList();
		list.add("aaa");
		list.add("aaf");
		list.add("aas");
		list.add("aad");
		list.add("aaa");
		list.add("aae");
		list.add("aaa");
		System.out.println(list.size());
		
		
		Set set = new HashSet();
		
		set.addAll(list);
		
		
		
		System.out.println("Setsize:  "+set.size());
		
		
		for (Iterator it = set.iterator(); it.hasNext();) {
			
				System.out.println("value:  "+it.next().toString());
			
			
		}
		
		
	}
	
	
	public static void Sort(){
		User user1 = new User("6傲娇非","12");
		User user2 = new User("3司法所","12");
		User user3 = new User("1司法所","12");
		
		User user4 = new User("5是否","12");
		User user5 = new User("*是否傲娇非","12");
		User user6 = new User("b撒地方傲娇非","12");
		User user7 = new User("(傲娇非","12");
		
		List<User> userList = new ArrayList<User>();
		
		userList.add(user1);
		userList.add(user2);
		userList.add(user5);
		userList.add(user6);
		userList.add(user7);
		userList.add(user3);
		userList.add(user4);
		
//		Collections.sort(userList);
		
		for (User user : userList) {
			System.out.println(user.name);
		}
		
		
	}
    
	
	public static void mapSort(){
		User user1 = new User("6傲娇非","123");
		User user2 = new User("3司法所","122");
		User user3 = new User("1司法所","121");
		
		User user4 = new User("5是否","125");
		User user5 = new User("*是否傲娇非","122");
		User user6 = new User("b撒地方傲娇非","142");
		User user7 = new User("(傲娇非","112");
		
		HashMap<String, User> map = new HashMap<String, User>();
		map.put(user1.getAge(), user1);
		map.put(user2.getAge(), user2);
		map.put(user3.getAge(), user3);
		map.put(user4.getAge(), user4);
		map.put(user5.getAge(), user5);
		map.put(user6.getAge(), user6);
		map.put(user7.getAge(), user7);
		
		
		List<Map.Entry<String, User>> infoIds =
			    new ArrayList<Map.Entry<String, User>>(map.entrySet());
		for (int i = 0; i < infoIds.size(); i++) {
		    User id = infoIds.get(i).getValue();
		    System.out.println(id.getName());
		}
		System.out.println("==============================================");
		Iterator<User> it = map.values().iterator();
		while(it.hasNext()){
           User user = it.next();
           System.out.println(user.getName());
		}
		Collections.sort(infoIds, new Comparator<Map.Entry<String, User>>() {   
		    public int compare(Map.Entry<String, User> o1, Map.Entry<String, User> o2) {      
		        //return (o2.getValue() - o1.getValue()); 
		        return (o1.getValue().getName()).toString().compareTo(o2.getValue().getName());
		    }
		}); 
		
		System.out.println("--------------------------------------------------");
		
		for (int i = 0; i < infoIds.size(); i++) {
		    User id = infoIds.get(i).getValue();
		    System.out.println(id.getName());
		}
		
		
	}
	
	public static void main(String[] args) {
		User user1 = new User("6傲娇非","123");
		User user2 = new User("3司法所","122");
		User user3 = new User("1司法所","121");
		
		User user4 = new User("5是否","125");
		User user5 = new User("*是否傲娇非","122");
		User user6 = new User("b撒地方傲娇非","142");
		User user7 = new User("!傲娇非","112");
		
		HashMap<String, User> map = new HashMap<String, User>();
		map.put(user1.getAge(), user1);
		map.put(user2.getAge(), user2);
		map.put(user3.getAge(), user3);
		map.put(user4.getAge(), user4);
		map.put(user5.getAge(), user5);
		map.put(user6.getAge(), user6);
		map.put(user7.getAge(), user7);
        Map<String, User> resultMap = sortMapByValue(map); //按Value进行排序  
        for (Map.Entry<String, User> entry : resultMap.entrySet()) {  
            System.out.println(entry.getKey() + " " + entry.getValue().getName());  
        }  
	}
	
	
	
	
	
	
	
	
    public static Map<String, User> sortMapByValue(Map<String, User> map) {  
        if (map == null || map.isEmpty()) {  
            return null;  
        }  
        Map<String, User> sortedMap = new LinkedHashMap<String, User>();  
        List<Map.Entry<String, User>> entryList = new ArrayList<Map.Entry<String, User>>(map.entrySet());  
        Collections.sort(entryList, new User(null, null));  
        Iterator<Map.Entry<String, User>> iter = entryList.iterator();  
        Map.Entry<String, User> tmpEntry = null;  
  
        while (iter.hasNext()) {  
            tmpEntry = iter.next();  
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());  
        }  
        return sortedMap;  
    }  
}  







	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
