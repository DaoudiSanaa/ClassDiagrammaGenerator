package org.mql.java.reflection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class PackageExtractor {
	private String pack = "";
	private Vector<String> s = new Vector<String>();
	private String cnt;

	public static void main(String[] args) {

		new PackageExtractor("DaoudiSanaa");
	}

	public PackageExtractor(String projectName) {
		String classPath = System.getProperty("java.class.path");
		System.out.println(classPath);
		File directory = new File(classPath);
		System.out.println(directory.isDirectory());

		getPackege(directory);

		for (int i = 0; i < s.size(); i++) {
			System.out.println(s.get(i));
		}
	}

	public Vector<String> getPackege(File directory) {
		File[] files = directory.listFiles();
		// System.out.println(directory.getAbsolutePath());
		for (File file : files) {
System.out.println(file.getName());
			cnt = pack;
			if (!file.isFile() && !file.listFiles()[0].isDirectory()) {
				
				cnt += file.getName();
				s.add(cnt);
			} else {
				pack += file.getName() + ".";
				getPackege(file);
				
			}
		}
	//	System.out.println(s);
		return s;
	}

}