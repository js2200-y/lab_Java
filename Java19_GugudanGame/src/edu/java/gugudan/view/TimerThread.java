package edu.java.gugudan.view;

import edu.java.gugudan.view.*;

public class TimerThread extends Thread{
	
	GugudanView view;
	
	public TimerThread(GugudanView v) {
		view = v;
	
	}
	
	public void run() {
		for(view.model.timer = 20; view.model.timer >= 0; view.model.timer--){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			view.lblTimer.setText("****제한시간 1분**** 남은 시간 : "+view.model.timer +"초");
			if(view.model.timer == 0){
				view.endGame();
				
			}
		}
	}
}

