package com.cases;

import java.net.URLDecoder;
import java.net.URLEncoder;

import junit.framework.TestCase;

import org.junit.Test;

import com.saysth.commons.utils.URLUtils;

/**
 * 字符编码解码测试用例
 * 
 * @author KelvinZ
 * 
 */
public class EncodingCase extends TestCase {

	@Test
	public static void testURLUtils() throws Exception {
		String url = "http://www.hahabei.com/SearchPlayFile.aspx?%u6D4B%u8BD5";
		url = url.replaceAll("%u", "\\\\u");
		System.out.println(url);

		url = "http://www.subeihm.com/price-search.asp?word=%B2%E2%CA%D4";
		System.out.println(URLUtils.decode(url));

		url = "http://www.baidu.com/s?ie=utf-8&bs=%E7%AC%94%E8%AE%B0%E6%9C%AC%E8%93%9D%E7%89%99%E9%A9%B1%E5%8A%A8%E4%B8%8B%E8%BD%BD&f=8&rsv_bp=1&wd=%E6%96%B0%E5%8D%8E%E6%8A%A5%E4%B8%9A%E7%AC%94%E8%AE%B0%E6%9C%AC%E8%93%9D%E7%89%99%E9%A9%B1%E5%8A%A8%E4%B8%8B%E8%BD%BD&rsv_sug3=6&rsv_sug1=5&rsv_sug4=315&inputT=12376";
		System.out.println(URLUtils.decode(url));
	}

	@Test
	public void testEncodeDecode() throws Exception {
		System.out.println(URLEncoder.encode("测试", "GBK"));
		System.out.println(URLEncoder.encode("测试", "UTF-8"));
		System.out.println(URLEncoder.encode("测试", "UTF-16"));
		System.out.println(URLDecoder.decode("%B2%E2%CA%D4", "GBK"));
		System.out.println(URLDecoder.decode("%E6%B5%8B%E8%AF%95", "UTF-8"));
		System.out.println(URLDecoder.decode("%FE%FF%6D%4B%8B%D5", "UTF-16"));
	}

}
