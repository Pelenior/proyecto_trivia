package model;

public class Jugador {

	 // Atributos
	   long puntuacion; // int + más largo
	   String nombre = "";
	   int racha;

	   // constructor vacío
	   public Jugador() {
	   }
	   
	   public Jugador(String nombre)
	   {
		   this.nombre = nombre;
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
	       if(this.puntuacion < 0)
	       {
	    	   this.puntuacion = 0;
	       }
	   }
	   
	   public void setNombre(String nombre)
	   {
		   this.nombre = nombre;
	   }
	   
	   public String getNombre()
	   {
		   return nombre;
	   }

	  
	}


















