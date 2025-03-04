package model;
import java.util.Scanner;

public class Jugador {

	 // Atributos
	   long puntuacion; // int + más largo
	   String nombre;
	   int racha;
	   int puntos;
	   
	   
	   
	   
	   String respuesta;
	   static Scanner sc = new Scanner(System.in);
	   // constructor vacío
	   public Jugador() {
	   }
	   // constructor lleno
	   public Jugador(long puntuacion, int puntos, String respuesta) {
	       this.puntuacion = puntuacion;
	       this.puntos = puntos;
	       this.respuesta = respuesta;
	   }
	   // Getters y Setters
	   // método para obtener el valor del atributo. Lee el valor del atributo desde fuera de la clase sin ser directamente accesible
	   public long getPuntuacion() {
	       return puntuacion; // no requiere parámetros, devuelve el valor del atributo de la clase. No necesita información adicional
	   }
	   // método para modificar el valor del atributo. Requiere parámetro porque el propósito es recibir el nuevo valor del atributo.
	   public void setPuntuacion(long puntuacion) {
	       this.puntuacion = puntuacion; /*El parámetro (long puntuacion) es necesario. Setter necesita saber qué valor asignar a la
	       							variable.*/
	   }
	   public int getPuntos() {
	       return puntos;
	   }
	   public void setPuntos(int puntos) {
	       this.puntos = puntos; // this hace referencia a la variable de la clase
	   }
	   public String getRespuesta() {
	       return respuesta;
	   }
	   public void setRespuesta(String respuesta) {
	       this.respuesta = respuesta;
	   }
	  
	}


















