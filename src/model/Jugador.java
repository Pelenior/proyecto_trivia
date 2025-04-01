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
	   public long getPuntuacion() {
	       return puntuacion;
	   }
	   
	   public void setPuntuacion(long puntuacion) {
	       this.puntuacion = puntuacion;
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
