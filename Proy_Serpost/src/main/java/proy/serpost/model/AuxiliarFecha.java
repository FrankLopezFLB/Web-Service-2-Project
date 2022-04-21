package proy.serpost.model;

public class AuxiliarFecha {
	private String fec1;
	private String fec2;
	
	public String getFec1() {
		return fec1;
	}
	public void setFec1(String fec1) {
		this.fec1 = fec1;
	}
	public String getFec2() {
		return fec2;
	}
	public void setFec2(String fec2) {
		this.fec2 = fec2;
	}
	
	@Override
	public String toString() {
		return "AuxiliarFecha [fec1=" + fec1 + ", fec2=" + fec2 + "]";
	}
	public AuxiliarFecha() {
		super();
	}
	public AuxiliarFecha(String fec1, String fec2) {
		super();
		this.fec1 = fec1;
		this.fec2 = fec2;
	}
	
}
