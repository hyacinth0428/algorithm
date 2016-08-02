package com.martin.lc.locked;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Design a Tic-tac-toe game that is played between two players on a n x n grid.

You may assume the following rules:

A move is guaranteed to be valid and is placed on an empty block.
Once a winning condition is reached, no more moves is allowed.
A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
Example:
Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.

TicTacToe toe = new TicTacToe(3);

toe.move(0, 0, 1); -> Returns 0 (no one wins)
|X| | |
| | | |    // Player 1 makes a move at (0, 0).
| | | |

toe.move(0, 2, 2); -> Returns 0 (no one wins)
|X| |O|
| | | |    // Player 2 makes a move at (0, 2).
| | | |

toe.move(2, 2, 1); -> Returns 0 (no one wins)
|X| |O|
| | | |    // Player 1 makes a move at (2, 2).
| | |X|

toe.move(1, 1, 2); -> Returns 0 (no one wins)
|X| |O|
| |O| |    // Player 2 makes a move at (1, 1).
| | |X|

toe.move(2, 0, 1); -> Returns 0 (no one wins)
|X| |O|
| |O| |    // Player 1 makes a move at (2, 0).
|X| |X|

toe.move(1, 0, 2); -> Returns 0 (no one wins)
|X| |O|
|O|O| |    // Player 2 makes a move at (1, 0).
|X| |X|

toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
|X| |O|
|O|O| |    // Player 1 makes a move at (2, 1).
|X|X|X|
Follow up:
Could you do better than O(n2) per move() operation?

MS, Google
 * */
public class TicTacToe {
	 public static class Stat{
	        public boolean p1In;
	        public boolean p2In;
	        public HashSet<Integer> occupied;
	        public Stat(){
	            this.p1In = false;
	            this.p2In = false;
	            this.occupied = new HashSet<Integer>();
	        }
	       
	        public boolean hasWin(int size){
	            return ( p1In != p2In ) && occupied.size() == size;
	        }
	    }
	    
	    Stat[] rStat;
	    Stat[] cStat;
	    Stat d1Stat;
	    Stat d2Stat;
	    int size;
	    /** Initialize your data structure here. */
	    public TicTacToe(int n) {
	        //NOTE!!!!: YOU WERE Arrays.fill(rStat, new Stat()); !!! in this case, all slot is the same new Stat() obj..
	        this.rStat = new Stat[n];
	        for(int i=0;i<n;i++) rStat[i] = new Stat();
	        
	        this.cStat = new Stat[n];
	        for(int i=0;i<n;i++) cStat[i] = new Stat();
	        
	        this.d1Stat = new Stat();
	        this.d2Stat = new Stat();
	        this.size = n;
	        //print();
	    }
	    
	    /** Player {player} makes a move at ({row}, {col}).
	        @param row The row of the board.
	        @param col The column of the board.
	        @param player The player, can be either 1 or 2.
	        @return The current winning condition, can be either:
	                0: No one wins.
	                1: Player 1 wins.
	                2: Player 2 wins. */
	    public int move(int row, int col, int player) {
	        //handle correspoding row, col, d
	        int rIndex = row;
	        int cIndex = col;
	        boolean d1 = false;
	        boolean d2 = false;
	        if( row == col) d1 = true;
	        if( row + col == size - 1) d2 = true;
	        if( player == 1){
	            rStat[rIndex].p1In = true;
	            cStat[cIndex].p1In = true;
	            if(d1) d1Stat.p1In = true;
	            if(d2) d2Stat.p1In = true;
	        }else{
	            rStat[rIndex].p2In = true;
	            cStat[cIndex].p2In = true;
	            if(d1) d1Stat.p2In = true;
	            if(d2) d2Stat.p2In = true;
	        }
	        
	        rStat[rIndex].occupied.add(col);
	        cStat[cIndex].occupied.add(row);
	        if(d1) d1Stat.occupied.add(col);
	        if(d2) d2Stat.occupied.add(row);
	        
	        if(rStat[rIndex].hasWin(this.size)) return player;
	        if(cStat[cIndex].hasWin(this.size)) return player;
	        if(d1Stat.hasWin(this.size)) return player;
	        if(d2Stat.hasWin(this.size)) return player;
	    
	        return 0;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
