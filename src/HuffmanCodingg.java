//import java.util.*;
//
//class HuffmanNode implements Comparable<HuffmanNode> {
//    char character;
//    int frequency;
//    HuffmanNode left, right;
//
//    public HuffmanNode(char character, int frequency) {
//        this.character = character;
//        this.frequency = frequency;
//        left = null;
//        right = null;
//    }
//
//    @Override
//    public int compareTo(HuffmanNode otherNode) {
//        return this.frequency - otherNode.frequency;
//    }
//}
//
//public class HuffmanCoding {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter the number of characters: ");
//        int numCharacters = scanner.nextInt();
//        scanner.nextLine(); // Consume newline
//
//        HashMap<Character, Integer> frequencyMap = new HashMap<>();
//        for (int i = 0; i < numCharacters; i++) {
//            System.out.print("Enter character " + (i + 1) + ": ");
//            char character = scanner.next().charAt(0);
//            System.out.print("Enter frequency for character " + character + ": ");
//            int frequency = scanner.nextInt();
//            frequencyMap.put(character, frequency);
//        }
//
//        HuffmanNode root = buildHuffmanTree(frequencyMap);
//        HashMap<Character, String> huffmanCodes = generateHuffmanCodes(root);
//
//        System.out.println("Huffman Codes:");
//        for (char c : huffmanCodes.keySet()) {
//            System.out.println(c + ": " + huffmanCodes.get(c));
//        }
//
//        System.out.print("\nEnter a code to decode: ");
//        String codeToDecode = scanner.next();
//        String decodedText = decodeHuffmanCode(root, codeToDecode);
//        System.out.println("Decoded text: " + decodedText);
//
//        scanner.close();
//    }
//
//    private static HashMap<Character, String> generateHuffmanCodes(HuffmanNode root) {
//        HashMap<Character, String> huffmanCodes = new HashMap<>();
//        generateCodes(root, "", huffmanCodes);
//        return huffmanCodes;
//    }
//
//    private static void generateCodes(HuffmanNode node, String code, HashMap<Character, String> huffmanCodes) {
//        if (node == null) return;
//        if (node.character != '\0') {
//            huffmanCodes.put(node.character, code);
//        }
//        generateCodes(node.left, code + "0", huffmanCodes);
//        generateCodes(node.right, code + "1", huffmanCodes);
//    }
//
//    private static HuffmanNode buildHuffmanTree(HashMap<Character, Integer> frequencyMap) {
//        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();
//        for (char c : frequencyMap.keySet()) {
//            pq.offer(new HuffmanNode(c, frequencyMap.get(c)));
//        }
//
//        while (pq.size() > 1) {
//            HuffmanNode left = pq.poll();
//            HuffmanNode right = pq.poll();
//            HuffmanNode newNode = new HuffmanNode('\0', left.frequency + right.frequency);
//            newNode.left = left;
//            newNode.right = right;
//            pq.offer(newNode);
//        }
//        return pq.poll();
//    }
//
//    private static String decodeHuffmanCode(HuffmanNode root, String code) {
//        StringBuilder decodedText = new StringBuilder();
//        HuffmanNode current = root;
//        for (char bit : code.toCharArray()) {
//            if (bit == '0') {
//                current = current.left;
//            } else if (bit == '1') {
//                current = current.right;
//            }
//
//            if (current.character != '\0') {
//                decodedText.append(current.character);
//                current = root; // Reset to root for next character
//            }
//        }
//        return decodedText.toString();
//    }
//}