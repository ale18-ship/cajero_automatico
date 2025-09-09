package com.cajero;

import java.util.Scanner;

public class CajeroAutomatico {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        int[] billetes = {50000, 20000, 10000, 5000};
        int[] cantidades = {10, 10, 10, 10};
        int saldo = calcularSaldo(billetes, cantidades);

        do {
            System.out.println("\n=== Simulador Cajero Automático ===");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> System.out.println("Saldo disponible: $" + saldo);
                case 2 -> {
                    System.out.print("Ingrese monto a depositar: ");
                    int deposito = sc.nextInt();

                    if (deposito % 5000 != 0) {
                        System.out.println("El cajero solo acepta múltiplos de $5000.");
                    } else {
                        int index = 3; // posición del billete de $5000
                        int cantidadBilletes = deposito / billetes[index];
                        cantidades[index] += cantidadBilletes;
                        saldo = calcularSaldo(billetes, cantidades);
                        System.out.println("Depósito exitoso. Nuevo saldo: $" + saldo);
                    }
                }
                case 3 -> {
                    System.out.print("Ingrese monto a retirar: ");
                    int retiro = sc.nextInt();

                    if (retiro > saldo) {
                        System.out.println("Fondos insuficientes. Su saldo es: $" + saldo);
                    } else {
                        int[] retiroBilletes = new int[billetes.length];
                        int montoRestante = retiro;

                        for (int i = 0; i < billetes.length; i++) {
                            int cantidadNecesaria = montoRestante / billetes[i];
                            int cantidadDisponible = cantidades[i];
                            int cantidadUsada = Math.min(cantidadNecesaria, cantidadDisponible);

                            retiroBilletes[i] = cantidadUsada;
                            montoRestante -= cantidadUsada * billetes[i];
                        }

                        if (montoRestante == 0) {

                            for (int i = 0; i < billetes.length; i++) {
                                cantidades[i] -= retiroBilletes[i];
                            }
                            saldo = calcularSaldo(billetes, cantidades);
                            System.out.println("Retiro exitoso de $" + retiro);
                            mostrarBilletes(retiroBilletes, billetes);
                            System.out.println("Nuevo saldo: $" + saldo);
                        } else {
                            System.out.println("No hay billetes suficientes para entregar ese monto.");
                        }
                    }
                }
                case 4 -> System.out.println("Gracias por usar el cajero.");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 4);

        sc.close();
    }

    private static int calcularSaldo(int[] billetes, int[] cantidades) {
        int saldo = 0;
        for (int i = 0; i < billetes.length; i++) {
            saldo += billetes[i] * cantidades[i];
        }
        return saldo;
    }

    private static void mostrarBilletes(int[] retiroBilletes, int[] billetes) {
        System.out.println("Billetes entregados:");
        for (int i = 0; i < billetes.length; i++) {
            if (retiroBilletes[i] > 0) {
                System.out.println("$" + billetes[i] + " x " + retiroBilletes[i]);
            }
        }
    }
}
