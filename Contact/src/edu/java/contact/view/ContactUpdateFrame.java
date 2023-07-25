package edu.java.contact.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.java.contact.model.Contact;
import edu.java.contact.controller.ContactDaoImpl;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactUpdateFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel buttonPanel;
	private JLabel lblName;
	private JLabel lblPhone;
	private JLabel lblEmail;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textEmail;
	private JButton btnCreate;
	private JButton btnCancel;
	
	private Component parent; // 부모 컴포넌트(JFrame)를 저장하기 위한 필드.
	private int cid; // 업데이트할 연락처의 cid를 저장하기 위한 필드.
	private ContactMain app; // 업데이트 성공한 후 알림메서드(notifyContactCreated)를 호출하기 위한 객체
	
	private final ContactDaoImpl dao = ContactDaoImpl.getInstance();

	/**
	 * Launch the application.
	 */
	public static void showContactUpdateFrame(Component parent, int cid, ContactMain app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactUpdateFrame frame = new ContactUpdateFrame(parent, cid, app);
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
	public ContactUpdateFrame(Component parent, int cid, ContactMain app) {
		this.parent = parent; // 순서 중요함~! initialize보다 먼저 들어와야함
		this.cid = cid;
		this.app = app;
		initialize(); // GUI 컴포넌트드를 생성하고 초기화.
		readContact();
	}
	
	private void readContact() {
		Contact contact = dao.read(cid);
		textName.setText(contact.getName());
		textPhone.setText(contact.getPhone());
		textEmail.setText(contact.getEmail());
	}
	
	public void initialize() {
		setTitle("연락처 업데이트");
		
		// 닫기(x)버튼의 기본 동작을 현재 창만 닫기로 설정.
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// JFrame이 화면에 보이는 좌표
		int x = 100;
		int y = 100;
		if (parent != null);
			x = parent.getX(); 
			y = parent.getY(); 
		setBounds(x, y, 370, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblName = new JLabel("이름");
		lblName.setFont(new Font("D2Coding", Font.BOLD, 20));
		lblName.setBounds(12, 10, 97, 36);
		panel.add(lblName);
		
		textName = new JTextField();
		textName.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 18));
		textName.setBounds(151, 10, 177, 36);
		panel.add(textName);
		textName.setColumns(10);
		
		lblPhone = new JLabel("전화번호");
		lblPhone.setFont(new Font("D2Coding", Font.BOLD, 20));
		lblPhone.setBounds(12, 56, 97, 36);
		panel.add(lblPhone);
		
		textPhone = new JTextField();
		textPhone.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 18));
		textPhone.setColumns(10);
		textPhone.setBounds(151, 56, 177, 36);
		panel.add(textPhone);
		
		lblEmail = new JLabel("이메일");
		lblEmail.setFont(new Font("D2Coding", Font.BOLD, 20));
		lblEmail.setBounds(12, 103, 97, 36);
		panel.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 18));
		textEmail.setColumns(10);
		textEmail.setBounds(151, 103, 177, 36);
		panel.add(textEmail);
		
		buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnCreate = new JButton("수정완료");
		btnCreate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updateContact();
			}
		});
		btnCreate.setFont(new Font("D2Coding", Font.BOLD, 20));
		buttonPanel.add(btnCreate);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose(); // 현재 창 닫기
			}
		});
		btnCancel.setFont(new Font("D2Coding", Font.BOLD, 20));
		buttonPanel.add(btnCancel);
	}

	private void updateContact() {
		// (1) JTextField에서 업데이트 정보를 읽기.
		String name = textName.getText();
		String phone = textPhone.getText();
		String email = textEmail.getText();
		
		Contact contact = new Contact(cid, name, phone, email);
		
		int confirm = JOptionPane.showConfirmDialog(
				ContactUpdateFrame.this,
				"정말로 업데이트 할까요?",
				"업데이트 확인",
				JOptionPane.YES_NO_OPTION);
		if (confirm == JOptionPane.YES_NO_OPTION) {
			dao.update(contact); // 리스트를 수정하고, 파일에 업데이트
			app.notifyContactUpdated();// ContactMain 프레임에 있는 테이블을 갱신하기 위해서
			dispose();
		}
		
	
		
		
	}


}
