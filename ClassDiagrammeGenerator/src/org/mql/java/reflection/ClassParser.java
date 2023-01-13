package org.mql.java.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.Vector;

public class ClassParser {
	private Class<?> cl;
	public org.mql.java.models.ClassModel newClass;

	public ClassParser(String name) {
		try {
			cl = Class.forName(name);
			getSquelette();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String getSimpleName() {
		return cl.getSimpleName();
	}

	public List<org.mql.java.models.MethodModel> getAllConstructor() {
		int index = 0;
		Constructor<?> c[] = cl.getDeclaredConstructors();
		List<org.mql.java.models.MethodModel> ml = new Vector<>();
		for (Constructor<?> constructor : c) {
			ml.add(new org.mql.java.models.MethodModel(Modifier.toString(constructor.getModifiers()), cl.getSimpleName()));
			Parameter p[] = constructor.getParameters();
			List<org.mql.java.models.FieldModel> prl = new Vector<>();
			for (Parameter parameter : p) {
				prl.add(new org.mql.java.models.FieldModel(parameter.getName(), parameter.getType().getSimpleName()));
			}
			ml.get(index).setParameters(prl);
			index++;
		}
		return ml;
	}

	public List<org.mql.java.models.MethodModel> getMethods() {
		int index = 0;
		Method m1[] = cl.getDeclaredMethods();
		List<org.mql.java.models.MethodModel> ml = new Vector<>();
		for (Method method : m1) {
			ml.add(new org.mql.java.models.MethodModel(Modifier.toString(method.getModifiers()),
					method.getReturnType().getSimpleName(), method.getName()));
			Parameter pm[] = method.getParameters();
			List<org.mql.java.models.FieldModel> mtl = new Vector<>();
			for (Parameter parameter : pm) {
				mtl.add(new org.mql.java.models.FieldModel(parameter.getName(), parameter.getType().getSimpleName()));
			}
			ml.get(index).setParameters(mtl);
			index++;
		}
		return ml;
	}

	public List<org.mql.java.models.FieldModel> getFields() {
		Field field[] = cl.getDeclaredFields();
		List<org.mql.java.models.FieldModel> fl = new Vector<>();
		for (Field field2 : field) {
			fl.add(new org.mql.java.models.FieldModel(Modifier.toString(field2.getModifiers()), field2.getName(),
					field2.getType().getSimpleName()));
		}
		return fl;
	}

	public String getSuperclass() {
		if (!cl.getSuperclass().getSimpleName().equals("Object")) {
			return " extends " + cl.getSuperclass().getSimpleName() + " ";
		}
		return " ";
	}

	public List<String> getInterfaces() {
		Class<?>[] cla = cl.getInterfaces();
		List<String> inter = new Vector<String>();
		if (cla.length > 0) {
			for (Class<?> class1 : cla) {
				inter.add(class1.getSimpleName());
			}
			return inter;
		}
		return inter;
	}

	public List<String> getInternClass() {
		Class<?>[] cla = cl.getDeclaredClasses();
		List<String> inter = new Vector<String>();
		for (Class<?> class1 : cla) {
			inter.add(class1.getName());
		}
		return inter;
	}

	public void getSquelette() {
		newClass = new org.mql.java.models.ClassModel(Modifier.toString(cl.getModifiers()), cl.getTypeName());
		newClass.setSuperclass(getSuperclass());
		newClass.setInterfaces(getInterfaces());
		newClass.setFields(getFields());
		newClass.setConstructors(getAllConstructor());
		newClass.setMethods(getMethods());
		newClass.setInternClass(getInternClass());
	/*	System.out.print(newClass.getVisibility());
		System.out.print(" class ");
		System.out.print(cl.getSimpleName());
		System.out.print(getSuperclass());

		if (newClass.getInterfaces().size() > 0) {
			System.out.print("implements ");
			for (int i = 0; i < newClass.getInterfaces().size(); i++) {
				if (i < newClass.getInterfaces().size() - 1) {
					System.out.print(newClass.getInterfaces().get(i) + " , ");
				} else {
					System.out.print(newClass.getInterfaces().get(i));
				}
			}
		}
		System.out.println("{");
		for (int i = 0; i < newClass.getFields().size(); i++) {
			System.out.println(newClass.getFields().get(i).getVisibility() + " " + newClass.getFields().get(i).getType()
					+ " " + newClass.getFields().get(i).getName() + " ;");
		}
		System.out.println("");
		for (int i = 0; i < newClass.getConstructors().size(); i++) {
			System.out.print(newClass.getConstructors().get(i).getVisibility() + " "
					+ newClass.getConstructors().get(i).getName());
			System.out.print(" ( ");
			for (int j = 0; j < newClass.getConstructors().get(i).getParameters().size(); j++) {
				if (j < newClass.getConstructors().get(i).getParameters().size() - 1)
					System.out.print(newClass.getConstructors().get(i).getParameters().get(j).getType() + " "
							+ newClass.getConstructors().get(i).getParameters().get(j).getName() + ",");
				else
					System.out.print(newClass.getConstructors().get(i).getParameters().get(j).getType() + " "
							+ newClass.getConstructors().get(i).getParameters().get(j).getName());
			}
			System.out.println(" ) ");
		}
		System.out.println("");
		for (int i = 0; i < newClass.getMethods().size(); i++) {
			System.out.print(newClass.getMethods().get(i).getVisibility() + " "
					+ newClass.getMethods().get(i).getReturneType() + " " + newClass.getMethods().get(i).getName());
			System.out.print(" (");
			for (int j = 0; j < newClass.getMethods().get(i).getParameters().size(); j++) {
				System.out.print(newClass.getMethods().get(i).getParameters().get(j).getType() + " "
						+ newClass.getMethods().get(i).getParameters().get(j).getName());
			}
			System.out.println(")");
		}
		for (int i = 0; i < newClass.getInternClass().size(); i++) {
			System.out.println("");
			new ClassParser(newClass.getInternClass().get(i));
		}

		System.out.println("}");*/

	}
/*
	public static void main(String[] args) {

		new ClassParser("org.mql.java.models.MethodModel");
	}*/
}
