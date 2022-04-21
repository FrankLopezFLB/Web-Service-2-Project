package proy.serpost.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VEHICULO")
public class Vehiculo {
	@Id
	@Column(name="VEH_CODIGO")
	private String codigo;
	
	@Column(name="VEH_MATRICULA")
	private String matricula;
	
	@Column(name="VEH_MARCA")
	private String marca;
	
	@Column(name="VEH_MODELO")
	private String modelo;
	
	@Column(name="VEH_FECHA_ADQ")
	private String fechaAd;
	
	@Column(name="CON_CODIGO")
	private int codConductor;
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getFechaAd() {
		return fechaAd;
	}

	public void setFechaAd(String fechaAd) {
		this.fechaAd = fechaAd;
	}

	public int getCodConductor() {
		return codConductor;
	}

	public void setCodConductor(int codConductor) {
		this.codConductor = codConductor;
	}

	public Vehiculo(String codigo, String matricula, String marca, String modelo, String fechaAd, int codConductor) {
		super();
		this.codigo = codigo;
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.fechaAd = fechaAd;
		this.codConductor = codConductor;
	}

	public Vehiculo() {
		super();
	}

	@Override
	public String toString() {
		return "Vehiculo [codigo=" + codigo + ", matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo
				+ ", fechaAd=" + fechaAd + ", codConductor=" + codConductor + "]";
	}
	
}