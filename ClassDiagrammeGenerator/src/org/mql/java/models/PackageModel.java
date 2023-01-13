package org.mql.java.models;

import java.util.Vector;

public class PackageModel {
private String name;
private Vector<ClassModel> classModels;

 public PackageModel(String name, Vector<ClassModel> classModels) {
	super();
	this.name = name;
	this.classModels = classModels;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Vector<ClassModel> getClassModels() {
	return classModels;
}

public void setClassModels(Vector<ClassModel> classModels) {
	this.classModels = classModels;
}

public PackageModel() {
		// TODO Auto-generated constructor stub
	}

}
