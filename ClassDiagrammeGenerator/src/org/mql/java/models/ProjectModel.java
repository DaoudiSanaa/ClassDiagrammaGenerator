package org.mql.java.models;

import java.util.Vector;

public class ProjectModel {
private String nameProject;
private Vector<PackageModel> packages;

	public ProjectModel() {
		// TODO Auto-generated constructor stub
	}
	
	public ProjectModel(String name, Vector<PackageModel> packages) {
		super();
		this.nameProject = name;
		this.packages = packages;
	}
	
	public String getName() {
		return nameProject;
	}
	
	public void setName(String name) {
		this.nameProject = name;
	}
	
	public Vector<PackageModel> getPackages() {
		return packages;
	}
	
	public void setPackages(Vector<PackageModel> packages) {
		this.packages = packages;
	}

}
