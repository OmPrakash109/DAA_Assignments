import java.util.*;
class HNode implements Comparable<HNode> {
    char character;
    int freq;
    HNode left, right;

    public HNode(char character, int freq) {
        this.character = character;
        this.freq = freq;
        this.left = null;
        this.right = null;
    }
    public int compareTo(HNode oth) {
        return this.freq - oth.freq;
    }
}
public class Huffman_Coding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of characters: ");
        int n = sc.nextInt();
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter character " + (i + 1) + ": ");
            char c = sc.next().charAt(0);
            System.out.print("Enter frequency for " + c + ": ");
            int freq = sc.nextInt();
            freqMap.put(c, freq);
        }
        
        PriorityQueue<HNode> minHeap = new PriorityQueue<>();
        for (char c : freqMap.keySet()) {
            minHeap.offer(new HNode(c, freqMap.get(c)));
        }
        while (minHeap.size() > 1) {
            HNode leftChild = minHeap.poll();
            HNode rightChild = minHeap.poll();
            HNode internalNode = new HNode('\0', leftChild.freq + rightChild.freq);
            internalNode.left = leftChild;
            internalNode.right = rightChild;
            minHeap.offer(internalNode);
        }
        HNode root = minHeap.poll();
        HashMap<Character, String> huffmanCodes = new HashMap<>();
        generateHuffmanCodes(root, "", huffmanCodes);
        System.out.println("\nHuffman Codes for the input characters are :");
        for (char c : huffmanCodes.keySet()) {
            System.out.println(c + ": " + huffmanCodes.get(c));
        }
        System.out.print("\nEnter the encoded text: ");
        String encodedText = sc.next();
        String decodedText = decode(encodedText, root);
        System.out.println("Decoded Text: " + decodedText);
    }
    private static void generateHuffmanCodes(HNode node, String code, HashMap<Character, String> huffmanCodes) {
        if (node == null) {
            return;
        }
        if (node.character != '\0') {
            huffmanCodes.put(node.character, code);
        }
        generateHuffmanCodes(node.left, code + "0", huffmanCodes);
        generateHuffmanCodes(node.right, code + "1", huffmanCodes);
    }
    private static String decode(String encoded, HNode root) {
        StringBuilder decoded = new StringBuilder();
        HNode crnt = root;
        for (char bit : encoded.toCharArray()) {
            if (bit == '0') {
                crnt = crnt.left;
            } else {
                crnt = crnt.right;
            }
            if (crnt.character != '\0') {
                decoded.append(crnt.character);
                crnt = root;
            }
        }
        return decoded.toString();
    }
}
