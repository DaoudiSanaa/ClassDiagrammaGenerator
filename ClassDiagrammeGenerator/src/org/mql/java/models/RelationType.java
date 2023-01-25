package org.mql.java.models;

public enum RelationType {
	
		AGREGATION(1,"agrégation"),
		UTILISATION(2,"utilisation"),
		IMPLEMENT(2,"implements"),
		EXTENSION(3,"extension");
		
		
		private int id;
		private String name;
		
		private RelationType(int id,String name) {
			this.id = id;
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		

}
