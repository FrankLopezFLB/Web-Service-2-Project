package proy.serpost.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente {
	@Id
	@Column(name = "CLI_CODIGO")
	private int codigoCli;
	@Column(name = "CLI_NOMBRE")
	private String nombreCli;
	@Column(name = "CLI_APELLIDO")
	private String apellidoCli;
	@Column(name = "CLI_DNI")
	private String dniCli;
	@Column(name = "CLI_TELEFONO")
	private String telefonoCli;
	@Column(name = "CLI_CORREO")
	private String correoCli;
	
	public int getCodigoCli() {
		return codigoCli;
	}
	public void setCodigoCli(int codigoCli) {
		this.codigoCli = codigoCli;
	}
	public String getNombreCli() {
		return nombreCli;
	}
	public void setNombreCli(String nombreCli) {
		this.nombreCli = nombreCli;
	}
	public String getApellidoCli() {
		return apellidoCli;
	}
	public void setApellidoCli(String apellidoCli) {
		this.apellidoCli = apellidoCli;
	}
	public String getDniCli() {
		return dniCli;
	}
	public void setDniCli(String dniCli) {
		this.dniCli = dniCli;
	}
	public String getTelefonoCli() {
		return telefonoCli;
	}
	public void setTelefonoCli(String telefonoCli) {
		this.telefonoCli = telefonoCli;
	}
	public String getCorreoCli() {
		return correoCli;
	}
	public void setCorreoCli(String correoCli) {
		this.correoCli = correoCli;
	}
	
	@Override
	public String toString() {
		return "Cliente [codigoCli=" + codigoCli + ", nombreCli=" + nombreCli + ", apellidoCli=" + apellidoCli
				+ ", dniCli=" + dniCli + ", telefonoCli=" + telefonoCli + ", correoCli=" + correoCli + "]";
	}
}
