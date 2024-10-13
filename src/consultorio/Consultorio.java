/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package consultorio;

import java.util.Scanner;

/**
 *
 * @author 34639
 */
public class Consultorio {

    static Scanner scanner = new Scanner(System.in);
    static GestorConsultorio gestor = new GestorConsultorio();

    public static void main(String[] args) {

        System.out.println("Bienvenido al sistema de gestión de personal");

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Crear paciente");
            System.out.println("2. Crear Medico");
            System.out.println("3. Crear cita");
            System.out.println("4. Obtener consulta por Paciente y fecha");
            System.out.println("5. Cancelar cita por paciente, fecha, hora");
            System.out.println("6. Imprimir citas medicas");
            System.out.println("7. Leer numero de citas");
            System.out.println("8. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:

                    gestor.leerPaciente();
                    System.out.println("Paciente añadido correctamente");

                    break;

                case 2:

                    gestor.leerMedico();
                    System.out.println("Medico añadido correctamente");
                    break;

                case 3:
                    gestor.leerCita();
                    System.out.println("Cita añadido correctamente");
                    break;

                case 4:
                    gestor.buscarConsulta();

                    break;

                case 5:
                    gestor.elimnarCita();
                    break;

                case 6:
                    gestor.imprimirCita();
                    System.out.println("las citas se han registrado en el documento de texto");
                    break;

                case 7:
                    gestor.lecturaNumeroCitas();

                case 8:

                    System.out.println("Saliendo del sistema...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no valida. porfavor, seleccione una opcion valida. ");

            }

        }
    }
}
