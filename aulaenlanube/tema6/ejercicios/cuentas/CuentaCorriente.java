package aulaenlanube.tema6.ejercicios.cuentas;

import aulaenlanube.tema4.bordes.BordesMatrices;

public class CuentaCorriente extends Cuenta {

    public CuentaCorriente(int numeroCuenta, Cliente titular) {
        super(numeroCuenta, 0, titular);
    }

    @Override
    public void verDatos() {

        String s = "";
        s += "Nºcuenta: " + numeroCuenta + " - CUENTA CORRIENTE\n";
        s += "Titular: " + titular.nombreCompleto() + ", domicilio en " + titular.direccionCompleta() + "\n";
        s += "Saldo actual: " + saldo + "€\n";
        s += "------------------------  M O V I M I E N T O S  ------------------------\n";
        s += obtenerMovimientos();
        BordesMatrices.mostrarTextoConBordes(s);
    }

    @Override
    public String toString() {
        return "CuentaCorriente " + super.toString();
    }

    @Override
    public void retiro(double cantidad) throws RetiroNoValidoException {
        if (cantidad > 300)
            throw new RetiroNoValidoException("retiro máximo 300€");
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
