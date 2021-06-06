package control;

import dataAccessObject.DHwewonDeungrok;
import valueObject.OHwewon;
import valueObject.OLogin;

public class CLogin {

	private DHwewonDeungrok dHwewonDeungrok;

	public CLogin() {
		this.dHwewonDeungrok = new DHwewonDeungrok();
	}

	// validate함수 : 오로그인 객체를 받아서 오회원객체를 리턴하는 함수
	public OHwewon validate(OLogin oLogin) {
		// 아이디를 받아서 오회원을 찾는함수
		OHwewon oHwewon = this.dHwewonDeungrok.read(oLogin.getId());
		if (oHwewon != null) {
			if (oLogin.getPassword().equals(oHwewon.getPassword())) {
				return oHwewon;
			}
		}
		// 가입된 아이디가 없음
		return null;
	}
}
