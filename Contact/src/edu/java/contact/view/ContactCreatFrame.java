package edu.java.contact.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import edu.java.contact.model.Contact;
import edu.java.contact.controller.ContactDaoImpl;

public class ContactCreatFrame extends JFrame {
	
	private final ContactDaoImpl dao = ContactDaoImpl.getInstance();
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
	private ContactMain app; // notifyContactCreated 메서드를 가지고 있는 객체
	
	/**
	 * Launch the application.
	 */
	public static void showContactCreatFrame(Component parent, ContactMain app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactCreatFrame frame = new ContactCreatFrame(parent, app);
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
	public ContactCreatFrame(Component parent, ContactMain app) {
		this.parent = parent; // 순서 중요함~! initialize보다 먼저 들어와야함
		this.app = app;
		initialize(); // GUI 컴포넌트드를 생성하고 초기화.
	}
	
	public void initialize() {
		setTitle("새 연락처 저장");
		
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
		lblName.setFont(new Font("D2Coding", Font.BOLD, 15));
		lblName.setBounds(12, 10, 97, 36);
		panel.add(lblName);
		
		textName = new JTextField();
		textName.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 18));
		textName.setBounds(151, 10, 177, 36);
		panel.add(textName);
		textName.setColumns(10);
		
		lblPhone = new JLabel("전화번호");
		lblPhone.setFont(new Font("D2Coding", Font.BOLD, 15));
		lblPhone.setBounds(12, 56, 97, 36);
		panel.add(lblPhone);
		
		textPhone = new JTextField();
		textPhone.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 18));
		textPhone.setColumns(10);
		textPhone.setBounds(151, 56, 177, 36);
		panel.add(textPhone);
		
		lblEmail = new JLabel("이메일");
		lblEmail.setFont(new Font("D2Coding", Font.BOLD, 15));
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
		
		btnCreate = new JButton("저장");
		btnCreate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createNewContact();
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

	private void createNewContact() {
		// JTextField에서 이름/전화번호/이메일 읽음
		String name = textName.getText();
		String phone = textPhone.getText();
		String email = textEmail.getText();
		
		// Contact 타입 객체 생성
		Contact contact = new Contact(0, name, phone, email);
		
		// 리스트에 추가하고 파일 업데이트하기 -> DAO
		dao.create(contact);
		
		// ContactMain에게 새 연락처가 저장됐음을 알려줌.
		app.notifyContactCreated();
		
		// 현재 창 닫기
		dispose();
	}
}
