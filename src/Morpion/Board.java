package Morpion;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Board {
    Scanner scan = new Scanner(System.in);
    //tableau de jeu
    int[][] board = new int[3][3];
    
    List<PointAndScore> successeursScores;
    
    

    //affiche le plateau de jeu
    public void displayBoard() {
    	for(int i=0;i<3;i++) {
    		for(int j=0;j<3;j++) {
    			System.out.print(board[i][j]+" ");
    		}
    		System.out.println("");
    	}
    }
    
//met dans le plateau � la case point, le symbole
//pour le joueur : player=1 pour X, player=2 pour O
    public void placeAMove(Point point, int player) {
    	
    	int x=point.x;
    	int y=point.y;
    	if(board[x][y]==0){
    	    if(player==1) {
    		    board[x][y]=1;
    	    }else if(player==2) {
    		    board[x][y]=2;
    	    }
    	}else {
    		System.out.println("Le case est deja remplie"+x+" "+y);
    	}
    	
    		
    }
    
//Invite l�utilisateur de saisir au clavier
//les coordonn�es d�un point (i,j)
//et place le mouvement sur le plateau pour le joueur pass� en param�tre.
    void takeHumanInput(int player) {
    	System.out.println("");
    	displayBoard();
    	System.out.println("Veuille choisir un x");
    	int x= scan.nextInt();
    	System.out.println("Veuille choisir un y");
    	int y=scan.nextInt();
    	Point p=new Point(x,y);
    	placeAMove(p,player);
    	System.out.println("");
    	displayBoard();
    }
    
// retourne la liste des cases vides du plateau
    public List<Point> getAvailablePoints(){
         List<Point> lp=new ArrayList<Point>();
         for(int i=0;i<3;i++) {
     		for(int j=0;j<3;j++) {
     			if(board[i][j]==0) {
     				lp.add(new Point(i,j));
     			}
     		}
     	}
        return lp;
    }
    
// v�rifie si X a fait l�une des 2 diagonales ou une ligne ou une colonne
    public boolean hasXWon() {
    	for(int i=0;i<3;i++) {
    		if(board[i][0]==1 && board[i][1]==1 && board[i][2]==1) {
    			return true;
    		}
    	}
    	for(int i=0;i<3;i++) {
    		if(board[0][i]==1 && board[1][i]==1 && board[2][i]==1) {
    			return true;
    		}
    	}
    	
    	if(board[0][0]==1 && board[1][1]==1 && board[2][2]==1)
    		return true;
    	
    	if(board[0][2]==1 && board[1][1]==1 && board[2][0]==1)
    		return true;

		return false;
    	
    }
    
// v�rifie si O a fait l�une des 2 diagonales ou une ligne ou une colonne
    public boolean hasOWon() {
    	for(int i=0;i<3;i++) {
    		if(board[i][0]==2 && board[i][1]==2 && board[i][2]==2) {
    			return true;
    		}
    	}
    	for(int i=0;i<3;i++) {
    		if(board[0][i]==2 && board[1][i]==2 && board[2][i]==2) {
    			return true;
    		}
    	}
    	
    	if(board[0][0]==2 && board[1][1]==2 && board[2][2]==2)
    		return true;
    	
    	if(board[0][2]==2 && board[1][1]==2 && board[2][0]==2)
    		return true;

		return false;
    	
    }
    
    
// v�rifie si le jeu est fini (quelqu�un a gagn� OU le tableau est plein (�galit�))
    public boolean isGameOver() {
    	if(hasXWon()) {
    		System.out.println("X has won");
    		return true;
    	}
    	if(hasOWon()) {
    		System.out.println("O has won");
    		return true;
        }
        for(int i=0;i<3;i++) {
    		for(int j=0;j<3;j++) {
    			if(board[i][j]==0) {
    				return false;
    			}
    		}
    	}
		return true;
    }
    
    
    
    public int returnMin(List<Integer> scores) {
    	int min=Integer.MAX_VALUE;
    	for(int tt: scores) {
    		if(min>=tt)
    			min=tt;
    	}
		return min;
    	//return Collections.min(scores);
    }
    
    public int returnMax(List<Integer> scores) {
    	
    	int max=Integer.MIN_VALUE;
    	for(int tt: scores) {
    		if(max<=tt)
    			max=tt;
    	}
		return max;

    }
    
    public Point returnBestMove() {
    	
    	int max=Integer.MIN_VALUE;
    	Point p1=null;
    	for(PointAndScore ps: successeursScores) {
    		if(max<ps.getScore())
    		{
    			max=ps.getScore();
    			p1=ps.point;
    		}
    	}
    	System.out.println(p1);
		return p1;
    
    }
    
    public void callMinimax(int depth, int turn){
    	successeursScores = new ArrayList<PointAndScore>();
    	int res = minimax(depth, turn, Integer.MIN_VALUE,Integer.MAX_VALUE);
    	//int res = minimax(depth, turn);
    }
    
    
    
    public int minimax(int depth, int turn) {
    	
    	if(hasXWon())    return 1;	
    	if(hasOWon())    return -1;
    	
    	
    	List<Point> lp=getAvailablePoints();
    	if(lp.isEmpty())    return 0;
    	
    	List<Integer> scores=new ArrayList<Integer>();
    	
    	if(turn==1) {
    		for(Point point: lp) {
    			placeAMove(point,1);
    			int currentScore=minimax(depth+1,2);
    			scores.add(currentScore);
    			if(depth==0) successeursScores.add(new PointAndScore(currentScore, point));
    			board[point.x][point.y] = 0;
    		}
    	}else if(turn==2) {
    		for(Point point: lp) {
    			placeAMove(point,2);
    			int currentScore=minimax(depth+1,1);
    			scores.add(currentScore);
    			board[point.x][point.y] = 0;
    		}
    	}
		
    	return (turn == 1) ? returnMax(scores): returnMin(scores);
     }
    
    
    
    public int minimax(int depth, int turn, int alpha, int beta) {
    	if(hasXWon())    return 1;	
    	if(hasOWon())    return -1;
    	
    	
    	List<Point> lp=getAvailablePoints();
    	if(lp.isEmpty())    return 0;
    	
    	
    	if(turn==1) {
    		int maxEval=Integer.MIN_VALUE;
    		for(Point point: lp) {
    			placeAMove(point,1);
    			int currentScore=minimax(depth+1,2,alpha,beta);
    			maxEval=(maxEval>currentScore)?maxEval:currentScore;
    			alpha=(alpha>currentScore)?alpha:currentScore;
    			if(depth==0) successeursScores.add(new PointAndScore(currentScore, point));
    			board[point.x][point.y] = 0;
    			if(beta<=alpha)
    				break;
    			
    		}
    		return maxEval;
    	}else if(turn==2) {
    		int minEval=Integer.MAX_VALUE;
    		for(Point point: lp) {
    			placeAMove(point,2);
    			int currentScore=minimax(depth+1,1,alpha,beta);
    			minEval=(minEval<currentScore)?minEval:currentScore;
    			beta=(beta<currentScore)?beta:currentScore;
    			board[point.x][point.y] = 0;
    			if(beta<=alpha)
    				break;
    			
    		}
    		return minEval;
    	}
		
    	return 0;
    }
}