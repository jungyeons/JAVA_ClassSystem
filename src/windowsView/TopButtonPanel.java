package windowsView;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopButtonPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private JButton loginButton;
    private JButton joinButton;
    private VMainFrame vMainFrame;


    public TopButtonPanel(VMainFrame frame) {
        super();
        this.setBackground(new Color(220, 220, 220));
        
        this.setLayout(new FlowLayout());

        this.vMainFrame = frame;
        
        this.loginButton = new JButton("login");

        loginButton.addActionListener(new MyActionListener());
       
        this.add(loginButton);

        
        this.joinButton = new JButton("join");
        joinButton.addActionListener(new MyActionListener());
        this.add(joinButton);


    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getJoinButton() {
        return joinButton;
    }

    public VMainFrame getInstance() {
        return this.vMainFrame;
    }

 

   
    private class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("login")) {
                // 로그인 다이얼로그 출력
                 new VLogin(getInstance());
            } else if (button.getText().equals("join")) {
                VJoin vJoin = new VJoin(getInstance());
                vJoin.setLocationRelativeTo(getInstance());
                vJoin.setVisible(true);
            }
        }
    }
}

