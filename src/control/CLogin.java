package control;

import dataAccessObject.DHwewonDeungrok;
import valueObject.OHwewon;
import valueObject.OLogin;

public class CLogin {

	private DHwewonDeungrok dHwewonDeungrok;

	public CLogin() {
		this.dHwewonDeungrok = new DHwewonDeungrok();
	}
	// validate�Լ� : ���α��� ��ü�� �޾Ƽ� ��ȸ����ü�� �����ϴ� �Լ�
	public OHwewon validate(OLogin oLogin) {
		// ���̵� �޾Ƽ� ��ȸ���� ã���Լ� -> ���ԵȾ����ΰ�? �� ���̵� �ش��ϴ� ȸ���� �ִ°�?
		OHwewon oHwewon = this.dHwewonDeungrok.read(oLogin.getId());
		if (oHwewon !=null) {
			if(oLogin.getPassword().equals(oHwewon.getPassword())) {
				return oHwewon;
			}
		}
		 // ���Ե� ���̵� ����.
		return null;
	}
}
