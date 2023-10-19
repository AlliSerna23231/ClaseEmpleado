package claseempleados;


import javax.swing.JOptionPane;

/**
 *
 * @author allil
 */
public class ClaseEmpleado {

    
    public static void main(String[] args) {
        int ne,opcion;
        int dato;
        Empleado vecEmpleado[];
        String menu="************MENU***********\n"+
                "1. Mostrar datos\n"+
                "2. Mostrar suma de salario\n"+
                "3. Ordenar empleados según su cédula\n"+
                "4. Buscar por cédula\n"+
                "5. Modificar la dirección de un empleado\n"+
                "6. Mostrar el nombre y la cédula del\n"
                + "empleado con menor salario\n"+
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
            case 4:buscarPorCedula(vecEmpleado);
            break;
            case 5: modificarDireccion(vecEmpleado);
            break;
            case 6: mostrarEmpleadoConMenorSalario(vecEmpleado);
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
    
    private static void mostrarEmpleadoConMenorSalario(Empleado[] vecEmpleado) {
    if (vecEmpleado.length == 0) {
        JOptionPane.showMessageDialog(null, "No hay empleados para mostrar.");
        return;
    }
    
    Empleado empleadoMenorSalario = vecEmpleado[0];

    for (int k = 1; k < vecEmpleado.length; k++) {
        if (vecEmpleado[k].getsalario() < empleadoMenorSalario.getsalario()) {
            empleadoMenorSalario = vecEmpleado[k];
        }
    }
    
    JOptionPane.showMessageDialog(null, "Empleado con menor salario:\nNombre: " + empleadoMenorSalario.getNombre() + "\nCédula: " + empleadoMenorSalario.getcedula());
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
    
    
    private static void buscarPorCedula(Empleado[] vecEmpleado) {
    String cedulaBuscada = JOptionPane.showInputDialog("Ingrese la cédula a buscar:");
    boolean encontrado = false;
    for (int k = 0; k < vecEmpleado.length; k++) {
        if (vecEmpleado[k].getcedula().equals(cedulaBuscada)) {
            
            JOptionPane.showMessageDialog(null, "Empleado encontrado:\n"
                    +"Nombre  Cédula  Dirección  Salario\n" + vecEmpleado[k].mostrar());
            encontrado = true;
            break; // Si se encuentra, podemos salir del bucle.
        }
    }
    if (!encontrado) {
        JOptionPane.showMessageDialog(null, "Empleado con cédula " + cedulaBuscada + " no encontrado.");
    }
}
    
    public static void buscarCed(Empleado vecEmpleado[], int dato){
        int ced;
        
        
         for (int k = 0; k < vecEmpleado.length; k++) {
            ced = Integer.parseInt(vecEmpleado[k].getcedula());
            if (ced == dato) {
                vecEmpleado[k].mostrar();
            }else{
                JOptionPane.showMessageDialog(null, "No se encontró ningún empleado con la identificación proporcionada.");
            } 
        }
    
    }
    
    
    private static void modificarDireccion(Empleado[] vecEmpleado) {
    String cedulaBuscada = JOptionPane.showInputDialog("Ingrese la cédula del empleado cuya dirección desea modificar:");
    boolean encontrado = false;
    for (int k = 0; k < vecEmpleado.length; k++) {
        if (vecEmpleado[k].getcedula().equals(cedulaBuscada)) {
            String nuevaDireccion = JOptionPane.showInputDialog("Ingrese la nueva dirección:");
            vecEmpleado[k].setDireccion(nuevaDireccion);
            JOptionPane.showMessageDialog(null, "Dirección modificada exitosamente.");
            encontrado = true;
            break; // Si se encuentra, podemos salir del bucle.
        }
    }
    if (!encontrado) {
        JOptionPane.showMessageDialog(null, "Empleado con cédula " + cedulaBuscada + " no encontrado.");
    }
}

    
}