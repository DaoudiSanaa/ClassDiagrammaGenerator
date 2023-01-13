package org.mql.java.ui;

import javax.swing.JFrame;

public class FormDiagramme extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private Form form;

	public FormDiagramme() {
		exp01();
		setContentPane(form);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	

	private void exp01() 
	{
		
		
	}
	public static void main(String[] args) {
		new FormDiagramme();
	}
}