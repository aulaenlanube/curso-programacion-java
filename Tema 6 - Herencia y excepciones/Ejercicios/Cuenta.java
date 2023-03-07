import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

public abstract class Cuenta {

    protected int numeroCuenta;
    protected double saldo;
    protected Cliente titular;
    private ArrayList<Movimiento> movimientos;

    //////////////////////////////////////////////////////
    // CONSTRUCTORES
    //////////////////////////////////////////////////////

    public Cuenta(int numeroCuenta, double saldo, Cliente titular) {

        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.titular = titular;
        this.movimientos = new ArrayList<Movimiento>();
    }

    //////////////////////////////////////////////////////
    // GETTERS & SETTERS
    //////////////////////////////////////////////////////

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    //////////////////////////////////////////////////////
    // MÉTODOS ABSTRACTOS
    //////////////////////////////////////////////////////

    public abstract void verDatos(); 

    public abstract void retiro(double cantidad) throws RetiroNoValidoException;

    public abstract void ingreso(double cantidad) throws IngresoNoValidoException;

    //////////////////////////////////////////////////////
    // MÉTODOS
    //////////////////////////////////////////////////////

    public void confirmarIngreso(double cantidad) {

        // se ingresa y se registra
        saldo += cantidad;
        movimientos.add(new Movimiento(LocalDateTime.now(), cantidad, Movimiento.INGRESO));
        System.out.println("Se han ingresado correctamente "+cantidad+"€ en la cuenta "+numeroCuenta);
    }

    protected void confirmarRetiro(double cantidad) {
        saldo -= cantidad;
        movimientos.add(new Movimiento(LocalDateTime.now(), cantidad, Movimiento.RETIRO));
        System.out.println("Se han retirado correctamente "+cantidad+"€ de la cuenta "+numeroCuenta);
    }

    protected String obtenerMovimientos() {
        String s = "";
        for (Movimiento m : movimientos) {
            s += m.toString() + "\n";
        }
        return s;
    }
 
    @Override
    public String toString() {
        return "[numeroCuenta=" + numeroCuenta + ", titular=" + titular.nombreCompleto() + "]";
    }

    //////////////////////////////////////////////////////
    // CLASE MOVIMIENTO
    //////////////////////////////////////////////////////
    
    private class Movimiento {

        private static final byte INGRESO = 0;
        private static final byte RETIRO = 1;

        private LocalDateTime fechaHora;
        private double importe;
        private double saldoFinal;
        private byte tipo;

        public Movimiento(LocalDateTime fechaHora, double importe, byte tipo) {
            this.fechaHora = fechaHora;
            this.importe = importe;
            this.saldoFinal = saldo;
            this.tipo = tipo;
        }

        @Override
        public String toString() {
            return (tipo == INGRESO ? "INGRESO" : " RETIRO")
                    + " [Fecha = " + fechaHora.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM))
                    + ", hora = " + fechaHora.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM))
                    + ", importe = " + importe + "€"
                    + ", saldo = " + saldoFinal + "€"
                    + "]";
        }
    }
}
