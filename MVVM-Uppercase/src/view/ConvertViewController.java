package view;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.util.StringConverter;
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



        Bindings.bindBidirectional(requestField.textProperty(), viewModel.requestProperty(), new StringConverter<Number>() {
            @Override
            public String toString(Number object) {
                return object.toString();
            }

            @Override
            public int fromString(String s) {
                return Integer.parseInt(s);
            }
        });
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
