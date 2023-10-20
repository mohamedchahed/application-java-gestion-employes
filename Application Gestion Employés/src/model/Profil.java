package model;


public class Profil {
	private int idprofil;
	private String libelle;
	public Profil() {
		
	}
	public Profil(String libelle) {
		setLibelle(libelle);
	}
	public Profil(int idProfil, String libelle) {
		setIdprofil(idProfil);
		setLibelle(libelle);
	}
	
	
	
	
	public int getIdprofil() {
		return idprofil;
	}
	public void setIdprofil(int idprofil) {
		this.idprofil = idprofil;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public void addItem(String libelle2) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}