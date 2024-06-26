import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ObjDatos = new Scanner(System.in);

        int fallos = 0;
        int continuar = 0;
        int [] CLAVES = {3782, 5463, 7253, 6372, 9642, 8365, 1284};
        double [] deudas = {56733, 0, 20000, 63737, 8712, 0};
        double [] saldos = {16784, 74, 928742, 781, 6432, 36713, 7832};

        /*INGRESO A LA CUENTA*/
        do {
        System.out.print("Ingrese su clave PIN de cuatro dígitos: ");
        int clave = ObjDatos.nextInt();

        /*VERIFICACIÓN Y BLOQUEO DE CUENTA*/
        while (continuar == 0) {
            for (int i = 0; i < CLAVES.length && continuar != 1; i++) {
                if (CLAVES[i] == clave) {
                    System.out.println("\nClave PIN ingresada con éxito. Ejecutando programa...");
                    continuar++;
                }
            }

            if (continuar == 0 && fallos != 3) {
                fallos++;
                System.out.println("\nLa clave PIN ingresada es incorrecta. Inténtelo nuevamente.");
                System.out.print("Ingrese su clave PIN de cuatro dígitos (" + (4 - fallos) + " intentos disponibles): ");
                clave = ObjDatos.nextInt();
            }

            else if (fallos == 3) {
                System.out.println("\nSuperó la cantidad máxima de intentos disponibles.");
                System.out.println("\nEjecutando bloqueo automático de la tarjeta.");
                System.out.println("Cerrando programa...");
                continuar += 2;
            }
        }

        /*MENÚ DESPLEGABLE*/
        while (continuar == 1) {

            System.out.println("""
                    \n\t\t\tMENÚ
                    1) Consultar dinero en cuenta.
                    2) Pagar tarjeta de crédito.
                    3) Depositar efectivo.
                    4) Retirar efectivo.
                    5) Cerrar sesión.
                    6) Salir.""");

            System.out.print("\nIngrese el número correspondiente a la acción que quiera realizar: ");
            int menu = ObjDatos.nextInt();
            if (menu != 1 && menu != 2 && menu != 3 && menu != 4 && menu != 5 && menu != 6) {
                while (menu != 1 && menu != 2 && menu != 3 && menu != 4 && menu != 5 && menu != 6){
                    System.out.print("El término ingresado no es válido. Inténtelo nuevamente: ");
                    menu = ObjDatos.nextInt();
                }
            }

            if (menu == 1) { /*CONSULTAR DINERO EN CUENTA*/

                for (int i = 0; i < CLAVES.length; i++) {
                    if (CLAVES[i] == clave){
                        System.out.println("\nDinero disponible en cuenta: $" + saldos[i]);
                        System.out.println("Volviendo al menú de inicio...");
                    }
                }

            }
            else if (menu == 2) { /*PAGAR TARJETA DE CRÉDITO*/

                for (int i = 0; i < CLAVES.length; i++) {
                    if (CLAVES[i] == clave){
                        System.out.println("\nSaldo a abonar: $" + deudas[i]);
                        if (deudas[i] == 0) {
                            System.out.println("No tiene pagos pendientes. Volviendo al menú de inicio...");
                        }
                        else {
                            System.out.print("¿Desea pagar con el dinero disponible en cuenta? SI [1] | NO [0]: ");
                            int respuesta = ObjDatos.nextInt();
                            if (respuesta != 1 && respuesta != 0) {
                                while (respuesta != 1 && respuesta != 0){
                                    System.out.print("El término ingresado no es válido. Inténtelo nuevamente: ");
                                    respuesta = ObjDatos.nextInt();
                                }
                            }
                            if (respuesta == 1 && saldos[i] >= deudas[i]) {
                                saldos[i] -= deudas[i];
                                deudas[i]  = 0;
                                System.out.println("Operación realizada con éxito. Volviendo al menú de inicio...");
                            }
                            else if (respuesta == 1 && saldos[i] < deudas[i]) {
                                System.out.println("\nEl dinero en cuenta es menor al saldo a abonar.");
                                System.out.println("Inténtelo nuevamente más tarde. Volviendo al menú de inicio...");
                            }
                            else {
                                System.out.println("\nVolviendo al menú de inicio...");
                            }
                        }
                    }
                }

            }
            else if (menu == 3) { /*DEPOSITAR EFECTIVO*/
                System.out.print("\nIngrese el monto de dinero a depositar: $");
                double monto_dep = ObjDatos.nextDouble();

                for (int i = 0; i < CLAVES.length; i++) {
                    if (CLAVES[i] == clave) {
                        saldos[i] += monto_dep;
                    }
                }
                System.out.println("Operación realizada con éxito. Volviendo al menú de inicio...");
            }
            else if (menu == 4) { /*RETIRAR EFECTIVO*/
                System.out.print("\nIngrese el monto de dinero a retirar: $");
                double monto_ret = ObjDatos.nextDouble();

                for (int i = 0; i < CLAVES.length; i++) {
                    if (CLAVES[i] == clave) {
                        if (monto_ret > saldos[i]) {
                            while (monto_ret > saldos[i]) {
                                System.out.print("\nEl monto ingresado supera la cantidad de dinero disponible en cuenta. Por favor, ingrese un valor menor a " + monto_ret + ": $");
                                monto_ret = ObjDatos.nextDouble();
                            }
                            saldos[i] -= monto_ret;
                        }
                    }
                }
                System.out.println("Operación realizada con éxito. Volviendo al menú de inicio...");
            }
            else if (menu == 5) { /*CERRAR SESIÓN*/
                System.out.println("\nCerrando sesión...");
                continuar = 0;

            }
            else if (menu == 6) { /*SALIR*/
                System.out.println("\nCerrando programa...");
                continuar = 2;
            }
        }
        } while (continuar != 2);
    }
}