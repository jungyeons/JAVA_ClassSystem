package main;

import java.util.Scanner;

import view.VInitial;

public class LMain {

	private VInitial initial;

	public LMain(Scanner scanner) {
		this.initial = new VInitial(scanner);
	}

	public void run() {
		System.out.println("LMain::run()");
		this.initial.show();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LMain main = new LMain(scanner);
		main.run();
		scanner.close();
	}
}

