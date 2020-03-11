package service;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import domain.User;

public class ParsingJson {
	

	public static User JsonTOObject(String myJson){
		/* json字符串转简单java对象
	     * 字符串：{"password":"123456","username":"dmego"}*/
		
		User user = JSON.parseObject(myJson, User.class);
		return user;
		
	}
}
