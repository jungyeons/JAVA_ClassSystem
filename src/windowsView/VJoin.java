package windowsView;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import control.CHwewonDeungrok;
import valueObject.OHwewon;

public class VJoin extends JDialog {
	private static final long serialVersionUID = 1L;
	JTextField idField = new JTextField(10);
	JPasswordField jPasswordField = new JPasswordField(10);
	JTextField nameField = new JTextField(10);
	JTextField addressField = new JTextField(10);
	JTextField hakgwaField = new JTextField(10);
	
	private CHwewonDeungrok cHwewonDeungrok;

	JButton okButton = new JButton("확인");
    
	public VJoin(JFrame vFrame) {
		super(vFrame, true);
		this.setTitle("회원가입");
		this.setSize(200, 600);
		this.setLayout(new FlowLayout());
		this.add(new JLabel("ID"));
		this.add(this.idField);
		this.add(new JLabel("Password"));
		this.add(this.jPasswordField);
		this.add(new JLabel("이름"));
		this.add(this.nameField);
		this.add(new JLabel("주소"));
		this.add(this.addressField);
		this.add(new JLabel("학과"));
		this.add(this.hakgwaField);
		this.add(this.okButton);
		
		okButton.addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent e) {
				String id = idField.getText();
	            String password = new String(jPasswordField.getPassword());
	            String name = nameField.getText();
	            String address = addressField.getText();
	            String hakgwa = hakgwaField.getText();
	            //O회원 객체 생성.
	            OHwewon oHwewon = new OHwewon();
	            //받은 값을 방금 만든 0회원 객체에다가 SET.
	            oHwewon.setId(id);
	            oHwewon.setPassword(password);
	            oHwewon.setName(name);
	            oHwewon.setAddress(address);
	            oHwewon.setHwakgwa(hakgwa);
	            //C회원등록 객체 생성
	            cHwewonDeungrok = new CHwewonDeungrok();
	            cHwewonDeungrok.saveHwewon(oHwewon);
			}
		}
		);
		
	}
}
