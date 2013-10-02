/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ibmconexion;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Uriel
 */
public class IbmConexion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Conexion c = new Conexion("db2admin","123456","192.168.1.69",50000,"equipo7");
        //Conexion_java cj = new Conexion_java("192.168.1.69", "root", "", "equipo7");
        int i = 0;
        ResultSet rs = c.buscar("SELECT * FROM BD.ciudad");
        //System.out.println(""+i);
        /*
        while(i < 5){
            if(c.insertar("INSERT INTO ciudad(idCiudad,nombre) VALUES("+i+",ciudad"+i+")")){
                System.out.println(":)");
            }
            i++;
        }*/
    }
}
