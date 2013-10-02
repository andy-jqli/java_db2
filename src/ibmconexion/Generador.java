/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ibmconexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Uriel
 */
public class Generador {
    private Conexion c;
    private Conexion_java cj;
    public Generador(Conexion c, Conexion_java cj){
        this.c = c;
        this.cj = cj;
    }
    
    public void generateTable(String tablaDb2, String tablaMysql) throws SQLException{
        // idCiudad nombreCiudad idAlumno nombreAlumno
        ResultSet rs = this.c.buscar("SELECT * FROM "+tablaDb2);
        ArrayList ar = new ArrayList();
        while(rs.next()){
            ArrayList auxiliar = new ArrayList();
            String idCiudad = rs.getString("idCiudad");
            ResultSet rs_auxiliar = c.buscar("SELECT * FROM "+tablaMysql+" WHERE idCiudad = "+idCiudad);
            if(rs_auxiliar == null){
                auxiliar.add(rs.getString("idCiudad"));
                auxiliar.add(rs.getString("nombre"));
                auxiliar.add("");
                auxiliar.add("");
                ar.add(auxiliar);
            }
            else{
                while(rs_auxiliar.next()){
                    auxiliar = new ArrayList();
                    auxiliar.add(rs.getString("idCiudad"));
                    auxiliar.add(rs.getString("nombre"));
                    auxiliar.add(rs_auxiliar.getString("idAlumno"));
                    auxiliar.add(rs_auxiliar.getString("nombre"));
                    ar.add(auxiliar);
                }
            }            
        }
        System.out.println(ar.toString());
    }
    
    
}
