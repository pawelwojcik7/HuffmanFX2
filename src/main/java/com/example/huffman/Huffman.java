package com.example.huffman;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Huffman {
    // Huffman Tree Traversing and storing the Huffman Codes in a dictionary.
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

    // Huffman Tree Traversing and decoding the encoded string
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

    // This function checks if Huffman Tree contains only one single node
    public static boolean is_Leaf(Huffman_Node root_node) {
        return root_node.left == null && root_node.right == null;
    }

    // Main Huffman tree build function
    public static void Main_Build_HuffmanTree(TextManipulator tm) {
        String text = tm.slowo;
        // Base case: empty string
        if (text == null || text.length() == 0) {
            return;
        }

        // Calculate the frequency of each character and store it in a map of dict

        Map<Character, Integer> frequency = new HashMap<>();
        for (char c : text.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        // priority queue to store nodes of the Huffman tree
        // the highest priority item has the lowest frequency

        PriorityQueue<Huffman_Node> prio_queue;
        prio_queue = new PriorityQueue<>(Comparator.comparingInt(l -> l.frequency));

        // leaf node for each character, adding it to the priority queue.

        for (var entry : frequency.entrySet()) {
            prio_queue.add(new Huffman_Node(entry.getKey(), entry.getValue()));
        }

        //repeat the process till there is more than one node in the queue
        while (prio_queue.size() != 1) {
            // Then remove the two nodes with the highest priority and lowest frequency

            Huffman_Node left = prio_queue.poll();
            Huffman_Node right = prio_queue.poll();

            // Now create a new internal node with two children nodes, and the frequency will be the some of both nodes; add the new node to the priority queue.
            int sum = left.frequency + right.frequency;
            prio_queue.add(new Huffman_Node(null, sum, left, right));
        }

        Huffman_Node root_node = prio_queue.peek();

        // Huffman tree Traversing and storing the Huffman codes in a dict or map
        Map<Character, String> huffmanCode = new HashMap<>();
        encode_huffman(root_node, "", huffmanCode);

        // Display the Huffman codes
        System.out.println("The Huffman Codes for the given text are: " + huffmanCode);
        System.out.println("The original text is: " + text);
        huffmanCode.forEach((c,s)-> {
            for(int i=0;i<tm.uniqueList.size();i++)
            {
                if(tm.uniqueList.get(i).equals(c)) tm.tab[i][4]=s;
                System.out.println("przypisano "+ c+ " "+s);
            }
        });
        // display the encoded string
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            sb.append(huffmanCode.get(c));
        }

        System.out.println("The encoded text is: " + sb);
        tm.encoded=sb.toString();
        System.out.print("The decoded text is: ");

        if (is_Leaf(root_node)) {
            // For input like a, aa, aaa, etc.
            while (root_node.frequency-- > 0) {
                System.out.print(root_node.charac);
            }
        } else {
            // Huffman Tree traversing with decoding the encoded string
            int index = -1;
            while (index < sb.length() - 1) {
                index = decode_huffman(root_node, index, sb);
            }
        }
    }


}