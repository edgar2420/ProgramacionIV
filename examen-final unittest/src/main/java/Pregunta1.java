import java.io.InputStream;
import java.util.ArrayList;

public class Pregunta1 {

    /**
     * 
     * @param in Repesenta la entrada
     * @return Retorna una lista con las salidas
     */
    public ArrayList<Integer> resolver(InputStream in){
        ArrayList<Integer> output = new ArrayList<>();
        return null;
    }

    private void addToOutput(int value, ArrayList<Integer> output){
        output.add(value);
        System.out.println(value);
    }

    public static void main(String[] args) {
        
        Pregunta1 p1 = new Pregunta1();
        ArrayList<Integer> output = p1.resolver(System.in);



    }


}
