package edu.java.gugudan.controller;


import edu.java.gugudan.view.MarkingThread;
import edu.java.gugudan.model.GugudanModel;
import edu.java.gugudan.view.GugudanView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GugudanController implements ActionListener{
	
	GugudanModel model;
	public GugudanView view;
	
	public GugudanController(GugudanModel m) {
		this.model = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.btnStart){
			view.cleanMain();
			view.repaint();
		}else if(e.getSource() == view.btnEnd){
			System.exit(0);
		}else{
			if(view.inputCheck(e) == model.resultSu){
				model.okCount++;
				model.markingRe = "정답입니다!!";
			}else{
				model.failCount++;
				model.markingRe = "오답입니다!!";
			}
			view.userInput();
		    view.marking();
			MarkingThread thread = new MarkingThread(view);
			thread.start();
			
		}
		
	}

}