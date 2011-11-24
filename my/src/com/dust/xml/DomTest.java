package com.dust.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DomTest {

	public static void main(String[] args) throws Exception {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.newDocument();
		Element root = document.createElement("VGOP");
		Element name = document.createElement("SvcCont");
		root.appendChild(name);
		document.appendChild(root);
		Element data = document.createElement("DataConsistencyReq");
		name.appendChild(data);

		Element DataTypeElement = document.createElement("DataType");
		DataTypeElement.setTextContent("000");
		data.appendChild(DataTypeElement);

		Element ConsistencyTypeElement = document.createElement("ConsistencyType");
		ConsistencyTypeElement.setTextContent("0");
		data.appendChild(ConsistencyTypeElement);

		Element ValidTimeStartElement = document.createElement("ValidTimeStart");
		ValidTimeStartElement.setTextContent("0");
		data.appendChild(ValidTimeStartElement);

		Element ValidTimeEndElement = document.createElement("ValidTimeEnd");
		ValidTimeEndElement.setTextContent("0");
		data.appendChild(ValidTimeEndElement);

		Element UserRangeElement = document.createElement("UserRange");
		UserRangeElement.setTextContent("0");
		data.appendChild(UserRangeElement);

		TransformerFactory tFactory = TransformerFactory.newInstance();
		Transformer transformer = tFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File("D://temp/aa.xml"));
		transformer.transform(source, result);

	}
}
