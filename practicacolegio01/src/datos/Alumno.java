/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.util.Arrays;

/**
 *
 * @author USUARIO
 */
public class Alumno extends Datos {

    private double[][] notas;
    private boolean pago;

    public Alumno(String codigo, String nombre, String apellido) {
        super();
    }

    public Alumno(double[][] notas, boolean pago) {
        this.notas = notas;
        this.pago = pago;
    }

    public Alumno(double[][] notas, boolean pago, String codigo, String nombre, String apellido) {
        super(codigo, nombre, apellido);
        this.notas = notas;
        this.pago = pago;
    }

    public double[][] getNotas() {
        return notas;
    }

    public void setNotas(int corte, double[] notasCorte) {
        this.notas[corte - 1] = notasCorte;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public double getPromedioTotal() {
        double suma = 0;
        int contador = 0;
        for (double[] corte : notas) {
            for (double nota : corte) {
                suma += nota;
                contador++;
            }
        }
        return suma / contador;
    }

    @Override
    public String toString() {
        return "{" + super.toString() + "notas=" + Arrays.toString(this.getNotas()) + ", pago=" + this.isPago() + '}';
    }

}
    
    

