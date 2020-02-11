/**
 * 
 */
package com.gr.moi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
@Entity
public class Profil {

	@Id
	@GeneratedValue
	Long id;
	String nom;
	
	@ElementCollection
	List<String> prenoms;
	@Embedded
	Adresse adresse;
	
	//@JsonIgnore
	@JsonManagedReference
	@OneToMany(mappedBy = "profile", fetch = FetchType.EAGER)
	List<Account> accounts=new ArrayList<>();
	
	

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenoms
	 */
	public List<String> getPrenoms() {
		return prenoms;
	}

	/**
	 * @param prenoms the prenoms to set
	 */
	public void setPrenoms(List<String> prenoms) {
		this.prenoms = prenoms;
	}

	/**
	 * @return the accounts
	 */
	public List<Account> getAccounts() {
		return accounts;
	}

	/**
	 * @param accounts the accounts to set
	 */
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	/**
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
}
