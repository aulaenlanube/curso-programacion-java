public class Practica1Main {
    
    public static void main(String[] args) {
        
         // Crear empresa
         Empresa empresa = new Empresa("CIF12345", "Mi Empresa");

         // Añadir dos analistas
         empresa.addTrabajador(new Analista("204433963W", "Carles", 2800, "Ingeniería Informática"));
         empresa.addTrabajador(new Analista("204437956R", "Maria", 3000, "Ingeniería Informática"));
 
         // Añadir dos programadores
         empresa.addTrabajador(new Programador("204437963W", "Alba", 1100, "Ingeniería Informática"));
         empresa.addTrabajador(new Programador("204437964W", "Marti", 1200, "Ingeniería Informática"));
 
         // Añadir dos administrativos
         empresa.addTrabajador(new Administrativo("20443300A", "Nuria", 1300, 5));
         empresa.addTrabajador(new Administrativo("20443301A", "Pepe", 1400, 10));
 
         // Añadir dos auxiliares
         empresa.addTrabajador(new Auxiliar("20443302A", "Jose", 1000, 2));
         empresa.addTrabajador(new Auxiliar("20443303A", "Ana", 1100, 3));

         for (Trabajador t : empresa.getTrabajadores()) {
            System.out.println(t);
            
         }
   
    }
}
