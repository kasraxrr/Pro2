package view;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import viewmodel.AuctionItemViewModel;


public class AuctionItemViewController {
    @FXML private Label itemLabel;
    @FXML private Label timeLabel;
    @FXML private Label currentBidTitle;
    @FXML private Label currentBidLabel;
    @FXML private Label currentBidderLabel;
    @FXML private TextField bidField;
    @FXML private Label errorLabel;
    private Region root;
    private ViewHandler viewHandler;
    private AuctionItemViewModel viewModel;
    @FXML private Button bidButton;

    public AuctionItemViewController(){

    }
    public void init(ViewHandler viewHandler,AuctionItemViewModel viewModel,Region root){
        this.viewHandler=viewHandler;
        this.viewModel=viewModel;
        this.root=root;

        itemLabel.textProperty().bind(viewModel.getItemProperty());
        timeLabel.textProperty().bind(viewModel.getTimeProperty());
        currentBidTitle.textProperty().bind(viewModel.getCurrentBidTitleProperty());
        Bindings.bindBidirectional(currentBidLabel.textProperty(),viewModel.getCurrentBidProperty(),new StringIntegerConverter(0));
        currentBidderLabel.textProperty().bindBidirectional(viewModel.getCurrentBidderProperty());
        Bindings.bindBidirectional(bidField.textProperty(),viewModel.getBidProperty(),new StringIntegerConverter(0));
        errorLabel.textProperty().bind(viewModel.getErrorProperty());

        viewModel.getEndProperty()
                .addListener((obs, oldValue, newValue) -> {
                    if (newValue)
                    {
                        timeLabel.setStyle("-fx-background-color: RED");
                        bidField.setDisable(true);
                        bidButton.setDisable(true);
                    }
                    else
                    {
                        timeLabel.setStyle("");
                        bidField.setDisable(false);
                        bidButton.setDisable(false);
                    }
                });
    }
    public void reset(){
        viewModel.clear();
    }

    public Region getRoot() {
        return root;
    }

    public void bidOnAction() {
        viewModel.bid();
    }
}
