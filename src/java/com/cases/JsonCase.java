package com.cases;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.cases.entity.CityLeadboard;
import com.cases.entity.Company;
import com.cases.entity.Hotspot;
import com.cases.entity.Member;
import com.cases.enums.Gender;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonCase {
	static Object obj;

	@BeforeClass
	public static void initTestObject() {
		Company company = new Company();
		company.setName("GSOL");
		Member member = new Member();
		member.setCompany(company);
		member.setUsername("kelvin");
		member.setGender(Gender.MALE);
		member.setMobile("138000088888");
		obj = member;
		System.out.println("initTestObject complete");
	}

	@Test
	public void testFastJson() {
		System.out.println(JSON.toJSONString(obj));
	}

	@Test
	public void testGson() {
		Gson gson = new GsonBuilder().create();
		System.out.println(gson.toJson(obj));
	}

	@Test
	@Ignore
	public void testJSON() throws Exception {
		System.out.println(JSON.toJSONString(testJson2(), SerializerFeature.PrettyFormat,
				SerializerFeature.DisableCircularReferenceDetect));
	}

	public Object testJson2() {
		int len = 3;
		List<Hotspot> hotspots = new ArrayList<Hotspot>();
		for (int i = 0; i < len; i++) {
			hotspots.add(new Hotspot("星巴克华强路店", 23.66, 115.3, "0755-00000000", "深圳市华强北路123号"));
		}

		CityLeadboard cl = new CityLeadboard("星巴克", "Stu", "http://a.b/c.png", 26, 122000, hotspots);
		List<CityLeadboard> result = new ArrayList<CityLeadboard>();
		result.add(cl);
		result.add(new CityLeadboard("麦当劳", "Mc", "http://a.b/c.png", 263, 22000, hotspots));
		return result;
	}

}