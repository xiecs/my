package com.dust.net.http;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

public class HtmlTest {

	static String LOGON_SITE = "211.138.245.150";
	static int LOGON_PORT = 80;
	static String inPath = "C:\\msisdn.txt";// �������
	static String outPath = "C:\\result.txt";// ����ļ���
//	static String cookieHead = "cod=300; csd=300004; JSESSIONID=C26F10A27DAA3572273BA0F927450FFF; JSESSIONID=A2D4CAC0A87B290E76817C04E4739825";

	//https://211.138.245.150/mpay/product/show.do?id=100000000008
	
	public static void main(String[] args) throws Exception {
		HttpClient client = new HttpClient();
		client.getHostConfiguration().setHost(LOGON_SITE, LOGON_PORT);

		PostMethod post = new PostMethod("/mpay/product/show.do?id=100000000008");
//		post.addRequestHeader("Cookie", cookieHead);

		Date begin=new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		System.out.println(format.format(begin)+"��ʼ����");
		int status = client.executeMethod(post);
		Date end=new Date();
		System.out.println(format.format(end)+"�������״̬��:" + status);
		post.releaseConnection();
		// д����ļ�


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
