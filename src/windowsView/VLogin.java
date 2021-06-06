package windowsView;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import control.CLogin;
import valueObject.OHwewon;
import valueObject.OLogin;

public class VLogin extends JFrame {
	private static final long serialVersionUID = 1L;
    
	public VLogin(VMainFrame frame) {
		
  
        JTextField jTextField = new JTextField();
        JPasswordField jPasswordField = new JPasswordField();
        Object[] message = {"User Name:", jTextField, "Password: ", jPasswordField};
    
        int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String username = jTextField.getText();
            String password = new String(jPasswordField.getPassword());
            OLogin oLogin = new OLogin();
            oLogin.setId(username);
            oLogin.setPassword(password);

            OHwewon oHwewon= new CLogin().validate(oLogin);
            // 로그인 성공시
            if(oHwewon !=null) {
            	setVisible(false);
                JOptionPane.showMessageDialog(null, "Success");
                frame.getTopButtonPanel().getLoginButton().setVisible(false);
                
                frame.getvMainPanel().getvSugangsincheong().getvMiridamgi().addRow("Msugang/"+oHwewon.getId());
                frame.getvMainPanel().getvSugangsincheong().getvSincheong().addRow("Ssugang/"+oHwewon.getId());
                System.out.println("로그인 성공");
            }else {
            	JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 다시 확인하세요");
                System.out.print("아이디와 비밀번호가 올바르지 않습니다.");
            }
        }
    }
	
}
