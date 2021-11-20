package com.casa.mfd.EscalerasYSerpientes;

public class Juego {
		 
	public static boolean mover() {
		//Inicializamos el boolean partida a true
		boolean partida = true;
		//Inicializamos el array con los jugadores.
		String[] jugadores = {"Jugador", "Computadora"};
		//Inicializamos las posiciones posJug y posCom a la posicion 1
		int posJug = 1;
		int posCom = 1;
		//Inicializamos el array posiciones con los valores de posJug y posCom
		/* Con un booleano podemos detener el flujo del juego
		 * en el caso de que haya ganador o perdedor.
		 */
		boolean hayGanadorOPerdedor = false;
		//Ponemos a 0 el contador de turnos
		int turnCont = 0;
		//Se inicializa dado a 0
		int dado = 0;
		//Inicializamos retorno1Jug a 0 para controlar que el jugador vuelve a la casilla 1 por sacar 3 seises seguidos
		int retorno1Jug = 0;
		//Inicializamos retorno1Com a 0 para controlar que el jugador vuelve a la casilla 1 por sacar 3 seises seguidos
		int retorno1Com = 0;
		//Imprimimos el tablero inicial
		System.out.println("Juego sin parámetros");
		System.out.println("Jugador = XX ------------- Computadora = ##");
		System.out.println("Tablero inicial");
		Tablero.tablero(posJug,posCom);
		//Comenzamos el bucle de tiradas
		while(!hayGanadorOPerdedor) {
			turnCont++;
			System.out.println("TURNO #" + turnCont);
			//Ahora cada jugador lanzará una vez
			for (int i = 0; i < jugadores.length && !hayGanadorOPerdedor; i++) {
				//Inicializamos el numero de seises de la tirada a 1 para cuando salga el primer seis
				int numSeis = 1;
				System.out.println("Lanza el jugador " + jugadores[i]);
				dado = Dado.tiraDado();
				System.out.println("El jugador " + jugadores[i] + " ha sacado un " + dado);
				if (jugadores[i] == "Jugador" && retorno1Jug > 0 && posJug == 1) {
					if (dado != 6) {
						System.out.println("El jugador " + jugadores[i] + " tiene que sacar un 6 para poder salir después de volver a la casilla 1");
						dado = 0;
						Tablero.tablero(posJug,posCom);
					} else {
						posJug += dado;
						posJug = Comprobaciones.comprobarPosicionJugador(posJug);
						dado = 0;
						Tablero.tablero(posJug, posCom);
					}
				} else if (jugadores[i] == "Computadora" && retorno1Com > 0 && posCom == 1) {
					if (dado != 6) {
						System.out.println("El jugador " + jugadores[i] + " tiene que sacar un 6 para poder salir después de volver a la casilla 1");
						dado = 0;
						Tablero.tablero(posJug,posCom);
					} else {
						posCom += dado;
						posCom = Comprobaciones.comprobarPosicionComputadora(posCom);
						dado = 0;
						Tablero.tablero(posJug, posCom);
					}				
				}				
				//Si se saca un seis se vuelve a tirar y si salen tres seises seguidos el jugador vuelve a la casilla 1
				while(dado == 6 && numSeis <= 3) {
					if(numSeis == 3) {
						System.out.println("El jugador " + jugadores[i] + "vuelve a la casilla 1 por sacar tres seises seguidos");
						if (jugadores[i] == "Jugador") {
							posJug = 1;
							retorno1Jug++;
							dado = 0;
						} else {
							posCom = 1;
							retorno1Com++;
							dado = 0;
						}
					}
					if (dado != 0) {
						if (jugadores[i] == "Jugador") {
							if (Comprobaciones.comprobarTramoFinalJugador(posJug,dado) == (posJug - dado)) {
								System.out.println("El jugador " + jugadores[i] + " tiene que sacar un numero menor para mover o para terminar, si es superior  a las casillas que le quedan no puede mover");
								Tablero.tablero(posJug, posCom);
								numSeis++;
								dado = Dado.tiraDado();
								System.out.println("El jugador " + jugadores[i] + " ha sacado un " + dado);
							} else {
								posJug += dado;
								posJug = Comprobaciones.comprobarPosicionJugador(posJug);
								Tablero.tablero(posJug, posCom);
								if(posJug == 25) {
									System.out.println("Jugador ha ganado la partida");
									hayGanadorOPerdedor = true;
									partida = false;
									return (partida);
								}
								numSeis++;
								dado = Dado.tiraDado();
								System.out.println("El jugador " + jugadores[i] + " ha sacado un " + dado);
							}
						} else {
							if (Comprobaciones.comprobarTramoFinalComputadora(posCom,dado) == (posCom - dado)) {
								System.out.println("El jugador " + jugadores[i] + " tiene que sacar un numero menor para mover o para terminar, si es superior  a las casillas que le quedan no puede mover");
								Tablero.tablero(posJug, posCom);
								numSeis++;
								dado = Dado.tiraDado();
								System.out.println("El jugador " + jugadores[i] + " ha sacado un " + dado);
							} else {
								posCom += dado;
								posCom = Comprobaciones.comprobarPosicionComputadora(posCom);
								Tablero.tablero(posJug, posCom);
								if(posCom == 25) {
									System.out.println("Computadora ha ganado la partida");
									hayGanadorOPerdedor = true;
									partida = false;
									return (partida);
								}
								numSeis++;
								dado = Dado.tiraDado();
								System.out.println("El jugador " + jugadores[i] + " ha sacado un " + dado);
							}
						}
					}
				}
				//Si no se saca un seis se procede normal
				if (dado != 0) {
					if (jugadores[i] == "Jugador") {
						if (Comprobaciones.comprobarTramoFinalJugador(posJug,dado) == (posJug - dado)) {
							System.out.println("El jugador " + jugadores[i] + " tiene que sacar un numero menor para mover o para terminar, si es superior  a las casillas que le quedan no puede mover");
							Tablero.tablero(posJug, posCom);
						} else {
							posJug += dado;
							posJug = Comprobaciones.comprobarPosicionJugador(posJug);
							Tablero.tablero(posJug, posCom);
							if(posJug == 25) {
									System.out.println("Jugador ha ganado la partida");
									hayGanadorOPerdedor = true;
									partida = false;
									return (partida);
							}
						}
					} else {
						if (Comprobaciones.comprobarTramoFinalComputadora(posCom,dado) == (posCom - dado)) {
							System.out.println("El jugador " + jugadores[i] + " tiene que sacar un numero menor para mover o para terminar, si es superior  a las casillas que le quedan no puede mover");
							Tablero.tablero(posJug, posCom);
						} else {
							posCom += dado;
							posCom = Comprobaciones.comprobarPosicionComputadora(posCom);
							Tablero.tablero(posJug, posCom);
							if(posCom == 25) {
									System.out.println("Computadora ha ganado la partida");
									hayGanadorOPerdedor = true;
									partida = false;
									return (partida);
							}
						}
					}
				}
			}
		}
		return true;
	}
		
