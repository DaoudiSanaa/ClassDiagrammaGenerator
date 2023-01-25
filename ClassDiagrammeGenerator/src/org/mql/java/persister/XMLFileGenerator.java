package org.mql.java.persister;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.mql.java.reflection.ClassParser;

public class XMLFileGenerator {

	public XMLFileGenerator(String fileName, String xmlvalue) {
		try {
			FileWriter fw = new FileWriter(fileName);
			ClassParser cp = new ClassParser("org.mql.java.models.ClassModel");

			fw.write(xmlvalue);
			fw.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// new XMLFileGenerator("resources/file.xml");
	}
}
