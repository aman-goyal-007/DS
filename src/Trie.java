
// this is case sensitive. We can make it case insensitive by converting word into same case before adding/searching
public class Trie {
    public static void main(String[] args) {
        TrieNode root = new TrieNode();
        System.out.print("Staring Trie!");
        root.addWord("their");
        root.addWord("there");
        root.addWord("answer");
        root.addWord("any");
        root.addWord("bye");
        System.out.print("\nChecking prefix!");
        root.isPrefixPresent("an");
        root.completeWordPrefix("ans");
    }
}

class TrieNode {
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

    void isPrefixPresent(String word) {
        TrieNode currentNode = this;
        System.out.print("\n " + word);
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int charIndex = c - 'a';
            if (currentNode.children[charIndex] != null) {
                currentNode = currentNode.children[charIndex];
            } else {
                System.out.print(" is not present");
                return;
            }
        }
        System.out.println(" is present");
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



