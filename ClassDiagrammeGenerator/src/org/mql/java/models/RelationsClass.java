package org.mql.java.models;

import java.util.List;

public class RelationsClass {
private String name;
private String extension;
private List<String> implementss;
private List<String> utilisation;
private List<String> agrégation;

public RelationsClass(String name, String extension) {
	super();
	this.name = name;
	this.extension = extension;
}

public RelationsClass() {
	super();
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getExtension() {
	return extension;
}
public void setExtension(String extension) {
	this.extension = extension;
}
public List<String> getImplementss() {
	return implementss;
}
public void setImplementss(List<String> implementss) {
	this.implementss = implementss;
}
public List<String> getUtilisation() {
	return utilisation;
}
public void setUtilisation(List<String> utilisation) {
	this.utilisation = utilisation;
}
public List<String> getAgrégation() {
	return agrégation;
}
public void setAgrégation(List<String> agrégation) {
	this.agrégation = agrégation;
}




}
