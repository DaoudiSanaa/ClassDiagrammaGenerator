package org.mql.java.xml.parser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.mql.java.models.ClassModel;
import org.mql.java.models.FieldModel;
import org.mql.java.models.PackageModel;
import org.mql.java.models.ProjectModel;
import org.mql.java.ui.FormClass;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class FormSAXParser extends DefaultHandler {
	private boolean nameProject = false;
	private boolean namePackage = false;
	private boolean returnType = false;

	private boolean type = false;
	private boolean name = false;
	private boolean vis = false;
	public List<ClassModel> classModel;
	public List<ProjectModel> projectModels;
	public List<PackageModel> packageModels;
	public List<FieldModel> fieldModels;

	public FormSAXParser(String source) throws ParserConfigurationException, SAXException, IOException {

		SAXParserFactory factory = SAXParserFactory.newDefaultInstance();

		SAXParser parser = factory.newSAXParser();
		parser.parse(source, this);

	}

	public void startDocument() throws SAXException {
		System.out.println(">> Start Document");

	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equals("nameProject")) {
			nameProject = true;
		} else if (qName.equals("namePackage")) {
			namePackage = true;
		} else if (qName.equals("visibility")) {
			vis = true;
		} else if (qName.equals("type")) {
			type = true;

		} else if (qName.equals("name")) {
			name = true;

		}

		else if (qName.equals("returnType")) {
			returnType = true;

		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("nameProject")) {
			nameProject = false;
		} else if (qName.equals("namePackage")) {
			namePackage = false;
		}

		else if (qName.equals("type")) {
			type = false;
		}

		else if (qName.equals("name")) {
			name = false;
		}

		else if (qName.equals("returnType")) {
			returnType = false;
		}

	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (nameProject) {
			String n = new String(ch, start, length);

			System.out.println(" " + n);
		} else if (namePackage) {
			String n = new String(ch, start, length);
			System.out.println(" " + n);
		}

		else if (vis) {
			String n = new String(ch, start, length);
			System.out.print(" " + n);
		} else if (type) {
			String n = new String(ch, start, length);
			System.out.print(" " + n);
		}

		else if (name) {
			String s = new String(ch, start, length);
			System.out.println(" " + s);
		}

		else if (returnType) {
			String n = new String(ch, start, length);
			System.out.print(" " + n);
		}
	}

	public void endDocument() throws SAXException {
		System.out.println(">> End Document");
	}

	public static void main(String[] args) {
		try {
			new FormSAXParser("resources/file.xml");
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
}
