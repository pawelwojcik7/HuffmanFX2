package com.example.huffman;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    @FXML
    private TableView tableView;
     public void huffmanMethod(ActionEvent e)
    {
        System.out.println("tu jestem");
        word = textArea1.getText();
        System.out.println(word+ " slowo");
        TextManipulator tm = new TextManipulator(word);
        Main_Build_HuffmanTree(tm);
        data = tm.tab;
        tableView=new TableView<>();
        TableColumn
        tableView.getColumns().add("id");
        tableView.getColumns().add("char");
        tableView.getColumns().add("weight");
        tableView.getColumns().add("probability");
        tableView.getColumns().add("code");
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