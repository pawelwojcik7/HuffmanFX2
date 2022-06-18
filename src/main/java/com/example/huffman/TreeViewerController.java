package com.example.huffman;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class TreeViewerController implements Initializable {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private Pane pane;
    Huffman_Node node;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    void initData(Huffman_Node huffman_node) {
        node = huffman_node;
        drawNodeRecursive(800, 25, 400, node);
    }

    public void drawNodeRecursive(int x, int y,int z, Huffman_Node node) { // rysowanie drzewka

        if (node.charac != null) { // jezeli node nie ma znaku to znaczy że jest wezłem sumy
            Circle circle = new Circle(x, y, 15, Paint.valueOf("blue")); // rysowanie niebieskiego kółka x,y promien 15
            pane.getChildren().add(circle); // dodanie kółka do panelu, panel ma 600 szerokosci
        } else {
            Circle circle = new Circle(x, y, 15, Paint.valueOf("red"));
            pane.getChildren().add(circle);
        }
        if (node.charac != null) {
            String str = String.valueOf(node.charac) + " : " + String.valueOf(node.frequency);
            Text txt = new Text(x - 9, y + 3, str);
            pane.getChildren().add(txt);
        } else {
            int sum = node.left.frequency + node.right.frequency;
            Text txt = new Text(x - 3, y + 3, String.valueOf(sum));
            pane.getChildren().add(txt);
        }

        if (node.left != null){
            Line line = new Line(x-z, y + 30, x-10, y+10);
            pane.getChildren().add(line);
            drawNodeRecursive(x-z, y + 30,(int)Math.floor(z/2), node.left);}
        if (node.right != null) {
            Line line = new Line(x+z, y + 30, x+10, y+10);
            pane.getChildren().add(line);
            drawNodeRecursive(x+z, y + 30, (int)Math.floor(z/2), node.right);
        }
    }
}
