/**
 * 
 */
package com.gr.moi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gr.moi.model.Personne;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public interface PersonneRepo extends JpaRepository<Personne, Long>{

}
