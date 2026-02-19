package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import viewmodel.ConvertViewModel;

import java.awt.*;

public class ConvertViewController {
    @FXML private TextField requestField;
    @FXML private TextField replyField;
    @FXML private Label errorLabel ;
    private Region root;
    private ViewHandler viewHandler;
    private ConvertViewModel viewModel;

    public void init(ViewHandler viewHandler,ConvertViewModel viewModel,Region root){
        this.viewHandler=viewHandler;
        this.viewModel=viewModel;
        this.root=root;


        requestField.textProperty().bindBidirectional(viewModel.requestProperty());
        replyField.textProperty().bind(viewModel.replyProperty());
        errorLabel.textProperty().bind(viewModel.errorProperty());
    }
    public void reset(){
        requestField.setText("");
        replyField.setText("");
        errorLabel.setText("");
    }

    public Region getRoot() {
        return root;
    }
    @FXML public void onSubmit(){
        this.viewModel.covert();
    }

   @FXML public void onEnter(ActionEvent event) {
        if (event.getSource()==requestField){
            onSubmit();
        }
    }
}
