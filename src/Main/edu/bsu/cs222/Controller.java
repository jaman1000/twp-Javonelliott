package Main.edu.bsu.cs222;

import java.io.FileInputStream;

import java.io.IOException;

import java.util.List;


import javafx.application.Application;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;

import javafx.scene.control.*;

import javafx.scene.layout.Pane;

import javafx.stage.Stage;


public class Controller {





    @FXML

    public TextArea outputText;

    @FXML

    private TextField inputText;

    @FXML

    private Revision revisions;

    @FXML

    private List editors;

    @FXML

    private Scene scene;

    @FXML

    private Stage window;



    private Main main;



    public void setMain(Main main) {

        this.main=main;

    }





    public void main(String[] args)

    {

        Application.launch(args);

    }

// launches visual interface

    public void start(Stage stage) throws IOException {

        window = stage;

        FXMLLoader loader = new FXMLLoader();

        String fxmlGUI = "GUI.fxml";

        FileInputStream fxmlStream = new FileInputStream(fxmlGUI);

        Pane root = loader.load(fxmlStream);

        scene = new Scene(root);

        window.setScene(scene);

        window.setTitle("Ja'von Elliott twp");

        window.show();



    }





    @FXML

    public void createRevisionList(ActionEvent actionEvent) throws IOException {

        this.revisions = new Revision(inputText.getText());

        String output = revisions.toString();

        printOutput(output);

    }



    @FXML

    public void printOutput(String output){

        outputText.setText(output);

    }



    @FXML

    public void sortByNumberOfEdits(ActionEvent actionEvent){

        this.editors = new editors (inputText.getText());

        String output = editors.toString();

        outputText.setText("");

        printOutput(output);

    }



    public void clearAllText(ActionEvent actionEvent) {

        inputText.setText("");

        outputText.setText("");

    }


}
// sourced from lauren ravenell
// added comments
// changed "contributors" variables.
// fixed compiling errors: