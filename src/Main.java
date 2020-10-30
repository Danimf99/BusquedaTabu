import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        //Cargar ficheros de inicio
        if (args.length == 0 || args.length > 2) {
            System.out.println("Parametros incorrectos");
            return;
        }

        File fCoordenadas = new File(args[0]);
        File fAleatorios;

        Scanner lectorCoord = new Scanner(fCoordenadas);

        Coordenada[] coordenadas = new Coordenada[Integer.parseInt(lectorCoord.nextLine())];
        int i = 0;

        //Guardamos en un array las coordenadas de cada concello
        while (lectorCoord.hasNextLine()) {
            String[] coord = lectorCoord.nextLine().split(" ");
            coordenadas[i] = new Coordenada(Double.parseDouble(coord[0]), Double.parseDouble(coord[1]));
            ++i;
        }
        lectorCoord.close();

        //SI nos pasan fichero de aleatorios creamos la solucion inicial a partir de el
        if (args.length == 2) {
            fAleatorios = new File(args[1]);
            Scanner lectorAleatorios = new Scanner(fAleatorios);
            ArrayList<Integer> solucionInicial = new ArrayList();

            while (lectorAleatorios.hasNextLine()) {
                double random = Double.parseDouble(lectorAleatorios.nextLine());
                int v = 1 + (int) Math.floor(random * (coordenadas.length - 1));
                while (solucionInicial.contains(v)) {
                    v = (v + 1) % (coordenadas.length - 1);
                    if(v == 0){
                        v = coordenadas.length-1;
                    }
                }
                solucionInicial.add(v);
            }

            lectorAleatorios.close();

            BusquedaTabu bt = new BusquedaTabu(coordenadas, solucionInicial);
            bt.solucion();

            return;
        }

        //Iniciamos la busqueda de la solucion
        BusquedaTabu bt = new BusquedaTabu(coordenadas);
        bt.solucion();

    }
}
