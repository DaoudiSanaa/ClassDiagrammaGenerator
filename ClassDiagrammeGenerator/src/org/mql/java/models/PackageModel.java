package org.mql.java.models;

import java.util.Vector;

public class PackageModel {
private String namePackage;
private Vector<ClassModel> classModels;

 public PackageModel(String name, Vector<ClassModel> classModels) {
	super();
	this.namePackage = name;
	this.classModels = classModels;
}

public String getName() {
	return namePackage;
}

public void setName(String name) {
	this.namePackage = name;
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
