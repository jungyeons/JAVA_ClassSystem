package control;

import java.util.Vector;

import dataAccessObject.DHwewonDeungrok;
import valueObject.OHwewon;

public class CHwewonDeungrok {

	private DHwewonDeungrok dHwewonDeungrok;

	public CHwewonDeungrok() {
		this.dHwewonDeungrok = new DHwewonDeungrok();
	}
	
    //readHwewon함수는 외부로부터 사용자 id를 받아서 해당 아이디 회원정보를 리턴.
	public OHwewon readHwewon(String id) {
		OHwewon oHwewon = this.dHwewonDeungrok.read(id);
		return oHwewon;
	}

	public void saveHwewon(OHwewon oHwewon) {
		this.dHwewonDeungrok.save(oHwewon);
	}
	public Vector<OHwewon> readAll(){
	      Vector<OHwewon> oHwewonList = this.dHwewonDeungrok.readAll();
		  return oHwewonList;
	
	}
}
