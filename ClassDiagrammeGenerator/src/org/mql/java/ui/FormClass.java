package org.mql.java.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import org.mql.java.models.ClassModel;
import org.mql.java.reflection.ClassParser;
import org.mql.java.reflection.PackageExplorer;

public class FormClass extends JPanel {
	private static final long serialVersionUID = 1L;

	public FormClass(Vector<String> projModel) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setPreferredSize(new Dimension(600, 3000));
		setBackground(Color.gray);
		for (int i = 0; i < projModel.size(); i++) {
			PackageExplorer pe = new PackageExplorer(projModel.get(i));

			for (int j = 0; j < pe.getclasses().length; j++) {
				ClassParser cp = new ClassParser(pe.getclasses()[j]);
				add(new PanelClass(cp.newClass));
			}
		}
	}
}

