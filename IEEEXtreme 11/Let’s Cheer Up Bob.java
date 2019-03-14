import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

	Scanner in = new Scanner(System.in);
	int[][] Bob = new int[3][3];
	HashMap<Integer, Integer> bobMap = new HashMap<Integer, Integer>();
	HashMap<Integer, Integer> gameField = new HashMap<Integer, Integer>();
	HashMap<Integer, Integer> gameField1 = new HashMap<Integer, Integer>();
	HashMap<Integer, Integer> gameField2 = new HashMap<Integer, Integer>();
	HashMap<Integer, Integer> gameField3 = new HashMap<Integer, Integer>();
	HashMap<Integer, Integer> gameField4 = new HashMap<Integer, Integer>();
	HashMap<Integer, Integer> gameFieldWin = new HashMap<Integer, Integer>();
	ArrayList<HashSet<Integer>> gameOver = new ArrayList<HashSet<Integer>>();
	ArrayList<ArrayList<Integer>> winArray = new ArrayList<ArrayList<Integer>>();
	gameOver.add(new HashSet<Integer>(Arrays.asList(1, 2, 3)));
	gameOver.add(new HashSet<Integer>(Arrays.asList(4, 5, 6)));
	gameOver.add(new HashSet<Integer>(Arrays.asList(7, 8, 9)));
	gameOver.add(new HashSet<Integer>(Arrays.asList(1, 4, 7)));
	gameOver.add(new HashSet<Integer>(Arrays.asList(2, 5, 8)));
	gameOver.add(new HashSet<Integer>(Arrays.asList(3, 6, 9)));
	gameOver.add(new HashSet<Integer>(Arrays.asList(1, 5, 9)));
	gameOver.add(new HashSet<Integer>(Arrays.asList(3, 5, 7)));
	ArrayList<Integer> bobSet = new ArrayList<Integer>(4);
	ArrayList<Integer> playerSet = new ArrayList<Integer>(4);
	ArrayList<Integer> bobSet1 = new ArrayList<Integer>(4);
	ArrayList<Integer> playerSet1 = new ArrayList<Integer>(4);
	ArrayList<Integer> bobSet2 = new ArrayList<Integer>(4);
	ArrayList<Integer> playerSet2 = new ArrayList<Integer>(4);
	ArrayList<Integer> bobSet3 = new ArrayList<Integer>(5);
	ArrayList<Integer> playerSet3 = new ArrayList<Integer>(4);
	ArrayList<Integer> bobSet0 = new ArrayList<Integer>(4);
	ArrayList<Integer> winSet = new ArrayList<Integer>(4);
	boolean fastGame=false;
	boolean found=false;
	int min1 = 0, min2 = 0, min3 = 0;
	String firstMoveS = "", secondMoveS = "", thirdMoveS = "", forthMoveS= "";

	Iterator<Integer> bobIt;
	Iterator<Integer> playerIt;
	int firstMove = 0, secondMove = 0, thirdMove = 0, forthMove = 0;

	for (int i = 1; i <= 9; i++) {
	    Bob[in.nextInt() - 1][in.nextInt() - 1] = i;

	}
	in.close();

	int c = 1;
	for (int i = 0; i < 3; i++) {
	    for (int j = 0; j < 3; j++) {
		bobMap.put(c, Bob[i][j]);
		c++;
	    }
	}

	for (int i = 0; i < 9; i++) {
	    if (bobMap.get(i + 1) == 1) {
		gameField.put(i + 1, 1);
		bobSet0.add(i + 1);
	    } else
		gameField.put(i + 1, -1);
	}
	gameFieldWin.putAll(gameField);
	// System.out.println(gameField.entrySet());

	Game: for (int i = 1; i <= 9; i++) { // First Move Player
	    gameField1.clear();
	    gameField1.putAll(gameField);
	    bobSet.clear();
	    bobSet.addAll(bobSet0);
	    playerSet.clear();

	    if (gameField.get(i) == -1) {
		gameField1.put(i, 10);
		playerSet.add(i);
	    } else
		continue;

	    for (int q = 1, w = 2; q <= 9 && w <= 9; q++) { // Second Move Bob
		if (bobMap.get(q) == w && gameField1.get(q) == -1) {
		    gameField1.put(q, 2);
		    bobSet.add(q);
		    break;
		} else if (bobMap.get(q) == w && gameField1.get(q) != -1) {
		    w++;
		    q = 0;
		}
	    }

	    for (int j = 1; j <= 9; j++) { // Second Move Player

		gameField2.clear();
		gameField2.putAll(gameField1);
		bobSet1.clear();
		bobSet1.addAll(bobSet);
		playerSet1.clear();
		playerSet1.addAll(playerSet);

		if (gameField2.get(j) == -1) {
		    gameField2.put(j, 20);
		    playerSet1.add(j);
		} else
		    continue;

		for (int q = 1, w = 3; q <= 9 && w <= 9; q++) { // Third Move
								// Bob
		    if (bobMap.get(q) == w && gameField2.get(q) == -1) {
			gameField2.put(q, 3);
			bobSet1.add(q);
			break;
		    } else if (bobMap.get(q) == w && gameField2.get(q) != -1) {
			w++;
			q = 0;
		    }
		}
		if (gameOver.contains(new HashSet<Integer>(bobSet1))) {
		    gameFieldWin.putAll(gameField2);
		    winSet.addAll(playerSet1);
		    fastGame=true;
		    break Game;
		}
		for (int e = 1; e <= 9; e++) { // Third Move Player
		    gameField3.clear();
		    gameField3.putAll(gameField2);
		    bobSet2.clear();
		    bobSet2.addAll(bobSet1);
		    playerSet2.clear();
		    playerSet2.addAll(playerSet1);

		    if (gameField3.get(e) == -1) {
			gameField3.put(e, 30);
			playerSet2.add(e);
		    } else
			continue;

		    if (gameOver.contains(new HashSet<Integer>(playerSet2)))
			continue;

		    for (int q = 1, w = 4; q <= 9 && w <= 9; q++) { // Forth
								    // Move Bob
			if (bobMap.get(q) == w && gameField3.get(q) == -1) {
			    gameField3.put(q, 4);
			    bobSet2.add(q);
			    break;
			} else if (bobMap.get(q) == w
				&& gameField3.get(q) != -1) {
			    w++;
			    q = 0;
			}
		    }
		    for (HashSet<Integer> p : gameOver) {
			    if (bobSet2.containsAll(p)){
				gameFieldWin.putAll(gameField3);
			    winArray.add(new ArrayList<Integer>(playerSet2));}
			}
		    

Move2:		    for (int r = 1; r <= 9; r++) { // Forth Move Player
			gameField4.clear();
			gameField4.putAll(gameField3);
			bobSet3.clear();
			bobSet3.addAll(bobSet2);
			playerSet3.clear();
			playerSet3.addAll(playerSet2);

			if (gameField4.get(r) == -1) {
			    gameField4.put(r, 40);
			    playerSet3.add(r);
			} else
			    continue;

			for (HashSet<Integer> p : gameOver) {
			    if (playerSet3.containsAll(p))
				continue Move2;
			}

			for (int q = 1, w = 5; q <= 9 && w <= 9; q++) { // Fifth
									// Move
									// Bob
			    if (bobMap.get(q) == w && gameField4.get(q) == -1) {
				gameField4.put(q, 5);				
				bobSet3.add(q);
				break;
			    } else if (bobMap.get(q) == w
				    && gameField4.get(q) != -1) {
				w++;
				q = 0;
			    }
			}
			for (HashSet<Integer> p : gameOver) {
			    if (bobSet3.containsAll(p)){
				gameFieldWin.putAll(gameField4);
			    winArray.add(new ArrayList<Integer>(playerSet3));}
			}

		    }

		}

	    }

	}
	System.out.println();
