package org.mql.java.models;


import java.util.List;

public class MethodModel {
	
	private String visibility;
	private String returnType;
	private String name;
	private List<FieldModel> parameters;
	
	public MethodModel(String visibility, String returne, String name, List<FieldModel> parameters) {
		super();
		this.visibility = visibility;
		this.returnType = returne;
		this.name = name;
		this.parameters = parameters;
	}
	
	public MethodModel(String visibility, String name) {
		super();
		this.visibility = visibility;
		this.name = name;
	}

	public MethodModel(String visibility, String returnType, String name) {
		super();
		this.visibility = visibility;
		this.returnType = returnType;
		this.name = name;
	}

	public MethodModel(String visibility, String name, List<FieldModel> parameters) {
		super();
		this.visibility = visibility;
		this.name = name;
		this.parameters = parameters;
	}
	public MethodModel() {
		super();
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public String getReturneType() {
		return returnType;
	}

	public void setReturneType(String returne) {
		this.returnType = returne;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FieldModel> getParameters() {
		return parameters;
	}

	public void setParameters(List<FieldModel> parameters) {
		this.parameters = parameters;
	}
	
}

