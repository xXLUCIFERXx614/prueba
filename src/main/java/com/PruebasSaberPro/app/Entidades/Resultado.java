package com.PruebasSaberPro.app.Entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Resultado {
    
    @Id
    private String id;
    private String numRegistro;
    private String puntajeGeneral;
    private int comunicacionEscrita;
    private int razonamientoCuantitativo;
    private int lecturaCritica;
    private int competenciasCiudadanas;
    private int ingles;
    private int formulacionProyectos;
    private int pensamientoCientifico;
    private int diseñoSoftware;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNumRegistro() {
		return numRegistro;
	}
	public void setNumRegistro(String numRegistro) {
		this.numRegistro = numRegistro;
	}
	public String getPuntajeGeneral() {
		return puntajeGeneral;
	}
	public void setPuntajeGeneral(String puntajeGeneral) {
		this.puntajeGeneral = puntajeGeneral;
	}
	public int getComunicacionEscrita() {
		return comunicacionEscrita;
	}
	public void setComunicacionEscrita(int comunicacionEscrita) {
		this.comunicacionEscrita = comunicacionEscrita;
	}
	public int getRazonamientoCuantitativo() {
		return razonamientoCuantitativo;
	}
	public void setRazonamientoCuantitativo(int razonamientoCuantitativo) {
		this.razonamientoCuantitativo = razonamientoCuantitativo;
	}
	public int getLecturaCritica() {
		return lecturaCritica;
	}
	public void setLecturaCritica(int lecturaCritica) {
		this.lecturaCritica = lecturaCritica;
	}
	public int getCompetenciasCiudadanas() {
		return competenciasCiudadanas;
	}
	public void setCompetenciasCiudadanas(int competenciasCiudadanas) {
		this.competenciasCiudadanas = competenciasCiudadanas;
	}
	public int getIngles() {
		return ingles;
	}
	public void setIngles(int ingles) {
		this.ingles = ingles;
	}
	public int getFormulacionProyectos() {
		return formulacionProyectos;
	}
	public void setFormulacionProyectos(int formulacionProyectos) {
		this.formulacionProyectos = formulacionProyectos;
	}
	public int getPensamientoCientifico() {
		return pensamientoCientifico;
	}
	public void setPensamientoCientifico(int pensamientoCientifico) {
		this.pensamientoCientifico = pensamientoCientifico;
	}
	public int getDiseñoSoftware() {
		return diseñoSoftware;
	}
	public void setDiseñoSoftware(int diseñoSoftware) {
		this.diseñoSoftware = diseñoSoftware;
	}
	
	
	

}
