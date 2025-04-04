package model;

import java.util.Random;
import java.util.Scanner;
import java.util.Scanner;
import java.util.ArrayList;

public class Trivia {
	//Atributos
	Scanner sc;
	//Matriz cuadrada de preguntas, con fila 1[0] la pregunta y fila 2[1] la respuesta
	 String[][] preguntasRespuestasFacil = {
	            {"¿Cuánto es 2+2?\n a) Pez\n b) 4\n c) 2", "b"},
	            {"Es Mario y...\n a) Mario verde\n b) Peach\n c) Luigi", "c"},
	            {"¿Quién escribió Don Quijote?\n a) Picasso\n b) Cervantes\n c) Shakespeare", "b"},
	            {"¿Quién pintó el Guernica?\n a) Diego Velázquez\n b) Joaquín Sorolla\n c) Ninguno de los dos", "c"},
	            {"¿Cómo termina la película 'Titanic?'\n a) Jack termina siendo el rey del mundo submarino ('soy el rey del mundo' no especificó si era el marino)\n b) Jack y Rose acaban juntos\n c) Jack y Rose mueren juntos", "a"},
	            {"¿Cuándo se descubrió América?\n a) 12 de octubre 1492\n b) 14 de noviembre 1490\n c) 10 de octubre 1400", "a"},
	            {"¿En qué deporte se utiliza una pelota ovalada?\n a) Fútbol\n b) Baloncesto\n c) Rugby", "c"},
	            {"¿Qué cantante es conocido como el 'Rey del Pop'?\n a) Pablo Alborán\n b) Harry Styles\n c) Michael Jackson", "c"},
	            {"¿Cómo se llama el mamífero que pone huevos?\n a) Ovíparos\n b) Mamíferos\n c) ¿Hay animales que ponen huevos?", "a"},
	            {"¿En qué continente se encuentra Egipto?\n a) Europa\n b) América\n c) África", "c"},
	            {"¿Qué planeta es conocido como el 'planeta rojo'?\n a) Saturno\n b) Marte\n c) Júpiter", "b"},
	            {"¿En qué lenguaje de programación se utiliza la función print() para mostrar mensajes en pantalla?\n a) XML\n b) Python\n c) C++", "b"},
	            {"¿Cómo se llama el manga y anime donde un joven llamado Goku busca las Esferas del Dragón?\n a) One Piece\n b) Pokémon\n c) Dragon Ball", "c"},
	            {"¿En el videojuego de la saga The Legend of Zelda el protagonista es?\n a) Link\n b) Zelda\n c) Navi", "a"},
	            {"¿Quién es el amigo de Sonic?\n a) Tails\n b) El Primas\n c) Dr. Robotnik/Eggman", "a"}
	        };

	 String[][] preguntasRespuestasMedio = {
	            {"¿Cuál es la capital de Finlandia?\n a) Helsinki\n b) Estocolmo\n c) Oslo", "a"},
	            {"¿String es una variable primitiva?\n a) Sí\n b) No\n c) No sé", "b"},
	            {"¿Don Quijote muere?\n a) No\n b) En el primer libro\n c) En el segundo libro", "c"},
	            {"¿Quién cantó la canción 'Libre'?\n 'Libre\n Como el sol cuando amanece\n Yo soy libre como el mar'\n a) Isabel Pantoja\n b) Nino Bravo\n c) Julio Iglesias", "b"},
	            {"¿Quién cantó 'El Perdón'?\n 'El perdón... El perdón\n Te lo da Dios\n Pero yo no, no \n Te lo da Dios\n Pero yo no, no'\n a) Diana Navarro\n b) Rosalía\n c) Ana Belén", "a"},
	            {"¿Cuál es la diferencia entre == y .equals() en Java?\n a) == compara contenido o valor de los objetos y .equals() compara referencias de objetos.\n b) No hay diferencia\n c) == se usa en int y .equals() se usa en String", "c"},
	            {"¿Cuál es el elemento químico con el símbolo 'Fe'?\n a) Francio\n b) Hierro\n c) Flúor", "b"},
	            {"¿En qué año se firmó la Declaración de Independencia de los Estados Unidos?\n a) 1770\n b) 1776\n c) 1780", "b"},
	            {"¿Quién pintó 'La última cena' y en qué año?\n a) Leonardo da Vinci pintada entre 1494 y 1498\n b) Leonardo da Vinci pintada entre 1490 y 1494\n c) Leonardo da Vinci pintada entre 1450 y 1458", "a"},
	            {"¿Cuál es el río más largo del mundo: el Amazonas o el Nilo?\n a) Nilo\n b) Amazonas\n c) Ninguno, es el Ebro", "a"},
	            {"¿Quién es el autor de la famosa pintura 'El Grito'?\n a) Frida Kahlo\n b) Edvard Munch\n c) Katsushika Hokusai", "b"},
	            {"¿Qué estilo artístico es asociado con la obra de Salvador Dalí?\n a) Surrealismo\n b) Realismo\n c) Litúrgico", "a"},
	            {"¿En qué museo se encuentra la pintura 'La Mona Lisa'?\n a) Museo de la Acrópolis\n b) Museo del Prado\n c) Museo del Louvre", "c"},
	            {"¿De qué país es la banda Extremoduro?\n a) México\n b) España\n c) Colombia", "b"},
	            {"'Betty la fea' es una telenovela...\n a) Mexicana\n b) Colombiana\n c) Venezolana", "b"}
	        };
	 
