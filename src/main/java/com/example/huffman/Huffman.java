package com.example.huffman;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Huffman {

    public static void encode_huffman(Huffman_Node root_node, String str,
                                      Map<Character, String> huffman_Code) {
        if (root_node == null) {
            return;
        }

        // if the root node is a leaf node
        if (is_Leaf(root_node)) {
            huffman_Code.put(root_node.charac, str.length() > 0 ? str : "1");
        }

        encode_huffman(root_node.left, str + '0', huffman_Code);
        encode_huffman(root_node.right, str + '1', huffman_Code);
    }


    public static int decode_huffman(Huffman_Node root_node, int index, StringBuilder sb) {
        if (root_node == null) {
            return index;
        }

        // if the root node is a leaf node
        if (is_Leaf(root_node)) {
            System.out.print(root_node.charac);
            return index;
        }

        index++;

        root_node = (sb.charAt(index) == '0') ? root_node.left : root_node.right;
        index = decode_huffman(root_node, index, sb);
        return index;
    }


    public static boolean is_Leaf(Huffman_Node root_node) {
        return root_node.left == null && root_node.right == null;
    }

    // Main Huffman tree build function
    public static Huffman_Node Main_Build_HuffmanTree(TextManipulator tm) {
        String text = tm.slowo;
        // Base case: empty string
        if (text == null || text.length() == 0) {
            return null;
        }


        Map<Character, Integer> frequency = new HashMap<>();
        for (char c : text.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }


        SortByValue sort = new SortByValue();

        PriorityQueue<Huffman_Node> prio_queue;
        prio_queue = new PriorityQueue<>(Comparator.comparingInt(l -> l.frequency));


        for (var entry : frequency.entrySet()) {
            prio_queue.add(new Huffman_Node(entry.getKey(), entry.getValue()));
        }


        while (prio_queue.size() != 1) {


            Huffman_Node left = prio_queue.poll();
            Huffman_Node right = prio_queue.poll();


            int sum = left.frequency + right.frequency;
            prio_queue.add(new Huffman_Node(null, sum, left, right));
        }

        Huffman_Node root_node = prio_queue.peek();
        Map<Character, String> huffmanCode = new HashMap<>();
        encode_huffman(root_node, "", huffmanCode);


        System.out.println("The Huffman Codes for the given text are: " + huffmanCode);
        System.out.println("The original text is: " + text);
        huffmanCode.forEach((c, s) -> {
            for (int i = 0; i < tm.uniqueList.size(); i++) {
                if (tm.uniqueList.get(i).equals(c)) tm.tab[i][4] = s;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            sb.append(huffmanCode.get(c));
        }

        System.out.println("The encoded text is: " + sb);
        tm.encoded = sb.toString();
        System.out.print("The decoded text is: ");

        if (is_Leaf(root_node)) {
            // For input like a, aa, aaa, etc.
            while (root_node.frequency-- > 0) {
                System.out.print(root_node.charac);
            }
        } else {
            int index = -1;
            while (index < sb.length() - 1) {
                index = decode_huffman(root_node, index, sb);
            }
        }
        levelAndIndexSet(root_node, 1, 1);
        return root_node;
    }

    public static void levelAndIndexSet(Huffman_Node node, int level, int index) {
        node.level = level;
        node.index = index;
        if (node.left != null) levelAndIndexSet(node.left, level + 1, index * 2 - 1);
        if (node.right != null) levelAndIndexSet(node.right, level + 1, index * 2);
    }

}