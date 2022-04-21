package proy.serpost.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="MENU")
public class Menu {
	@Id
	@Column(name="COD_MENU")
	private int codigoMenu;
	@Column(name="DESC_MENU")
	private String nombreMenu;
	public Menu() {
		super();
	}
	@Column(name="URL_MENU")
	private String urlMenu;
	
	@Override
	public String toString() {
		return "Menu [codigoMenu=" + codigoMenu + ", nombreMenu=" + nombreMenu + ", urlMenu=" + urlMenu + "]";
	}
	
	public Menu(int codigoMenu, String nombreMenu, String urlMenu) {
		super();
		this.codigoMenu = codigoMenu;
		this.nombreMenu = nombreMenu;
		this.urlMenu = urlMenu;
	}
	public int getCodigoMenu() {
		return codigoMenu;
	}
	public void setCodigoMenu(int codigoMenu) {
		this.codigoMenu = codigoMenu;
	}
	public String getNombreMenu() {
		return nombreMenu;
	}
	public void setNombreMenu(String nombreMenu) {
		this.nombreMenu = nombreMenu;
	}
	public String getUrlMenu() {
		return urlMenu;
	}
	public void setUrlMenu(String urlMenu) {
		this.urlMenu = urlMenu;
	}


	
	
	
}
