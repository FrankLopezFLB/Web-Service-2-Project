package proy.serpost.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DESTINO")
public class Destino {
	@Id
	@Column(name="DES_CODIGO")
	String codigo;
	@Column(name="DES_PAIS")
	String pais;
	@Column(name="DES_CIUDAD")
	String ciudad;
	@Column(name="DES_CODIGO_POS")
	String codpostal;
	@Column(name="REG_CODIGO")
	int codregion;
	/*@Column(name="")
	String desregion;*/
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getCodpostal() {
		return codpostal;
	}
	public void setCodpostal(String codpostal) {
		this.codpostal = codpostal;
	}
	public int getCodregion() {
		return codregion;
	}
	public void setCodregion(int codregion) {
		this.codregion = codregion;
	}
	
	@Override
	public String toString() {
		return "Destino [codigo=" + codigo + ", pais=" + pais + ", ciudad=" + ciudad + ", codpostal=" + codpostal
				+ ", codregion=" + codregion + "]";
	}
	public Destino() {
		super();
	}
	
	public Destino(String codigo, String pais, String ciudad, String codpostal, int codregion) {
		super();
		this.codigo = codigo;
		this.pais = pais;
		this.ciudad = ciudad;
		this.codpostal = codpostal;
		this.codregion = codregion;
	}		
	
}