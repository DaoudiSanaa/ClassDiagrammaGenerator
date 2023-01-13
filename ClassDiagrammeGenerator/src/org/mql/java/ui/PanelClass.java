
package org.mql.java.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelClass extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel name;
	private List<JLabel> field;
	private List<JLabel> method;
	
	public PanelClass(String label) {
	   setLayout(new FlowLayout(FlowLayout.LEFT));
		
	   name = new JLabel();
   
	   add(name);
	   
	  /* field = new JLabel();
	   method=new JLabel();	
		add(field);
		add(method);
		*/
	
	}

	public PanelClass(String label, int size, int labelWidth) {
		this(label);
		JLabel l1 = (JLabel)getComponent(0);
	l1.setPreferredSize(new Dimension(labelWidth, l1.getPreferredSize().height));
	}
			
		}
	