int x=4;

if(fastGame==false){
B:	for (int i=0; i<winArray.size(); i++){
	    //System.out.println(winArray.get(i));
	    if(winArray.get(i).size()<x){
		firstMove=winArray.get(i).get(0);
		secondMove=winArray.get(i).get(1);
		thirdMove=winArray.get(i).get(2);
		
		    switch(firstMove){
			case 1:{ firstMoveS="1 1";break; }
			case 2:{ firstMoveS="1 2";break; }
			case 3:{ firstMoveS="1 3";break; }
			case 4:{ firstMoveS="2 1";break; }
			case 5:{ firstMoveS="2 2";break; }
			case 6:{ firstMoveS="2 3";break; }
			case 7:{ firstMoveS="3 1";break; }
			case 8:{ firstMoveS="3 2";break; }
			case 9:{ firstMoveS="3 3";break; }
		    }
		    switch(secondMove){
			case 1:{ secondMoveS="1 1";break; }
			case 2:{ secondMoveS="1 2";break; }
			case 3:{ secondMoveS="1 3";break; }
			case 4:{ secondMoveS="2 1";break; }
			case 5:{ secondMoveS="2 2";break; }
			case 6:{ secondMoveS="2 3";break; }
			case 7:{ secondMoveS="3 1";break; }
			case 8:{ secondMoveS="3 2";break; }
			case 9:{ secondMoveS="3 3";break; }
		    }
		    switch(thirdMove){
			case 1:{ thirdMoveS="1 1";break; }
			case 2:{ thirdMoveS="1 2";break; }
			case 3:{ thirdMoveS="1 3";break; }
			case 4:{ thirdMoveS="2 1";break; }
			case 5:{ thirdMoveS="2 2";break; }
			case 6:{ thirdMoveS="2 3";break; }
			case 7:{ thirdMoveS="3 1";break; }
			case 8:{ thirdMoveS="3 2";break; }
			case 9:{ thirdMoveS="3 3";break; }
		    }
		    found=true;
		    if(x==5){ forthMove=winArray.get(i).get(3);
		    switch(forthMove){
			case 1:{ forthMoveS="1 1";break; }
			case 2:{ forthMoveS="1 2";break; }
			case 3:{ forthMoveS="1 3";break; }
			case 4:{ forthMoveS="2 1";break; }
			case 5:{ forthMoveS="2 2";break; }
			case 6:{ forthMoveS="2 3";break; }
			case 7:{ forthMoveS="3 1";break; }
			case 8:{ forthMoveS="3 2";break; }
			case 9:{ forthMoveS="3 3";break; }
		    }
		    System.out.println(firstMoveS+"\n"+secondMoveS+"\n"+thirdMoveS+"\n"+forthMoveS);
		    }
		    else		
		System.out.println(firstMoveS+"\n"+secondMoveS+"\n"+thirdMoveS);
		break;
	}
	    if(i==winArray.size()-1&&found==false){ x=5; i=-1; continue B;}
	    }
	}

	else{
	    firstMove=winSet.get(0);
	    secondMove=winSet.get(1);
	    switch(firstMove){
		case 1:{ firstMoveS="1 1";break; }
		case 2:{ firstMoveS="1 2";break; }
		case 3:{ firstMoveS="1 3";break; }
		case 4:{ firstMoveS="2 1";break; }
		case 5:{ firstMoveS="2 2";break; }
		case 6:{ firstMoveS="2 3";break; }
		case 7:{ firstMoveS="3 1";break; }
		case 8:{ firstMoveS="3 2";break; }
		case 9:{ firstMoveS="3 3";break; }
	    }
	    switch(secondMove){
		case 1:{ secondMoveS="1 1";break; }
		case 2:{ secondMoveS="1 2";break; }
		case 3:{ secondMoveS="1 3";break; }
		case 4:{ secondMoveS="2 1";break; }
		case 5:{ secondMoveS="2 2";break; }
		case 6:{ secondMoveS="2 3";break; }
		case 7:{ secondMoveS="3 1";break; }
		case 8:{ secondMoveS="3 2";break; }
		case 9:{ secondMoveS="3 3";break; }
	    }
	    System.out.println(firstMoveS+"\n"+secondMoveS);
	}
	    
	
    }

}
