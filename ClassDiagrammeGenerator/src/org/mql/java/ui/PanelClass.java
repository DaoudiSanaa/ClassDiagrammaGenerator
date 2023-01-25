package org.mql.java.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import org.mql.java.models.ClassModel;

public class PanelClass extends JPanel {
	private static final long serialVersionUID = 1L;
	private ClassModel classModel;
	private JLabel name;

	public PanelClass(ClassModel classModel) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.lightGray);
		name = new JLabel(classModel.getName());
		add(name);
		EtchedBorder border = new EtchedBorder();
		name.setBorder((new LineBorder(Color.white, 3)));
		name.setLayout(new FlowLayout(FlowLayout.CENTER));

		setBorder(new LineBorder(Color.black, 3));
		add(new JLabel("\n"));
		for (int i = 0; i < classModel.getFields().size(); i++) {
			add(new JLabel(
					"- " + classModel.getFields().get(i).getName() + " : " + classModel.getFields().get(i).getType()));
		}
		add(new JLabel("\n"));
		for (int i = 0; i < classModel.getMethods().size(); i++) {
			add(new JLabel("+ " + classModel.getMethods().get(i).getName() + "() : "
					+ classModel.getMethods().get(i).getReturneType()));
		}

	}

}
