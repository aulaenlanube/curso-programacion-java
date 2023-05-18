package aulaenlanube.tema6.ejercicios.cuentas;

import aulaenlanube.tema4.bordes.Bordes;

public class CuentaVivienda extends Cuenta {

    public CuentaVivienda(int numeroCuenta, Cliente titular) {
        super(numeroCuenta, 1000, titular);
    }

    @Override
    public void verDatos() {

        String s = "";
        s += "Nºcuenta: " + numeroCuenta + " - CUENTA VIVIENDA\n";
        s += "Titular: " + titular.nombreCompleto() + ", domicilio en " + titular.direccionCompleta() + "\n";
        s += "Saldo actual: " + saldo + "€\n";
        s += "------------------------  M O V I M I E N T O S  ------------------------\n";
        s += obtenerMovimientos();
        Bordes.mostrarTextoConBordes(s);
    }

    @Override
    public String toString() {
        return "CuentaVivienda " + super.toString();
    }

    @Override
    public void retiro(double cantidad) throws RetiroNoValidoException {
        if (cantidad > 500)
            throw new RetiroNoValidoException("retiro máximo 500€");
        if (cantidad > saldo)
            throw new RetiroNoValidoException("saldo insuficiente");
        if (cantidad < 10)
            throw new RetiroNoValidoException("retiro mínimo 10€");
        confirmarRetiro(cantidad);
    }

    @Override
    public void ingreso(double cantidad) throws IngresoNoValidoException {
        if (cantidad < 10)
            throw new IngresoNoValidoException("ingreso mínimo 10€");
        confirmarIngreso(cantidad);
    }
}
