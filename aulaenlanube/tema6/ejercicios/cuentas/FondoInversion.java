package aulaenlanube.tema6.ejercicios.cuentas;

import aulaenlanube.tema4.bordes.BordesMatrices;

public class FondoInversion extends Cuenta {

    private double interes;

    public FondoInversion(int numeroCuenta, Cliente titular) {
        super(numeroCuenta, 5000, titular);
        calcularInteres();
    }

    public double getInteres() {
        return interes;
    }

    private void calcularInteres() {
        if (saldo >= 100_000)
            interes = 5;
        else if (saldo >= 50_000)
            interes = 4;
        else
            interes = 2;
    }

    @Override
    public void verDatos() {

        String s = "";
        s += "Nºcuenta: " + numeroCuenta + " - FONDO DE INVERSIÓN AL " + interes + "%\n";
        s += "Titular: " + titular.nombreCompleto() + ", domicilio en " + titular.direccionCompleta() + "\n";
        s += "Saldo actual: " + saldo + "€\n";
        s += "------------------------  M O V I M I E N T O S  ------------------------\n";
        s += obtenerMovimientos();
        BordesMatrices.mostrarTextoConBordes(s);
    }

    @Override
    public String toString() {
        return "FondoInversion " + super.toString();
    }

    @Override
    public void retiro(double cantidad) throws RetiroNoValidoException {
        if (cantidad < 500)
            throw new RetiroNoValidoException("retiro mínimo 500€");
        if (saldo - cantidad < 3000)
            throw new RetiroNoValidoException(
                    "saldo insuficiente, deben haber como mínimo 3000€ en el fondo de inversión, el saldo actual es "
                            + saldo + "€");
        confirmarRetiro(cantidad);
        calcularInteres();
    }

    @Override
    public void ingreso(double cantidad) throws IngresoNoValidoException {
        if (cantidad < 500)
            throw new IngresoNoValidoException("ingreso mínimo 500€");
        confirmarIngreso(cantidad);
        calcularInteres();
    }
}
