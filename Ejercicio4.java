package Examen;

public class Ejercicio4 {
	
	/*
	 * Pre:---
	 * Post: En este m�todo comprobamos si la i es menor o igual que 100, mostramos la multiplicaci�n del n�mero por 
	 * el valor de la i y llam�mos al m�todo "tablaMultiplicar" sum�ndole 2 al valor de la i.
	 */
	public static void tablaMultiplicar(int num, int i) {
		if(i <= 100) {
			System.out.println(num + " x " + i + " = " + num * i);
			tablaMultiplicar(num, i + 2);
		}
	}
	
	/*
	 * Pre:---
	 * Post: En este m�todo llam�mos al m�todo "TablaMultiplicar" envi�ndole el n�mero recibido y un entero de valor 0.
	 */
	public static void tablaMultiplicar(int num) {
		tablaMultiplicar(num, 0);
	}
	
	/*
	 * Pre:---
	 * Post: En el m�todo main creamos un n�mero y llam�mos al m�todo "tablaMultiplicar" envi�ndole ese n�mero.
	 */
	public static void main(String[]args) {
		int num = 2;
		tablaMultiplicar(num);
	}
}
