package proy.serpost.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="REGION")
public class Region {
	@Id
	@Column(name="REG_CODIGO")
	private int codigo;
	@Column(name="REG_DESCRIPCION")
	private String descripcion;
	@Column(name="REG_COSTO")
	private double costo;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	@Override
	public String toString() {
		return "Region [codigo=" + codigo + ", descripcion=" + descripcion + ", costo=" + costo + "]";
	}
	
}
