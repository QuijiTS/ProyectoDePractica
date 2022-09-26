/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.aplicacion;

/**
 *
 * @author quiji
 */
public class Aplicacion {

    public static void main(String[] args) {
        DBConnection db = new DBConnection();
        db.createConnection();
        
        Login l1 = new Login();
        l1.setVisible(true);
        
        MenuAdministrador m1 = new MenuAdministrador();
        m1.setVisible(false);
        
        Factura f1 = new Factura();
        f1.setVisible(true);
    }
}
