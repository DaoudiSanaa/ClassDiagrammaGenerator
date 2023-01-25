package org.mql.java.app;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.mql.java.reflection.ClassParser;

public class Labeled extends JPanel {
	private static final long serialVersionUID = 1L;

	public Labeled(int size, ClassParser cl) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		String h1 = new String(cl.newClass.getVisibility() + " class " + cl.getSimpleName() + ""
				+ cl.newClass.getSuperclass() + " implements ");
		for (int i = 0; i < cl.newClass.getInterfaces().size(); i++) {
			if (i < cl.newClass.getInterfaces().size() - 1) {
				h1 += cl.newClass.getInterfaces().get(i) + " , ";
			} else {
				h1 += cl.newClass.getInterfaces().get(i);
			}
		}
		h1 += "{";
		add(new JLabel(h1));
		for (int i = 0; i < cl.newClass.getFields().size(); i++) {
			JLabel j = new JLabel(cl.newClass.getFields().get(i).getVisibility() + " "
					+ cl.newClass.getFields().get(i).getType() + " " + cl.newClass.getFields().get(i).getName() + " ;");
			add(j);
		}
		add(new JLabel(" "));

		for (int i = 0; i < cl.newClass.getConstructors().size(); i++) {
			String h2 = (" ");
			h2 += cl.newClass.getConstructors().get(i).getVisibility() + " "
					+ cl.newClass.getConstructors().get(i).getName();
			h2 += " ( ";
			for (int j = 0; j < cl.newClass.getConstructors().get(i).getParameters().size(); j++) {
				if (j < cl.newClass.getConstructors().get(i).getParameters().size() - 1)
					h2 += cl.newClass.getConstructors().get(i).getParameters().get(j).getType() + " "
							+ cl.newClass.getConstructors().get(i).getParameters().get(j).getName() + ",";
				else
					h2 += cl.newClass.getConstructors().get(i).getParameters().get(j).getType() + " "
							+ cl.newClass.getConstructors().get(i).getParameters().get(j).getName();
			}
			h2 += " ) ";
			add(new JLabel(h2));
		}
		add(new JLabel(" "));

		for (int i = 0; i < cl.newClass.getMethods().size(); i++) {
			String h2 = (" ");
			h2 += cl.newClass.getMethods().get(i).getVisibility() + " "
					+ cl.newClass.getMethods().get(i).getReturneType() + " "
					+ cl.newClass.getMethods().get(i).getName();
			h2 += " ( ";
			for (int j = 0; j < cl.newClass.getMethods().get(i).getParameters().size(); j++) {
				h2 += cl.newClass.getMethods().get(i).getParameters().get(j).getType() + " "
						+ cl.newClass.getMethods().get(i).getParameters().get(j).getName();
			}
			h2 += " ) ";
			add(new JLabel(h2));
		}

		for (int i = 0; i < cl.newClass.getInternClass().size(); i++) {

		}
		add(new JLabel("}"));
		add(new JLabel(" "));
		add(new JLabel(" "));
	}

	public Labeled(int size, int labelWidth, ClassParser c) {
		this(size, c);
		JLabel l1 = (JLabel) getComponent(0);
		l1.setPreferredSize(new Dimension(labelWidth, l1.getPreferredSize().height));
	}
}
