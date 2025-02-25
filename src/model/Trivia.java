package model;

import java.util.Random;

public class Trivia {
	
	
	public Trivia() {
		
	}
	
	public void selectorPreguntas(String dificultad) {
		Random random = new Random();
		
		switch(dificultad) {
		
			case "1":
				String[][] preguntasRespuestas = {
			            {"¿Quién dirige la selección española de fútbol?", "Luis de la Fuente Castillo"},
			            {"¿Cuántas medallas olímpicas se llevó Ana Peleteiro en los JJOO de Tokyo 2020?", "Una de bronce."},
			            {"¿Qué número llevaba Benzema en el Real Madrid?", "9."},
			            {"¿Qué deporte practicaba Simone Biles?", "Gimnasia."},
			            {"¿En qué año fueron los Juegos Olímpicos de Londres?", "2012."},
			            {"¿Quién ganó la liga española de fútbol en 2022?", "El Real Madrid."},
			            {"¿Cómo murió Kobe Bryant?", "En un accidente de helicóptero."},
			            {"¿Cuántas veces ha ganado Rafael Nadal el torneo de Wimbledon?", "Dos veces."},
			            {"¿Qué selección perdió la final del Mundial de fútbol femenino en 2019?", "Países Bajos."},
			            {"¿Cuánto dura un partido de rugby?", "80 minutos."},
			            {"¿Quién es el máximo goleador de la historia del fútbol?", "Cristiano Ronaldo."},
			            {"¿Qué selección ha ganado más Copas Mundiales de Fútbol?", "Brasil."},
			            {"¿Quién es el atleta con más medallas olímpicas?", "Michael Phelps (23 oros, 3 platas y 2 bronces)."},
			            {"¿Quién es el futbolista con más balones de oro?", "Leo Messi (6)."},
			            {"¿Qué atleta tiene el récord de los 100 metros lisos?", "Usain Bolt."},
			            {"¿Cuál es el equipo de la NBA con más títulos?", "Los Boston Celtics."},
			            {"¿Cuánto dura una maratón?", "42 km."},
			            {"¿En qué equipo jugó Michael Jordan la mayor parte de su carrera?", "Chicago Bulls."},
			            {"¿Cuáles son las tres grandes vueltas del ciclismo?", "El Tour de Francia, la Vuelta a España y el Giro de Italia."},
			            {"¿Cuál es el deporte nacional de Japón?", "El sumo."},
			            {"¿En qué ciudad se encuentra el estadio popularmente conocido como La Bombonera?", "En Buenos Aires."},
			            {"¿Qué número llevaba a la espalda Raúl González del Real Madrid?", "El 7."},
			            {"¿Qué significan las siglas ATP en el ámbito deportivo?", "Asociación de Tenistas Profesionales."},
			            {"¿Cuánto dura un 'round' de boxeo masculino?", "3 minutos."},
			            {"¿En qué deporte se conoce al árbitro como juez de silla?", "En el tenis."},
			            {"¿Quién fue el primer español campeón de la NBA?", "Pau Gasol."},
			            {"¿En qué escudería competía Michael Schumacher en Fórmula 1?", "En Ferrari."},
			            {"¿Cuál es el deporte más practicado en el mundo?", "La natación."},
			            {"¿Qué pieza de ajedrez puede hacer un movimiento en forma de L?", "El caballo."},
			            {"¿Cuánto dura la prórroga en un partido de fútbol?", "30 minutos."},
			            {"¿A qué distancia se encuentra la línea de tres puntos en el baloncesto?", "6.75 metros."},
			            {"¿Cuántos integrantes tiene un equipo de vóley playa?", "Dos."},
			            {"¿A qué deporte se le llama “ballet acuático”?", "Natación sincronizada."},
			            {"¿Cuáles son los colores de los Juegos Olímpicos?", "Azul, Rojo, Amarillo, Verde y Negro."},
			            {"¿Cuál es el deporte más popular de India?", "El criquet."},
			            {"¿Cómo se llama el lugar donde se realizan las carreras de caballos?", "Hipódromo."}
			        };
				System.out.println(preguntasRespuestas[random.nextInt(preguntasRespuestas.length)][0]);
		}
	}

}
