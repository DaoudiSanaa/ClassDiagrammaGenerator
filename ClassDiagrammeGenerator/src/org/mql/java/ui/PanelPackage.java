package org.mql.java.ui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import org.mql.java.models.ClassModel;
import org.mql.java.models.PackageModel;
import org.mql.java.reflection.ClassParser;
import org.mql.java.reflection.PackageExplorer;

public class PanelPackage extends JPanel {

	private static final long serialVersionUID = 1L;
	private PackageModel model;
	private JLabel name;

	public PanelPackage(String model) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(new LineBorder(Color.black, 3));
		setPreferredSize(new Dimension(300, 300));
		name = new JLabel(model);
		add(name);

		add(new JLabel("\n "));
		PackageExplorer pe = new PackageExplorer(model);

		for (int j = 0; j < pe.getclasses().length; j++) {

			add(new JLabel(pe.getclasses()[j]));
		}

	}

}
