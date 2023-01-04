package org.mql.java.app;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.mql.java.reflection.ClassParser;

public class Labeledinfo extends JPanel {
	private static final long serialVersionUID = 1L;

	public Labeledinfo(int size, ClassParser cl) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(new JLabel("==> L'ensemble des informations : "));
		String m = ("  nomber des Interfaces : " + cl.newClass.getInterfaces().size());
		add(new JLabel(m));

		String m1 = ("  nomber de proprietes : " + cl.newClass.getFields().size());
		add(new JLabel(m1));

		String m2 = ("  nomber des constructors : " + cl.newClass.getConstructors().size());
		add(new JLabel(m2));

		String m3 = ("  nomber des methods : " + cl.newClass.getMethods().size());
		add(new JLabel(m3));

		String m4=("  nomber des classes internes : "+  cl.newClass.getInternClass().size());
		add(new JLabel(m4));
	}

	public Labeledinfo(int size, int labelWidth, ClassParser c) {
		this(size, c);
		JLabel l1 = (JLabel) getComponent(0);
		l1.setPreferredSize(new Dimension(labelWidth, l1.getPreferredSize().height));
	}

}
