public class Practica3Main {

    public static void main(String[] args) {

        Empresa empresa = new Empresa();
    
        EmpleadoPorHoras empleado1 = new EmpleadoPorHoras("Juan", "Perez", "111A", 0, 40, 10);
        EmpleadoFijo empleado2 = new EmpleadoFijo("Maria", "Lopez", "222B", 0, 2000);
    
        empresa.agregarEmpleado(empleado1);
        empresa.agregarEmpleado(empleado2);
    
        for (Empleado empleado : empresa.getEmpleados()) {
            System.out.println(empleado.toString());
        }
    
        try {
            empresa.eliminarEmpleado("1111");
            empresa.eliminarEmpleado("111A");
        } catch (EmpleadoNoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    
        for (Empleado empleado : empresa.getEmpleados()) {
            System.out.println(empleado.toString());
        }
    }
}
    