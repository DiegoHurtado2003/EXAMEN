import java.io.*;
import java.util.Scanner;
import java.util.TreeSet;

public class Utilidades {
    //Declaro el arraylist para poder utilizarlo después.
    // public static ArrayList<Facturas> listaFacturas = new ArrayList<>();
    public static TreeSet<Facturas> listaFacturas1 = new TreeSet<Facturas>();


    /*
 Este método lee el fichero de texto mediante un bufferscanner;
 mientras va leyendo los datos del fichero le va asignando estos
 datos a unas variables previamente declaradas.

 Con estas variables instanciaremos un objeta de la clase Facturas
 y volcaremos este objeto en el Arraylist que ge declarado al principio.

 Este proceso se repetirá hasta que no haya más datos en el archivo.
     */
    public void leerFichero() {
        String nombreEmpresa = null, fechaEnvio = null, CIF = null, codEnvio = null, cadena = null;
        double importe = 0, importeIva = 0;
        //String[] codigosFactura = new String[4];
        String codigosFactura = null;
        Scanner sc = null;
        BufferedReader lector = null;
        Facturas facturas;
        Conceptos[] arrayConceptos = new Conceptos[4];
        try {
            lector = new BufferedReader(new FileReader("facturasmezcladas.txt"));
            cadena = lector.readLine();
            //Lectura de los datos
            while (cadena != null) {
                sc = new Scanner(cadena);
                if (sc.hasNext()) {
                    CIF = sc.next();
                }

                if (sc.hasNext()) {
                    nombreEmpresa = sc.next();
                }

                if (sc.hasNext()) {
                    fechaEnvio = sc.next();
                }

                if (sc.hasNext()) {
                    codEnvio = sc.next();
                }


                for (int i = 0; i <= 3; i++) {
                    if (sc.hasNext()) {
                        codigosFactura = sc.next();
                    }

                    if (sc.hasNextDouble()) {
                        importe = sc.nextDouble();
                    }

                    if (sc.hasNextDouble()) {
                        importeIva = sc.nextDouble();
                    }

                    arrayConceptos[i] = new Conceptos(importe, importeIva, codigosFactura);
                }
                /*
                 *            if (sc.hasNext()) {
                    codigosFactura[0] = sc.next();
                }

                if (sc.hasNextDouble()) {
                    importe = sc.nextDouble();
                }

                if (sc.hasNextDouble()) {
                    importeIva = sc.nextDouble();
                }


                if (sc.hasNext()) {
                    codigosFactura[1] = sc.next();
                }

                if (sc.hasNextDouble()) {
                    importe = importe + sc.nextDouble();
                }

                if (sc.hasNextDouble()) {
                    importeIva = importeIva + sc.nextDouble();
                }


                if (sc.hasNext()) {
                    codigosFactura[2] = sc.next();
                }

                if (sc.hasNextDouble()) {
                    importe = importe + sc.nextDouble();
                }

                if (sc.hasNextDouble()) {
                    importeIva = importeIva + sc.nextDouble();
                }


                if (sc.hasNext()) {
                    codigosFactura[3] = sc.next();
                }

                if (sc.hasNextDouble()) {
                    importe = importe + sc.nextDouble();
                }

                if (sc.hasNextDouble()) {
                    importeIva = importeIva + sc.nextDouble();
                }
                 */


                facturas = new Facturas(nombreEmpresa,
                        fechaEnvio, CIF, codEnvio, arrayConceptos);

                //  listaFacturas.add(facturas);
                listaFacturas1.add(facturas);
                cadena = lector.readLine();
            }
        } catch (IOException fileNotFoundException) {
            System.err.println("Error, " + fileNotFoundException);
        } catch (Exception Exc) {
            System.err.println(Exc);
        }finally {
            try {
                lector.close();
            } catch (IOException e) {
                System.err.println("Error en el cierre, " + e);;
            }
        }
    }

  /*
  Este método elimina los elementos duplicados de
  la lista, ayundandose del método equals. Esto lo hace haciendo
  que si hay un objeto igual al que estamos situado en un momento concreto
  elimina el resto que se repitan.
   */

    /*
        public void eliminarDuplicado() {
        for (int i = 0; i < listaFacturas.size(); i++) {
            for (int j = i; j < listaFacturas.size(); j++) {
                if (listaFacturas.get(i).equals(listaFacturas.get(j))) {
                    listaFacturas.remove(listaFacturas.get(j));
                }            }
        }
    }
     */


    public void ordenarLista() {
        System.out.println("No sé ordenarlo");
    }//Lo ordena el treeset

    /*
    En este método escribimos en un archivo los datos del rraylist que previamente
    hemos creado y modificado para que no haya elementos duplicados.
     */
    public void escrbirFichero() {

        ObjectOutputStream escritor = null;
        try {
            escritor = new ObjectOutputStream(new FileOutputStream("facturasparapagar.bin"));

/*
            for (int i = 0; i < listaFactoras1.size(); i++) {
                escritor.writeObject(listaFactoras1.get(i));
            }

 */
            for (Facturas articulo : listaFacturas1) {
                System.out.println(articulo);
                escritor.writeObject(articulo);

            }
            System.out.println(listaFacturas1.size());
        } catch (IOException fileNotFoundException) {
            System.err.println("Error, no se encontró el archivo " + fileNotFoundException);
        } finally {
            try {
                assert escritor != null;
                escritor.close();
            } catch (IOException ioException) {
                System.err.println("Error, " + ioException);
            }
        }
    }


}
