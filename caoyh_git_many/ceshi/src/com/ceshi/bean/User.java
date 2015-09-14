/** 
 * <pre>项目名称:ceshi 
 * 文件名称:User.java 
 * 包名:com.ceshi.bean 
 * 创建日期:2015年7月30日下午3:10:22 
 * Copyright (c) 2015,  All Rights Reserved.</pre> 
 */  
package com.ceshi.bean;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

/** 
 * <pre>项目名称：ceshi    
 * 类名称：User    
 * 类描述：    
 * 创建人：caoyh  
 * 创建时间：2015年7月30日 下午3:10:22    
 * 修改备注：       
 * @version </pre>    
 */
public class User  implements Comparator<Map.Entry<String, User>>{

	public String name;
	
	public String age;
	
	public User(String name,String age){
		  this.name=name;
		  this.age=age;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	

//	@Override
//	public int compareTo(User o) {
//        if (null == o) return 1;  
//        else {  
//            return this.name.compareTo(o.name);  
//        }  
//	}

	/* (non-Javadoc)    
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)    
	 */
	@Override
	public int compare(Entry<String, User> o1, Entry<String, User> o2) {
		// TODO Auto-generated method stub
        return o1.getValue().getName().compareTo(o2.getValue().getName());  
	}
	
	
	
	
	
}
