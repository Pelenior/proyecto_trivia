package controller;
import java.util.Scanner;

import model.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Trivia trivia = new Trivia(sc);
		
		int turno = 0;
		
		trivia.menu();
		
		if(trivia.getSalir() == false) {
			trivia.selectorDificultad();
		}
		
		while(true)
		{
			trivia.selectorPreguntas(trivia.getJugadores().get(turno));
			turno++;
			if(turno >= trivia.getNumJugadores())
			{
				turno = 0;
			}
		}
	}

}
