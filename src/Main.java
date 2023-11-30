import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del empleado:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese la posición del empleado (CEO, Jefe, Ingeniero, Analista, Scrum Master, RRHH):");
        String posicion = scanner.nextLine();

        System.out.println("Ingrese el sueldo del empleado:");
        double sueldo = scanner.nextDouble();

        // Limpiar el buffer después de la entrada de números para permitir la lectura de la siguiente línea
        scanner.nextLine();

        System.out.println("Ingrese el horario de ingreso del empleado (en formato de 24 horas, por ejemplo, 7 para las 7am):");
        int horarioIngreso = Integer.parseInt(scanner.nextLine());

        // Verificar infracciones
        double porcentajeDescuento = 0.0;

        if (posicion.equalsIgnoreCase("CEO")) {
            if (horarioIngreso > 7) {
                porcentajeDescuento = 0.01;
            }
        } else if (posicion.equalsIgnoreCase("Jefe")) {
            if (horarioIngreso > 8) {
                porcentajeDescuento = 0.05;
            }
        } else if (posicion.equalsIgnoreCase("Ingeniero")) {
            if (horarioIngreso > 9) {
                porcentajeDescuento = 0.15;
            }
        } else if (posicion.equalsIgnoreCase("Analista")) {
            if (horarioIngreso > 9) {
                porcentajeDescuento = 0.20;
            }
        } else if (posicion.equalsIgnoreCase("Scrum Master") || posicion.equalsIgnoreCase("RRHH")) {
            if (horarioIngreso > 9) {
                porcentajeDescuento = (posicion.equalsIgnoreCase("Scrum Master")) ? 0.10 : 0.09;
            }
        }

        if (porcentajeDescuento > 0) {
            double descuentoAnual = sueldo * porcentajeDescuento;
            String infoEmpleado = nombre + "," + posicion + "," + descuentoAnual;

            // Escribir la información del empleado con infracción en un archivo
            try (PrintWriter writer = new PrintWriter(new FileWriter("empleados_con_infraccion.txt", true))) {
                writer.println(infoEmpleado);
            } catch (IOException e) {
                System.out.println("Error al escribir en el archivo.");
            }
        }

        scanner.close();
    }
}