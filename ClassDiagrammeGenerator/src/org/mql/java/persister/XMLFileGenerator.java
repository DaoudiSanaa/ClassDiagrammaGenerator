package org.mql.java.persister;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class XMLFileGenerator {

	public XMLFileGenerator(String fileName) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("resources/"+fileName+".xml"));
			String o = "<element></element>";
			out.write(o);
			out.append(o); // out.write(o.toString())
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new XMLFileGenerator("file");
	}
}
