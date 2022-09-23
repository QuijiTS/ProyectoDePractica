/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author quiji
 */
public class DBConnection {
    static Connection connection;
    private final String url = "jdbc:mysql://localhost:3306/RestauranteDeOtroMundo?useSSL=false";
    private final String user = "root";
    private final String password = "Tempest18";
    
    public void createConnection() {
    try {
        connection = DriverManager.getConnection(url, user, password);
            System.out.println("SE INICIO LA CONEXION");
        } catch(SQLException e) {
            System.out.println("NO SE INICIO LA CONEXION");
            System.out.println(e.getMessage());
        }
    }
}
