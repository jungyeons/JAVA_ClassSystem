package textView;


import java.util.Vector;
import control.CHwewonDeungrok;
import valueObject.OHwewon;

public class VHwewon {

	private CHwewonDeungrok cHwewonDeungrok;
	
	VHwewon(){
		
		this.cHwewonDeungrok = new CHwewonDeungrok();
		
	}
	public void show() {
		Vector<OHwewon> oHwewonList = this.cHwewonDeungrok.readAll();
		for(OHwewon one:oHwewonList ) {
			System.out.println(one.getId()+one.getName()+one.getAddress()+one.getHwakgwa());
		}
	}

}
