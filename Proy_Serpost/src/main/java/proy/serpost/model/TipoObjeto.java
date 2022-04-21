package proy.serpost.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TIPO_OBJETO")
public class TipoObjeto {
	@Id
	@Column(name = "TIP_OBJ_CODIGO")
	private int codigo;
	@Column(name = "TIP_OBJ_DESCRIPCION")
	private String descripcion;
	
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
	
	@Override
	public String toString() {
		return "TipoObjeto [codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}
	
	public TipoObjeto(int codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
	
	public TipoObjeto() {
		super();
	}
		
}
