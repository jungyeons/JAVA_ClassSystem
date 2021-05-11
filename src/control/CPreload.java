package control;

import java.util.Scanner;

import dataAccessObject.DPreload;
import valueObject.OPreload;

public class CPreload {
	private Scanner scanner;
	 private DPreload dPreload;

	   public CPreload(Scanner scanner) {
	        this.scanner = scanner;
	        this.dPreload = new DPreload();
	    }

	    public void save(OPreload oPreload) {
	        this.dPreload.save(oPreload);
	    }
}
