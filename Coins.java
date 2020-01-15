import java.io.File;
import java.util.Scanner;

public class Coins {

    private Coins() {
    }
    
    public int makeChange(int total, int[] coins) {
        int[][] coins2D = new int[coins.length][total + 1];
	int[] D = new int[coins.length];

	for (int i = 0; i < 1; i++) {
	    for (int j = 0; j < total + 1; j++) {
		coins2D[i][j] = j;
	    }
	}
	for (int i = 0; i < coins.length; i++) {
	    for (int j = 0; j <= 1; j++) {
		coins2D[i][j] = j;
	    }
	}
	
	for (int i = 1; i < coins.length; i++) {
	    for (int j = 2; j < total + 1; j++) {
                if (j >= coins[i]) {
                    coins2D[i][j] = Math.min(coins2D[i - 1][j], (1 + coins2D[i][j - coins[i]]));
		}
                else {
		    coins2D[i][j] = coins2D[i - 1][j];
		}            
	    }
        }

	/*
	for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < total + 1; j++) {
		System.out.print(coins2D[i][j] + " ");
	    }
	}
	*/
	
	int minCoins = Integer.MAX_VALUE - 1;
	int minIndexY = 0;
	int minIndexY1 = Integer.MAX_VALUE - 1;
	for (int i = coins.length - 1; i >= 0; i--) {
	    for (int j = total; j < total + 1; j++) {  
		if (coins2D[i][j] <= minCoins && i < minIndexY1) {
		    minCoins = coins2D[i][j];
		    minIndexY1 = i;
		    minIndexY = i;
		}
	    }
	} 

	//System.out.println(minCoins);
	System.out.println(total + ": " + minCoins + " coins");
	//System.out.println(minIndexX);
	int total1 = total;
	//minIndexX = Integer.MAX_VALUE - 1;
	for (int j = total; j >= 0; j--) {
	    for (int i = coins.length - 1; i >= 0; i--) {
		if (coins2D[i][j] < minCoins && i <= minIndexY1) {
			minCoins = coins2D[i][j];
			minIndexY1 = i;
			minIndexY = i;
			D[minIndexY] += 1;   
		}
	    }
	}
    
	for (int i = coins.length - 1; i >= 0; i--) {
	    if (D[i] != 0) {
		System.out.println(coins[i] + " * " + D[i]);
	    }
	}
	
	return 0;
    }

    public static int[] readFiles(String file) {
	try {
	    File f = new File(file);
	    Scanner s = new Scanner(f);
	    int ctr = 0;
	    while (s.hasNextInt()) {
		ctr++;
		s.nextInt();
	    }
	    int[] coins = new int[ctr];
	
	    Scanner s1 = new Scanner(f);
	
	    int total = 0;
	    for (int i = 0; i < 1; i++) {
		total = s1.nextInt();
	    }
	    
	    for (int i = 1; i < coins.length; i++) {
		coins[i] = s1.nextInt();
	    }
	    
	    Coins coin = new Coins();
	    int change = coin.makeChange(total, coins);
	    
	    return coins;
	}
	catch (Exception e) {
	    return null;
	}
    }
    
    public static void main(String[] args) {
	int[] numbers = readFiles(args[0]);
      
	//int total = 161;
        //int coins[] = {1, 10, 21, 34, 70, 100};
    }
}