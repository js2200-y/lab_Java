package edu.java.jdbc05;

import java.awt.*;
import javax.swing.*;

public class CafeKioskMenu extends JFrame {
    private JLabel menuLabel;
    private JPanel menuPanel;
    private JButton[] menuButtons;

    public CafeKioskMenu() {
        // 메뉴 라벨 생성
        menuLabel = new JLabel("메뉴판", JLabel.CENTER);
        menuLabel.setFont(new Font("굴림체", Font.BOLD, 30));

        // 메뉴 버튼 생성
        menuButtons = new JButton[3];
        menuButtons[0] = new JButton("아메리카노");
        menuButtons[1] = new JButton("카페라떼");
        menuButtons[2] = new JButton("카푸치노");

        // 메뉴 버튼 패널 생성
        menuPanel = new JPanel(new GridLayout(3, 1));
        for (int i = 0; i < 3; i++) {
            menuPanel.add(menuButtons[i]);
        }

        // 프레임에 메뉴 라벨과 메뉴 버튼 패널 추가
        Container contentPane = getContentPane();
        contentPane.add(menuLabel, BorderLayout.NORTH);
        contentPane.add(menuPanel, BorderLayout.CENTER);

        // 프레임 설정
        setTitle("카페 키오스크 메뉴판");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CafeKioskMenu();
    }
}