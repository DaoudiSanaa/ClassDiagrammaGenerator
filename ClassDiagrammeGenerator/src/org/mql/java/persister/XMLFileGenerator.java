package org.mql.java.persister;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class XMLFileGenerator {

	public XMLFileGenerator(String fileName) {
	try {
		FileWriter fw= new FileWriter(fileName);
		fw.write("<hii></hii>");
		fw.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
	public static void main(String[] args) {
		new XMLFileGenerator("resources/file.xml");
	}
}
