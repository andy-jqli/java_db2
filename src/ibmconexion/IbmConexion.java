/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ibmconexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

/**
 *
 * @author Uriel
 */
public class IbmConexion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //Conexion a DB2
        Conexion c = new Conexion("db2admin","123456","192.168.1.69",50000,"equipo7");
        //Conexion a mySQL
        Conexion_java cj = new Conexion_java("localhost", "root", "", "equipo7");
        // Crear Bot para llenar datos
        Bot b = new Bot(c,cj);
        Generador g = new Generador(c,cj);
        g.generateTable("BD.ciudad","alumno");
    }
    
   
}