	public static boolean moverConParametros(String[] args) {
		//Inicializamos indice a 0
		int indice = 0;
		//Inicializamos max al valor de la longitud del array args menos 1 elemento
		int max = args.length - 1;
		//Inicializamos el boolean partida a true
		boolean partida = true;
		//Inicializamos el array con los jugadores.
		String[] jugadores = {"Jugador", "Computadora"};
		//Inicializamos las posiciones posJug y posCom a la posicion 1
		int posJug = 1;
		int posCom = 1;
		//Inicializamos el array posiciones con los valores de posJug y posCom
		/* Con un booleano podemos detener el flujo del juego
		 * en el caso de que haya ganador o perdedor.
		 */
		boolean hayGanadorOPerdedor = false;
		//Ponemos a 0 el contador de turnos
		int turnCont = 0;
		//Se inicializa dado a 0
		int dado = 0;
		//Inicializamos retorno1Jug a 0 para controlar que el jugador vuelve a la casilla 1 por sacar 3 seises seguidos
		int retorno1Jug = 0;
		//Inicializamos retorno1Com a 0 para controlar que el jugador vuelve a la casilla 1 por sacar 3 seises seguidos
		int retorno1Com = 0;
		//Imprimimos el tablero inicial
		System.out.println("Juego con parámetros");
		System.out.println("Jugador = XX ------------- Computadora = ##");
		System.out.println("Tablero inicial");
		Tablero.tablero(posJug,posCom);
		//Comenzamos el bucle de tiradas
		while(!hayGanadorOPerdedor) {
			turnCont++;
			System.out.println("TURNO #" + turnCont);
			//Ahora cada jugador lanzará una vez
			for (int i = 0; i < jugadores.length && !hayGanadorOPerdedor; i++) {
				//Inicializamos el numero de seises de la tirada a 1 para cuando salga el primer seis
				int numSeis = 1;
				if(indice < max) {
					indice++;
				} else {
					return false;
				}
				System.out.println("Lanza el jugador " + jugadores[i]);
				dado = Integer.parseInt(args[indice]);
				System.out.println("El jugador " + jugadores[i] + " ha sacado un " + dado);
				if (jugadores[i] == "Jugador" && retorno1Jug > 0 && posJug == 1) {
					if (dado != 6) {
						System.out.println("El jugador " + jugadores[i] + " tiene que sacar un 6 para poder salir después de volver a la casilla 1");
						dado = 0;
						Tablero.tablero(posJug,posCom);	
					} else {
						posJug += dado;
						posJug = Comprobaciones.comprobarPosicionJugador(posJug);
						dado = 0;
						Tablero.tablero(posJug, posCom);
					}
				} else if (jugadores[i] == "Computadora" && retorno1Com > 0 && posCom == 1) {
					if (dado != 6) {
						System.out.println("El jugador " + jugadores[i] + " tiene que sacar un 6 para poder salir después de volver a la casilla 1");
						dado = 0;
						Tablero.tablero(posJug,posCom);
					} else {
						posCom += dado;
						posCom = Comprobaciones.comprobarPosicionComputadora(posCom);
						dado = 0;
						Tablero.tablero(posJug, posCom);
					}				
				}				
				//Si se saca un seis se vuelve a tirar y si salen tres seises seguidos el jugador vuelve a la casilla 1
				while(dado == 6 && numSeis <= 3) {
					if(numSeis == 3) {
						System.out.println("El jugador " + jugadores[i] + "vuelve a la casilla 1 por sacar tres seises seguidos");
						if (jugadores[i] == "Jugador") {
							posJug = 1;
							retorno1Jug++;
							dado = 0;
						} else {
							posCom = 1;
							retorno1Com++;
							dado = 0;
						}
					}
					if (dado != 0) {
						if (jugadores[i] == "Jugador") {
							if (Comprobaciones.comprobarTramoFinalJugador(posJug,dado) == (posJug - dado)) {
								System.out.println("El jugador " + jugadores[i] + " tiene que sacar un numero menor para mover o para terminar, si es superior  a las casillas que le quedan no puede mover");
								Tablero.tablero(posJug, posCom);
								numSeis++;
								if(indice < max) {
									indice++;
								} else {
									return false;
								}
								dado = Integer.parseInt(args[indice]);
								System.out.println("El jugador " + jugadores[i] + " ha sacado un " + dado);
							} else {
								posJug += dado;
								posJug = Comprobaciones.comprobarPosicionJugador(posJug);
								Tablero.tablero(posJug, posCom);
								if(posJug == 25) {
									System.out.println("Jugador ha ganado la partida");
									hayGanadorOPerdedor = true;
									partida = false;
									return (partida);
								}
								numSeis++;
								if(indice < max) {
									indice++;
								} else {
									return false;
								}
								dado = Integer.parseInt(args[indice]);
								System.out.println("El jugador " + jugadores[i] + " ha sacado un " + dado);
							}
						} else {
							if (Comprobaciones.comprobarTramoFinalComputadora(posCom,dado) == (posCom - dado)) {
								System.out.println("El jugador " + jugadores[i] + " tiene que sacar un numero menor para mover o para terminar, si es superior  a las casillas que le quedan no puede mover");
								Tablero.tablero(posJug, posCom);
								numSeis++;
								if(indice < max) {
									indice++;
								} else {
									return false;
								}
								dado = Integer.parseInt(args[indice]);
								System.out.println("El jugador " + jugadores[i] + " ha sacado un " + dado);
							} else {
								posCom += dado;
								posCom = Comprobaciones.comprobarPosicionComputadora(posCom);
								Tablero.tablero(posJug, posCom);
								if(posCom == 25) {
									System.out.println("Computadora ha ganado la partida");
									hayGanadorOPerdedor = true;
									partida = false;
									return (partida);
								}
								numSeis++;
								if(indice < max) {
									indice++;
								} else {
									return false;
								}
								dado = Integer.parseInt(args[indice]);
								
								System.out.println("El jugador " + jugadores[i] + " ha sacado un " + dado);
							}
						}
					}
				}
				//Si no se saca un seis se procede normal
				if (dado != 0) {
					if (jugadores[i] == "Jugador") {
						if (Comprobaciones.comprobarTramoFinalJugador(posJug,dado) == (posJug - dado)) {
							System.out.println("El jugador " + jugadores[i] + " tiene que sacar un numero menor para mover o para terminar, si es superior  a las casillas que le quedan no puede mover");
							Tablero.tablero(posJug, posCom);
						} else {
							posJug += dado;
							posJug = Comprobaciones.comprobarPosicionJugador(posJug);
							Tablero.tablero(posJug, posCom);
							if(posJug == 25) {
									System.out.println("Jugador ha ganado la partida");
									hayGanadorOPerdedor = true;
									partida = false;
									return (partida);
							}
						}
					} else {
						if (Comprobaciones.comprobarTramoFinalComputadora(posCom,dado) == (posCom - dado)) {
							System.out.println("El jugador " + jugadores[i] + " tiene que sacar un numero menor para mover o para terminar, si es superior  a las casillas que le quedan no puede mover");
							Tablero.tablero(posJug, posCom);
						} else {
							posCom += dado;
							posCom = Comprobaciones.comprobarPosicionComputadora(posCom);
							Tablero.tablero(posJug, posCom);
							if(posCom == 25) {
									System.out.println("Computadora ha ganado la partida");
									hayGanadorOPerdedor = true;
									partida = false;
									return (partida);
							}
						}
					}
				}
			}
		}
		return true;
	}
}
