package Examen;

import java.io.File;
import java.util.Scanner;

public class Ejercicio1 {
	
	/*
	 * Pre:---
	 * Post: En este método creamos un objeto MySql y cargamos la base de datos, posteriormente 
	 * leemos le fichero "hablanosDelDon.txt" y comprobamos cada línea para ver que 
	 * letras comienzan o terminan por el String letra. Las palabras indicadas son 
	 * añadidas a la base de datos a través del método añadir" del objeto MySql.
	 */
	public static void fichero () {
		try {
			MySql base = new MySql();
			base.cargarBase();
			String letra = "s";
			File f = new File("C:\\Users\\diegi\\Desktop\\examen\\hablanosDelDon.txt");
			Scanner lineas = new Scanner(f);
			int num = 1; 
			System.out.println("La letra es "+ letra);
			while(lineas.hasNextLine()) {
				String linea = lineas.nextLine();
				String [] palabras = linea.split(" ");
				for(int i = 0; i < palabras.length; i++) {
					if(palabras[i].contains(",") || palabras[i].contains(".")){
						palabras[i] = palabras[i].substring(0,palabras[i].length() - 1);
					}
					if(palabras[i].substring(0,1).equals(letra) || 
							palabras[i].substring(palabras[i].length() - 1,palabras[i].length()).equals(letra)) {
						System.out.println("Palabra: " + palabras[i] + " Linea: "+num);
						base.añadir(letra, palabras[i], num);
					}
				}
				num++;
			}
			lineas.close();
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	/*
	 * Pre:---
	 * Post: En el método main, únicamente llamamos al método fichero.
	 */
	public static void main(String[]args) {
		fichero();
	}
}