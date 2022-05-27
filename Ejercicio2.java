package Examen;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Ejercicio2 {
	
	public static ArrayList<Divorcios> divorciosPorCiudad(ArrayList<Divorcios> divorciosList){
		ArrayList<Divorcios> divorciosCiudad = new ArrayList<Divorcios>();
		String ciudad = ""; 
		Divorcios divo = new Divorcios();
		for(int i = 0; i < divorciosList.size(); i++) {
			ciudad = divorciosList.get(i).getCiudad();
			if(divorciosList.get(i).getAño() > 2012 && divorciosList.get(i).getAño() < 2020) {
				if(ciudad.equals(divorciosList.get(i).getCiudad())){
					divo.setTotal(divo.getTotal() + divorciosList.get(i).getTotal());
				}
				else {
					divorciosCiudad.add(divo);
					divo.setTotal(divorciosList.get(i).getTotal());
					divo.setCiudad(ciudad);
				}
			}
		}
		divorciosCiudad.add(divo);
		return divorciosCiudad;
	}
		
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
	 * Post: 
	 */
	public static void main(String[]args) {
		ArrayList<Divorcios> divorciosList= fichero();
		for(int i = 0; i < divorciosList.size(); i++) {
			System.out.println(divorciosList.get(i));
		}
		System.out.println("---------------");
		System.out.println("---------------");
		System.out.println("---------------");
		System.out.println("---------------");
		System.out.println("---------------");
		int con2019 = divorciosCon2019(divorciosList);
		int sin2018 = divorciosSin2018(divorciosList);
		System.out.println(con2019);
		System.out.println(sin2018);
		ArrayList<Divorcios> divorciosCiudad = divorciosPorCiudad(divorciosList);
		System.out.println(divorciosCiudad.size());
		for(int i = 0; i < divorciosCiudad.size(); i++) {
			System.out.println(divorciosCiudad.get(i));
		}
	}
}
