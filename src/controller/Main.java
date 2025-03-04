package controller;
import java.util.Scanner;

import model.*;

public class Main {

	public static void main(String[] args) {
		Trivia trivia = new Trivia();
		Scanner sc = new Scanner(System.in);
		Jugador jugador = new Jugador();
		
		trivia.menu();
		trivia.selectorDificultad();
		trivia.selectorPreguntas(jugador);
	}

}
