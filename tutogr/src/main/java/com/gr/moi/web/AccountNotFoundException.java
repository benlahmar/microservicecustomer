/**
 * 
 */
package com.gr.moi.web;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public class AccountNotFoundException extends RuntimeException {

	public AccountNotFoundException(Long id) {
        super("Account id not found : " + id);
    }
}
