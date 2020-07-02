package com.planificador.modelo;

public class Pais {
	private String cod_pais;
	private String pais;
	
	public Pais() {
		super();
	}
	
	public Pais(String cod_pais, String pais) {
		super();
		this.cod_pais = cod_pais;
		this.pais = pais;
	}

	public String getcod_pais() {
		return cod_pais;
	}
	public void setcod_pais(String cod_pais) {
		this.cod_pais = cod_pais;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}

}