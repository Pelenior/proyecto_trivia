package model;

import java.util.Random;
import java.util.Scanner;

public class Trivia {
	
	String[][] preguntasRespuestasFacil = {{"¿Cómo se llama el lugar donde se realizan las carreras de caballos?", "Hipodromo"}};
	String[][] preguntasRespuestasMedio = {{"¿Cómo se llama el lugar donde se realizan las carreras de camellos?", "Hipodromo"}};
	String[][] preguntasRespuestasDificil = {{"¿Cómo se llama el lugar donde se realizan las carreras de patos?", "Hipodromo"}};
	
	String dificultad = "";
	
	public Trivia() {
		
	}
	
	public String getDificultad() {
		return dificultad;
	}

	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}
	
	
	
	
	public void selectorPreguntas() {
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		String decision;
		int respuesta;
		
		long tiempoInicio = System.currentTimeMillis() / 1000;
		
		switch(dificultad) {
		
			case "1":
				respuesta = random.nextInt(preguntasRespuestasFacil.length);
				System.out.println(preguntasRespuestasFacil[respuesta][0]);
				decision = sc.nextLine();
				if(decision.equalsIgnoreCase(preguntasRespuestasFacil[respuesta][1])) System.out.println("Bombardeen a Diego");
			break;
			case "2":
				respuesta = random.nextInt(preguntasRespuestasMedio.length);
				System.out.println(preguntasRespuestasMedio[respuesta][0]);
				decision = sc.nextLine();
				if(decision.equalsIgnoreCase(preguntasRespuestasMedio[respuesta][1])) System.out.println("Bombardeen a Diego");
			break;
			case "3":
				respuesta = random.nextInt(preguntasRespuestasDificil.length);
				System.out.println(preguntasRespuestasDificil[respuesta][0]);
				decision = sc.nextLine();
				if(decision.equalsIgnoreCase(preguntasRespuestasDificil[respuesta][1])) System.out.println("Bombardeen a Diego");
			break;
		}

        System.out.println("Has tardado " + ((System.currentTimeMillis() / 1000) - tiempoInicio) + " en responder");
		long tiempoTardado = System.currentTimeMillis() / 1000 - tiempoInicio;
		calculoPuntos();
	}
	
	public void selectorDificultad() {
		Scanner sc = new Scanner(System.in);
		
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

	public int calculoPuntos() {
		
		return 1;
	}

}
