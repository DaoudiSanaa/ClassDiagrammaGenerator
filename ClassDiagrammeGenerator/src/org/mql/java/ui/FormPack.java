package org.mql.java.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.JPanel;

import org.mql.java.reflection.ClassParser;
import org.mql.java.reflection.PackageExplorer;

public class FormPack extends JPanel {
	private static final long serialVersionUID = 1L;

	public FormPack(Vector<String> projModel) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setPreferredSize(new Dimension(600, 3000));

		for (int i = 0; i < projModel.size(); i++) {

			add(new PanelPackage(projModel.get(i)));

		}

	}

}
