package model;

public class Jugador {

	 // Atributos
	   long puntuacion; // int + más largo
	   String nombre = "";
	   int racha = 0;
	   int vidas = 3;

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
	   
	   public String getNombre()
	   {
		   return nombre;
	   }
	   
	   public int getVidas()
	   {
		   return vidas;
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
	   
	   public void setVidas(int vidas)
	   {
		   this.vidas = vidas;
	   }
	   
	   

	  
	}
