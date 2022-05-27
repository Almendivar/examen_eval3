package Examen;

public class Divorcios {
	private String ciudad;
	private String separacion;
	private int a�o;
	private int total;
	
	public Divorcios(String ciudad, String separacion, int a�o, int total) {
		super();
		this.ciudad = ciudad;
		this.separacion = separacion;
		this.a�o = a�o;
		this.total = total;
	}
	
	public Divorcios() {
		super();
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getSeparacion() {
		return separacion;
	}

	public void setSeparacion(String separacion) {
		this.separacion = separacion;
	}

	public int getA�o() {
		return a�o;
	}

	public void setA�o(int a�o) {
		this.a�o = a�o;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Divorcios [ciudad=" + ciudad + ", separacion=" + separacion + ", a�o=" + a�o + ", total=" + total + "]";
	}
}
