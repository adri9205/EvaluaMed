package com.example.evaluamed;

public class Calificaciones {
	String titulo;
	String descripcion;
	Double calificacion;
public Calificaciones(){
	super();
}
public Calificaciones(String titulo, String descripcion, Double calificacion){
	this.titulo=titulo;
	this.descripcion=descripcion;
	this.calificacion=calificacion;
}
public String getTitulo(){
	return titulo;
}
public String getDescripcion(){
	return descripcion;
}
public Double getCalificacion(){
	return calificacion;
}

public void setTitulo(String titulo){
	this.titulo=titulo;
}
public void setDescripcion(String descripcion){
	this.descripcion=descripcion;
}
public void setCalificacion(Double calificacion)
{
	this.calificacion=calificacion;
}
}
