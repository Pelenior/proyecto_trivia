package model;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Leaderboard {
	

	public Leaderboard()
	{

	}
	
	public void actualizarLeaderboard(long[] puntuaciones, String[] nombres, boolean isMulti)
	{
		String pathToPuntuacion = "puntuaciones.json";//el path a donde están los archivos
		String pathToNames = "nombres.json";
		boolean hayNuevoRecord = false;
		if(isMulti)
		{
			pathToPuntuacion = "puntuaciones-multi.json";
			pathToNames = "nombres-multi.json";
		}
		
		try{
			String puntuacionContent = new String(Files.readAllBytes(Paths.get(pathToPuntuacion)));//guardamos el contenido de los archivos en un String
			String leaderboardContent = new String(Files.readAllBytes(Paths.get(pathToNames)));

            // Convert String content into a JSONObject
            JSONObject puntuacionJson = new JSONObject(puntuacionContent);//guardamos el contenido del String en un objeto de tipo JSONObject, el cual nos permite leerlo y cambiarlo
            JSONObject namesJson = new JSONObject(leaderboardContent);
    		
            //comprobación de si hay mejores puntuaciones
    		for(int i = 0; i < puntuaciones.length; i++)
            {
            	if(puntuaciones[i] > puntuacionJson.getInt("top1"))
            	{
            		puntuacionJson.put("top3", puntuacionJson.getInt("top2"));
            		puntuacionJson.put("top2", puntuacionJson.getInt("top1"));
            		puntuacionJson.put("top1", puntuaciones[i]);
            		
            		namesJson.put("top3", namesJson.getString("top2"));
            		namesJson.put("top2", namesJson.getString("top1"));
            		namesJson.put("top1", nombres[i]);
            		
            		hayNuevoRecord = true;
            	}
            	else if(puntuaciones[i] > puntuacionJson.getInt("top2") && !namesJson.getString("top1").equalsIgnoreCase(nombres[i]))
            	{
            		puntuacionJson.put("top3", puntuacionJson.getInt("top2"));
            		puntuacionJson.put("top2", puntuaciones[i]);
            		
            		namesJson.put("top3", namesJson.getString("top2"));
            		namesJson.put("top2", nombres[i]);
            		
            		hayNuevoRecord = true;
            	}
            	else if(puntuaciones[i] > puntuacionJson.getInt("top3") && !namesJson.getString("top1").equalsIgnoreCase(nombres[i]) && !namesJson.getString("top2").equalsIgnoreCase(nombres[i]))
            	{
            		namesJson.put("top3", nombres[i]);
            		
            		hayNuevoRecord = true;
            	}
            }
            
            try (FileWriter file = new FileWriter(pathToPuntuacion)) {
                file.write(puntuacionJson.toString(4));//escribimos el JSON de forma legible
            } catch (IOException e) {
                System.out.println("Error al guardar el archivo JSON: " + e.getMessage());
            }
            
            try (FileWriter file = new FileWriter(pathToNames)) {
                file.write(namesJson.toString(4));//escribimos el JSON de forma legible
            } catch (IOException e) {
                System.out.println("Error al guardar el archivo JSON: " + e.getMessage());
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		if(hayNuevoRecord)
		{
			System.out.println("Enhorabuena!! Has conseguido una nueva puntuación más alta");
			imprimirLeaderboard();
		}
		
	}
	
	public void imprimirLeaderboard()
	{
		String pathToPuntuacion = "puntuaciones.json";//el path a donde están los archivos
		String pathToNames = "nombres.json";
		String pathToPuntuacionMulti = "puntuaciones-multi.json";//el path a donde están los archivos
		String pathToNamesMulti = "nombres-multi.json";
		try{
			String puntuacionContent = new String(Files.readAllBytes(Paths.get(pathToPuntuacion)));//guardamos el contenido de los archivos en un String
			String leaderboardContent = new String(Files.readAllBytes(Paths.get(pathToNames)));

			String puntuacionContentMulti = new String(Files.readAllBytes(Paths.get(pathToPuntuacionMulti)));//guardamos el contenido de los archivos en un String
			String leaderboardContentMulti = new String(Files.readAllBytes(Paths.get(pathToNamesMulti)));
			
            JSONObject puntuacionJson = new JSONObject(puntuacionContent);//guardamos el contenido del String en un objeto de tipo JSONObject, el cual nos permite leerlo y cambiarlo
            JSONObject namesJson = new JSONObject(leaderboardContent);
            
            JSONObject puntuacionJsonMulti = new JSONObject(puntuacionContentMulti);//guardamos el contenido del String en un objeto de tipo JSONObject, el cual nos permite leerlo y cambiarlo
            JSONObject namesJsonMulti = new JSONObject(leaderboardContentMulti);
            
            System.out.println(Color.WHITE_BOLD + "SOLO" + Color.RESET);
            System.out.println("Top 1: " + namesJson.getString("top1") + ": " + puntuacionJson.getInt("top1"));
            System.out.println("Top 2: " + namesJson.getString("top2") + ": " + puntuacionJson.getInt("top2"));
            System.out.println("Top 3: " + namesJson.getString("top3") + ": " + puntuacionJson.getInt("top3"));
            
            System.out.println("\n" + Color.WHITE_BOLD + "MULTIPLAYER" + Color.RESET);
            System.out.println("Top 1: " + namesJsonMulti.getString("top1") + ": " + puntuacionJsonMulti.getInt("top1"));
            System.out.println("Top 2: " + namesJsonMulti.getString("top2") + ": " + puntuacionJsonMulti.getInt("top2"));
            System.out.println("Top 3: " + namesJsonMulti.getString("top3") + ": " + puntuacionJsonMulti.getInt("top3"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
