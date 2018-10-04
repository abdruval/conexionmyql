package conexionmysqlcorba;
import Terceros.*;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Abdruval Collazos
 */
public class Tercero extends TerceroPOA{
    
    Conexion objConect = new Conexion();

    @Override
    public boolean insertarTercero(String nombre, String apellido, String telefono) {
        
        
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarTercero(int id, String nombre, String apellido, String telefono) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarTercero(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String consultarTercero(int id) {
        
        String resultado = "";
        
        try {
            
            String sqlConsultar = "Select * from terceros where id = " + id;
            objConect.conectar();
            Statement st = objConect.conex.createStatement();
            ResultSet rs = st.executeQuery(sqlConsultar);
            
            while (rs.next()) {                
                resultado += rs.getString(2) + " - " + rs.getString(3) + " - " + rs.getString(4);
            }
            
            //Cerrar las conexiones.
            rs.close();
            objConect.conex.close();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        
        return resultado;
        
        
        
    }

    @Override
    public void shutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ResultSet cargarTercero(){
        
       ResultSet resultado = null;
       
        try {
            String sqlConsultar = "Select nombres, apellidos, telefono from terceros";
            objConect.conectar();
            Statement st = objConect.conex.createStatement();
            resultado = st.executeQuery(sqlConsultar);
           
            //Cerrar las conexiones.
           // rs.close();
            objConect.conex.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }
       return resultado;
        
        
    }
    
    
}
