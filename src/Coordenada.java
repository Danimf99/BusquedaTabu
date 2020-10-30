import java.util.Objects;

public class Coordenada {
    private double latitud;
    private double longitud;
    private final int RADIUS = 6371;

    public Coordenada(double latitud, double longitud) {
        //Cambios de grados a radianes
        this.latitud = latitud * Math.PI / 180;
        this.longitud = longitud * Math.PI / 180;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public double distancia(Coordenada destino) {
        double op1 = (destino.getLatitud() - this.latitud) / 2;
        double op2 = (destino.getLongitud() - this.longitud) / 2;

        op1 = Math.pow(Math.sin(op1), 2);
        op2 = Math.pow(Math.sin(op2), 2);
        op2 = Math.cos(this.latitud) * Math.cos(destino.getLatitud()) * op2;

        double op3 = Math.asin(Math.sqrt(op1 + op2));

        return Math.ceil(2 * RADIUS * op3);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordenada that = (Coordenada) o;
        return Double.compare(that.latitud, latitud) == 0 &&
                Double.compare(that.longitud, longitud) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitud, longitud);
    }
}
