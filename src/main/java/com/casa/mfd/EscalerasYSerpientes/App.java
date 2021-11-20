package com.casa.mfd.EscalerasYSerpientes;

public class App {
    public static void main( String[] args ) {
    	if (args.length < 1) {
    		while (Juego.mover()) {
    			System.out.println("");
    		}
    	} else {
    		while (Juego.moverConParametros(args)) {
    			System.out.println("");
    		}
    	}
    }
}
