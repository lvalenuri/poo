/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class BDAlumno {

    ArrayList<Alumno> Alum = new ArrayList<>();

    public void registrarAlumno(Alumno alumno) {
        Alum.add(alumno);
    }

    public Alumno buscarAlumno(String codigo) {
        for (Alumno alumno : Alum) {
            if (alumno.getCodigo().equals(codigo)) {
                return alumno;
            }
        }
        return null;
    }

    public void modificarAlumno(String codigo, String nombre, String apellido) {
        Alumno alumno = buscarAlumno(codigo);
        if (alumno != null) {
            alumno.setNombre(nombre);
            alumno.setApellido(apellido);
        }
    }

    public void registrarNotas(String codigo, int corte, double[] notasCorte) {
        Alumno alumno = buscarAlumno(codigo);
        if (alumno != null) {
            alumno.setNotas(corte, notasCorte);
        }
    }

    public void agregarPago(String codigo, boolean pago) {
        Alumno alumno = buscarAlumno(codigo);
        if (alumno != null) {
            alumno.setPago(pago);
        }
    }

    public ArrayList<Alumno> getAlumno() {
        return Alum;
    }
}
