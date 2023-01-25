package org.mql.java.ui;

import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import org.mql.java.models.ClassModel;
import org.mql.java.persister.Persister;
import org.mql.java.reflection.ClassParser;
import org.mql.java.reflection.PackageExplorer;
import org.mql.java.reflection.PackageExtractor;

public class FormDiagrammeClass extends JFrame {

	private static final long serialVersionUID = 1L;

	private FormClass form;

	public FormDiagrammeClass(Vector<String> projModel) {
		form = new FormClass(projModel);
		JScrollPane sc = new JScrollPane(form);
		sc.setPreferredSize(new Dimension(1000, 500));
		setContentPane(sc);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	public static void main(String[] args) {
		
		/*
		 * PackageExplorer pe = new PackageExplorer("org.mql.java.models");
		 * new FormDiagramme(pe.getclasses());
		 */
		PackageExtractor pc = new PackageExtractor("ClassDiagrammeGenerator");
		new FormDiagrammeClass(pc.getPackages());

	}
}
