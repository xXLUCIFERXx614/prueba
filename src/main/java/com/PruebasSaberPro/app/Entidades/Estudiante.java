package com.PruebasSaberPro.app.Entidades;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class Estudiante {
    
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private String tipoDoc;
    private String numeroDeCC;
    private String email;
    private String telefono;
    private String contraseña;
    private String role;
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
	
    // Getters y Setters
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getNumeroDeCC() {
        return numeroDeCC;
    }

    public void setNumeroDeCC(String numeroDeCC) {
        this.numeroDeCC = numeroDeCC;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
