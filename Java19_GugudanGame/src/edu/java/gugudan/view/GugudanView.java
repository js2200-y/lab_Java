package edu.java.gugudan.view;

import edu.java.gugudan.controller.Gugudan;
import edu.java.gugudan.controller.GugudanController;
import edu.java.gugudan.controller.GugudanDaoImpl;
import edu.java.gugudan.model.GugudanModel;
import edu.java.gugudan.view.gameScoreframe;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.Icon;


public class GugudanView extends JFrame {
	
	private final GugudanDaoImpl dao = GugudanDaoImpl.getInstance();
	public GugudanModel model;
	public GugudanController controller;
	public Container cpane;
	private int cid;
	public JLabel mainLabel; //메인라벨
	public JButton btnStart; //시작버튼
	public JButton btnEnd;   //종료버튼
	public JButton btnInfo ; // 정보버튼
	public JLabel lblTimer = new JLabel();
	public JLabel lblOk = new JLabel();
	public JLabel lblFail = new JLabel();
	public JLabel lblQuestion = new JLabel();
	public JLabel lblMarking = new JLabel();
	public JLabel lblEndmsg = new JLabel();
	public JButton btnScore;
	
	public JButton[] btnNumber = new JButton[16];
	
	public GugudanView(GugudanModel m,GugudanController c ) {
		super("Gugudan game.yjs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(new Color(255, 234, 62));
		this.addWindowListener(new WindowAdapter(){
		      public void windowClosing(WindowEvent e){
		       System.exit(0);
		      }
		     }
		     );
		this.model = m;
		this.controller = c;
		c.view = this;
		initDisplay();
	}
	

	public void initDisplay(){
		cpane = getContentPane();
		
		mainGUI();
	}
	
	
	public void mainGUI(){
		mainLabel = new JLabel(new ImageIcon("image/game.jpg"));
		mainLabel.setFont(new Font("D2Coding", Font.PLAIN, 18));
		mainLabel.setBounds(0, 6, 736, 464);
		btnStart = new JButton("게임 시작하기");
		btnStart.setFont(new Font("D2Coding", Font.BOLD, 12));
		btnStart.setBounds(215, 481, 300, 35);
		btnEnd = new JButton("종료하기");
		btnEnd.setFont(new Font("D2Coding", Font.BOLD, 12));
		btnEnd.setBounds(215, 575, 300, 35);
		btnInfo = new JButton("왜 구구단을 외워야할까요??");
		btnInfo.setFont(new Font("D2Coding", Font.BOLD, 12));
		btnInfo.setBounds(215, 528, 300, 35);
		

		btnStart.addActionListener(controller);
		btnEnd.addActionListener(controller);
		getContentPane().setLayout(null);

		cpane.add(mainLabel);
		cpane.add(btnStart);
		cpane.add(btnEnd);
		cpane.add(btnInfo);
		
		
	}
	
	public void cleanMain(){
		cpane.remove(mainLabel);
		cpane.remove(btnStart);
		cpane.remove(btnEnd);
		cpane.remove(btnInfo);
		
		playGUI();
		
	}
	
	//게임화면
	public void playGUI(){
		btnScore = new JButton("회차별 점수");
		btnScore.setBounds(530, 10, 140, 35);
		btnScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameScoreframe.showGugudanCreatFrame(cpane, cid, GugudanView.this);
				createNewGugudan();
			}
		});
		
		btnEnd.setFont(new Font("D2Coding", Font.BOLD, 20));
		lblTimer.setBounds(20,0,400,50);
		lblOk.setBounds(50,230,150,50);
		lblFail.setBounds(350,230,150,50);
		lblQuestion.setBounds(50,10,400,200);
		lblMarking.setBounds(200,80,300,200);
		lblEndmsg.setBounds(200,150,400,50);
		displayRecord();//성적을 표시한다
		setQuestion();  //문제를 표시한다
		lblQuestion.setFont(new Font("D2Coding", Font.BOLD, 70)); 
		lblMarking.setFont(new Font("D2Coding", Font.BOLD, 40)); 
		lblEndmsg.setFont(new Font("D2Coding", Font.BOLD, 40)); 
		lblTimer.setFont(new Font("D2Coding", Font.BOLD,20));
		
		cpane.add(btnScore);
		cpane.add(lblTimer);
		cpane.add(lblOk);
		cpane.add(lblFail);
		cpane.add(lblQuestion);
		cpane.add(lblMarking);

		// 버튼 16개
		for(int i = 0; i < 16; i++){
			btnNumber[i] = new JButton(model.displaySu[i]+"");
		}
		int x = 100;
		int y = 300;
		for(int i = 0; i < 16; i++){
			btnNumber[i].setBounds(x, y, 100, 55);
			x += 150;
			if((i+1) % 4 == 0){
				x = 100;
				y += 60;
			}
		}
		for(int i = 0; i < 16; i++){
			btnNumber[i].addActionListener(controller);
			cpane.add(btnNumber[i]);
		}

		TimerThread thread = new TimerThread(this);
		thread.start();
	}
	
	
	//문제를 출력한다
	public void setQuestion(){
		model.setQuestion();
		lblQuestion.setText(model.firstSu + " x " + model.secondSu + " = ");
	}
	//유저가 입력한 수를 화면에 표시해준다
	public void userInput(){
		lblQuestion.setText(model.firstSu + " x " + model.secondSu + " = " + model.userInput);
		
	}
	//유저가 입력한 수의 채점 결과를 표시한다
	public void marking(){
		lblMarking.setText(model.markingRe);
		
	}
	//채점 결과 초기화
	public void initMarking(){
		lblMarking.setText("");
		
	}
	
	//유저가 입력한 수를 체크한다
    public int inputCheck(ActionEvent e){
    	int re = 0;
    	for(int i = 0; i < 16; i++){
			if(e.getSource() == btnNumber[i]){//정답일 경우
				re = Integer.parseInt(btnNumber[i].getText());
				model.userInput = re;      //입력한수를 저장
				model.displaySu[i] = model.setRandomSu();
				btnNumber[i].setText(""+model.displaySu[i]);
				break;
			}
		}
    	return re;
    }
    //정답 및 오답을 체크한다
    public void displayRecord(){
    	lblOk.setText("정답 수 : " +model.okCount+" 개");
		lblFail.setText("오답 수 : " +model.failCount+" 개");
    }
	
    //게임종료
    public void endGame(){
    	for(int i = 0; i < 16; i++){
    		cpane.remove(btnNumber[i]);
    	}
    	repaint();
    	lblEndmsg.setText("게임종료!!!");
    	cpane.add(lblEndmsg);
    }
    public void createNewGugudan() {
		String okcount = lblOk.getText();
		String failcount = lblFail.getText();
		
		Gugudan gugudan = new Gugudan(cid, okcount, failcount);
		
		dao.create(gugudan);

	}
}
