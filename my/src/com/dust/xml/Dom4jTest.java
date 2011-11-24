package com.dust.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class Dom4jTest {

	/**
	 * @param args
	 * @throws DocumentException
	 */
	public static void main(String[] args) throws DocumentException {
		Document document = DocumentHelper
				.parseText("<?xml version=\"1.0\" encoding=\"GB2312\"?>\n<er_trans version=\"1.0\"><trans_type>generate_response</trans_type><trans_field_block><sp_id>10001</sp_id><sp_order_number>10001</sp_order_number><er_seq>10001</er_seq><er_resp><er_resp_id>0000</er_resp_id><er_resp_str>成功</er_resp_str></er_resp><er_time>20090616045942234</er_time><addition_number>111111</addition_number><bmp>222222</bmp>	</trans_field_block></er_trans>");
		Element element = document.getRootElement();
		System.out.println(element.getName());

	}

}
