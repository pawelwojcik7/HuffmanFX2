package com.example.huffman;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class TreeViewer {
    public TreeViewer(Huffman_Node root) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("treeviewer-view.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("TreeViewer");
            stage.setScene(new Scene(root1, 1600, 900));
            stage.setResizable(false);
            TreeViewerController controller = fxmlLoader.getController();
            controller.initData(root);
            stage.show();
        } catch (IOException e) {


        }
    }


}
