package com.example.huffman;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class TreeViewerController {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private Pane pane;
    Huffman_Node node;
    ArrayList<Integer> list2;
    ArrayList<Integer> list = new ArrayList<Integer>();

    void initData(Huffman_Node huffman_node) {
        node = huffman_node;
        inittt(0);
        System.out.println(list2);
        drawNodes(node, 80, 0);
        drawLines(node);

    }

    void inittt(int i) {
        Huffman_Node node1 = node;
        list2 = new ArrayList<Integer>();
        list2.add(1);
        i = i + 1;
        if (node1.left != null) initList2(i, node1.left);
        if (node1.right != null) initList2(i, node1.right);
    }

    void initList2(int i, Huffman_Node node1) {
        if (list2.size() <= i) list2.add(1);
        else {
            list2.set(i, list2.get(i) + 1);
        }

        if (node1.left != null) {
            initList2(i + 1, node1.left);
        }
        if (node1.right != null) {
            initList2(i + 1, node1.right);
        }
    }


    public void drawNodes(Huffman_Node root, int y, int i) {

        if (list.size() == i) list.add(1);
        else {
            list.set(i, list.get(i) + 1);
        }
        int x = (int) Math.floor(1600 / (list2.get(i) + 1)) * list.get(i);
        root.x = x;
        root.y = y;
        if (root.charac != null) {
            Circle circle = new Circle(x, y, 25, Paint.valueOf("#EC7063"));
            pane.getChildren().add(circle);
            String str = String.valueOf(root.charac) + " : " + String.valueOf(root.frequency);
            Text txt = new Text(x - 9, y + 3, str);
            pane.getChildren().add(txt);
        } else {
            Circle circle = new Circle(x, y, 25, Paint.valueOf("#5DADE2"));
            pane.getChildren().add(circle);
            int sum = root.left.frequency + root.right.frequency;
            Text txt = new Text(x - 3, y + 3, String.valueOf(sum));
            pane.getChildren().add(txt);
        }

        if (root.left != null) {
            int x2 = (int) Math.floor(1600 / (list2.get(i + 1) + 1));
            drawNodes(root.left, y + 90, i + 1);
        }
        if (root.right != null) {
            int x2 = (int) Math.floor(1600 / (list2.get(i + 1) + 1));@(3TFR4)
            drawNodes(root.right, y + 90, i + 1);
        }

    }

    public void drawLines(Huffman_Node root) {
        if (root.left != null) {
            Line line = new Line(root.x - 15, root.y + 20, root.left.x, root.left.y - 25);
            pane.getChildren().add(line);
            drawLines(root.left);
        }
        if (root.right != null) {
            Line line = new Line(root.x + 15, root.y + 20, root.right.x - 15, root.right.y - 20);
            pane.getChildren().add(line);
            drawLines(root.right);

        }
    }
}
