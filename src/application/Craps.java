package application;

import java.security.SecureRandom;

public class Craps {
	// Cria um gerador seguro de numeros aleatorios para uso no metodo rolldice
	private static final SecureRandom randomNumbers = new SecureRandom();
	
	// com constantes que representam o estado do jogo, funcionam como maquina de estados.
	private enum Status{CONTINUE, WON, LOST};
	// constantes que representam lançamento comuns dos dados
	private static final int SNAKE_EYES =2;
	private static final int TREY =3;
	private static final int SEVEN =7;
	private static final int YO_LEVEN = 11;
	private static final int BOX_CARS =12;
	
	// joga uma partida craps
	
	public static void main(String[] args) {
		int myPoint = 0; // pontos se não ganhar ou perder na 1ºrolagem 
		Status gameStatus; // pode conter CONTINUE, WON ou LOST
		int sumOfDice = rollDice(); // primeira rolagem dos dados.
		// determina o estado do jogo e a pontuação com base no primeiro lançamento
		switch (sumOfDice)
		{
		case SEVEN: // ganha com 7 no primeiro lançamento
		case YO_LEVEN: // ganha com 11 no primeiro lançamento
			gameStatus = Status.WON;
			break;
		case SNAKE_EYES: // perde com 2 no primeiro lançamento
		case TREY: // perde com 3 no primeiro lançamento.
		case BOX_CARS: // perde com 12 no primeiro lançamento
				gameStatus = Status.LOST;
				break;
		default: // nao ganhou nem perdeu, portanto registra a pontuação
				gameStatus = Status.CONTINUE; // jogo nao terminou
				myPoint = sumOfDice; // informa a pontuação
				System.out.printf("point is %d%n", myPoint);
				break;
		}
		
		//enquanto o jogo nao estiver completo
		while (gameStatus == Status.CONTINUE)// nem WON nem LOST
		{
			sumOfDice = rollDice(); // lancça os dados novamente
			
			//determina o estado do jogo
			
			if (sumOfDice == myPoint) //vitoria por pontuação
			gameStatus = Status.WON;
			
			else 
				if (sumOfDice == SEVEN)
					gameStatus = Status.LOST;
		}
		
		// exibe uma menasgem ganou ou prdeu
		
		if (gameStatus == Status.WON)
			System.out.println("player Wins");
		else
			System.out.println("player Loses");		
		}
	// lança os dados, calcula a soma e exibe os resultados
	
	public static int rollDice()
	{
		int diell = 1 + randomNumbers.nextInt(6);
		int diel2 = 1 + randomNumbers.nextInt(6);
	
		int sum = diell + diel2;
		
	return sum;
	}

}

