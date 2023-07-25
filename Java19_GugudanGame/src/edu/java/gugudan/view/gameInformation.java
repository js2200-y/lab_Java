package edu.java.gugudan.view;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;

public class gameInformation extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void showInformation() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gameInformation frame = new gameInformation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public gameInformation() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 681, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("왜 구구단을 외워야 할까요???");
		lblNewLabel.setFont(new Font("D2Coding", Font.BOLD, 20));
		lblNewLabel.setToolTipText("");
		lblNewLabel.setBounds(12, 122, 298, 45);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("\r\n"
				        + "1. 수학적 능력 향상: 구구단은 기본적인 곱셈을 익히는 것이며, 이는 수학적 사고와\r\n"
						+ "                 문제해결 능력을 향상시키는 데 도움이 됩니다.\r\n\r\n"
						+ "2. 기억력 강화: 구구단을 외우는 것은 기억력을 강화하는 데 도움이 됩니다.\r\n"
						+ "		이는 다른 과목에서도 유용할 수 있습니다.\r\n\r\n"
						+ "3. 자신감 향상: 구구단을 외울 때 성취감을 느끼고, \r\n"
						+ "		이는 자신감 향상으로 이어질 수 있습니다.\r\n\r\n"
						+ "4. 시간 절약: 구구단을 외우면 계산을 빠르게 할 수 있으므로 시간도 절약하고,\r\n"
						+ "		문제풀이능력도 향상 시킬 수 있습니다.");
		textArea.setFont(new Font("D2Coding", Font.BOLD, 15));
		textArea.setBackground(new Color(253, 252, 223));
		textArea.setBounds(12, 328, 641, 243);
		contentPane.add(textArea);
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon("image/game2.jpg"));
		lblNewLabel_1.setBounds(298, 10, 355, 308);
		contentPane.add(lblNewLabel_1);
	}
}
