/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle8;

import java.util.ArrayList;

/**
 *
 * @author xochi
 */
public class Nodo {
    int [][] estado;
    ArrayList<Nodo> hijos = new ArrayList<Nodo>();
    Nodo padre;
    int f, g;

    public Nodo(int[][] estado) {
        this.estado = estado;
        hijos = null;
        padre = null;
        f =0;
        g = 0;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public int[][] getEstado() {
        return estado;
    }

    public void setEstado(int[][] estado) {
        this.estado = estado;
    }

    public ArrayList<Nodo> getHijos() {
        return hijos;
    }

    public void setHijos(ArrayList<Nodo> hijos) {
        this.hijos = hijos;
        if (hijos!=null) {
            for (Nodo h:hijos) {
                h.padre=this;
            }
        }
    }
    
}
