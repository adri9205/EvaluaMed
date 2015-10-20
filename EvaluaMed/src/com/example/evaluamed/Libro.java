package com.example.evaluamed;

public class Libro {
	
public String titulo;
public String isbn;
public String fecha_publicacion;
public String esp;
public String year;
public String id;
public Libro(){
	
	super();
}
public Libro (String id, String titulo, String isbn, String fecha_publicacion, String esp, String year)
{
	this.titulo=titulo;
	this.isbn=isbn;
	this.fecha_publicacion=fecha_publicacion;
	this.esp=esp;
	this.year=year;
	this.id=id;

}

public String getTitulo(){
	return titulo;
}

public String getFecha_publicacion(){
	return fecha_publicacion;
}

public String getIsbn(){
	return isbn;
	
}

public void setTitulo(String titulo){
	this.titulo=titulo;
}

public void setIsbn(String isbn){
	this.isbn=isbn;
}

public void setFecha_publicacion(String fecha_publicacion){
	this.fecha_publicacion=fecha_publicacion;
}

public String getYear(){
	return year;
}

public String getEsp(){
	return esp;
}
public void setYear(String year){
	this.year=year;
}

public void setEsp(String esp){
	this.esp=esp;
}
public String getId(){
	return id;
}
public void setId(String id){
	this.id=id;
}
}