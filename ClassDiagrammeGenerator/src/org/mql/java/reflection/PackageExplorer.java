package org.mql.java.reflection;

import java.io.File;
import java.util.Vector;

import org.mql.java.models.PackageModel;

public class PackageExplorer {
	private String[] s;
	private String packageName;
	private String packagepath;
	private PackageModel newmodel;
	Vector<String> v = new Vector<String>();

	public PackageExplorer(String packageName) {
		// s = getClassList("org.mql.java.app");
		String classPath = System.getProperty("java.class.path");
		System.out.println(classPath);
		this.packageName = packageName;
		packagepath = packageName.replace(".", "/");
		System.out.println(packagepath);

		File directory = new File(classPath + "/" + packagepath);
		System.out.println(directory.isDirectory());
		s = getClassList(directory);

	}

	public String[] getClassList(File directory) {

		File f[] = directory.listFiles();

		for (int i = 0; i < f.length; i++) {

			if (f[i].isFile() && f[i].getName().endsWith(".class")) {

				String name = f[i].getName().replace(".class", "");
				v.add(packageName + "." + name);

			} else if (f[i].isDirectory()) {

				getClassList(f[i]);
			}
		}

		String t[] = new String[v.size()];
		v.toArray(t);
		return t;

	}

	public String[] getclasses() {
		return s;
	}

}
