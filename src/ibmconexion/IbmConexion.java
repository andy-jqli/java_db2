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
        
        //Populate the DB2 TABLE
        int i = 1;        
        while(i <= 5){
            if(c.insertar("INSERT INTO BD.ciudad(BD.ciudad.idCiudad,BD.ciudad.nombre) VALUES ('"+i+"','Ciudad"+i+"')")){
                System.out.println(":)");
            }
            i++;
        }
        System.out.println("Las tabla ciudad tiene "+c.contarRegistros("BD.ciudad")+" registros");
        
        //Populate the mySQL TABLE
        /*
        int i = 1;
        Random r = new Random();
        while(i <= 10){
            int random = getRandom(1,5,r);
            if(c.insertar("INSERT INTO alumno(idAlumno,nombre,idCiudad) VALUES('"+i+"','Alumno"+i+"','Ciudad"+random+"')")){
                System.out.println(":)");
            }
            i++;
        }
        System.out.println("Las tabla alumno tiene:  "+cj.contarRegistros("alumno")+" registros");  
        */
    }
    
    private static int getRandom(int aStart, int aEnd, Random aRandom){
        if (aStart > aEnd) {
            throw new IllegalArgumentException("Start cannot exceed End.");
        }
    
        long range = (long)aEnd - (long)aStart + 1;
    
        long fraction = (long)(range * aRandom.nextDouble());
        int randomNumber =  (int)(fraction + aStart);    
    
        return randomNumber;
    }
}
