package Examen;

public class Divorcios {
	private String ciudad;
	private String separacion;
	private int año;
	private int total;
	
	public Divorcios(String ciudad, String separacion, int año, int total) {
		super();
		this.ciudad = ciudad;
		this.separacion = separacion;
		this.año = año;
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

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Divorcios [ciudad=" + ciudad + ", separacion=" + separacion + ", año=" + año + ", total=" + total + "]";
	}
}