	 String[][] preguntasRespuestasDificil = {
	            {"¿En qué año se descubrió la tumba de Tutankamón?\n a) 1922\n b) 1910\n c) 1920", "a"},
	            {"¿En qué año se disolvió la banda española Mecano?\n a) 1988\n b) 1980\n c) 1998", "c"},
	            {"¿Quién hizo 'Entre dos aguas'?\n a) Vicente Amigo Girol\n b) Paco de Lucía\n c) Jimi Hendrix", "b"},
	            {"¿Quién cantó ORIGINALMENTE 'Veremos a Dolores'?\n 'Sí, veremos a Dolores a caminar\n las calles de Madrid'\n a) Víctor Manuel\n b) Ana Belén\n c) Kendall Peña", "a"},
	            {"¿Qué es el 'Deadlock' en Java y cómo puedes evitarlo?\n a) Es un bloqueo mutuo entre hilos; se evita adquiriendo bloqueos en el mismo orden.\n b) Ocurre cuando un hilo se detiene por completo debido a un error de sintaxis, y se evita eliminando todos los bloqueos en el código.\n c) Es cuando varios hilos se ejecutan al mismo tiempo sin problemas, y se evita ejecutándolos de manera secuencial.", "a"},
	            {"¿Cómo funciona la recolección de basura (Garbage Collection) en Java?\n a) Se realiza manualmente usando el método System.gc() y se asegura de que no haya objetos inactivos en el programa.\n b) Destruye automáticamente los objetos en memoria cada vez que el programa se ejecuta sin necesidad de un recolector de basura.\n c) Elimina objetos no referenciados para liberar memoria automáticamente.", "c"},
	            {"¿Qué es un Serializable en Java?\n a) Una clase que se utiliza para manejar la entrada y salida de datos a través de la red.\n b) Una interfaz que permite convertir un objeto en un flujo de bytes para ser almacenado o transmitido.\n c) Una interfaz que convierte los objetos en cadenas de texto para poder ser almacenados en bases de datos.", "b"},
	            {"¿Quién fue el primer emperador romano?\n a) Augusto\n b) Julio César\n c) Tiberio", "a"},
	            {"¿En qué año se fundó la ciudad de Constantinopla?\n a) 290 d.C\n b) 300 d.C\n c) 330 d.C", "c"},
	            {"¿Quién escribió el libro 'No tengo boca y debo gritar'?\n a) Harlan Ellison\n b) Stephen King\n c) William Faulkner", "a"},
	            {"¿Quién escribió 'Meridiano de sangre'?\n a) Philip Roth\n b) Cormac McCarthy\n c) Jack London", "b"},
	            {"¿Quién escribió 'Indigno de ser Humano'?\n a) Liu Zongyuan\n b) Byung-Chul Han\n c) Osamu Dazai", "c"},
	            {"¿Cómo se llama la yegua de Link?\n a) Epona\n b) Navi\n c) Tingle", "a"},
	            {"En Naruto, ¿cuál es el nombre de la técnica secreta que Minato Namikaze usó para sellar al Zorro de Nueve Colas dentro de su hijo Naruto?\n a) Sello de Armadura de Hierro\n b) Sello de los Cinco Elementos\n c) Sello de los Ocho Trigramas", "c"},
	            {"¿Qué hace un elefante al despertar?\n a) Se levanta.\n b) Se va con su manada.\n c) Sombra.", "c"}
	        };
	
	String dificultad = "";
	String jugadoresStr = "";
	int numJugadores = 0;
		
	boolean individual = false;
	boolean multijugador = false;
	boolean partida = false;
	boolean salir = false;
	
