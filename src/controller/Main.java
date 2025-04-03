package controller;
import java.util.Scanner;

import model.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Trivia trivia = new Trivia(sc);
		
		int turno = 0;
		int turnoTotal = 0;
		
		trivia.menu();
		
		if(trivia.getSalir() == false) {
			trivia.selectorDificultad();
		}
		
		while(turnoTotal < 9 && trivia.getJugadores().get(0).getVidas() > 0)
		{
			trivia.selectorPreguntas(trivia.getJugadores().get(turno));
			turno++;
			if(turno >= trivia.getNumJugadores())
			{
				turno = 0;
				turnoTotal++;
				//Individual 8 preguntas, multijugador 3, antes de la pregunta final
				if((turnoTotal == 8 && trivia.getNumJugadores() == 1) || (turnoTotal == 3) && trivia.getNumJugadores() > 1) 
				{
					System.out.println(Color.RED_BOLD + "Última ronda" + Color.RESET + "...");
					turnoTotal = 8;
				}
				if(trivia.getNumJugadores() == 1 && trivia.getJugadores().get(0).getVidas() > 0)
				{
					System.out.println("Esta es tu puntuación: " + trivia.getJugadores().get(0).getPuntuacion() + " puntos");
				}
				else if(turnoTotal < 8 && trivia.getJugadores().get(0).getVidas() > 0)
				{
					System.out.println("¡Así van las puntuaciones!");
					for(Jugador jugador : trivia.getJugadores())
					{
						if(!jugador.getNombre().equals(""))
							System.out.println(jugador.getNombre() + ": " + jugador.getPuntuacion() + " puntos");
					}
				}
			}
			System.out.println("Pulsa cualquier tecla para continuar...");
			sc.nextLine();
		}
		if(trivia.getJugadores().get(0).getVidas() > 0)
		{
			String nombreGanador = trivia.getJugadores().get(0).getNombre(); // en caso de que queden todos con 0 puntos, 1 jugador gana
			long puntuacionGanador = 0;
			for(Jugador jugador : trivia.getJugadores())
			{
				if(jugador.getPuntuacion() > puntuacionGanador)
				{
					puntuacionGanador = jugador.getPuntuacion();
					nombreGanador = jugador.getNombre();
				}
			}
			if(trivia.getNumJugadores() == 1)
			{
				System.out.println("Tu puntuación final es...");
				System.out.println(puntuacionGanador + " puntos!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!😀");
			}
			else
			{
				System.out.println("Y el ganador es...\n\n\n");
				System.out.println(nombreGanador + " con " + puntuacionGanador + " puntos!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!😀");
			}
		}
		else
		{
			System.out.println("Te quedas sin vidas!");
		}
		System.out.println("¡Gracias por jugar!");
	}

}
