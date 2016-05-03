package org.theradoc.scenariobuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JScrollPane;

public class MicroWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6821924617237572026L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MicroWindow frame = new MicroWindow(args[0]);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param string 
	 */
	public MicroWindow(String hl7) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1222, 805);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPaneFullMicro = new JScrollPane();
		scrollPaneFullMicro.setBounds(12, 13, 1180, 734);
		contentPane.add(scrollPaneFullMicro);
		
		JTextArea taFullMicro = new JTextArea();
		taFullMicro.setEditable(false);
		taFullMicro.setWrapStyleWord(true);
		taFullMicro.setText(hl7);
		taFullMicro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPaneFullMicro.setViewportView(taFullMicro);
		taFullMicro.setCaretPosition(0);
	}
}
