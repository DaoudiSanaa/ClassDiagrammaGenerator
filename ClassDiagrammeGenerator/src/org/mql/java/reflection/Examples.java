package org.mql.java.reflection;

import java.io.File;
import java.util.Vector;

public class Examples {

	public Examples() {
		exp01();
	}

	public void exp01() {
		PackageExtractor proj = new PackageExtractor("ClassDiagrammeGenerator");
		Vector<String> s=proj.getPackages();
		for (String string : s) {
			PackageExplorer pack = new PackageExplorer(string);
			String[] m = pack.getclasses();
			for (String string2 : m) {
				ClassParser cl = new ClassParser(string2);
				
				cl.getSquelette();
			}
		}
	}

	public static void main(String[] args) {
		new Examples();
	}

}
