package com.text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 抽取指定格式的文本数据
 * 
 * @author xiecs
 * 
 */
public class Cut {

	public static void main(String[] args) throws IOException {
		String SYMBOL_IN = "\\|";// 输入文件分割符
		String SYMBOL_OUT = ",";// 输出文件分割符

		String FILE_IN = "C://radius_data_XXT_jichu_20111021.txt";// 输入文件
		String FILE_OUT = "C://data.txt";// 输出文件

		
		BufferedReader in = new BufferedReader(new FileReader(FILE_IN));
		PrintWriter out = new PrintWriter(new FileWriter(new File(FILE_OUT)));

		String s;
		String arr[] = new String[13];
		StringBuffer str_out;
		while ((s = in.readLine()) != null) {
			// s2 += s + "\n";
			// System.out.println(s);
			arr = s.split(SYMBOL_IN);
			str_out = new StringBuffer();
			str_out.append(arr[1] + SYMBOL_OUT);
			str_out.append(arr[2] + SYMBOL_OUT);
			str_out.append(arr[5] + SYMBOL_OUT);
			str_out.append(arr[9] + SYMBOL_OUT);
			str_out.append(arr[10]);

			out.println(str_out.toString());
		}
		in.close();
		out.flush();
		out.close();

	}

}
