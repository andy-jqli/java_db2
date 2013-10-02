/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ibmconexion;

import java.util.Random;

/**
 *
 * @author Uriel
 */
public class Bot {
    private Conexion c;
    private Conexion_java cj;
    
    public Bot(Conexion c, Conexion_java cj){
        this.c = c;
        this.cj = cj;
    }
    
    public void llenarDatosDB2(int i){
        while(i <= 5){
            if(this.c.insertar("INSERT INTO BD.ciudad(BD.ciudad.idCiudad,BD.ciudad.nombre) VALUES ('"+i+"','Ciudad"+i+"')")){
            }
            i++;
        }
        System.out.println("Las tabla ciudad tiene "+this.c.contarRegistros("BD.ciudad")+" registros");
        
    }
    
    public void llenarDatosMysql(int i){
        Random r = new Random();
        while(i <= 10){
            int random = getRandom(1,5,r);
            if(c.insertar("INSERT INTO alumno(idAlumno,nombre,idCiudad) VALUES('"+i+"','Alumno"+i+"',"+random+")")){
                System.out.println(":)");
            }
            i++;
        }
        System.out.println("Las tabla alumno tiene:  "+this.cj.contarRegistros("alumno")+" registros");  
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
