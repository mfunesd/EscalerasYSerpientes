package com.casa.mfd.EscalerasYSerpientes;

public class Tablero {
	public static String tablero(int posJug, int posCom) {
		int casillas = 25;
		for (int i = 1; i <= casillas; i++) {
		  if( i == posJug || i == posCom){
			  if(posJug != posCom) {
				  if(i == posJug) {
						System.out.print("XX");
						System.out.print(" ");
				  }
				  if(i == posCom) {
						System.out.print("##");
						System.out.print(" ");
				  }
			  } else {
				System.out.print("X#");
				System.out.print(" ");
			  }
			  if(i % 5 == 0){
				System.out.println("");
			  }
		  } else {
			  if(i <= 9){
				System.out.print(0);
			  }
			  System.out.print(i);
			  System.out.print(" ");
			  if(i % 5 == 0){
				System.out.println("");
			  }
		  }
		}
		return ("");
	}
}
