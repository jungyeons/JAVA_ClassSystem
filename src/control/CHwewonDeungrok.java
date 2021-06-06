package control;

import java.util.Vector;

import dataAccessObject.DHwewonDeungrok;
import valueObject.OHwewon;

public class CHwewonDeungrok {

	private DHwewonDeungrok dHwewonDeungrok;

	public CHwewonDeungrok() {
		this.dHwewonDeungrok = new DHwewonDeungrok();
	}
	
    //readHwewon�Լ��� �ܺηκ��� ����� id�� �޾Ƽ� �ش� ���̵� ȸ�������� ����.
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
