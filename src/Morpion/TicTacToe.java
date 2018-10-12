package Morpion;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class TicTacToe {
    public static void main(String args[]) {
    	Board b=new Board();
    	int player=0;
    	/*
        while(!b.isGameOver()) {
        	if(player%2==0)
        	    b.takeHumanInput(1);
        	else
        		b.takeHumanInput(2);
        	player++;
        }
        */
    	
    	b.displayBoard();
    	while(!b.isGameOver()) {
    		b.takeHumanInput(2);
    		b.displayBoard();
    		if(b.isGameOver())
    			break;
    		b.callMinimax(0, 1);
    		b.placeAMove(b.returnBestMove(),1);
   			b.displayBoard();
    		
        }
 
    }
}