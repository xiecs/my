package com.dust.net.http;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class CopyOfHtmlTest {

	static String LOGON_SITE = "211.138.251.204";
	static int LOGON_PORT = 80;
	static String inPath = "C:\\msisdn.txt";// �������
	static String outPath = "C:\\result.txt";// ����ļ���
	static String cookieHead = "cod=300; csd=300004; JSESSIONID=C26F10A27DAA3572273BA0F927450FFF; JSESSIONID=A2D4CAC0A87B290E76817C04E4739825";

	public static void main(String[] args) throws Exception {
		HttpClient client = new HttpClient();
		client.getHostConfiguration().setHost(LOGON_SITE, LOGON_PORT);

		PostMethod post = new PostMethod(
				"/justone/school_management/device_query.jsp?post=post");
		post.addRequestHeader("Cookie", cookieHead);

		List<String> msisdnList = getMsisdn();
		List<String> resultList = new ArrayList<String>();
		for (String msisdn : msisdnList) {
			// �����get���󣬲���ֱ�Ӹ���t�Ӻ���
			// ���ò���post=post&dn=13877164174&deviceID=
			NameValuePair arg1 = new NameValuePair("post", "post");
			NameValuePair arg2 = new NameValuePair("dn", msisdn);
			NameValuePair arg3 = new NameValuePair("deviceID", "");
			post.setRequestBody(new NameValuePair[] { arg1, arg2, arg3 });
			// ��������
			int status = client.executeMethod(post);
			System.out.println("�������״̬��:" + status);
			String body = post.getResponseBodyAsString();
			resultList.add(msisdn + "���Ϊ:" + handle(body));
			// System.out.println("Ӧ���ģ�" + body);
		}
		// ��������
		post.releaseConnection();
		// д����ļ�
		writeFile(resultList);

		// // �鿴cookie��Ϣ
		// Cookie[] cookies = client.getState().getCookies();
		// for (int i = 0; i < cookies.length; i++) {
		// Cookie cookie = cookies[i];
		// String domain = cookie.getDomain();
		// String path = cookie.getPath();
		// String argName = cookie.getName();
		// String value = cookie.getValue();
		// System.out.println("Cookie: " + domain + ", " + path + ", "
		// + argName + ", " + value);
		// }

		// // ��½�󣬷�������ҳ��
		// GetMethod get = new
		// GetMethod("/eshopconsole/admin/pages/infoMgr/product/productCheck.do");
		// // Header headers=new BasicHeader("X_REQUESTED_WITH",
		// "XMLHttpRequest");
		// status = client.executeMethod(get);
		// System.out.println("�������״̬��:" + status);
		// String htmlContent = get.getResponseBodyAsString();
		// System.out.println(htmlContent);
		// get.releaseConnection();

	}

	public static List<String> getMsisdn() throws IOException {
		File read = new File(inPath);
		BufferedReader in = new BufferedReader(new FileReader(read));
		List<String> list = new ArrayList<String>();
		while (in.ready()) {
			String str = in.readLine();
			list.add(str);
		}
		return list;
	}

	public static String handle(String content) {
		Pattern patTable = Pattern.compile("id=\"tableid\"[\\S\\s]*?</table>");
		Matcher matTable = patTable.matcher(content);
		Pattern patTd = Pattern.compile("<td>[\\S\\s]*?</td>");
		String result = null;
		
		if (matTable.find()) {
			String table = matTable.group();// ץȡtable
			// System.out.println(matTable.group());
			Matcher matTd = patTd.matcher(table);// ץȡtd
			StringBuilder sb=new StringBuilder();
			while (matTd.find()) {
				sb.append(matTd.group().replaceAll("<td>","").replaceAll("</td>", ","));
			}
			result=sb.toString();
		} else {
			result = "�Ҳ�����ؼ�¼";
		}
//		System.out.print(result);
		return result;
	}

	public static void writeFile(List<String> list) throws Exception {
		//�ж��ļ��Ƿ����
		File file = new File(outPath);
		if(!file.exists()){
			file.createNewFile();
		}
		PrintWriter pw = new PrintWriter(file, "GBK");
		for (String reslut : list) {
			pw.println(reslut);
		}
		pw.flush();
		pw.close();
	}

}
