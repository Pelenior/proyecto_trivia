package model;

import java.util.Random;
import java.util.Scanner;
import java.util.Scanner;
import java.util.ArrayList;

public class Trivia {
	//Atributos
	Scanner sc;
	//Matriz cuadrada de preguntas
	String[][] preguntasRespuestasFacil = {{"¿Cuánto es 2+2?", "4"}, {"Es Mario y...", "Luigi"}, {"¿Quién escribió don Quijote?", "Cervantes"}, {"¿Quién es el protagonista de la saga \'The Legend of Zelda\'?", "Link"}, {"¿En qué año se descubrió América?", "1492"}};
	String[][] preguntasRespuestasMedio = {{"¿Es \'Integer\' una clase?", "Si"}, {"¿Qué elemento tiene el símbolo \'Fe\'?", "Hierro"}, {"¿Es Java un lenguaje de programación orientado a objetos?", "Si"}, {"¿Qué estilo artístico es asociado con la obra de Salvador Dalí?", "Surrealismo"}, {"¿Cuál es el río más largo del mundo?", "Nilo"}};
	String[][] preguntasRespuestasDificil = {{"¿En qué año se descubrió la tumba de Tutankamón?", "1922"}, {"¿En qué año se firmó la Declaración de la Independencia en Estados Unidos?", "1776"}, {"¿Quién es el mejor profesor de todos los tiempos sin duda alguna?", "Flan"}, {"¿Qué hace un elefante al despertar?", "Sombra"}, {"¿Cuál es el ipvx más moderno?", "ipv7"}};
	
	String dificultad = "";
	
	String jugadoresStr = "";
	int numJugadores = 0;
	
	//PRUEBA PARA VER SI SE SUBE EL CAMBIO AL GITHUB
	
	boolean individual = false;
	boolean multijugador = false;
	boolean partida = false;
	boolean salir = false;
	
	ArrayList<Jugador> jugadores = new ArrayList<>();//ArrayList de objeto jugador que recibe nombre jugadores
	
	private void init()
	{
		for(int i = 0; i < 4; i++)
		{
			jugadores.add(new Jugador());
		}
	}
	
	public Trivia(Scanner sc) {
		this.sc = sc;
		init();
	}
	
