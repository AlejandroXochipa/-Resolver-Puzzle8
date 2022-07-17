/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author xochi
 */
public class Puzzle8 {
         //private static 
         private static  ArrayList<Nodo> expandidos = new ArrayList<Nodo>();
         // private static ArrayList<Nodo> nodoFinal = new ArrayList<Nodo>();
          public static ArrayList<Nodo> visitados = new ArrayList<Nodo>();
           private static int [][] solucion = {{1,2,3},{4,5,6},{7,8,0}};
           private static Nodo Nfinal = new Nodo(solucion);
           public static boolean Manh = false;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [][] inicio = {{7,1,8},{2,6,3},{4,5,0}}; 
      // int [][] inicio2 ={{}};
      int [][] inicio2 = {{4,1,0},{2,6,3},{7,5,8}};
      int [][] inicio3 = {{2,8,3},{1,6,4},{7,0,8}};
        Nodo inicial = new Nodo(inicio2);
       // buscarSolucion(inicial,solucion);
       solucionH(inicial);
       //H2(inicial);
     //  int s = casillaFuera(inicial);
       // System.out.println(s);
       //generarSucesores( inicial);
      // casillaFuera(inicial);
    }

  /* private static void buscarSolucion(Nodo inicial, int[][] solucion) {
       ArrayList<Nodo> expandidos = new ArrayList<Nodo>();
        ArrayList<Nodo> visitados = new ArrayList<Nodo>();
       expandidos.add(inicial);
       int cont=0;
       
       while(expandidos.size()!=0){
           Nodo revisar = expandidos.remove(0);
           imprimirEstado(revisar.getEstado());
           int[] pcero = ubicarPosicion(revisar.getEstado());
           System.out.println("El numero de vueltas es:" + (++cont));
            if (Arrays.deepEquals(revisar.getEstado(), solucion)) {
            System.out.println("Solucion encontrada");
            break;
            
          }
            
          // expandidos.remove(mejor);
           visitados.add(revisar);
           if (pcero[0]!=0) {
               Nodo hijo = new Nodo(clonar(revisar.getEstado()));
               int arriba = hijo.getEstado()[pcero[0]-1][pcero[1]];
               hijo.getEstado()[pcero[0]][pcero[1]]=arriba;
               hijo.getEstado()[pcero[0]-1][pcero[1]]=0;
               if(!estaEnVisitados(visitados,hijo))
              // hijo.f= casillaFuera(hijo);
               expandidos.add(hijo);
           }
           if (pcero[0]!=2) {
               Nodo hijo = new Nodo(clonar(revisar.getEstado()));
               int abajo = hijo.getEstado()[pcero[0]+1][pcero[1]];
               hijo.getEstado()[pcero[0]][pcero[1]]=abajo;
               hijo.getEstado()[pcero[0]+1][pcero[1]]=0;
               if(!estaEnVisitados(visitados,hijo))
              // hijo.f= casillaFuera(hijo);
               expandidos.add(hijo);
           }
           if (pcero[1]!=0) {
               Nodo hijo = new Nodo(clonar(revisar.getEstado()));
               int izquierda = hijo.getEstado()[pcero[0]][pcero[1]-1];
               hijo.getEstado()[pcero[0]][pcero[1]]=izquierda;
               hijo.getEstado()[pcero[0]][pcero[1]-1]=0;
               if(!estaEnVisitados(visitados,hijo))
               //hijo.f= casillaFuera(hijo);
               expandidos.add(hijo);
           }
           if (pcero[1]!=2) {
               Nodo hijo = new Nodo(clonar(revisar.getEstado()));
               int derecha = hijo.getEstado()[pcero[0]][pcero[1]+1];
               hijo.getEstado()[pcero[0]][pcero[1]]=derecha;
               hijo.getEstado()[pcero[0]][pcero[1]+1]=0;
               if(!estaEnVisitados(visitados,hijo))
                //    hijo.f= casillaFuera(hijo);
               expandidos.add(hijo);
           }
       }
    }*/

   
    
    
    

    
   static int intentos = 0;
    
    private static void solucionH(Nodo inicial){
        // ArrayList<Nodo> expandidos = new ArrayList<Nodo>();
       // ArrayList<Nodo> visitados = new ArrayList<Nodo>();
       
     //  Queue<Nodo> abierta = new Queue<Nodo>();
       int cont=0;
       //Nodo inicio2 
       //expandidos.remove(o)
     // int s = casillaFuera(inicial);
      // inicial.estado= expandidos;
      Nodo inicial2 = new Nodo(inicial.getEstado());
     inicial2.g=0;
     inicial.f = Manhathan(inicial2) + inicial.g;
      expandidos.add(inicial2);
       //Nodo revisar = expandidos.remove(0);
       // visitados.add(revisar);
      
      for(;;){
      
          if (expandidos.isEmpty()) {
              System.out.println("Fallo");
              break;
          }
          Nodo mejor = null;
          for (Nodo n: expandidos) {
              if (mejor==null) {
                  mejor=n;
                  /*System.out.println("Su estado en null es: ");
                    imprimirEstado(mejor.getEstado());
                      System.out.println("F " + mejor.getF());*/
              }else if((mejor.f>n.f)||(mejor.f==n.f&&mejor.g<n.g)){
                  mejor = n;
                  /* System.out.println("Su estado en menor o mayor es: ");
                   imprimirEstado(mejor.getEstado());
                    System.out.println("F " + mejor.getF());*/
              }
          }
          
          
          expandidos.remove(mejor);
          visitados.add(mejor);
      
       
     
        if (Arrays.deepEquals(mejor.getEstado(), Nfinal.getEstado())) {
            System.out.println("Es solucion mostrar: ");
            Nodo tmp = mejor;
            LinkedList<Nodo> camino = new LinkedList<Nodo>();
            while(tmp!=null){
                camino.addFirst(tmp);
                tmp = tmp.padre;
            }
            int a=0;
            for (Nodo ntmp:camino) {
                a++;
                if (a==1) {
                    System.out.println("Su estado inicial es: ");
                    imprimirEstado(ntmp.getEstado());
                    System.out.println("F " + ntmp.getF());
                }else{
                System.out.println("El estado " + a + " es:");
                imprimirEstado(ntmp.getEstado());
                System.out.println("F " + ntmp.getF());
                }
            }
            System.out.println(a);
            return;
        }else{
            intentos++;
        }
      
       
      
       expandidos.addAll(generarSucesores(mejor , mejor.g));
      }
       //expandidos.toString();
       // System.out.println("Se encontro en estos intentos: " + intentos);
         
    }
 
    
    
    
    
    
    private static void H2(Nodo inicial){
         //  Queue<Nodo> abierta = new Queue<Nodo>();
      int cont=0,intentos=0;
      inicial.f = casillaFuera(inicial);
      expandidos.add(inicial);

      for(;;){
          if (expandidos.isEmpty()) {
              System.out.println("Fallo");
              break;
          }   
          
          
          Nodo mejor = null;
           for (Nodo f:expandidos) {
          
                
                mejor =f;
                 System.out.println("Estas en igual anulo");
                 imprimirEstado(mejor.getEstado());
            if ((mejor.f<f.f) || mejor.f==f.f) {
                mejor=f;
                 System.out.println("Estas en mayor igual");
                 imprimirEstado(mejor.getEstado());
            }
        }
           //expandidos.sort();
           
           
          
       Nodo revisar = expandidos.remove(0);
       expandidos.remove(mejor);
        
       visitados.add(revisar);
      // expandidos.addAll(generarSucesores(mejor));
       
        if (Arrays.deepEquals(mejor.getEstado(), Nfinal.getEstado())) {
            System.out.println("Es solucion mostrar: ");
            Nodo tmp = mejor;
            LinkedList<Nodo> camino = new LinkedList<Nodo>();
            while(tmp!=null){
                camino.addFirst(tmp);
                tmp = tmp.padre;
            }
            int a=0;
            for (Nodo ntmp:camino) {
                a++;
                imprimirEstado(ntmp.getEstado());
            }
            System.out.println(a);
            return;
        }else{
            intentos++;
        }
      }
    }
    
    
    
    
    
    private static boolean esSolucion(Nodo hijo){
        for (int i = 0; i <3; i++) {
            for (int j = 0; j < 3; j++) {
                if (hijo.getEstado()[i][j]!=solucion[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
    
    
    
    
     private static boolean esSolucion2(Nodo hijo){
      for (int i = 0; i <3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Arrays.deepEquals(solucion, hijo.getEstado())) {
                    return true;
                }
            }
        }
        return false;

    }
    
    
    
    
    
     private static boolean estaCerrada(Nodo hijo){
         for (Nodo ncerrado:visitados) {
             if (comparar(hijo.getEstado(),ncerrado.getEstado())) {
                 return true;
             }
         }
         return false;
    }
     private static boolean comparar(int[][] actual, int[][] comparar) {
         for (int i = 0; i < 3; i++) {
             for (int j = 0; j < 3; j++) {
                 if (actual[i][j]!=comparar[i][j]) {
                     return false;
                 }
             }
         }
         return true;
    }
    
    private static ArrayList<Nodo> generarSucesores(Nodo inicial, int factual){
       ArrayList<Nodo> sucesores = new ArrayList<Nodo>();
        int[] pcero = ubicarPosicion(inicial.getEstado());
        if (pcero[0]>0) {
               Nodo hijo = new Nodo(clonar(inicial.getEstado()));
               hijo.padre=inicial;
               hijo.g= factual+1;
               int arriba = hijo.getEstado()[pcero[0]-1][pcero[1]];
               hijo.getEstado()[pcero[0]][pcero[1]]=arriba;
               hijo.getEstado()[pcero[0]-1][pcero[1]]=0;
              //visitados.add(hijo);
               //if(!estaEnVisitados(visitados,hijo))
                if(!estaCerrada(hijo)){
               //expandidos.add(hijo);
                  if (Manh) 
                      hijo.f= Manhathan(hijo) + hijo.g;
                  else
                      hijo.f = casillaFuera(hijo) + hijo.g;
                sucesores.add(hijo);
              }
           }
           if (pcero[0]<2) {
               Nodo hijo = new Nodo(clonar(inicial.getEstado()));
               int abajo = hijo.getEstado()[pcero[0]+1][pcero[1]];
               hijo.getEstado()[pcero[0]][pcero[1]]=abajo;
               hijo.getEstado()[pcero[0]+1][pcero[1]]=0;
               //visitados.add(hijo);
              // if(!estaEnVisitados(visitados,hijo))
              if(!estaCerrada(hijo)){
               //expandidos.add(hijo);
                  if (Manh) 
                      hijo.f= Manhathan(hijo) + hijo.g;
                  else
                      hijo.f = casillaFuera(hijo) + hijo.g;
                sucesores.add(hijo);
              }
           }
           if (pcero[1]>0) {
               Nodo hijo = new Nodo(clonar(inicial.getEstado()));
               int izquierda = hijo.getEstado()[pcero[0]][pcero[1]-1];
               hijo.getEstado()[pcero[0]][pcero[1]]=izquierda;
               hijo.getEstado()[pcero[0]][pcero[1]-1]=0;
               //visitados.add(hijo);
               //if(!estaEnVisitados(visitados,hijo))
              if(!estaCerrada(hijo)){
               //expandidos.add(hijo);
                  if (Manh) 
                      hijo.f= Manhathan(hijo) + hijo.g;
                  else
                      hijo.f = casillaFuera(hijo) + hijo.g;
                sucesores.add(hijo);
              }
           }
           if (pcero[1]<2) {
               Nodo hijo = new Nodo(clonar(inicial.getEstado()));
               int derecha = hijo.getEstado()[pcero[0]][pcero[1]+1];
               hijo.getEstado()[pcero[0]][pcero[1]]=derecha;
               hijo.getEstado()[pcero[0]][pcero[1]+1]=0;
               //visitados.add(hijo);
              // if(!estaEnVisitados(visitados,hijo))
               if(!estaCerrada(hijo)){
               //expandidos.add(hijo);
                  if (Manh) 
                      hijo.f= Manhathan(hijo) + hijo.g;
                  else
                      hijo.f = casillaFuera(hijo) + hijo.g;
                sucesores.add(hijo);
              }
           }
         inicial.setHijos(sucesores);
       
        return sucesores;
    }
    
    
    
    
    
    

    private static void imprimirEstado(int[][] estado) {
        for (int i = 0; i < estado.length; i++) {
            for (int j = 0; j < estado.length; j++) {
                System.out.print("["+estado[i][j]+"]");
            }
            System.out.println("");
        }
    }

    private static int [] ubicarPosicion(int[][] estado) {
        int [] posicion = new int[2];
        for (int i = 0; i < estado.length; i++) {
            for (int j = 0; j < estado.length; j++) {
                if (estado[i][j]==0) {
                    posicion[0]=i;
                    posicion[1]=j;
                }
            }
        }
       // System.out.println("La posicion de 0 esta en: " + "(" +posicion[0]+ "," + posicion[1]+")");
      return posicion;
    }

    private static int[][] clonar(int[][] estado) {
       int [][] clonado = new int[estado.length][estado.length];
       for (int i = 0; i < estado.length; i++) {
            for (int j = 0; j < estado.length; j++) {
                clonado[i][j]=estado[i][j];
            }
        }
       return clonado;
    }

    private static boolean estaEnVisitados(ArrayList<Nodo> visitados, Nodo hijo) {
         
        for (Nodo v:visitados) {
            if (Arrays.deepEquals(v.getEstado(), hijo.getEstado())) {
                return true;
            }
        }
        return false;
    }
    
    
    
    private static int Manhathan(Nodo matriz){
        int h=0;
        if ((matriz.getEstado()[0][0]!=1 && matriz.getEstado()[0][0]!=0) ) {
            int get = getCasillasM(0,0,matriz.getEstado()[0][0]);
            h+=get;
        }
         if (matriz.getEstado()[0][1]!=2 && matriz.getEstado()[0][1]!=0) {
             int get = getCasillasM(0,1,matriz.getEstado()[0][1]);
             h+=get;
            
        }
         if (matriz.getEstado()[0][2]!=3 && matriz.getEstado()[0][2]!=0) {
              int get = getCasillasM(0,2,matriz.getEstado()[0][2]);
            h+=get;
        }
         if (matriz.getEstado()[1][0]!=4 && matriz.getEstado()[1][0]!=0) {
             int get = getCasillasM(1,0,matriz.getEstado()[1][0]);
           h+=get;
        }
         if (matriz.getEstado()[1][1]!=5 && matriz.getEstado()[1][1]!=0) {
              int get = getCasillasM(1,1,matriz.getEstado()[1][1]);
            h+=get;
        }
         if (matriz.getEstado()[1][2]!=6 && matriz.getEstado()[1][2]!=0) {
              int get = getCasillasM(1,2,matriz.getEstado()[1][2]);
            h+=get;
        }
         if (matriz.getEstado()[2][0]!=7 && matriz.getEstado()[2][0]!=0) {
              int get = getCasillasM(2,0,matriz.getEstado()[2][0]);
           h+=get;
        }
         if (matriz.getEstado()[2][1]!=8 && matriz.getEstado()[2][1]!=0) {
              int get = getCasillasM(2,1,matriz.getEstado()[2][1]);
            h+=get;
        }
         if (matriz.getEstado()[2][2]!=0 && matriz.getEstado()[2][2]!=0) {
             int get = getCasillasM(2,2,matriz.getEstado()[2][2]);
           h+=get;
        }
         return h;
    }
    
     private static int getCasillasM(int i, int j, int i1) {
         switch(i1){
             case 1: return i+j;
             case 2: return Math.abs(j-1) + Math.abs(i);
             case 3: return Math.abs(j-2) + Math.abs(i);
             case 4: return Math.abs(j) + Math.abs(i-1);
             case 5: return Math.abs(j-1) + Math.abs(i-1);
             case 6: return Math.abs(j-2) + Math.abs(i-1);
             case 7: return Math.abs(j) + Math.abs(i-2);
             case 8: return Math.abs(j-1) + Math.abs(i-2);
         }
   return 0;
    }
     
     
     
     
     
    private static int casillaFuera(Nodo matriz){
        int h = 0;
        if ((matriz.getEstado()[0][0]!=1 && matriz.getEstado()[0][0]!=0) ) {
            h++;
        }
         if (matriz.getEstado()[0][1]!=2 && matriz.getEstado()[0][1]!=0) {
            h++;
        }
         if (matriz.getEstado()[0][2]!=3 && matriz.getEstado()[0][2]!=0) {
            h++;
        }
         if (matriz.getEstado()[1][0]!=4 && matriz.getEstado()[1][0]!=0) {
            h++;
        }
         if (matriz.getEstado()[1][1]!=5 && matriz.getEstado()[1][1]!=0) {
            h++;
        }
         if (matriz.getEstado()[1][2]!=6 && matriz.getEstado()[1][2]!=0) {
            h++;
        }
         if (matriz.getEstado()[2][0]!=7 && matriz.getEstado()[2][0]!=0) {
            h++;
        }
         if (matriz.getEstado()[2][1]!=8 && matriz.getEstado()[2][1]!=0) {
            h++;
        }
         if (matriz.getEstado()[2][2]!=0 && matriz.getEstado()[2][2]!=0) {
            h++;
        }
        
    
        return h;
    }

   

    
    
}
