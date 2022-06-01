import java.io.Serializable;

public class Conceptos implements Serializable {

    double importe, imprteIVA;
    String codigosFactura;

    public double getImporte() {
        return importe;
    }

    public double getImprteIVA() {
        return imprteIVA;
    }

    public String getCodigosFactura() {
        return codigosFactura;
    }

    public Conceptos(double importe, double imprteIVA, String codigosFactura) {
        this.importe = importe;
        this.imprteIVA = imprteIVA;
        this.codigosFactura = codigosFactura;


    }

    @Override
    public String toString() {
        return "Conceptos{" +
                "importe=" + importe +
                ", imprteIVA=" + imprteIVA +
                ", codigosFactura='" + codigosFactura + '\'' +
                '}';
    }

}
