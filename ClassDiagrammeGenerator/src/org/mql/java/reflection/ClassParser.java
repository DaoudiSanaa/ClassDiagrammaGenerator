package org.mql.java.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.Vector;

import org.mql.java.models.ClassModel;
import org.mql.java.models.FieldModel;
import org.mql.java.models.MethodModel;
import org.mql.java.models.RelationsClass;

public class ClassParser {
	private Class<?> cl;
	public ClassModel newClass;
	public RelationsClass relationsClass;
	public List<String> agrégationlist = new Vector<String>();
	public List<String> utilisationlist = new Vector<String>();

	public ClassParser(String name) {
		try {
			cl = Class.forName(name);
			getSquelette();

			if (cl.getSuperclass().getClassLoader() != null) {
				relationsClass = new RelationsClass(name, newClass.getSuperclass());
			} else {
				relationsClass = new RelationsClass(name, " ");
			}

			relationsClass.setAgrégation(agrégationlist);
			relationsClass.setUtilisation(utilisationlist);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String getSimpleName() {
		return cl.getSimpleName();
	}

	public List<MethodModel> getAllConstructor() {
		int index = 0;
		Constructor<?> c[] = cl.getDeclaredConstructors();
		List<MethodModel> ml = new Vector<>();
		for (Constructor<?> constructor : c) {
			ml.add(new MethodModel(Modifier.toString(constructor.getModifiers()), cl.getSimpleName()));
			Parameter p[] = constructor.getParameters();
			List<FieldModel> prl = new Vector<>();
			for (Parameter parameter : p) {
				prl.add(new FieldModel(parameter.getName(), parameter.getType().getSimpleName()));
			}
			ml.get(index).setParameters(prl);
			index++;
		}
		return ml;
	}

	public List<MethodModel> getMethods() {
		int index = 0;
		Method m1[] = cl.getDeclaredMethods();
		List<MethodModel> ml = new Vector<>();
		for (Method method : m1) {
			ml.add(new MethodModel(Modifier.toString(method.getModifiers()), method.getReturnType().getSimpleName(),
					method.getName()));
			Parameter pm[] = method.getParameters();
			List<FieldModel> mtl = new Vector<>();
			for (Parameter parameter : pm) {
				mtl.add(new FieldModel(parameter.getName(), parameter.getType().getSimpleName()));
				if (parameter.getType().getClassLoader() != null) {
					utilisationlist.add(parameter.getType().getName());
				}
			}
			ml.get(index).setParameters(mtl);
			index++;
		}
		return ml;
	}

	public List<FieldModel> getFields() {
		Field field[] = cl.getDeclaredFields();
		List<FieldModel> fl = new Vector<>();
		for (Field field2 : field) {
			fl.add(new FieldModel(Modifier.toString(field2.getModifiers()), field2.getName(),
					field2.getType().getSimpleName()));
			if (field2.getType().getClassLoader() != null) {
				agrégationlist.add(field2.getType().getName());

			}
		}
		return fl;
	}

	public String getSuperclass() {
		if (!cl.getSuperclass().getSimpleName().equals("Object")) {
			return cl.getSuperclass().getSimpleName() + " ";
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
		newClass = new ClassModel(Modifier.toString(cl.getModifiers()), cl.getTypeName());
		newClass.setSuperclass(getSuperclass());
		newClass.setInterfaces(getInterfaces());
		newClass.setFields(getFields());
		newClass.setConstructors(getAllConstructor());
		newClass.setMethods(getMethods());
		newClass.setInternClass(getInternClass());

	}

	public static void main(String[] args) {

		new ClassParser("org.mql.java.models.ClassModel");

	}
}
