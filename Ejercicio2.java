package Examen;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio2 {
	
	/*
	 * Pre:---
	 * Post: En este método sumamos el total de divorcios entre 2013 y 2019 por ciudad y los añadimos a un nuevo 
	 * ArrayList con el nombre de la ciudad para devolverlo al método main.
	 */
	public static ArrayList<Divorcios> divorciosPorCiudad(ArrayList<Divorcios> divorciosList){
		ArrayList<Divorcios> divorciosCiudad = new ArrayList<Divorcios>();
		String ciudad = ""; 
		int totales = 0;
		Divorcios divo = new Divorcios();
		for(int i = 0; i < divorciosList.size(); i++) {
			if(divorciosList.get(i).getAño() > 2012 && divorciosList.get(i).getAño() < 2020) {
				if(ciudad.equals(divorciosList.get(i).getCiudad())){
					totales = totales + divorciosList.get(i).getTotal();
				}
				else {
					divorciosCiudad.add(new Divorcios(ciudad, "", 0, totales));
					totales = divorciosList.get(i).getTotal();
					ciudad = divorciosList.get(i).getCiudad();
				}
			}
			ciudad = divorciosList.get(i).getCiudad();
		}
		divorciosCiudad.add(divo);
		return divorciosCiudad;
	}
		
	/*
	 * Pre:---
	 * Post: En este método comprobamos todos los divorcios que han sido efectuados en 2018 y que no tengan 
	 * separación previa, posteriormente devolvemos el número total al método main.
	 */
	public static int divorciosSin2018(ArrayList<Divorcios> divorciosList) {
		int con2018 = 0;
		for(int i = 0; i < divorciosList.size(); i++) {
			if(divorciosList.get(i).getAño() == 2018 && 
					divorciosList.get(i).getSeparacion().equalsIgnoreCase("No")) {
				con2018 = con2018 + divorciosList.get(i).getTotal();
			}
		}
		return con2018;
	}
	
	/*
	 * Pre:---
	 * Post: En este método comprobamos todos los divorcios que han sido efectuados en 2019 y que tengan 
	 * separación previa, posteriormente devolvemos el número total al método main.
	 */
	public static int divorciosCon2019(ArrayList<Divorcios> divorciosList) {
		int con2019 = 0;
		for(int i = 0; i < divorciosList.size(); i++) {
			if(divorciosList.get(i).getAño() == 2019 && 
					divorciosList.get(i).getSeparacion().equalsIgnoreCase("Si")) {
				con2019 = con2019 + divorciosList.get(i).getTotal();
			}
		}
		return con2019;
	}
		
	/*
	 * Pre:---
	 * Post: En este método leemos comprobamos el tamaño del total de divorcios y dependiendo de su tamaño
	 * eliminamos el punto para poder transformarlo en número posteriormente, también eliminamos el id de la ciudad
	 * y los registros de total divorcios que contengan .. le damos valor 0.
	 */
	public static String[] quitarSobras(String[] palabras) {
		if(palabras[3].length() == 5) {
			palabras[3] = palabras[3].substring(0,1) + palabras[3].substring(2,5);
		}
		else if(palabras[3].length() == 6) {
			palabras[3] = palabras[3].substring(0,2) + palabras[3].substring(3,6);
		}
		palabras[0] = palabras[0].substring(3,palabras[0].length());
		if(palabras[3].contains("..")) {
			palabras[3] = "0";
		}
		return palabras;
	}
	
	/*
	 * Pre:---
	 * Post: En este método leemos el fichero csv divorcios.csv y añadimos sus datos al ArrayList divorciosList, 
	 * para así, devolverlo al método main.
	 */
	public static ArrayList<Divorcios> fichero () {
		try {
			ArrayList<Divorcios> divorciosList= new ArrayList<Divorcios>();
			File f = new File("C:\\Users\\diegi\\Desktop\\examen\\divorcios.csv");
			Scanner lineas = new Scanner(f);
			lineas.nextLine();
			while(lineas.hasNextLine()) {
				String linea = lineas.nextLine();
				String [] palabras = linea.split(";");
				palabras = quitarSobras(palabras);
				divorciosList.add(new Divorcios(palabras[0], palabras[1], 
						Integer.parseInt(palabras[2]), Integer.parseInt(palabras[3])));
			}
			lineas.close();
			return divorciosList;
		}
		catch(Exception e){
			System.out.println(e.toString());
			return null;
		}
	}
	
	/*
	 * Pre:---
	 * Post: En el método main, llamámos a los métodos correspondientes para leer el fichero csv y calcular 
	 * el número de divorcios con separación en 2019 y sin separación en 2018. Posteriormente llamamos al 
	 * método "divorciosPorCiudad", para coger un ArrayList con el número total de divorcios por ciudad y 
	 * guardamos en un nuevo "Divorcios" la ciudad con más divorcios para mostrarla en pantalla.
	 */
	public static void main(String[]args) {
		ArrayList<Divorcios> divorciosList= fichero();
		int con2019 = divorciosCon2019(divorciosList);
		int sin2018 = divorciosSin2018(divorciosList);
		System.out.println("Total de divorcios con separacion previa 2019: " + con2019);
		System.out.println("Total de divorcios sin separacion previa 2018: " + sin2018);
		ArrayList<Divorcios> divorciosCiudad = divorciosPorCiudad(divorciosList);
		Divorcios divo = new Divorcios(divorciosCiudad.get(1).getCiudad(),"", 
				0, divorciosCiudad.get(1).getTotal());
		for(int i = 2; i < divorciosCiudad.size(); i++) {
			if(divo.getTotal() < divorciosCiudad.get(i).getTotal()) {
				divo.setCiudad(divorciosCiudad.get(i).getCiudad());
				divo.setTotal(divorciosCiudad.get(i).getTotal());
			}
		}
		System.out.println("Localidad con mayor número de divorcios totales: " + divo.getCiudad() +
				" ,con número de divorcios: " + divo.getTotal() );
	}
}
