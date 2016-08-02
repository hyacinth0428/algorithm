package com.martin.lc.locked;

import java.util.ArrayList;

/**
 * Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, count the total number of unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.

Rules for a valid pattern:
Each pattern must connect at least m keys and at most n keys.
All the keys must be distinct.
If the line connecting two consecutive keys in the pattern passes through any other keys, the other keys must have previously selected in the pattern. No jumps through non selected key is allowed.
The order of keys used matters.

Explanation:
| 1 | 2 | 3 |
| 4 | 5 | 6 |
| 7 | 8 | 9 |
Invalid move: 4 - 1 - 3 - 6 
Line 1 - 3 passes through key 2 which had not been selected in the pattern.

Invalid move: 4 - 1 - 9 - 2
Line 1 - 9 passes through key 5 which had not been selected in the pattern.

Valid move: 2 - 4 - 1 - 3 - 6
Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern

Valid move: 6 - 5 - 4 - 1 - 9 - 2
Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.

Example:
Given m = 1, n = 1, return 9.
Google
*/
public class AndroidLockPattern {
	int cnt = 0;
    public int numberOfPatterns(int m, int n) {
        for(int i =m;i<=n;i++){
            for(int a = 0; a<3;a ++){
                for(int b=0; b<3; b++){
                    cnt += dfs(new boolean[3][3], a, b,1,i);
                }
            }
        }
        return cnt; 
    }
    
    public int dfs(boolean[][] visited, int x, int y,int level, int target){
        if(level == target) return 1;
        else{
            int cnt = 0;
            //level;
            visited[x][y] = true;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(i==x&&j==y) continue;
                    if(!visited[i][j] ){
                        int dis = Math.max( Math.abs(x-i), Math.abs(y-j));
                        if(dis==1) cnt += dfs(visited,i,j,level+1,target);
                        else{
                            if(x==i){
                                if(visited[x][1]) cnt += dfs(visited,i,j,level+1,target);
                            }
                            else if(y==j){
                                if(visited[1][y]) cnt += dfs(visited,i,j,level+1,target);
                            }
                            else{
                                if( Math.abs(x-i) == Math.abs(y-j)){
                                    if(visited[1][1]) cnt += dfs(visited,i,j,level+1,target);
                                }else{
                                    cnt += dfs(visited,i,j,level+1,target);
                                }
                            }
                            
                        }
                    }
                }
            }
            visited[x][y] = false;
            return cnt;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(1,2);
		list.remove(2);
		System.out.println();
	}

}
