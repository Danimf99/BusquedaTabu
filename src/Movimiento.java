import java.util.Objects;

public class Movimiento {
    private int indexi;
    private int indexj;

    public Movimiento(int indexi, int indexj) {
        this.indexi = indexi;
        this.indexj = indexj;
    }

    public Movimiento(){
        this.indexj = -1;
        this.indexi = -1;
    }
    public int getIndexi() {
        return indexi;
    }

    public void setIndexi(int indexi) {
        this.indexi = indexi;
    }

    public int getIndexj() {
        return indexj;
    }

    public void setIndexj(int indexj) {
        this.indexj = indexj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movimiento that = (Movimiento) o;
        return indexi == that.indexi &&
                indexj == that.indexj;
    }

    @Override
    public int hashCode() {
        return Objects.hash(indexi, indexj);
    }
}
