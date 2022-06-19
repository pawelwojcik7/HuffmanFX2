package com.example.huffman;




import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// A Tree node
class Huffman_Node
{
    Character charac;
    Integer frequency;
    Huffman_Node left = null, right = null;

    int x,y, level, index;

    Huffman_Node(Character charac, Integer frequency)
    {
        this.charac = charac;
        this.frequency = frequency;
    }

    public Huffman_Node(Character charac, Integer frequency, Huffman_Node left, Huffman_Node right)
    {
        this.charac = charac;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }
}