	public String getDificultad() {
		return dificultad;
	}

	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}
	
	public boolean getSalir() {
		return salir;
	}
	
	public int getNumJugadores()
	{
		return numJugadores;
	}
	
	public ArrayList<Jugador> getJugadores()
	{
		return jugadores;
	}
	
	public void selectorPreguntas(Jugador jugador) {
		Random random = new Random();
		String decision;
		int respuesta;
		boolean acertado = false;
		
		long tiempoInicio = System.currentTimeMillis() / 1000;
		
		System.out.println("Turno de " + jugador.getNombre());
		
		switch(dificultad) {
		
		//DIFICULTAD FACIL
			case "1":
				respuesta = random.nextInt(preguntasRespuestasFacil.length);
				System.out.println(Color.WHITE_BOLD + preguntasRespuestasFacil[respuesta][0] + Color.RESET);
				decision = sc.nextLine();
				if(decision.equalsIgnoreCase(preguntasRespuestasFacil[respuesta][1])) {
					System.out.println(Color.GREEN_BRIGHT + "¡Respuesta correcta!" + Color.RESET);
					acertado = true;
				}
				else
				{
					System.out.println("¡Qué pena! " + Color.RED + "Respuesta incorrecta" + Color.RESET + ", la respuesta correcta era: " + preguntasRespuestasFacil[respuesta][1]);
				}
			break;
		//DIFICULTAD MEDIO
			case "2":
				respuesta = random.nextInt(preguntasRespuestasMedio.length);
				System.out.println(Color.WHITE_BOLD + preguntasRespuestasMedio[respuesta][0] + Color.RESET);
				decision = sc.nextLine();
				if(decision.equalsIgnoreCase(preguntasRespuestasMedio[respuesta][1])) {
					System.out.println(Color.GREEN_BRIGHT + "¡Respuesta correcta!" + Color.RESET);
					acertado = true;
				}
				else
				{
					System.out.println("¡Qué pena! " + Color.RED + "Respuesta incorrecta" + Color.RESET + ", la respuesta correcta era: " + preguntasRespuestasMedio[respuesta][1]);
					
				}
			break;
		//DIFICULTAD DIFICIL
			case "3":
				respuesta = random.nextInt(preguntasRespuestasDificil.length);
				System.out.println(Color.WHITE_BOLD + preguntasRespuestasDificil[respuesta][0] + Color.RESET);
				decision = sc.nextLine();
				if(decision.equalsIgnoreCase(preguntasRespuestasDificil[respuesta][1])) { 
					System.out.println(Color.GREEN_BRIGHT + "¡Respuesta correcta!" + Color.RESET);
					acertado = true;
				}
				else
				{
					System.out.println("¡Qué pena! " + Color.RED + "Respuesta incorrecta" + Color.RESET + ", la respuesta correcta era: " + preguntasRespuestasDificil[respuesta][1]);
				}
			break;
		}
        System.out.println("Has tardado " + ((System.currentTimeMillis() / 1000) - tiempoInicio) + " segundos en responder");
		long tiempoTardado = System.currentTimeMillis() / 1000 - tiempoInicio;
		long puntuacion = 0;
		puntuacion = calculoPuntos(acertado, tiempoTardado);
		System.out.println(jugador.getNombre() + " ha conseguido " + puntuacion + " puntos esta ronda");
		
		jugador.setPuntuacion(jugador.getPuntuacion() + puntuacion);
	}
	
	public void selectorDificultad() {
		
		boolean confirmar = false;
		
		while(confirmar == false) {
			System.out.println("   SELECCIONA UNA DIFICULTAD\n" + Color.GREEN_BOLD_BRIGHT + "\n   1.FACIL  " + Color.YELLOW_BOLD_BRIGHT + "2.MEDIO  " + Color.RED_BOLD + "3.DIFICL" + Color.RESET);
			
			setDificultad(sc.nextLine());
			while(!getDificultad().equalsIgnoreCase("1") && !getDificultad().equalsIgnoreCase("2") && !getDificultad().equalsIgnoreCase("3")) {
				System.out.println(Color.RED_BOLD_BRIGHT + getDificultad() + " no es un dificultad valida" + Color.RESET);
				setDificultad(sc.nextLine());
			}
			
			if(getDificultad().equalsIgnoreCase("1")) System.out.println("DIFICULTAD: " + Color.GREEN_BOLD_BRIGHT + "FACIL");
			else if(getDificultad().equalsIgnoreCase("2")) System.out.println("DIFICULTAD: " + Color.YELLOW_BOLD_BRIGHT + "MEDIO" );
			else System.out.println("DIFICULTAD: " + Color.RED_BOLD_BRIGHT + "DIFICL" );
			System.out.println(Color.RESET);
			
			System.out.println("¿Estas seguro de esta dificultad?" + "\n               Y/N");
			
			if(sc.nextLine().equalsIgnoreCase("y")) confirmar = true;
		}
		
		
		
	}

	public long calculoPuntos(boolean acertado, long tiempoTardado) {
		long puntuacion = 0;
		
		
		if(acertado == true) {
			puntuacion = 1000 - (tiempoTardado * 10);
		}
		else if(acertado == false && tiempoTardado > 10) {
			puntuacion -= tiempoTardado * 10;
		}
		
		
		return puntuacion;
	}
	
	 public void menu() {
		  String decision;
		  
		  while(partida != true && salir != true) {
		      System.out.println(Color.YELLOW_BOLD + "                   BIENVENIDO AL RELOJ DE ARENA"  + Color.YELLOW_BOLD_BRIGHT + "\n1.Iniciar Juego  |  2.¿Que es Reloj de Arena?  |  3.Salir\n" + Color.RESET);
		      decision = sc.nextLine();
		      while(!decision.equals("1") && !decision.equals("2") && !decision.equals("3")) {
		    	  System.out.println(Color.RED_BRIGHT + "Visto que ha respondido incorrectamente le recordamos que debe introducir" + Color.RED_BOLD_BRIGHT + " 1, 2 o 3" + Color.RESET);
		    	  decision = sc.nextLine();
		      }
		      
		      switch(decision) {
		      
			      case "1":
			    	  menuPartida();
			    	  break;
			      case "2":
			    	  menuAyuda(); 
				      break;
			      case "3":
			    	  salir = true;
			    	  System.out.println("Saliendo...");
			    	  break;
		      }
		  }
	   }
	 
	public void menuAyuda() {
		 String decision = "Si";
		 
		 while(decision.equalsIgnoreCase("Si")) {
			 System.out.println(Color.GREEN_BOLD_BRIGHT + "Bienvenido, en que te puedo ayudar hoy:\n" + Color.RESET + " 1.Modos de juego" + " 2.Menus" + " 3.Programacion" + " 4.Manual completo" + " 5.Salir");
			 decision = sc.nextLine();
			 
			 while(!decision.equals("1") && !decision.equals("2") && !decision.equals("3") && !decision.equals("4") && !decision.equals("5")) { 
				 System.out.println("Veo que necesitas ayuda con el funcionamiento de los menus, ¿Es eso cierto?  (Tienes responder con Si o No)");
				 decision = sc.nextLine();
				 if(decision.equalsIgnoreCase("Si")) decision = "2";
				 else if(decision.equalsIgnoreCase("No")) {
					 System.out.println("Bienvenido, en que te puedo ayudar hoy:\n" + " 1.Modos de juego" + " 2.Menus" +  " 3.Programacion" + " 4.Manual completo" + " 5.Salir");
					 decision = sc.nextLine();
				 }
			 }
			 
			 switch(decision) {
			 
			 case "1":
				 System.out.println(Color.GREEN_BOLD_BRIGHT + "De acuerdo, elige sobre que modo quieres ayuda: \n" + Color.RESET + "1.Juego individual 2.Juego Multijugador 3.Manual completo 4.Salir");
				 decision = sc.nextLine();
				 
				 while(!decision.equals("1") && !decision.equals("2") && !decision.equals("3") && !decision.equals("4")) { 
					 System.out.println(Color.RED_BOLD_BRIGHT + "Tal vez deberias revisar la ayuda de los menus, pero si no intenta introducir 1,2 o 3" + Color.RESET);
					 System.out.println("1.Juego individual 2.Juego Multijugador 3.Manual completo 4.Salir");
					 decision = sc.nextLine();
				 }
				 switch(decision) {
				 case "1":
					 System.out.println(Color.WHITE_BOLD_BRIGHT + "\nEl modo individual consiste en un juego clasico de preguntas y respuestas,\ndonde comienzas con tres vidas y tu objetivo es responder el mayor numero de preguntas." + Color.RESET);
					 break;
				 case "2":
					 System.out.println(Color.WHITE_BOLD_BRIGHT + "\nEl modo multijugador consiste en un juego clasico de preguntas y respuestas,\ndonde debes competir con los otros jugadores para ver quien responde mas rapido o tiene una mayor racha de preguntas" + Color.RESET);
					 break;
				 case "3":
					 System.out.println(Color.WHITE_BOLD_BRIGHT + "MANUAL DE MODOS DE JUEGO");
					 System.out.println(Color.WHITE_BOLD_BRIGHT + "\n1.El modo individual consiste en un juego clasico de preguntas y respuestas,\ndonde comienzas con tres vidas y tu objetivo es responder el mayor numero de preguntas." + Color.RESET);
					 System.out.println(Color.WHITE_BOLD_BRIGHT + "\n2.El modo multijugador consiste en un juego clasico de preguntas y respuestas,\ndonde debes competir con los otros jugadores para ver quien responde mas rapido o tiene una mayor racha de preguntas" + Color.RESET);
					 break;
				 case "4":
					 decision = "salir";
					 break;
				 }
				 break;
			 case "2":
				 System.out.println(Color.WHITE_BOLD_BRIGHT + "MANUAL DE MENUS");
				 System.out.println(Color.WHITE_BOLD_BRIGHT + "\nLos menus suelen ser: \n1.Elecciones por numero, un ejemplo como 1.A 2.B, "
				 					+ "donde debes introducir uno de los numeros que aparecen en el selector en este caso 1 o 2. "
				 					+ "\n2.Elecciones por texto, como Si o No, donde debes introducir una respuesta que aparezca tras la pregunta en este caso Si o No. "
				 					+ "\n\n-Sumado a esto el programa les ayudara si cometen algun error o les recomendara soluciones para ello" + Color.RESET);
				 break;
			 case "3":
				 System.out.println("");
				 break;
			 case "4":
				 System.out.println("MANUAL COMPLETO DE RELOJ DE ARENA");
				 
				 System.out.println(Color.WHITE_BOLD_BRIGHT + "MANUAL DE MODOS DE JUEGO");
				 System.out.println(Color.WHITE_BOLD_BRIGHT + "\n1.El modo individual consiste en un juego clasico de preguntas y respuestas,\ndonde comienzas con tres vidas y tu objetivo es responder el mayor numero de preguntas." + Color.RESET);
				 System.out.println(Color.WHITE_BOLD_BRIGHT + "\n2.El modo multijugador consiste en un juego clasico de preguntas y respuestas,\ndonde debes competir con los otros jugadores para ver quien responde mas rapido o tiene una mayor racha de preguntas" + Color.RESET);
				 
				 System.out.println(Color.WHITE_BOLD_BRIGHT + "MANUAL DE MENUS");
				 System.out.println(Color.WHITE_BOLD_BRIGHT + "\nLos menus suelen ser: \n1.Elecciones por numero, un ejemplo como 1.A 2.B, "
				 					+ "donde debes introducir uno de los numeros que aparecen en el selector en este caso 1 o 2. "
				 					+ "\n2.Elecciones por texto, como Si o No, donde debes introducir una respuesta que aparezca tras la pregunta en este caso Si o No. "
				 					+ "\n\n-Sumado a esto el programa les ayudara si cometen algun error o les recomendara soluciones para ello" + Color.RESET);
				
				 break;
			 }
			 
			 System.out.println("\nTras esto tienes alguna duda mas: Si o No");
			 decision = sc.nextLine();
			 
			 while(!decision.equalsIgnoreCase("Si") && !decision.equalsIgnoreCase("No")) { 
				 System.out.println("\nTal vez deberias leer de nuevo el manual de menus");
				 System.out.println("\nTras esto tienes alguna duda mas: Si o No");
				 decision = sc.nextLine();
			 }
		 }
		 
	 }

	 public void menuPartida() {
		 String decision;
		 int tries = 0;
		 
		 System.out.println("ANTES DE EMPEZAR\n Selecciona el modo de juego: \n1.Individual 2.Multijugador(2-4 jugadores) 3.Atrás");
		 decision = sc.nextLine();
		 
		 while(!decision.equals("1") && !decision.equals("2") && !decision.equals("3")) {
			 tries++;
			 if(tries == 1) System.out.println(Color.RED_BOLD + "El numero debe estar entre 1,2 o 3" + Color.RESET);
			 else System.out.println(Color.GREEN_BOLD + "Tal vez deberias revisar el manual de menus" + Color.RESET);
			 decision = sc.nextLine();
			 
		 }
		 switch(decision) {
		 
		 case "1":
			 System.out.println("Bienvenido al modo Individual\n");
			 individual = true;
			 partida = true;
			 numJugadores = 1;
			 
			 //Aqui estaria guapo meter un leaderboard o algo asi pero lo dejo para luego
			 break;
		 case "2":
			 System.out.println("Bienvenido al modo multijugador");
			 System.out.println("A continuacion deberas elegir el numero de jugadores, entre 2-4\n");
			 
			 jugadoresStr = sc.nextLine();
			 while(!jugadoresStr.equals("2") && !jugadoresStr.equals("3") && !jugadoresStr.equals("4")) {
				 tries++;
				 if(tries == 1) System.out.println(Color.RED_BOLD + "El numero debe estar entre 2, 3 o 4" + Color.RESET);
				 else System.out.println(Color.GREEN_BOLD + "Tal vez deberias revisar el manual de menus" + Color.RESET);
				 jugadoresStr = sc.nextLine();
			 }
			 
			 switch(jugadoresStr)
			 {
				 case "2":
				 {
					 numJugadores = 2;
					 break;
				 }
				 case "3":
				 {
					 numJugadores = 3;
					 break;
				 }
				 case "4":
				 {
					 numJugadores = 4;
					 break;
				 }
			 }
			 multijugador = true;
			 partida = true;
			 
			//Aqui estaria guapo meter un leaderboard o algo asi pero lo dejo para luego
			 break;
		 }
		 
		 setJugadores();
	 }
	 
	 //creamos nuevos jugadores con nuevos nombres
	 private void setJugadores()
	 {
		 String nombre = "";
		 for(int i = 0; i < numJugadores; i++)
		 {
			 while(nombre.equals(""))
			 {
				 System.out.println("¿Cúal es el nombre del jugador " + (i + 1) + "?");
				 nombre = sc.nextLine();
				 if(nombre.equals(""))
					 System.out.println("Ese nombre no es válido");
				 else
					 jugadores.set(i, new Jugador(nombre)); 
			 }
			 nombre = "";
		 }
	 }
	 

}
