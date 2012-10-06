package com;
/************************************************
 * <p>Title:�ޱ���GB2Alpha</p>
 * <p>CreateData: 2005-8-16   15:40:10</p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * @author ����
 * @version 1.0
 ***********************************************/
/**
 * Created by IntelliJ IDEA. User: ����� Date: 2004-5-17 Time: 10:59:59 ClassDescription:ȡ�������ַ�����ƴ������ĸ
 */

public class GB2Alpha {

	// ��ĸZʹ����������ǩ�������У�����ֵ
	// i, u, v��������ĸ, ����ǰ�����ĸ
	private char[] chartable = { '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', 'Ŷ', 'ž', '��',
			'Ȼ', '��', '��', '��', '��', '��', '��', 'ѹ', '��', '��' };

	private char[] alphatable = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',

	'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	private int[] table = new int[27];

	// ��ʼ��
	{
		for (int i = 0; i < 27; ++i) {
			table[i] = gbValue(chartable[i]);
		}
	}

	public GB2Alpha() {

	}

	// ������,�����ַ�,�õ�������ĸ,
	// Ӣ����ĸ���ض�Ӧ�Ĵ�д��ĸ
	// �����Ǽ��庺�ַ��� '0'

	public char Char2Alpha(char ch) {

		if (ch >= 'a' && ch <= 'z') return (char) (ch - 'a' + 'A');
		if (ch >= 'A' && ch <= 'Z') return ch;

		int gb = gbValue(ch);
		if (gb < table[0]) return '0';

		int i;
		for (i = 0; i < 26; ++i) {
			if (match(i, gb)) break;
		}

		if (i >= 26)
			return '0';
		else
			return alphatable[i];
	}

	// ����һ���������ֵ��ַ�������һ������ƴ������ĸ���ַ���
	public String String2Alpha(String SourceStr) {
		String Result = "";
		int StrLength = SourceStr.length();
		int i;
		try {
			for (i = 0; i < StrLength; i++) {
				Result += Char2Alpha(SourceStr.charAt(i));
			}
		} catch (Exception e) {
			Result = "";
		}
		return Result;
	}

	private boolean match(int i, int gb) {
		if (gb < table[i]) return false;

		int j = i + 1;

		// ��ĸZʹ����������ǩ
		while (j < 26 && (table[j] == table[i]))
			++j;

		if (j == 26)
			return gb <= table[j];
		else
			return gb < table[j];

	}

	/**
	 * **********************************************
	 * <p>
	 * �������ƣ�intercept(��ȡ���ֵĳ���)
	 * </p>
	 * <p>
	 * ����ʱ�䣺2005-8-16,17:01:27
	 * </p>
	 * <p>
	 * ������Ա��wangkai
	 * </p>
	 * 
	 * @param FromStr
	 *            ��Ҫ��ȡ������
	 * @param MaxLen
	 *            ��ȡ�೤
	 * @param ShowMore
	 *            �Ƿ���ʾ���������
	 * @return ��ȡ�������
	 ********************************************** 
	 */
	public static String intercept(String FromStr, int MaxLen, boolean ShowMore) {
		String ToStr = "";

		if (MaxLen <= 0) return FromStr;
		//if (StrTools.CheckStrNull(FromStr)) return "";
		int FromLen = FromStr.length();
		if (MaxLen >= ChineseLen(FromStr)) return FromStr;
		if (ShowMore) if (MaxLen > 5) MaxLen = MaxLen - 3;
		int k = 0;
		try {
			for (int i = 0; i < MaxLen;) {
				char str = FromStr.charAt(k);
				ToStr = ToStr + String.valueOf(str);
				if (gbValue(str) > 0)
					i = i + 2;
				else
					i++;
				k++;

			}
		} catch (Exception e) {
		}
		if (ShowMore) if (MaxLen > 4) ToStr = ToStr + "...";
		return ToStr;
	}

	/**
	 * **********************************************
	 * <p>
	 * �������ƣ�ChineseLen(��õ�ǰ���ֵĳ��ȣ�����Ϊ2���ַ�)
	 * </p>
	 * <p>
	 * ����ʱ�䣺2005-8-16,17:00:51
	 * </p>
	 * <p>
	 * ������Ա��wangkai
	 * </p>
	 * 
	 * @param FromStr
	 * @return
	 ********************************************** 
	 */
	public static int ChineseLen(String FromStr) {
		//if (StrTools.CheckStrNull(FromStr)) return 0;
		int FromLen = FromStr.length();
		int ChineseLen = 0;
		for (int i = 0; i < FromLen; i++) {
			if (gbValue(FromStr.charAt(i)) > 0) {
				ChineseLen = ChineseLen + 2;
			} else {
				ChineseLen++;
			}
		}
		return ChineseLen;
	}

	/*******
	 * **********************************************
	 * <p>
	 * �������ƣ�gbValue(����GBK�ı���)
	 * </p>
	 * <p>
	 * ����ʱ�䣺2005-8-16,16:22:52
	 * </p>
	 * <p>
	 * ������Ա��wangkai
	 * </p>
	 * 
	 * @param ch
	 * @return
	 ********************************************** 
	 */
	public static int gbValue(char ch) {
		String str = new String();
		str += ch;
		try {
			byte[] bytes = str.getBytes("GBK");
			if (bytes.length < 2) return 0;
			return (bytes[0] << 8 & 0xff00) + (bytes[1] & 0xff);
		} catch (Exception e) {
			return 0;
		}
	}

	public static void main(String[] args) {
		GB2Alpha obj1 = new GB2Alpha();
		System.out.println(obj1.String2Alpha("����"));
		System.out.println(obj1.String2Alpha("�����"));
		System.out.println(obj1.String2Alpha("��ү"));
		return;
	}
}