package swing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//import java.awt.*;
//import javax.swing.*;

public class Ex17_Swing_Basic {
	public static void main(String[] args) {
		JFrame f = new JFrame("Swing");
		f.setSize(500, 400);
		JPanel p = new JPanel();
		p.setBackground(Color.green);
		JButton btn = new JButton("btn");
		
		p.add(btn);
		f.getContentPane().add(p);
		f.setVisible(true);
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("swing");
			}
		});
		
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose(); //메모리 제거
			}
			
		});
	}

}
