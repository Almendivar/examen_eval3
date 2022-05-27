package Examen;

public class Ejercicio4 {
	
	/*
	 * Pre:---
	 * Post: En este método comprobamos si la i es menor o igual que 100, mostramos la multiplicación del número por 
	 * el valor de la i y llamámos al método "tablaMultiplicar" sumándole 2 al valor de la i.
	 */
	public static void tablaMultiplicar(int num, int i) {
		if(i <= 100) {
			System.out.println(num + " x " + i + " = " + num * i);
			tablaMultiplicar(num, i + 2);
		}
	}
	
	/*
	 * Pre:---
	 * Post: En este método llamámos al método "TablaMultiplicar" enviándole el número recibido y un entero de valor 0.
	 */
	public static void tablaMultiplicar(int num) {
		tablaMultiplicar(num, 0);
	}
	
	/*
	 * Pre:---
	 * Post: En el método main creamos un número y llamámos al método "tablaMultiplicar" enviándole ese número.
	 */
	public static void main(String[]args) {
		int num = 2;
		tablaMultiplicar(num);
	}
}