	ArrayList<Jugador> jugadores = new ArrayList<>();//ArrayList de objeto jugador que recibe nombre jugadores
	
	//se inicializa los jugadores
	private void init() {
		for(int i = 0; i < 4; i++) {//recorre toda lista Jugador con número máx 4
			jugadores.add(new Jugador());//se añaden jugadores
		}
	}
	
	public Trivia(Scanner sc) {
		this.sc = sc;
		init();//metodo que guarda jugadores
	}
	
	//Getters y Setters
	public String getDificultad() {
		return dificultad;
	}

	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}
	
	public boolean getSalir() {
		return salir;
	}
	
	public int getNumJugadores() {
		return numJugadores;
	}
	
	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}
	
	public void selectorPreguntas(Jugador jugador) {
		Random random = new Random();
		String decision = "";
		int respuesta;
		boolean acertado = false;
		//se guarda el tiempo en el que tardas a responder las preguntas
		long tiempoInicio = System.currentTimeMillis() / 1000;//caluclar tiempo que tarda en responder (de milisegundo a segundos)
		
		System.out.println("Turno de " + jugador.getNombre());
		
		switch(dificultad) {
		
		//DIFICULTAD FACIL
			case "1":
				respuesta = random.nextInt(preguntasRespuestasFacil.length);
				while(!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b") && !decision.equalsIgnoreCase("c"))
				{
					System.out.println(Color.WHITE_BOLD + preguntasRespuestasFacil[respuesta][0] + Color.RESET);
					decision = sc.nextLine();
					if(!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b") && !decision.equalsIgnoreCase("c"))
					{
						System.out.println("Responde con \"a\", \"b\" o \"c\"");
					}
				}
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
				while(!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b") && !decision.equalsIgnoreCase("c"))
				{
					System.out.println(Color.WHITE_BOLD + preguntasRespuestasMedio[respuesta][0] + Color.RESET);
					decision = sc.nextLine();
					if(!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b") && !decision.equalsIgnoreCase("c"))
					{
						System.out.println("Responde con \"a\", \"b\" o \"c\"");
					}
				}
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
				while(!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b") && !decision.equalsIgnoreCase("c"))
				{
					System.out.println(Color.WHITE_BOLD + preguntasRespuestasDificil[respuesta][0] + Color.RESET);
					decision = sc.nextLine();
					if(!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b") && !decision.equalsIgnoreCase("c"))
					{
						System.out.println("Responde con \"a\", \"b\" o \"c\"");
					}
				}
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
		
		//vidas
		if(numJugadores == 1 && !acertado)
		{
			jugador.setVidas(jugador.getVidas() - 1);
			System.out.println(jugador.getNombre() + " no ha acertado y pierde 1 vida, ahora tiene " + jugador.getVidas() + " vidas");
		}
		else
		{
			System.out.println(jugador.getNombre() + " ha conseguido " + puntuacion + " puntos esta ronda");
		}
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
		
		//si acertado, se resta a 1000 el tiempo multi por 10
		if(acertado == true) {
			puntuacion = 1000 - (tiempoTardado * 10);
		}
		else if(acertado == false && tiempoTardado > 10) {
			puntuacion -= tiempoTardado * 10;
		}//si fallo y has tardado mas de 10seg te resta tu puntacion por el tiempo por 10
		
		
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
				 if(decision.equalsIgnoreCase("Si")) decision = "2";//te lleva durectamente a ayuda
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
				 System.out.println("Haber atendido a clase");
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
			 
			 //Aqui estaria guapo meter un leaderboard (mejores puntuaciones) o algo asi pero lo dejo para luego
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
		 
		 crearJugadores();//crea jugadores
	 }
	 
	 //creamos nuevos jugadores con nuevos nombres
	 private void crearJugadores()
	 {
		 String[] nombre = {"", "", "", ""};
		 for(int i = 0; i < numJugadores; i++)
		 {
			 while(nombre[i].equals(""))
			 {
				 System.out.println("¿Cúal es el nombre del jugador " + (i + 1) + "?");
				 nombre[i] = sc.nextLine();
				 for(int j = 0; j < nombre.length; j++)
				 {
					 if(nombre[i].equals(nombre[j]) && i > j)
					 {
						 System.out.println("Dos jugadores no pueden tener el mismo nombre");
						 nombre[i] = "";
					 }
				 }
				 if(nombre[i].equals(""))
					 System.out.println("Ese nombre no es válido");
				 else
					 jugadores.set(i, new Jugador(nombre[i]));//guarda jugador y nombre lo crea
			 }
		 }
	 }
	 

}
