package com.cases.entity;

import com.alibaba.fastjson.annotation.JSONType;

@JSONType(orders = { "name", "lat", "lon", "phone", "addr" })
public class Hotspot {
	public Hotspot(String name, double lat, double lon, String phone, String addr) {
		this.name = name;
		this.lat = lat;
		this.lon = lon;
		this.phone = phone;
		this.addr = addr;
	}

	public String name;
	public double lat;
	public double lon;
	public String phone;
	public String addr;
}
