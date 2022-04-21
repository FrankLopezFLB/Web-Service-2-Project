package proy.serpost.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TRABAJADOR")
public class Trabajador {
	@Id
	@Column(name="TRA_CODIGO")
	private int codigoTra;
	@Column(name="TRA_NOMBRE")
	private String nombreTra;
	@Column(name="TRA_APELLIDO")
	private String apellidoTra;
	@Column(name="TRA_DNI")
	private String dniTra;
	@Column(name="TRA_FECHA_NAC")
	private String fechaTaa;
	@Column(name="TRA_CORREO")
	private String correoTra;
	@Column(name="TRA_TELEFONO")
	private String telefonoTra;
	@Column(name="CAR_CODIGO")
	private int codigocar;
	@Column(name="TRA_CONTRASENA")
	private String contrasena;
	@Override
	public String toString() {
		return "Trabajador [codigoTra=" + codigoTra + ", nombreTra=" + nombreTra + ", apellidoTra=" + apellidoTra
				+ ", dniTra=" + dniTra + ", fechaTaa=" + fechaTaa + ", correoTra=" + correoTra + ", telefonoTra="
				+ telefonoTra + ", codigocar=" + codigocar + ", contrasena=" + contrasena + "]";
	}
	public Trabajador() {
		super();
	}
	public Trabajador(int codigoTra, String nombreTra, String apellidoTra, String dniTra, String fechaTaa,
			String correoTra, String telefonoTra, int codigocar, String contrasena) {
		super();
		this.codigoTra = codigoTra;
		this.nombreTra = nombreTra;
		this.apellidoTra = apellidoTra;
		this.dniTra = dniTra;
		this.fechaTaa = fechaTaa;
		this.correoTra = correoTra;
		this.telefonoTra = telefonoTra;
		this.codigocar = codigocar;
		this.contrasena = contrasena;
	}
	public int getCodigoTra() {
		return codigoTra;
	}
	public void setCodigoTra(int codigoTra) {
		this.codigoTra = codigoTra;
	}
	public String getNombreTra() {
		return nombreTra;
	}
	public void setNombreTra(String nombreTra) {
		this.nombreTra = nombreTra;
	}
	public String getApellidoTra() {
		return apellidoTra;
	}
	public void setApellidoTra(String apellidoTra) {
		this.apellidoTra = apellidoTra;
	}
	public String getDniTra() {
		return dniTra;
	}
	public void setDniTra(String dniTra) {
		this.dniTra = dniTra;
	}
	public String getFechaTaa() {
		return fechaTaa;
	}
	public void setFechaTaa(String fechaTaa) {
		this.fechaTaa = fechaTaa;
	}
	public String getCorreoTra() {
		return correoTra;
	}
	public void setCorreoTra(String correoTra) {
		this.correoTra = correoTra;
	}
	public String getTelefonoTra() {
		return telefonoTra;
	}
	public void setTelefonoTra(String telefonoTra) {
		this.telefonoTra = telefonoTra;
	}
	public int getCodigocar() {
		return codigocar;
	}
	public void setCodigocar(int codigocar) {
		this.codigocar = codigocar;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
}
