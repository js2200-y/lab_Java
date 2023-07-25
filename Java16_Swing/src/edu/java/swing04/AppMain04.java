package edu.java.swing04;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain04 {

	// 이미지 파일의 경로들을 저장하는 배열
	private static final String[] IMAGES = {
			"images/1.1.jpg",
			"images/1.2.jpg",
			"images/1.3.jpg",
			"images/1.4.jpg",
			"images/1.5.jpg"
			
	};

	private int index; // 현재 화면에 보여지는 이미지 파일의 인덱스
	private JFrame frame;
	private JLabel lblNewLabel;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain04 window = new AppMain04();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppMain04() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 660, 757);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel(new ImageIcon(IMAGES[index]));
		lblNewLabel.setBounds(130, 80, 390, 439);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("<");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// btnNewButton 버튼이 클릭됐을 때 할일을 작성
				showPrevImage();
//				if (index > 0 ) {
//					index--;
//				} else {
//					index = IMAGES.length -1;
//				}
//				lblNewLabel.setIcon(new ImageIcon(IMAGES[index]));
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 30));
		btnNewButton.setBounds(130, 584, 111, 81);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton(">");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (index < IMAGES.length -1 ) {
					index++;
				} else {
					index = 0;
				}
				lblNewLabel.setIcon(new ImageIcon(IMAGES[index]));
			}
		});
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 30));
		btnNewButton_1.setBounds(426, 584, 111, 81);
		frame.getContentPane().add(btnNewButton_1);
	}

	protected void showPrevImage() {
		if (index > 0 ) {
			index--;
		} else {
			index = IMAGES.length -1;
		}
		lblNewLabel.setIcon(new ImageIcon(IMAGES[index]));
		
	}
}
