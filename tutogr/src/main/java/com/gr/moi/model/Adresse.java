/**
 * 
 */
package com.gr.moi.model;

import javax.persistence.Embeddable;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
@Embeddable
public class Adresse {

	Long idadresse;
	String rue,ville,pays;
	
	/**
	 * @return the idadresse
	 */
	public Long getIdadresse() {
		return idadresse;
	}
	/**
	 * @param idadresse the idadresse to set
	 */
	public void setIdadresse(Long idadresse) {
		this.idadresse = idadresse;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	
	
}
