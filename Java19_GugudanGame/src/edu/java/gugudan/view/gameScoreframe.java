package edu.java.gugudan.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import edu.java.gugudan.model.GugudanModel;
import edu.java.gugudan.controller.Gugudan;
import edu.java.gugudan.controller.GugudanDaoImpl;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class gameScoreframe extends JFrame {
	
	private static final String[] COLUMN_NAMES= {"회차", "정답 갯수", "틀린 갯수"};
	
	public JLabel lblOk = new JLabel();
	public JLabel lblFail = new JLabel();
	
	private final GugudanDaoImpl dao = GugudanDaoImpl.getInstance();
	private JPanel contentPane;
	private JPanel buttonPanel;
	private JButton btnCreate;
	private JButton btnCancel;
	
	private Component parent; // 부모 컴포넌트(JFrame)를 저장하기 위한 필드.
	private GugudanView app; // notifyContactCreated 메서드를 가지고 있는 객체
	private int cid;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel model;
	private List<Gugudan> gugudanList;
	
	/**
	 * Launch the application.
	 */
	public static void showGugudanCreatFrame(Component parent, int cid, GugudanView app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gameScoreframe frame = new gameScoreframe(parent, cid, app);
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
	public gameScoreframe(Component parent, int cid, GugudanView app) {
		this.parent = parent; // 순서 중요함~! initialize보다 먼저 들어와야함
		this.cid = cid;
		this.app = app;
		initialize(); // GUI 컴포넌트드를 생성하고 초기화.
		loadGugudanData();
	}
	
	private void loadGugudanData() {
		gugudanList = dao.read();
		for (Gugudan g : gugudanList) {
			Object[] row = {g.getCid(),g.getOkcount(), g.getFailcount()};
			model.addRow(row);
		}
	}

	public void initialize() {
		setTitle("회차별 점수");
		
		// 닫기(x)버튼의 기본 동작을 현재 창만 닫기로 설정.
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		// JFrame이 화면에 보이는 좌표
		int x = 100;
		int y = 100;
		if (parent != null);
			x = parent.getX(); 
			y = parent.getY(); 
		setBounds(x, y, 321, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnCreate = new JButton("삭제");
		btnCreate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteGugudan();
			}
		});
		btnCreate.setFont(new Font("D2Coding", Font.PLAIN, 15));
		buttonPanel.add(btnCreate);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose(); // 현재 창 닫기
			}
		});
		btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 15));
		buttonPanel.add(btnCancel);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 12));
		model = new DefaultTableModel(null, COLUMN_NAMES); 
		table.setModel(model);
			
		scrollPane.setViewportView(table);
	}

	protected void deleteGugudan() {
		// 테이블에서 선택된 행의 인덱스를 찾음.
				int row  = table.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(
							contentPane, 
							"삭제하려는 행을 먼저 선택하세요~!",
							"경고", 
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				int confirm = JOptionPane.showConfirmDialog(
						contentPane, 
						"정말 삭제할까요?",
						"삭제 확인", 
						JOptionPane.YES_NO_OPTION);
				
				if (confirm == JOptionPane.YES_OPTION) {
					int cid = gugudanList.get(row).getCid();
					dao.delete(cid); // 리스트에서 연락처 삭제하고 파일도 업데이트함~!
					model.removeRow(row); // JTable에서 행 삭제.
					
					JOptionPane.showMessageDialog(contentPane, "삭제 성공!!");
		
	}


}}
