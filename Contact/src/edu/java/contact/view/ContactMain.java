package edu.java.contact.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.java.contact.model.Contact;
import edu.java.contact.controller.ContactDaoImpl;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactMain {
	// 테이블 컬럼 이름 (상수)
	private static final String[] COLUMN_NAMES= {"이름", "전화번호"};
	

	private JFrame frame;
	private JPanel buttonPanel;
	private JButton btnInsert;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel model; // 테이블의 데이터, 컬럼 이름 등을 관리하는 객체.
	private List<Contact> contactList; // DB테이블에서 검색한 결과를 저장할 리스트.멤버변수
	
	 // 연락처 정보 관리하는 객체(Controller)
	private final ContactDaoImpl dao = ContactDaoImpl.getInstance();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactMain window = new ContactMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// ContactUpdateFrame에서 연락처 업데이트를 성공했을 때 호출할 메서드.
	public void notifyContactUpdated() {
		
		resetTableModel(); // JTable을 처음부터 새로 그림.
		
		JOptionPane.showMessageDialog(frame, "연락처 업데이트 성공!");
	}
	
	
	
	// ContactCreatFrame에서 새 연락처 저장을 성공했을 때 호출할 메서드
	public void notifyContactCreated() {
		
		resetTableModel();
		
		JOptionPane.showMessageDialog(frame, "새 연락처 저장 성공!");
	}
	
	private void resetTableModel() {
		model = new DefaultTableModel(null, COLUMN_NAMES); 
		// 파일에 저장된 데이터를 다시 읽고 테이블모델에 추가.
		loadContactData();
		// 새롭게 만들어진 테이블 모델을 테이블에 셋팅
		table.setModel(model);
		
	}
	

	/**
	 * Create the application.
	 */
	public ContactMain() {
		initialize(); // 화면에 보여질 GUI 컴포넌트들을 생성하고 초기화.
		loadContactData(); // 파일에 저장된 연락처 데이터를 로딩.(테이블 초기화)
	}
	
	private void loadContactData() {
		contactList = dao.read();
		for (Contact c : contactList) {
			Object[] row = {c.getName(),c.getPhone()};
			model.addRow(row);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 405, 580);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("연락처 v0.7");
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		buttonPanel = new JPanel();
		frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
		
		btnInsert = new JButton("새 연락처");
		btnInsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ContactCreatFrame.showContactCreatFrame(frame, ContactMain.this);
				// this -> ActionListener 타입의 익명 객체 
				// ContactMain06.this -> ContactMain06 타입의 객체
			}
		});
		btnInsert.setFont(new Font("D2Coding", Font.BOLD, 13));
		buttonPanel.add(btnInsert);
		
		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updateContact();
			}
		});
		btnUpdate.setFont(new Font("D2Coding", Font.BOLD, 13));
		buttonPanel.add(btnUpdate);
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteContact();
			}
		});
		btnDelete.setFont(new Font("D2Coding", Font.BOLD, 13));
		buttonPanel.add(btnDelete);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectContactsByKeyword();
			}
		});
		btnSearch.setFont(new Font("D2Coding", Font.BOLD, 13));
		buttonPanel.add(btnSearch);
		
		scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable(); // JTable 타입 객체 생성
		table.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 12));
		model = new DefaultTableModel(null, COLUMN_NAMES); // TableModel 객체 생성
		table.setModel(model); // 테이블모델 객체를 테이블에 셋팅
		// TODO: 테이블 컬럼 이름의 폰트 변경
		// TODO: 테이블 데이터 행의 폰트 변경
		scrollPane.setViewportView(table); // 테이블을 스크롤페인에 부착.
	}

	private void selectContactsByKeyword() {
		String keyword = JOptionPane.showInputDialog(frame, "검색어");
		System.out.println("keyword=" + keyword);
		if (keyword == null) {
			JOptionPane.showMessageDialog(frame, "검색어를 입력하세요...");
			return; //메서드 종료
		}
		
		contactList = dao.read(keyword); // 검색결과
		
		model = new DefaultTableModel(null, COLUMN_NAMES);
		for (Contact c : contactList) {
			Object[] row = {c.getName(), c.getPhone()};
			model.addRow(row);
		}
		table.setModel(model);
	}

	private void updateContact() {
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(
					frame, 
					"업데이트할 행을 먼저 선택하세요~!", 
					"경고", 
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		// ContactUpdateFrame을 생성해서 업데이트 창을 띄움.
		// 새 창의 부모 컴포넌트 (frame) -> 업데이트 창을 띄울 좌표를 계산하기 위해서
		// 선택된 연락처의 cid -> 업데이트 창에서 수정 전의 데이터를 출력하기 위해서
		// ContactMain의 주소까지 전달 -> 업데이트 성공했을 때 업데이트 창이 메인 창에게 알려주기 위해서
		// 익명클래스의 this는 위치를 정확하게 표현하기~!
		int cid = contactList.get(row).getCid();
		ContactUpdateFrame.showContactUpdateFrame(frame, cid, ContactMain.this);
		
		
	}

	private void deleteContact() {
		// 테이블에서 선택된 행의 인덱스를 찾음.
		int row  = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(
					frame, 
					"삭제하려는 행을 먼저 선택하세요~!",
					"경고", 
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		int confirm = JOptionPane.showConfirmDialog(
				frame, 
				"정말 삭제할까요?",
				"삭제 확인", 
				JOptionPane.YES_NO_OPTION);
		
		if (confirm == JOptionPane.YES_OPTION) {
			int cid = contactList.get(row).getCid();
			dao.delete(cid); // 리스트에서 연락처 삭제하고 파일도 업데이트함~!
			model.removeRow(row); // JTable에서 행 삭제.
			
			JOptionPane.showMessageDialog(frame, "삭제 성공!!");
		}
		
		
	}

}
