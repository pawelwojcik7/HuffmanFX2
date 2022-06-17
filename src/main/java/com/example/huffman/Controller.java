package com.example.huffman;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableView tableView=new TableView<Data>();
     public void huffmanMethod(ActionEvent e)
    {
        System.out.println("tu jestem");
        word = textArea1.getText();
        System.out.println(word+ " slowo");
        TextManipulator tm = new TextManipulator(word);
        Main_Build_HuffmanTree(tm);
        data = tm.tab;
        Data[] wiersze = new Data[tm.uniqueList.size()];
        tableView=new TableView<Data>();
        TableColumn column1 = new TableColumn<Data, String>("Id");
        column1.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn column2 = new TableColumn<Data, String>("Character");
        column2.setCellValueFactory(new PropertyValueFactory<>("character"));
        TableColumn column3 = new TableColumn<Data, String>("Weight");
        column3.setCellValueFactory(new PropertyValueFactory<>("weight"));
        TableColumn column4 = new TableColumn<Data, String>("Probability");
        column4.setCellValueFactory(new PropertyValueFactory<>("probability"));
        TableColumn column5 = new TableColumn<Data, String>("Code");
        column5.setCellValueFactory(new PropertyValueFactory<>("code"));

        tableView.getColumns().add("column1");
        tableView.getColumns().add("column2");
        tableView.getColumns().add("column3");
        tableView.getColumns().add("column4");
        tableView.getColumns().add("column5");
        //for(int i=0;i<tm.uniqueList.size();i++)
        //{
        //    wiersze[i]=new Data(data[i][0],data[i][1],data[i][2],data[i][3],data[i][4]);
       //     tableView.getItems().add(wiersze[i]);
      //  }

        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

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