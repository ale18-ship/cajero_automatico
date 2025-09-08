package com.cajero;

import java.util.Scanner;

public class CajeroAutomatico {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        int saldo = 0;

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
                    saldo += deposito;
                    System.out.println("Depósito exitoso. Nuevo saldo: $" + saldo);
                }
                case 3 -> {
                    System.out.print("Ingrese monto a retirar: ");
                    int retiro = sc.nextInt();
                    if (retiro <= saldo) {
                        saldo -= retiro;
                        System.out.println("Retiro exitoso. Nuevo saldo: $" + saldo);
                    } else {
                        System.out.println("Fondos insuficientes. Su saldo es: $" + saldo);
                    }
                }
                case 4 -> System.out.println("Gracias por usar el cajero.");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 4);

        sc.close();
    }
}

