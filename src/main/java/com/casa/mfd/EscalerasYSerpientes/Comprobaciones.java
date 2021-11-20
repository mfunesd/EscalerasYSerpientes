package com.casa.mfd.EscalerasYSerpientes;

public class Comprobaciones {
		 
	public static int comprobarPosicionJugador(int posJug) {
		//Se comprueba si posJug es la numero 2 y entonces Jugador sube a la casilla 18
		if(posJug == 2) {
			posJug = 18;
			System.out.println("Como el jugador Jugador ha caido en la casilla 2 sube a la 18");
			return (posJug);
		}
		//Se comprueba si posJug es la numero 13 y entonces Jugador sube a la casilla 17
		if(posJug == 13) {
			posJug = 17;
			System.out.println("Como el jugador Jugador ha caido en la casilla 13 sube a la 17");
			return (posJug);
		}
		//Se comprueba si posJug es la numero 15 y entonces Jugador sube a la casilla 23
		if(posJug == 15) {
			posJug = 23;
			System.out.println("Como el jugador Jugador ha caido en la casilla 15 sube a la 23");
			return (posJug);
		}
		//Se comprueba si posJug es la numero 19 y entonces Jugador baja a la casilla 4
		if(posJug == 19) {
			posJug = 4;
			System.out.println("Como el jugador Jugador ha caido en la casilla 19 baja a la 4");
			return (posJug);
		}
		//Se comprueba si posJug es la numero 20 y entonces Jugador baja a la casilla 6
		if(posJug == 20) {
			posJug = 6;
			System.out.println("Como el jugador Jugador ha caido en la casilla 20 baja a la 6");
			return (posJug);
		}
		//Se comprueba si posJug es la numero 23 y entonces Jugador baja a la casilla 14
		if(posJug == 23) {
			posJug = 14;
			System.out.println("Como el jugador Jugador ha caido en la casilla 23 baja a la 14");
			return (posJug);
		}
		return (posJug);
	}
			
	public static int comprobarPosicionComputadora(int posCom) {	
		//Se comprueba si posCom es la numero 2 y entonces Computadora sube a la casilla 18
		if(posCom == 2) {
			posCom = 18;
			System.out.println("Como el jugador Computadora ha caido en la casilla 2 sube a la 18");
			return (posCom);
		}
		//Se comprueba si posCom es la numero 13 y entonces Computadora sube a la casilla 17
		if(posCom == 13) {
			posCom = 17;
			System.out.println("Como el jugador Computadora ha caido en la casilla 13 sube a la 17");
			return (posCom);
		}
		//Se comprueba si posCom es la numero 15 y entonces Computadora sube a la casilla 23
		if(posCom == 15) {
			posCom = 23;
			System.out.println("Como el jugador Computadora ha caido en la casilla 15 sube a la 23");
			return (posCom);
		}
		//Se comprueba si posCom es la numero 19 y entonces Computadora baja a la casilla 4
		if(posCom == 19) {
			posCom = 4;
			System.out.println("Como el jugador Computadora ha caido en la casilla 19 baja a la 4");
			return (posCom);
		}
		//Se comprueba si posCom es la numero 20 y entonces Computadora baja a la casilla 6
		if(posCom == 20) {
			posCom = 6;
			System.out.println("Como el jugador Computadora ha caido en la casilla 20 baja a la 6");
			return (posCom);
		}
		//Se comprueba si posCom es la numero 23 y entonces Computadora baja a la casilla 14
		if(posCom == 23) {
			posCom = 14;
			System.out.println("Como el jugador Computadora ha caido en la casilla 23 baja a la 14");
			return (posCom);
		}
		return (posCom);
	}
		
	public static int comprobarTramoFinalJugador(int posJug,int dado) {
		if ((25 - posJug) <= 6) {
			if (posJug == 19) {
				if (dado <= 6) {
					return posJug;
				} else {
					return (posJug - dado);
				}
			} else if (posJug == 20) {
				if (dado <= 5) {
					return posJug;
				} else {
					return (posJug - dado);
				}
			} else if (posJug == 21) {
				if (dado <= 4) {
					return posJug;
				} else {
					return (posJug - dado);
				}
			} else if (posJug == 22) {
				if (dado <= 3) {
					return posJug;
				} else {
					return (posJug - dado);
				}
			} else if (posJug == 23) {
				if (dado <= 2) {
					return posJug;
				} else {
					return (posJug - dado);
				}
			} else if (posJug == 24) {
				if (dado == 1) {
					return posJug;
				} else {
					return (posJug - dado);
				}
			}
		}
		return posJug;
	}
		
	public static int comprobarTramoFinalComputadora(int posCom,int dado) {
		if ((25 - posCom) <= 6) {
			if (posCom == 19) {
				if (dado <= 6) {
					return posCom;
				} else {
					return (posCom - dado);
				}
			} else if (posCom == 20) {
				if (dado <= 5) {
					return posCom;
				} else {
					return (posCom - dado);
				}
			} else if (posCom == 21) {
				if (dado <= 4) {
					return posCom;
				} else {
					return (posCom - dado);
				}
			} else if (posCom == 22) {
				if (dado <= 3) {
					return posCom;
				} else {
					return (posCom - dado);
				}
			} else if (posCom == 23) {
				if (dado <= 2) {
					return posCom;
				} else {
					return (posCom - dado);
				}
			} else if (posCom == 24) {
				if (dado == 1) {
					return posCom;
				} else {
					return (posCom - dado);
				}
			}
		}
		return posCom;
	}
}