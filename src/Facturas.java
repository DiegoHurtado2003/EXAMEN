import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Facturas implements Serializable, Comparable {
    double importeBonificacion, importeTotal, importeTotalIVA;
    String nombreEmpresa, fechaEnvio, CIF, codEnvio;
    Conceptos[] concepto;


    public Facturas(String nombreEmpresa, String fechaEnvio,
                    String CIF, String codEnvio, Conceptos[] concepto) {

        this.nombreEmpresa = nombreEmpresa;
        this.fechaEnvio = fechaEnvio;
        this.CIF = CIF;
        this.codEnvio = codEnvio;
        this.concepto = concepto;
        this.importeBonificacion = calcularImporteBonificacion();
        this.importeTotal = calcularImporteTotal();
        this.importeTotalIVA = calcularImporteIVA();
    }

    private double calcularImporteIVA() {
        double importeTotalIva = 0;
        for (int i = 0; i < concepto.length; i++) {
            importeTotalIva = importeTotalIva + this.concepto[i].getImprteIVA();
        }
        return importeTotalIva;
    }

    private double calcularImporteTotal() {
        double importeTotal = 0;
        for (int i = 0; i < concepto.length; i++) {
            importeTotal = importeTotal + this.concepto[i].getImporte();
        }
        return importeTotal;
    }



    /*
    Este método nos devuelve el descuento que le hace la
    farmaceutica al hospital según la cuantía de la factura
     */




    private double calcularImporteBonificacion() {
        double resultado;


        if (this.importeTotalIVA < 1000) {
            resultado = this.importeTotalIVA * 0;
        } else if (this.importeTotalIVA >= 1000 & this.importeTotalIVA <= 3000) {
            resultado = this.importeTotalIVA * 0.1;
        } else {
            resultado = this.importeTotalIVA * 0.15;
        }
        return resultado;
    }

    /*
    Este método sobreescribe el método equals para que
    compare los objetos Facturas por el CIF, la fecha
    de envío y el código de envío.

    Aunque no sé si esté del todo bien, puesto que cuando
    lo utilizo me sale un aviso en amarillo que dice que el método se llama a
    si msimo
     */
    @Override
    public boolean equals(Object o) {
        boolean iguales = this == o;
        assert o instanceof Facturas;
        Facturas facturas = (Facturas) o;
        if (Objects.equals(CIF, facturas.CIF)
                && Objects.equals(fechaEnvio, facturas.fechaEnvio)
                && Objects.equals(codEnvio, facturas.codEnvio)) {
            iguales = true;
        }
        return iguales;
    }

    public int compareTo(Object o) {
        int comparacion = 0;
        if (o instanceof Facturas farmacia) {
            comparacion = this.CIF.compareTo(farmacia.CIF);
            if (comparacion == 0)
                comparacion = this.fechaEnvio.compareTo(farmacia.fechaEnvio);
            if (comparacion == 0)
                comparacion = this.codEnvio.compareTo(farmacia.codEnvio);
        }
        return comparacion;
    }

    @Override
    public String toString() {
        return "Facturas{" +
                "importeBonificacion=" + importeBonificacion +
                ", nombreEmpresa='" + nombreEmpresa + '\'' +
                ", fechaEnvio='" + fechaEnvio + '\'' +
                ", CIF='" + CIF + '\'' +
                ", codEnvio='" + codEnvio + '\'' +
                ", concepto=" + Arrays.toString(concepto) +
                '}';
    }
}
