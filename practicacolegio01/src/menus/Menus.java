/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menus;

import datos.Alumno;
import datos.BDAlumno;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class Menus {

    BDAlumno bdalumnos = new BDAlumno();
    Scanner tec = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("BIEVENIDO AL SISTEMA DE INFORMACIÓN DEL COLEGIO 'APRENDIENDO ANDO'");
        System.out.println("1. Iniciar Sesion");
        System.out.println("2. Salir");

        int op = tec.nextInt();
        tec.nextLine();

        switch (op) {
            case 1:
                iniciarSesion();
                break;
            case 2:
                System.out.println("Gracias por utilizar nuestro sistema");
            default: {
                System.out.println("Opcion invalida, seleccione una opcion correcta");
                mostrarMenu();
            }
        }
    }

    private void iniciarSesion() {
        System.out.println("Seleccione el tipo de usuario");
        System.out.println("1. Administrador");
        System.out.println("2. Estudiante");

        int tipoUsuario = tec.nextInt();
        tec.nextLine();

        switch (tipoUsuario) {
            case 1:
                iniciarSesionAdmin();
                break;
            case 2:
                iniciarSesionAlumno();
                break;
            default:
                System.out.println("Elija una opcion valida");
                mostrarMenu();
        }
    }

    private void iniciarSesionAdmin() {
        System.out.println("usuario: ");
        String usuario = tec.nextLine();
        System.out.println("Contraseña: ");
        String contraseña = tec.nextLine();

        if ("admin".equals(usuario) && "password1".equals(contraseña)) {
            mostrarMenuAdmin();
        } else {
            System.out.println("Los datos son incorrectos, por favor vuelva a intentarlo");
            mostrarMenu();
        }
    }

    private void iniciarSesionAlumno() {
        System.out.println("Ingrese el codigo");
        String codigo = tec.nextLine();

        Alumno alumno = bdalumnos.buscarAlumno(codigo);
        if (alumno != null) {
            mostrarMenuAlumno(alumno);
        } else {
            System.out.println("Los datos son incorrectos, por favor vuelva a intentarlo");
            mostrarMenu();
        }
    }

    private void mostrarMenuAdmin() {
        System.out.println("Menu Administrativo: ");
        System.out.println("1. Registrar alumno");
        System.out.println("2. Modificar datos de alumno");
        System.out.println("3. Ingresar notas");
        System.out.println("4. Agregar pago");
        System.out.println("5. Ver base de datos");
        System.out.println("6. Salir");

        int op = tec.nextInt();
        tec.nextLine();

        switch (op) {
            case 1:
                registrarEstudiante();
                break;
            case 2:
                modificarDatos();
                break;
            case 3:
                ingresarNotas();
                break;
            case 4:
                agregarPago();
                break;
            case 5:
                verBaseDeDatos();
                break;
            case 6:
                System.out.println("Saliendo el programa");
                mostrarMenu();
            default:
                System.out.println("Ingresa una opción valida");
                mostrarMenuAdmin();
        }
    }

    private void mostrarMenuAlumno(Alumno alumno) {
        System.out.println("Menu Estudiantil: ");
        System.out.println("1. Ver notas");
        System.out.println("2. Ver promdio anual");
        System.out.println("3. Ver horarios");
        System.out.println("4. Salir");

        int op = tec.nextInt();
        tec.nextLine();

        switch (op) {
            case 1:
                verNotas(alumno);
                break;
            case 2:
                verPromedioAnual(alumno);
                break;
            case 3:
                verHorarios(alumno);
                break;
            case 4:
                System.out.println("Saliendo del programa");
                mostrarMenu();
            default:
                System.out.println("Ingrese una opcion valida");
                mostrarMenuAlumno(alumno);

        }
    }

    private void registrarEstudiante() {
        System.out.println("Codigo: ");
        String codigo = tec.nextLine();
        System.out.println("Nombre: ");
        String nombre = tec.nextLine();
        System.out.println("Apellido: ");
        String apellido = tec.nextLine();

        Alumno nuevoAlumno = new Alumno(codigo, nombre, apellido);
        bdalumnos.registrarAlumno(nuevoAlumno);
        System.out.println("Alumno registrado con exito");
        mostrarMenuAdmin();
    }

    private void modificarDatos() {
        System.out.println("Codigo del alumno a modificar");
        String codigo = tec.nextLine();
        System.out.println("nuevo nombre");
        String nombre = tec.nextLine();
        System.out.println("Nuevo apellido: ");
        String apellido = tec.nextLine();

        bdalumnos.modificarAlumno(codigo, nombre, apellido);
        System.out.println("Datos del alumno modificados");
        mostrarMenuAdmin();
    }

    private void ingresarNotas() {
        System.out.println("Codio del alumno");
        String codigo = tec.nextLine();
        System.out.println("Ingrese el corte que desea (1, 2, o 3)");
        int corte = tec.nextInt();
        tec.nextLine();

        double[] notasCorte = new double[7];
        for (int i = 0; i < 7; i++) {
            System.out.println("Nota de la materia " + (i + 1) + ":");
            notasCorte[i] = tec.nextDouble();
        }
        bdalumnos.registrarNotas(codigo, corte, notasCorte);
        System.out.println("Notas registradas con exito: ");
        mostrarMenuAdmin();
    }

    private void agregarPago() {
        System.out.println("Codigo del alumno: ");
        String codigo = tec.nextLine();
        System.out.println("Pago realiado true/false");
        boolean pago = tec.nextBoolean();

        bdalumnos.agregarPago(codigo, pago);
        System.out.println("Estado de pago actualizado con exito");
        mostrarMenuAdmin();

    }

    private void verBaseDeDatos() {
        for (Alumno alumno : bdalumnos.getAlumno()) {
            System.out.println(alumno.toString());
        }
        mostrarMenuAdmin();
    }

    private void verNotas(Alumno alumno) {
        if (alumno.isPago()) {
            for (int i = 0; i < alumno.getNotas().length; i++) {
                System.out.println("Notas del corte" + (i + 1) + ":" + Arrays.toString(alumno.getNotas()[i]));

            }
        } else {
            System.out.println("Pago pendiente, no puede ver las notas");
        }
        mostrarMenuAlumno(alumno);
    }

    private void verPromedioAnual(Alumno alumno) {
        if (alumno.isPago()) {
            double promedioTotal = alumno.getPromedioTotal();
            if (promedioTotal >= 3.0) {
                System.out.println("¡Felicidades! has aprobado");
            } else {
                System.out.println("No has aprobado, suerte para la proxima");
            }
            mostrarMenuAlumno(alumno);
        }
    }

    private void verHorarios(Alumno alumno) {
        System.out.println("Horario del estudiante: " + alumno.getCodigo() + ":");
        System.out.println("Lunes a viernes de 8:00 AM a 3:00 PM");
        mostrarMenuAlumno(alumno);

    }

}
