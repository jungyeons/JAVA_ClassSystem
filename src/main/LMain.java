package main;

import java.util.Scanner;

import view.VInitial;

public class LMain {

	private VInitial initial;
	
    //持失切 
	public LMain(Scanner scanner) {
		this.initial = new VInitial(scanner);
	}

	public void run() {
		System.out.println("LMain::run()");
		this.initial.show();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//LMain 持失切 硲窒 -> 梓端 持失
		LMain main = new LMain(scanner);
		main.run();
		scanner.close();
	}
}

