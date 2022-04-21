package proy.serpost.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Reporte {
	@Id
	@Column(name="ENV_CODIGO")
	private String codigo;
	@Column(name="ENV_NOM_DEST")
	private String destinatario;
	@Column(name="ENV_FECHA")
	private String fechaenvio;
	@Column(name="NOM_CLIENTE")
	private String cliente;
	
	@Column(name="DET_CODIGO")
	private int detallecodigo;
	@Column(name="DET_NOMBRE")
	private String detallenombre;
	
	@Column(name="TIP_OBJ_DESCRIPCION")
	private String tipoobjeto;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getFechaenvio() {
		return fechaenvio;
	}

	public void setFechaenvio(String fechaenvio) {
		this.fechaenvio = fechaenvio;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public int getDetallecodigo() {
		return detallecodigo;
	}

	public void setDetallecodigo(int detallecodigo) {
		this.detallecodigo = detallecodigo;
	}

	public String getDetallenombre() {
		return detallenombre;
	}

	public void setDetallenombre(String detallenombre) {
		this.detallenombre = detallenombre;
	}

	public String getTipoobjeto() {
		return tipoobjeto;
	}

	public void setTipoobjeto(String tipoobjeto) {
		this.tipoobjeto = tipoobjeto;
	}

	@Override
	public String toString() {
		return "Reporte [codigo=" + codigo + ", destinatario=" + destinatario + ", fechaenvio=" + fechaenvio
				+ ", cliente=" + cliente + ", detallecodigo=" + detallecodigo + ", detallenombre=" + detallenombre
				+ ", tipoobjeto=" + tipoobjeto + "]";
	}
	

}