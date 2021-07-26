/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fungsi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Bara Hoerzz
 */
public class Koneksi {
    public static Connection konek;
    public Connection koneksiDatabase(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver ditemukan");
            String url = "jdbc:mysql://localhost:3306/db_keuangan";
            String user = "root";
            String pass = "";
            konek = DriverManager.getConnection(url,user,pass);
            System.out.println("Database terkoneksi");
        }catch(ClassNotFoundException e){
            System.out.println("Driver tidak ditemukan");
            System.exit(0);
        }catch(SQLException e){
            System.out.println("Koneksi database gagal");
        }
        return konek;
    }
}
