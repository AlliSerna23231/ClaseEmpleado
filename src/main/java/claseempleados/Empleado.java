package claseempleados;



import javax.swing.JOptionPane;

/**
 *
 * @author allil
 */
public class Empleado {
    private String cedula;
    private String nombre;
    private String direccion;
    private Float salario;


    public Empleado(String cedula, String nombre, String direccion, Float salario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.salario = salario;
        
    }
    
    public void setDireccion(String nuevaDireccion) {
    this.direccion = nuevaDireccion;
    }

    
    public String getcedula(){return cedula;}
    public String getNombre(){return nombre;}
    public Float getsalario(){return salario;}
 

    //Método para mostrar todos los datos (Pendiente)
    public String mostrar() {
        String salida = "";
        salida += cedula + "    " + nombre + "    " + direccion + "   " +salario+ "      ";
        return salida;
    }
    
}