/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author dalejwtf
 */
public class Direccion {
    
    private int id_direccion;
    private int id_pais;
    private String callesRes;
    private String ciudad;

    public Direccion(){}
    
    public Direccion(int id_direccion, int id_pais, String callesRes, String ciudad) {
        this.id_direccion = id_direccion;
        this.id_pais = id_pais;
        this.callesRes = callesRes;
        this.ciudad = ciudad;
    }

    public int getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    public int getId_pais() {
        return id_pais;
    }

    public void setId_pais(int id_pais) {
        this.id_pais = id_pais;
    }

    public String getCallesRes() {
        return callesRes;
    }

    public void setCallesRes(String callesRes) {
        this.callesRes = callesRes;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    
    
}
