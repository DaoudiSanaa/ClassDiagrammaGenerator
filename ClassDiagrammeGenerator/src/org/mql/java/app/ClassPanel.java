package org.mql.java.app;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import org.mql.java.reflection.ClassParser;



public class ClassPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private int labelWidth = 400;
	private JPanel container;

	public ClassPanel(String title) {
		this(title, 400);
	}
	
	public ClassPanel(String title, int labelWidth) {
		container = new JPanel();
	
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		add(container);
		EtchedBorder border = new EtchedBorder();
		container.setBorder(new TitledBorder(border, title));
	}

	public void add(Labeled field) {
		container.add(field);
	}

	public void add( int size,ClassParser c) {
		container.add(new Labeled( size, labelWidth,c));
	}
	public void addinfo( int size,ClassParser c) {
		container.add(new Labeledinfo( size, labelWidth,c));
	}
}
