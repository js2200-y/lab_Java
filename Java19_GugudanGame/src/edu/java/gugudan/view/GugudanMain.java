package edu.java.gugudan.view;

import edu.java.gugudan.controller.GugudanController;
import edu.java.gugudan.controller.GugudanDaoImpl;
import edu.java.gugudan.model.GugudanModel;
import edu.java.gugudan.view.GugudanView;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GugudanMain {
	
	private final GugudanDaoImpl dao = GugudanDaoImpl.getInstance();
	
	public static void main(String[] args) {
		
		GugudanModel model = new GugudanModel();
		GugudanController controller = new GugudanController(model);
		GugudanView view = new GugudanView(model,controller);
		view.btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameInformation();
			}
		});
		view.setSize(720,660);
		view.setVisible(true);

	}

	protected static void gameInformation() {
		gameInformation.showInformation();
	}

}
