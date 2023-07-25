package edu.java.gugudan.view;

import edu.java.gugudan.view.GugudanView;

public class MarkingThread extends Thread{
	
	GugudanView view;
	
	public MarkingThread(GugudanView v) {
		view = v;
	
	}
	
	public void run() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		view.initMarking();
		view.setQuestion();
		view.displayRecord();
	}

}
