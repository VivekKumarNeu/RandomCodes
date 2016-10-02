package com.trees;

import java.util.HashMap;

public class tries {

	class TrieNode {

		HashMap<Character, TrieNode> bucket;
		boolean wordend;

		public TrieNode() {
			bucket = new HashMap<>();
			wordend = false;
		}
	}

	private final TrieNode root;

	public tries() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode current = root;
		for (int i = 0; i <= word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.bucket.get(ch);
			if (node == null) {
				node = new TrieNode();
				current.bucket.put(ch, node);
			}

			current = node;
		}

		current.wordend = true;
	}

	public boolean search(String word) {

		TrieNode current = root;
		for (int i = 0; i <= word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.bucket.get(ch);

			if (node == null)
				return false;

			current = node;
		}
		current.wordend = true;
		
			return true;
	}
	
	public boolean delete(TrieNode current, String word, int in)
	{
		if(word.length()==0){
			if (!current.wordend) {
            return false;
        }
        current.wordend = false;
        return current.bucket.size() == 0;
	}
    char ch = word.charAt(in);
    TrieNode node = current.bucket.get(ch);
    if (node == null) {
        return false;
    }
    boolean shouldDeleteCurrentNode = delete(node, word, in + 1);

    if (shouldDeleteCurrentNode) {
    	current.bucket.remove(ch);
        return current.bucket.size() == 0;
    }
    return false;
		}
	
}
	