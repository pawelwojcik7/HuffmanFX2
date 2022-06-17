package com.example.huffman;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.huffman.Huffman.Main_Build_HuffmanTree;


public class Controller implements Initializable {
    String[] columns = {"id", "char", "weight", "probability", "code"};
    String[][] data;
    String word;
    @FXML
    private TextArea textArea1;
    @FXML
    private TextArea textArea2;
    @FXML
    private TableView<Data> tableView;
    @FXML
    private TableColumn<Data, String> character;

    @FXML
    private TableColumn<Data, String> code;
    @FXML
    private TableColumn<Data, String> id;
    @FXML
    private TableColumn<Data, String> weight;
    @FXML
    private TableColumn<Data, String> probability;


    public void huffmanMethod(ActionEvent e) {
        System.out.println("tu jestem");
        word = textArea1.getText();
        System.out.println(word + " slowo");
        TextManipulator tm = new TextManipulator(word);
        Main_Build_HuffmanTree(tm);
        data = tm.tab;
        Data wiersz = new Data();
        ObservableList<Data> list = FXCollections.observableArrayList();
        for(int i = 0; i < tm.uniqueList.size(); i++) {
            wiersz = new Data(data[i][0], data[i][1], data[i][2], data[i][3], data[i][4]);
            list.add(wiersz);
        }
        tableView.setItems(list);



    }

    public void FGK(ActionEvent e) {

    }

    public void Vitter(ActionEvent e) {

    }

    public void Drzewo(ActionEvent e) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<Data, String>("id"));
        character.setCellValueFactory(new PropertyValueFactory<Data, String>("character"));
        weight.setCellValueFactory(new PropertyValueFactory<Data, String>("weight"));
        probability.setCellValueFactory(new PropertyValueFactory<Data, String>("probability"));
        code.setCellValueFactory(new PropertyValueFactory<Data, String>("code"));
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
}