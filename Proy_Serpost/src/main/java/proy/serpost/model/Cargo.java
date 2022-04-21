package proy.serpost.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CARGO")
public class Cargo {
	@Id
	@Column(name="CAR_CODIGO")
	private int codigocargo;
	@Column(name="CAR_NOMCARGO")
	private String nombrecargo;
	@Override
	public String toString() {
		return "Cargo [codigocargo=" + codigocargo + ", nombrecargo=" + nombrecargo + "]";
	}
	public int getCodigocargo() {
		return codigocargo;
	}
	public void setCodigocargo(int codigocargo) {
		this.codigocargo = codigocargo;
	}
	public String getNombrecargo() {
		return nombrecargo;
	}
	public void setNombrecargo(String nombrecargo) {
		this.nombrecargo = nombrecargo;
	}
}
