package org.mql.java.models;

import java.util.List;

public class ClassModel {
	
	private String visibility;
	private String name;
	private List<Field> fields;
	private String superclass;
	private List<String> interfaces;
	private List<Method> constructors;
	private List<Method> methods;
	private List<String> internClass;
	
	public ClassModel(String visibility, String name) {
		super();
		this.visibility = visibility;
		this.name = name;
	}

	public ClassModel(String visibility, String name, List<Field> fields, String superclass, List<String> interfaces,
			List<Method> constructors, List<Method> methods) {
		super();
		this.visibility = visibility;
		this.name = name;
		this.fields = fields;
		this.superclass = superclass;
		this.interfaces = interfaces;
		this.constructors = constructors;
		this.methods = methods;
		
	}

	//anfeker karim
	
	public List<String> getInternClass() {
		return internClass;
	}

	public void setInternClass(List<String> internClass) {
		this.internClass = internClass;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	public String getSuperclass() {
		return superclass;
	}

	public void setSuperclass(String superclass) {
		this.superclass = superclass;
	}

	public List<String> getInterfaces() {
		return interfaces;
	}

	public void setInterfaces(List<String> interfaces) {
		this.interfaces = interfaces;
	}

	public List<Method> getConstructors() {
		return constructors;
	}

	public void setConstructors(List<Method> constructors) {
		this.constructors = constructors;
	}

	public List<Method> getMethods() {
		return methods;
	}

	public void setMethods(List<Method> methods) {
		this.methods = methods;
	}

	}
	

