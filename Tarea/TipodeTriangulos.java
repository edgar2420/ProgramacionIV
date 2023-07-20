
/*Recibir 3 números double (A, B and C) que representan los lados de un triángulo y ordenarlos de manera decreciente, de tal manera que el lado A sea el mas grande de los tres lados. A continuación, determinar el tipo de triángulo que pueden formar, basado en los siguientes casos, mostrando siempre el mensaje apropiado:
si A ≥ B + C, mostrar el mensaje: NAO FORMA TRIANGULO
si A2 = B2 + C2, mostrar el mensaje: TRIANGULO RETANGULO
si A2 > B2 + C2, mostrar el mensaje: TRIANGULO OBTUSANGULO
si A2 < B2 + C2, mostrar el mensaje: TRIANGULO ACUTANGULO
si los tres lados son del mismo tamaño, mostrar el mensaje: TRIANGULO EQUILATERO
si sólo dos lados son iguales y el tercero es diferente, mostrar el mensaje: TRIANGULO ISOSCELES
Entrada
La entrada contiene tres números double, A (0 < A) , B (0 < B) y C (0 < C).

Salida
Mostrar todas las clasificaciones del triángulo presentadas en la entrada. */
import java.util.Scanner;

public class TipodeTriangulos {
    public static void main(String[] args) {
        double A, B, C;
        Scanner sc = new Scanner(System.in);
        A = sc.nextDouble();
        B = sc.nextDouble();
        C = sc.nextDouble();
        if (A > 0 && B > 0 && C > 0) {
            double aux[] = ordenarDecreciente(new double[] { A, B, C });
            A = aux[0];
            B = aux[1];
            C = aux[2];
            if (A >= (B + C)) {
                System.out.println("NAO FORMA TRIANGULO");
            } else if ((A * A) == ((B * B) + (C * C))) {
                System.out.println("TRIANGULO RETANGULO");
            } else if ((A * A) > ((B * B) + (C * C))) {
                System.out.println("TRIANGULO OBTUSANGULO");
            } else if ((A * A) < ((B * B) + (C * C))) {
                System.out.println("TRIANGULO ACUTANGULO");
            }
            if (A == B && B == C && C == A) {
                System.out.println("TRIANGULO EQUILATERO");
            } else if ((A == B && A != C) || (B == C && B != A) || (A == C && A != B)) {
                System.out.println("TRIANGULO ISOSCELES");
            }
        }
    }

    private static double[] ordenarDecreciente(double[] doubles) {
        for (int i = 0; i < doubles.length; i++) {
            for (int j = 0; j < doubles.length - 1; j++) {
                if (doubles[j] < doubles[j + 1]) {
                    double temporal = doubles[j];
                    doubles[j] = doubles[j + 1];
                    doubles[j + 1] = temporal;
                }
            }
        }
        return doubles;
    }
}