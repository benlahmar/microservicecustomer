/**
 * 
 */
package com.gr.moi.web;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public class CustomErrorResponse {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timestamp;
    public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	private int status;
    private String error;
    
}
