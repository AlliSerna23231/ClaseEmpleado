
package claseempleados;

import javax.swing.JOptionPane;

/**
 *
 * @author allil
 */
public class ClaseEmpleados {

    
    public static void main(String[] args) {
        int ne,opcion;
        int dato;
        Empleado vecEmpleado[];
        String menu="************MENU***********\n"+
                "1. Mostrar datos\n"+
                "2. Mostrar suma de salario\n"+
                "3. Ordenar empleados según su cédula\n"+
                "4. Buscar por cédula\n"+
                "5. Mostrar ordenado por identificación\n"+
                "6. Permitir modificar nombre\n"+
                "7. Permitir modificar las notas\n"+
                "0. Salir\n"+
                "Digite Opción";
        ne=Integer.parseInt(JOptionPane.showInputDialog("Cuantos empleados son"));
        vecEmpleado = new Empleado[ne];
        ingresarDatos(vecEmpleado);
        do { opcion=Integer.parseInt(JOptionPane.showInputDialog(menu));
        switch(opcion){
            case 1: mostrarDatos(vecEmpleado);
            break;
            case 2: mostrarSS(vecEmpleado);
            break;
            case 3: OrdenarCed(vecEmpleado);
                    mostrarDatos(vecEmpleado);
            break;
            case 4:
                dato = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cédula a buscar"));
                buscarCed(vecEmpleado, dato);
                
            break;
            case 5: System.out.println("Hola");
            break;
            case 6: System.out.println("Hola");
            break;
            case 7: System.out.println("Hola");
            break;
            case 0: System.exit(0);
        }   
        }while (opcion!=0);
    }//Fin main
       
    
    
    private static void ingresarDatos(Empleado vecEmpleado[]) {
        int k;
        String cedula, direccion,nombre;
        float salario;
        for (k = 0; k < vecEmpleado.length; k++) {
            nombre = JOptionPane.showInputDialog("Ingrese el nombre");
            cedula = JOptionPane.showInputDialog("Ingrese la cedula");
            direccion = JOptionPane.showInputDialog("Ingrese la direccion");
            salario = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el salario"));
            vecEmpleado[k] = new Empleado(cedula, nombre,direccion,salario);
        }
    }
    private static void mostrarDatos(Empleado vecEmpleado[]) {
        String salida="";
        for(int k=0; k<vecEmpleado.length; k++){
            salida+=vecEmpleado[k].mostrar()+"\n";
        }
        JOptionPane.showMessageDialog(null, "Nombre  Cédula  Dirección  Salario\n"+salida);
    }

    private static void mostrarSS(Empleado vecEmpleado[]) {
        int suma=0;
        for(int k=0; k<vecEmpleado.length; k++){
            suma = (int) (suma + vecEmpleado[k].getsalario());
        }
        JOptionPane.showMessageDialog(null, "Suma Salario\n"+suma);
    }
    
    private static void OrdenarCed(Empleado vecEmpleado[]) {
        int k, j;
        Empleado aux;
        for (k = 0; k < vecEmpleado.length - 1; k++) {
            for (j = 0; j < vecEmpleado.length - k - 1; j++) {
                if (vecEmpleado[j].getcedula().compareToIgnoreCase(vecEmpleado[j + 1].getcedula()) > 0) {
                    aux = vecEmpleado[j];
                    vecEmpleado[j] = vecEmpleado[j + 1];
                    vecEmpleado[j + 1] = aux;
                }
            }
        }
    }
    
    public static void buscarCed(Empleado vecEmpleado[], int dato){
        int ced;
        
        ced = Integer.parseInt(vecEmpleado.getcedula());
            if (ced == dato) {
               // vecEmpleado.mostrar();
            }
        
         for (int k = 0; k < vecEmpleado.length; k++) {
            ced = Integer.parseInt(vecEmpleado[k].getcedula());
            if (ced == dato) {
                vecEmpleado[k].mostrar();
            }else{
                JOptionPane.showMessageDialog(null, "No se encontró ningún empleado con la identificación proporcionada.");
            } 
        }
    
    }
}
