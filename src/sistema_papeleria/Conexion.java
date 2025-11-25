/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema_Papeleria;

import java.sql.*;

/**
 *
 * @author aaaaa
 */
public class Conexion {
     Connection BaseDatos = null;
     Statement st = null;
  
    //Donde se localiza la base de datos
    String url="jdbc:postgresql://localhost:5432/Papeleria";
  
    //Credenciales de la base de datos
    String usuario="postgres";
    String contrasena="postgres";
    public Connection conectar(){
        try {
            BaseDatos = DriverManager.getConnection(url,usuario,contrasena);
            System.out.println("Base de datos Conectada!");
        } catch (Exception e) {
            System.out.println("Error al conectar"+e);
        }
        return BaseDatos;
    }
    public static void main(String[] args) {
        Conexion c = new Conexion();
        c.conectar();
        
    }
}
