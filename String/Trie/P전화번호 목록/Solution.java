package Programmers;

import java.util.*;

class Solution {
	static class TrieNode {
		Map<Character, TrieNode> childNodes = new HashMap<>();
		boolean isLastChar;
	}

	static class Trie {
		TrieNode root = new TrieNode();

		void insert(String input) {
			TrieNode cur = root;

			for (int i = 0; i < input.length(); i++) {
				char ch = input.charAt(i);
				if (cur.childNodes.containsKey(ch) == false) {
					cur.childNodes.put(ch, new TrieNode());
				}
				cur = cur.childNodes.get(ch);
			}
			cur.isLastChar = true;
		}

		boolean check(String input) {
			TrieNode cur = root;

			for (int i = 0; i < input.length(); i++) {
				char ch = input.charAt(i);
				if (cur.isLastChar == true && cur.childNodes.get(ch) != null) return false;
				cur = cur.childNodes.get(ch);
			}

			return true;
		}
	}

	public boolean solution(String[] phone_book) {
		Trie trie = new Trie();

		for (String pb : phone_book) {
//			trie.insert(pb);
			for(int i = 0; i < phone_book.length; i++) {
				if(phone_book[i].equals(pb)) continue;
				if(phone_book[i].startsWith(pb)) return false;
				if(pb.startsWith(phone_book[i])) return false;
			}
		}

//		for (String pb : phone_book) {
//			if (trie.check(pb) == false)
//				return false;
//		}

		return true;
	}

	public static void main(String[] args) {
		Solution s = new Solution();

		System.out.println(s.solution(new String[] { "119", "97674223", "1195524421" }));
		System.out.println(s.solution(new String[] { "123", "456", "789" }));
		System.out.println(s.solution(new String[] { "12", "123", "1235", "567", "88" }));
	}
}