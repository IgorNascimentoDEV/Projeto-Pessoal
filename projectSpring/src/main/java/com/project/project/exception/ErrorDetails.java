package com.project.project.exception;

import java.util.Date;

public class ErrorDetails {
	
	private Date timestamp;
	private String mensagem;
	private String detalhes;
	
	public ErrorDetails(Date timestamp, String mensagem, String detalhes) {
		this.timestamp = timestamp;
		this.mensagem = mensagem;
		this.detalhes = detalhes;
	}
	
	
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	
}
