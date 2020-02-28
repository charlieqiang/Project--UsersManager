package com.demo;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.util.HttpUtils;


public class HttpsTest {
	private static Logger log = LoggerFactory.getLogger(HttpsTest.class);
	public static void main(String[] args) {
		// 拼接请求地址
		String requestUrl = "https://api.baidu.com/json/sms/v4/ReportService/getProfessionalReportId";
		// 需要提交的json数据
		String jsonData = "{"+
						    "\"header\": {"+
						        "\"token\": \"授权码\","+
						        "\"username\": \"账户名称\","+
						        "\"target\": \"推广账户名称\","+
						        "\"password\": \"账户密码\""+
						    "},"+
						    "\"body\": {"+
						    
								"\"reportRequestType\": {"+
									"\"performanceData\": ["+
									    "\"impression\","+
									    "\"click\","+
									    "\"cost\","+
									    "\"ctr\","+
									    "\"cpc\","+
									    "\"conversion\","+
									    "\"position\""+
									"],"+
									"\"startDate\": \"2016-11-01\","+
									"\"endDate\": \"2016-11-01\","+
									"\"idOnly\": false,"+
									"\"levelOfDetails\": 11,"+
									"\"format\": 2,"+
									"\"reportType\": 14,"+
									"\"statRange\": 11,"+
									"\"unitOfTime\": 5,"+
									"\"device\": 0,"+
									"\"platform\": 3"+
								"}"+
						    
						    "}"+
						"}";
		//发送请求获取结果
		JSONObject jsonObject = HttpUtils.httpsRequest(requestUrl, "POST", jsonData);
		System.out.println(jsonObject);
		/*if (null != jsonObject) {
			try {
				Object aaa = jsonObject.get("header");
			} catch (Exception e) {
				log.error("获取网页授权凭证失败 errcode:{} errmsg:{}", e);
			}
		}*/
    }
}
