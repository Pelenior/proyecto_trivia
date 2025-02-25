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
	}
	
	public void selectorDificultad() {
		Scanner sc = new Scanner(System.in);
	
		System.out.println("SLECCIONA UNA DIFICULTAD");
		
		setDificultad(sc.nextLine());
	}

	

}
