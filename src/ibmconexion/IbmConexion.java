/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ibmconexion;

/**
 *
 * @author Uriel
 */
public class IbmConexion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        Conexion c = new Conexion("db2admin","123456","192.168.1.69",50000,"equipo7");
    }
}
