package hackersrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NoPrefixSet {
    public static void main(String[] args) {
        TrieNode root = new TrieNode();
        Scanner scan = new Scanner(System.in);
        int n =scan.nextInt();
        List<String> input = new ArrayList<>();
        for(int i=0;i<n;i++){
            input.add(scan.next());
        }
        boolean isBad = false;
        String cond = "";
        input.stream().forEach(word-> root.addWord(word));
        for(int i=0;i<input.size() && !isBad;i++){
            String word = input.get(i);
            for(int m=0;m<input.size() && m!=i;m++){
                if(root.isPrefixPresent(input.get(m))){
                    isBad=true;
                    cond = input.get(m);
                    break;
                }
            }
        }
        if(isBad){
            System.out.println("BAD SET");
            System.out.println(cond);
        }else{
            System.out.println("GOOD SET");
        }
    }
   static class TrieNode {

        TrieNode(){}
        final int TOTAL_ALPHABETS = 26;
        TrieNode[] children = new TrieNode[TOTAL_ALPHABETS];
        boolean isEnd = false;

        void addWord(String word) {
            TrieNode currentNode = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int charIndex = c - 'a';
                if (currentNode.children[charIndex] == null) {
                    currentNode.children[charIndex] = new TrieNode();
                }

                currentNode = currentNode.children[charIndex];
            }
            currentNode.isEnd = true;

        }

        boolean isPrefixPresent(String word) {
            TrieNode currentNode = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int charIndex = c - 'a';
                if (currentNode.children[charIndex] != null) {
                    currentNode = currentNode.children[charIndex];
                } else {
                    return false;
                }
            }
            return true;
        }

        void completeWordPrefix(String word) {
            TrieNode currentNode = this;
            String prefix = "";
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int charIndex = c - 'a';
                if (currentNode.children[charIndex] != null) {
                    currentNode = currentNode.children[charIndex];
                    prefix += c;
                } else {
                    return;
                }
            }

            for (TrieNode node : currentNode.children) {
            }
            // Now prefix is present. We have to show them all words with this prefix
            System.out.println("\nSuggestion for word " + word + " as below ---- ");
            for (int i = 0; i < currentNode.children.length; i++) {
                if (currentNode.children[i] != null) {
                    printDFS(currentNode.children[i], prefix + (char) (i + 'a'));
                }
            }

        }

        void printDFS(TrieNode node, String prefix) {
            if (node.isEnd) {
                System.out.println(" " + prefix);
            } else {
                for (int i = 0; i < node.children.length; i++) {
                    if (node.children[i] != null)
                        printDFS(node.children[i], prefix + (char) (i + 'a'));
                }
            }
        }

    }
}
