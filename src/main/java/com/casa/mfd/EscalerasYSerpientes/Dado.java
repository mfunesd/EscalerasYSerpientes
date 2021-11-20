package com.casa.mfd.EscalerasYSerpientes;

public class Dado {
		 
	public static int tiraDado() {
		int dado = 0;
		dado = (int) (Math.random() * 6) + 1;
		return dado;
	}
}