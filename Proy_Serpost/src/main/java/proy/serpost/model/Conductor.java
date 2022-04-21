package proy.serpost.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CONDUCTOR")
public class Conductor {
	@Id
	@Column(name="CON_CODIGO")
	private int codigo;
	
	@Column(name="CON_NOMBRE")
	private String nombre;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Conductor(int codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public Conductor() {
		super();
	}

	@Override
	public String toString() {
		return "Conductor [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	
}
