package objetos;

public class Peso {

    private int medida;
    private String unidad;

    public Peso(int medida, String unidad) {
        this.medida = medida;
        this.unidad = unidad;
    }

    public int getMedida() {
        return medida;
    }

    public void setMedida(int medida) {
        this.medida = medida;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
}
