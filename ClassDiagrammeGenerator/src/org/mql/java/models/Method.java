package org.mql.java.models;


import java.util.List;

public class Method {
	
	private String visibility;
	private String returnType;
	private String name;
	private List<Field> parameters;
	public Method(String visibility, String returne, String name, List<Field> parameters) {
		super();
		this.visibility = visibility;
		this.returnType = returne;
		this.name = name;
		this.parameters = parameters;
	}
	
	public Method(String visibility, String name) {
		super();
		this.visibility = visibility;
		this.name = name;
	}

	public Method(String visibility, String returnType, String name) {
		super();
		this.visibility = visibility;
		this.returnType = returnType;
		this.name = name;
	}

	public Method(String visibility, String name, List<Field> parameters) {
		super();
		this.visibility = visibility;
		this.name = name;
		this.parameters = parameters;
	}
	public Method() {
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

	public List<Field> getParameters() {
		return parameters;
	}

	public void setParameters(List<Field> parameters) {
		this.parameters = parameters;
	}
	
}

