package org.mql.java.app;



import javax.swing.JFrame;
import javax.swing.JPanel;

import org.mql.java.reflection.ClassParser;

public class ClassParserFrame  extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private ClassPanel form;

	public ClassParserFrame() {
		exp01();
		setContentPane(form);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	


	private void exp01() 
	{
		form = new ClassPanel(" Le squelette d'une classe : ",400);
		form.add(400,new ClassParser("org.mql.java.models.Class"));
		form.addinfo(400,new ClassParser("org.mql.java.models.Class"));
		
	}
	public static void main(String[] args) {
		new ClassParserFrame();
	}


	

}
