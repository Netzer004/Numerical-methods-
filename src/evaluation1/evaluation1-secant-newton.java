package evaluation1;
import java.util.*;
import java.text.DecimalFormat;

public class evaluation1-secant-newton {
    static DecimalFormat f = new DecimalFormat("#0.0000");
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String pregunta;
        int metodo;

        imprimirPantallaInicio("de su eleccion");
        System.out.println("Ingrese la pregunta: ");
        pregunta = input.nextLine();

        System.out.print("Selecione el metodo para realizar el problema: "
                + "\n(1)->Metodo Newton-Raphson"
                + "\n(2)->Metodo Secante"
                + "\n(10)->Salir"
                + "\nOpcion-> ");
        metodo = input.nextInt();

        while(true) {
            switch(metodo) {
                case 1:
                    System.out.println("Se ha seleccionado Metodo de Newton-Raphson, ingrese los siguientes datos: ");
                    System.out.println(f.format(metodoNewton(pregunta)));
                    break;
                case 2:
                    System.out.println("Se ha seleccionado Metodo de la Secante, ingrese los siguientes datos: ");
                    break;
                case 10:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Seleccione un metodo valido (1,2,10)...");
            }

            System.out.println("Selecione el metodo para realizar el problema: "
                    + "\n(1)->Metodo Newton-Raphson"
                    + "\n(2)->Metodo Secante"
                    + "\n(10)->Salir");
            metodo = input.nextInt();

        }




    }

    static void imprimirPantallaInicio(String tipo) {
        System.out.println("\n\n\t\tInstituto Tecnológico de Culiacán\n"
                + "\t\tIng. En Sistemas Computacionales\n"
                + "Audelo Salas Diego Alejandro\n"
                + "Brandon Gael Uriarte Lopez\n"
                + "Raices de una Ecuación. Método de " + tipo + "\n"
                + "Métodos númericos\n"
                + "De 13:00 a 14:00 horas. " + "\n"
                + "\nEste programa ejecuta el proceso de cálculo de Racies de una ecuación utilizando el método de "
                +tipo+"\n");
    }

    static double metodoNewton(String pregunta) {
        int contador = 1, tCalculos;
        double x1,fx1,fx2,dfx1,x2, error;
        System.out.print("Ingrese x1 -> ");
        x1 = input.nextDouble();
        System.out.print("\nIngrese el error -> ");
        error = input.nextDouble();
        System.out.print("\nIngrese el total de calculos -> ");
        tCalculos = input.nextInt();

        imprimirPantallaInicio("Newton-Raphson");

        fx1=(-0.000234)*(Math.pow((x1-80),2))+1.5;
        dfx1 = -0.000468*x1 + 0.03744;
        System.out.println("PREGUNTA: " + pregunta);
        System.out.println("| Nc\t|\tx1\t|\tf(x1)\t|\tf'(x1)\t|\tx2\t|\tf(x2)\t|");

        do{

            x2 = x1 - (fx1/dfx1);
            fx2 = ((-0.000234)*(Math.pow((x2-80),2)))+1.5;
            System.out.println("| "+ contador +"\t| "+f.format(x1)+"\t| "+f.format(fx1)+"\t| "+f.format(dfx1)+"\t| "+f.format(x2)+"\t| "+f.format(fx2)+"\t|");
            if(Math.abs(fx2) > error) {
                contador ++;
                x1=x2;
                fx1=fx2;
                dfx1 = -0.000468*x2 + 0.03744;
            }else if (contador > tCalculos){
                System.out.println("Se han superado la cantidad de cálculos necesarios...");
                return -1;
            }else {
                System.out.println("La Raíz de la Ecuación = " + x2);
                return x2;
            }

        }while(Math.abs(fx2) > error && contador < tCalculos);



        return 0;
    }
}
