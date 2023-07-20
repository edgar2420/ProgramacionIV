
/* Tenemos algunos textos y queremos justificarlos a la derecha, es decir, alinearlos a la derecha. Cree un programa que lea un texto, lo formatee correctamente, justifique todas sus líneas, imprimiéndolas en el mismo orden en que aparecen en la entrada.

Aporte
La entrada contiene varios casos de prueba. La primera línea de un caso de prueba contendrá un número entero N (1 ≤ N ≤ 100) indicando el número de líneas que forman el texto. Cada una de las siguientes N líneas contendrá un texto, compuesto de 1 a 50 letras mayúsculas ('A'-'Z') o espacios (' '). Todas las líneas de texto contendrán al menos una letra. Puede haber más de un carácter de espacio entre palabras. Además, puede haber espacios iniciales y finales en las líneas de entrada. El final de la entrada se indica mediante N = 0.

Producción
Para cada caso de prueba, imprima las líneas de texto con un solo carácter de espacio entre palabras, y rellene a la izquierda con caracteres de espacio para que todas las líneas tengan la misma longitud que la línea más larga existente en ese texto. Imprima una línea vacía entre todos los casos de prueba. No debe haber espacios finales impresos, y debe descartar los espacios iniciales innecesarios, de modo que al menos una línea de cada texto comience con una letra. */
import java.util.Scanner;

public class Justifier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n != 0) {
            String line = sc.nextLine();
            String[] words = line.split(" ");
            int max = 0;
            for (int i = 0; i < words.length; i++) {
                if (words[i].length() > max) {
                    max = words[i].length();
                }
            }
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                while (word.length() < max) {
                    word = word + " ";
                }
                System.out.print(word);
            }
            System.out.println();
            n = sc.nextInt();
        }
    }
}