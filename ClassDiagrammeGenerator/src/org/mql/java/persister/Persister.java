package org.mql.java.persister;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import org.mql.java.models.ClassModel;
import org.mql.java.models.FieldModel;
import org.mql.java.models.MethodModel;
import org.mql.java.models.PackageModel;
import org.mql.java.reflection.ClassParser;
import org.mql.java.reflection.PackageExplorer;
import org.mql.java.reflection.PackageExtractor;

public class Persister {
	private PackageModel pack;
	private ClassModel classe;

	public Persister(ClassModel classe) {
		this.classe = classe;
		System.out.println(classToXml(classe));
	}

	public Persister(String nameproj) {
		System.out.println(projectToXml(nameproj));
		XMLFileGenerator xml = new XMLFileGenerator("resources/file.xml", projectToXml(nameproj));
	}

	public String classToXml(ClassModel classe) {
		String xmlValue = "";

		java.lang.reflect.Field[] fields = classe.getClass().getDeclaredFields();

		xmlValue += "<class>";

		for (java.lang.reflect.Field field : fields) {
			if (field.getName().equals("fields")) {
				xmlValue += "\n<properties>";

				for (int i = 0; i < classe.getFields().size(); i++) {
					xmlValue += "\n<property>";
					xmlValue += propertyToXml(classe.getFields().get(i));
					xmlValue += "\n</property>";
				}
				xmlValue += "\n</properties>";
			} else if (field.getName().equals("constructors")) {

				xmlValue += "\n<constructors>";
				for (int i = 0; i < classe.getConstructors().size(); i++) {
					xmlValue += constructorToXml(classe.getConstructors().get(i));
				}
				xmlValue += "\n</constructors>";
			} else if (field.getName().equals("methods")) {

				xmlValue += "\n<methods>";
				for (int i = 0; i < classe.getMethods().size(); i++) {
					xmlValue += methodToXml(classe.getMethods().get(i));
				}
				xmlValue += "\n</methods>";
			} else if (field.getName().equals("interfaces")) {

				xmlValue += "\n<interfaces>";
				for (int i = 0; i < classe.getInterfaces().size(); i++) {
					xmlValue += "\n<" + field.getName() + ">" + classe.getInterfaces().get(i) + "</" + field.getName()
							+ ">";
				}
				xmlValue += "\n</interfaces>";
			} else if (field.getName().equals("internClass")) {

				xmlValue += "\n<internClass>";
				for (int i = 0; i < classe.getInternClass().size(); i++) {
					xmlValue += "\n<" + field.getName() + ">" + classe.getInternClass().get(i) + "</" + field.getName()
							+ ">";
				}
				xmlValue += "\n</internClass>";
			} else {
				try {
					field.setAccessible(true);
					xmlValue += "\n<" + field.getName() + ">" + field.get(classe) + "</" + field.getName() + ">";
					field.setAccessible(false);

				} catch (Exception e) {

					System.out.println("ERREUR : " + e.getMessage());
				}
			}

		}

		return xmlValue + "\n</class>\n";
	}

	public String methodToXml(MethodModel methodModel) {
		String xmlValue = "";

		java.lang.reflect.Field[] fields = methodModel.getClass().getDeclaredFields();

		xmlValue += "\n<method>";

		for (java.lang.reflect.Field field : fields) {

			if (field.getName().equals("parameters")) {
				xmlValue += "\n<parameters>";

				for (int i = 0; i < methodModel.getParameters().size(); i++) {
					xmlValue += "<parameter>";
					xmlValue += propertyToXml(methodModel.getParameters().get(i));
					xmlValue += "\n</parameter>";
				}
				xmlValue += "\n</parameters>";
			} else {
				try {
					field.setAccessible(true);
					xmlValue += "\n<" + field.getName() + ">" + field.get(methodModel) + "</" + field.getName() + ">";
					field.setAccessible(false);

				} catch (Exception e) {

					System.out.println("ERREUR : " + e.getMessage());
				}
			}
		}

		return xmlValue + "\n</method>";
	}

	public String constructorToXml(MethodModel methodModel) {
		String xmlValue = "";

		java.lang.reflect.Field[] fields = methodModel.getClass().getDeclaredFields();

		xmlValue += "<constructor>";

		for (java.lang.reflect.Field field : fields) {

			if (field.getName().equals("parameters")) {
				xmlValue += "\n<parameters>";

				for (int i = 0; i < methodModel.getParameters().size(); i++) {
					xmlValue += "<parameter>";
					xmlValue += propertyToXml(methodModel.getParameters().get(i));
					xmlValue += "</parameter>\n";
				}
				xmlValue += "\n</parameters>\n";
			} else {
				try {
					field.setAccessible(true);
					xmlValue += "\n<" + field.getName() + ">" + field.get(methodModel) + "</" + field.getName() + ">";
					field.setAccessible(false);

				} catch (Exception e) {

					System.out.println("ERREUR : " + e.getMessage());
				}
			}
		}

		return xmlValue + "</constructor>";
	}

	public String propertyToXml(FieldModel property) {

		String xmlValue = "";

		java.lang.reflect.Field[] fields = property.getClass().getDeclaredFields();

		for (java.lang.reflect.Field field : fields) {
			try {
				field.setAccessible(true);
				xmlValue += "\n<" + field.getName() + ">" + field.get(property) + "</" + field.getName() + ">";
				field.setAccessible(false);

			} catch (Exception e) {

				System.out.println("ERREUR : " + e.getMessage());
			}
		}

		return xmlValue;

	}

	public String packageToXml(String namepack) {
		String xmlValue = "";
		xmlValue += "<package>";
		xmlValue += "<namePackage>" + namepack + "</namePackage>";
		PackageExplorer pc = new PackageExplorer(namepack);
		xmlValue += "<classes>";
		for (int i = 0; i < pc.getclasses().length; i++) {

			ClassParser cp = new ClassParser(pc.getclasses()[i]);
			xmlValue += classToXml(cp.newClass);

		}
		xmlValue += "\n</classes>";

		return xmlValue + "</package>";
	}

	public String projectToXml(String nameproj) {
		String xmlValue = "";
		xmlValue += "<project>";
		xmlValue += "<nameProject>" + nameproj + "</nameProject>";
		PackageExtractor pc = new PackageExtractor(nameproj);
		xmlValue += "<packages>";
		for (int i = 0; i < pc.getPackages().size(); i++) {

			xmlValue += packageToXml(pc.getPackages().get(i));

		}
		xmlValue += "\n</packages>";
		return xmlValue + "</project>";
	}

	public static void main(String[] args) {

		/*
		 * PackageExplorer pc = new PackageExplorer("org.mql.java.models"); for(int i =
		 * 0; i < pc.getclasses().length; i++) { ClassParser cp = new
		 * ClassParser(pc.getclasses()[i]); Persister persister = new
		 * Persister(cp.newClass); }
		 */

		new Persister("ClassDiagrammeGenerator");
	}

}
