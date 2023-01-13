package org.mql.java.persister;



import org.mql.java.models.ClassModel;
import org.mql.java.models.FieldModel;
import org.mql.java.reflection.ClassParser;

public class Persister {

	private ClassModel classe;
	
	public Persister(ClassModel classe) {
		this.classe = classe;
		classToXml();
	}
	
	public String classToXml() 
	{
		String xmlValue = "";
		
		java.lang.reflect.Field [] fields = classe.getClass().getDeclaredFields();
		
		xmlValue +="<class>";
		
		for (java.lang.reflect.Field field : fields) {
			
			if(!field.getType().getName().equals("java.lang.String")) 
			{
				try {
					field.setAccessible(true);
					xmlValue += "\n<"+field.getName()+">"+field.get(classe)+"</"+field.getName()+">";
					field.setAccessible(false);
					
				} catch (Exception e) {
					
					System.out.println("ERREUR : "+e.getMessage());
				}
			}
			
			else if(field.getName().equals("fields"))
			{
				xmlValue +="\n<properties>";
				for (int i = 0; i < classe.getFields().size(); i++) {
					xmlValue += propertyToXml(classe.getFields().get(i));
				}
				xmlValue +="\n</properties>";
			}
		
			
		
		}
		
		return xmlValue+"\n</class>";
	}
	
	private String propertyToXml(FieldModel property)
	{
		
		String xmlValue = "";
		
		java.lang.reflect.Field [] fields = property.getClass().getDeclaredFields();
		
		xmlValue +="<property>";
		
		for (java.lang.reflect.Field field : fields) {
			try {
				field.setAccessible(true);
				xmlValue += "\n<"+field.getName()+">"+field.get(classe)+"</"+field.getName()+">";
				field.setAccessible(false);
				
			} catch (Exception e) {
				
				System.out.println("ERREUR : "+e.getMessage());
			}
		}
		
		return xmlValue+"</property>";
			
	}
	
	

	public static void main(String[] args) {
		ClassParser cp=new ClassParser("org.mql.java.models.ClassModel");
		
		Persister persister = new Persister(cp.newClass);
		System.out.println(persister.classToXml());
		
	}
	
	

}
