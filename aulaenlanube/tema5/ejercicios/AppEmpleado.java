package aulaenlanube.tema5.ejercicios;
public class AppEmpleado {

    public static void main(String[] args) {
        
        Empleado e1 = new Empleado();
        Empleado e2 = new Empleado("Pep",19,2000);
        Empleado e3 = new Empleado("Tom",1,1000);
        Empleado e4 = new Empleado("Jon",5,1500);


        e1.subirSalario(100);
        e2.subirSalario(10);
        e3.subirSalario(20);
        e4.subirSalario(50);

        e1.mostrarDatos();
        e2.mostrarDatos();
        e3.mostrarDatos();
        e4.mostrarDatos();
    }
    
}
