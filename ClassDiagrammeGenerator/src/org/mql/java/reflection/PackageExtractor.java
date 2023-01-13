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

		new PackageExtractor("ClassDiagrammeGenerator ");

	}

	public PackageExtractor(String projectName) {
		String classPath = System.getProperty("java.class.path");
		System.out.println(classPath);
		File directory = new File(classPath);

		getPackege(directory);
/*
		for (int i = 0; i < s.size(); i++) {
			System.out.println(s.get(i));
		}*/
	}

	public Vector<String> getPackege(File directory) {

		if (directory.isDirectory()) {
			File[] files = directory.listFiles();
			for (File file : files) {
				
			 
				
				
					cnt = pack;
				if (!file.isFile() && !file.listFiles()[file.listFiles().length-1].isDirectory()) {

					cnt += file.getName();
					cnt=cnt.substring(11,cnt.length());
					s.add(cnt);
				} else {
					pack += file.getName() + ".";
					getPackege(file);
				}
			}
		}
		return s;
	}
	public Vector<String> getPackages() {
		return s;
	}
}
