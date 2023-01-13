package org.mql.java.models;

public class FieldModel {
	
	private String visibility;
	private String name;
	private String type;
	
	public FieldModel() {
		// TODO Auto-generated constructor stub
	}
	public FieldModel(String visibility, String name , String type) {
		super();
		this.visibility = visibility;
		this.name = name;
		this.type = type;
		
	}
	
	public FieldModel(String name, String type) {
		super();
		this.name = name;
		this.type = type;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
