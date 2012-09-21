package com.cases.entity;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONType;

@JSONType(orders = { "name", "ssid", "logoUrl", "hotspotCnt", "peopleCnt", "hotspots" })
public class CityLeadboard {
	public CityLeadboard(String name, String ssid, String logoUrl, int hotspotCnt, int peopleCnt, List<Hotspot> hotspots) {
		this.name = name;
		this.ssid = ssid;
		this.logoUrl = logoUrl;
		this.hotspotCnt = hotspotCnt;
		this.peopleCnt = peopleCnt;
		this.hotspots = hotspots;
	}

	public String name;
	public String ssid;
	public String logoUrl;
	public int hotspotCnt;
	public int peopleCnt;
	public List<Hotspot> hotspots;
}
