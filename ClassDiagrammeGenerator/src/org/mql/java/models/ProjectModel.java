package org.mql.java.models;

import java.util.Vector;

public class ProjectModel {
private String name;
private Vector<PackageModel> packages;

	public ProjectModel() {
		// TODO Auto-generated constructor stub
	}
	
	public ProjectModel(String name, Vector<PackageModel> packages) {
		super();
		this.name = name;
		this.packages = packages;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Vector<PackageModel> getPackages() {
		return packages;
	}
	
	public void setPackages(Vector<PackageModel> packages) {
		this.packages = packages;
	}

}
