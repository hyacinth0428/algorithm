package com.martin.lc.locked;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Design a Snake game that is played on a device with screen size = width x height. Play the game online if you are not familiar with the game.

The snake is initially positioned at the top left corner (0,0) with length = 1 unit.

You are given a list of food's positions in row-column order. When a snake eats the food, its length and the game's score both increase by 1.

Each food appears one by one on the screen. For example, the second food will not appear until the first food was eaten by the snake.

When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.

Example:
Given width = 3, height = 2, and food = [[1,2],[0,1]].

Snake snake = new Snake(width, height, food);

Initially the snake appears at position (0,0) and the food at (1,2).

|S| | |
| | |F|

snake.move("R"); -> Returns 0

| |S| |
| | |F|

snake.move("D"); -> Returns 0

| | | |
| |S|F|

snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )

| |F| |
| |S|S|

snake.move("U"); -> Returns 1

| |F|S|
| | |S|

snake.move("L"); -> Returns 2 (Snake eats the second food)

| |S|S|
| | |S|

snake.move("U"); -> Returns -1 (Game over because snake collides with border)

Credits:
Special thanks to @elmirap for adding this problem and creating all test cases.

Hide Company Tags Google
Show Tags

 * */
public class SnakeGame {
	private int hX = 0;
    private int hY = 0;
    private HashSet<Integer> set;
    private Deque<Integer> dq;
    private int fIndex = 0;
    private int height = 0;
    private int width = 0;
    private int[][] food;
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.set = new HashSet<Integer>();
        this.dq = new LinkedList<Integer>();
        this.height = height;
        this.width = width;
        this.food = food;
        dq.offerLast(0);
        set.add(0);
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        //remove last one
        //System.out.println(dq.size());
        //System.out.println(set.size());
        int polled = dq.pollFirst();
        set.remove(polled);
        //remove to new one, and check valid
        if( direction.equals("U") ) hX -= 1;
        else if(direction.equals("L")) hY -= 1;
        else if(direction.equals("R")) hY += 1;
        else hX += 1;
        
        int pVal = hX * width + hY;
        
        if( hX < 0 || hX >= height || hY <0 || hY >= width || set.contains(pVal) ) return -1;
        
        if( fIndex < food.length){
            if( hX == food[fIndex][0] && hY == food[fIndex][1]){
                fIndex ++;
                dq.offerFirst(polled);
                set.add(polled);
            }
        }
        
        dq.offerLast(pVal);
        set.add(pVal);
        
        //System.out.println(fIndex);
        return fIndex;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
