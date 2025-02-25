package controller;
import java.util.Scanner;

import model.*;

public class Main {

	public static void main(String[] args) {
		Trivia trivia = new Trivia();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("ELIGE");
		trivia.selectorPreguntas(sc.nextLine());
	}

}
