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

	JButton okButton = new JButton("Ȯ��");
    
	public VJoin(JFrame vFrame) {
		super(vFrame, true);
		this.setTitle("ȸ������");
		this.setSize(200, 600);
		this.setLayout(new FlowLayout());
		this.add(new JLabel("ID"));
		this.add(this.idField);
		this.add(new JLabel("Password"));
		this.add(this.jPasswordField);
		this.add(new JLabel("�̸�"));
		this.add(this.nameField);
		this.add(new JLabel("�ּ�"));
		this.add(this.addressField);
		this.add(new JLabel("�а�"));
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
	            //Oȸ�� ��ü ����.
	            OHwewon oHwewon = new OHwewon();
	            //���� ���� ��� ���� 0ȸ�� ��ü���ٰ� SET.
	            oHwewon.setId(id);
	            oHwewon.setPassword(password);
	            oHwewon.setName(name);
	            oHwewon.setAddress(address);
	            oHwewon.setHwakgwa(hakgwa);
	            //Cȸ����� ��ü ����
	            cHwewonDeungrok = new CHwewonDeungrok();
	            cHwewonDeungrok.saveHwewon(oHwewon);
			}
		}
		);
		
	}
}
