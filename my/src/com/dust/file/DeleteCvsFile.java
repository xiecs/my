package com.dust.file;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class DeleteCvsFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "D://mpay//myservice";
		File file = new File(path);
		File[] fileParent = file.listFiles();
		for (File f : fileParent) {
			System.out.println("扫描：" + f.getAbsolutePath());
			if (f.isDirectory()) {
				deleteFile(f.getAbsolutePath());
			}
		}
	}

	public static void deleteFile(String path) {
		File file = new File(path);
		if (file.isDirectory() && file.getName().equals("CVS")) {
			
			
			try {
				FileUtils util=new FileUtils();
				util.forceDelete(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//			file.delete();
			System.out.println("delete====" + path);
		} else if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File f : files) {
				deleteFile(f.getAbsolutePath());
			}
		}
	}

}
