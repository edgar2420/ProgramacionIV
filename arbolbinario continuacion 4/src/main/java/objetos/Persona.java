package objetos;

public class Persona implements Comparable<Persona>{
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public int compareTo(Persona o) {
        /*
        * > 0
        * = 0
        * < 0
        * */

            //  21 - 21 = 0
        return edad - o.getEdad();
    }
}









