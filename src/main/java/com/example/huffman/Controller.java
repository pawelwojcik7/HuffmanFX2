package com.example.huffman;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import static com.example.huffman.Huffman.Main_Build_HuffmanTree;


public class Controller {
    String[] columns = {"id", "char", "weight", "probability", "code"};
    String[][] data ;
    String word;
    @FXML
    private TextArea textArea1;
    @FXML
    private TextArea textArea2;
    public void huffmanMethod(ActionEvent e)
    {
        System.out.println("tu jestem");
        word = textArea1.getText();
        System.out.println(word+ " slowo");
        TextManipulator tm = new TextManipulator(word);

        Main_Build_HuffmanTree(word);


        //System.out.println(encodedText);

        //huffman.printCodes();

        //String originalText = huffman.decode(encodedText);
        //System.out.println(originalText);
        //data = huffman.tm.tab;
        //table = new JTable(data, columns);


    }
    public void FGK(ActionEvent e)
    {

    }
    public void Vitter(ActionEvent e)
    {

    }
    public void Drzewo(ActionEvent e)
    {

    }
}