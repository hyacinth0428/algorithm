package com.martin.AdvancedDatasStructure;

import java.util.HashMap;

class TrieNode {
    public boolean isStr;
    public String content;
    public HashMap<Character,TrieNode> children;
    // Initialize your data structure here.
    public TrieNode() {
        this.isStr = false;
        this.content = "";
        this.children = new HashMap<Character,TrieNode>();
    }
  
}
public class Trie {
	 private TrieNode root;

	    public Trie() {
	        root = new TrieNode();
	    }

	    // Inserts a word into the trie.
	    public void insert(String word) {
	        TrieNode curNode = root;
	        for(int i=0;i<word.length();i++){
	            char curChar = word.charAt(i);
	            if(!curNode.children.containsKey(curChar)){
	                curNode.children.put(curChar,new TrieNode());
	            }
	            curNode = curNode.children.get(curChar);
	        }
	        curNode.isStr = true;
	        curNode.content = word;
	    }

	    // Returns if the word is in the trie.
	    public boolean search(String word) {
	        TrieNode curNode = root;
	        for(int i=0;i<word.length();i++){
	            char curChar = word.charAt(i);
	            if(!curNode.children.containsKey(curChar)) return false;
	            else{
	                curNode = curNode.children.get(curChar);
	            }
	        }
	        return curNode.isStr;
	    }

	    // Returns if there is any word in the trie
	    // that starts with the given prefix.
	    public boolean startsWith(String prefix) {
	        TrieNode curNode = root;
	        for(int i=0;i<prefix.length();i++){
	            char curChar = prefix.charAt(i);
	            if(!curNode.children.containsKey(curChar)) return false;
	            else{
	                curNode = curNode.children.get(curChar);
	            }
	        }
	        return true;
	    }
}
