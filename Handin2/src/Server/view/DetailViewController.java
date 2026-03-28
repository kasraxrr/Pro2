package Server.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import Server.viewmodel.DetailViewModel;

public class DetailViewController {

    @FXML private TextField titleField;
    @FXML private TextField artistField;
    @FXML private TextField yearField;
    @FXML private TextField reservedBy;
    @FXML private TextField loanedBy;
    @FXML private Label state;
    @FXML private Label errorLabel;
    @FXML private Button submitButton;
    @FXML private Button cancelButton;
    private Region root;
    private ViewHandler viewHandler;
    private DetailViewModel detailViewModel;

    public void init(ViewHandler viewHandler,
                     DetailViewModel detailViewModel, Region root)
    {
        this.viewHandler = viewHandler;
        this.detailViewModel = detailViewModel;
        this.root = root;

        state.textProperty().bind(detailViewModel.getStateProperty());
        errorLabel.textProperty().bind(detailViewModel.getErrorProperty());
        reservedBy.textProperty().bindBidirectional(detailViewModel.getReserverNameProperty());
        loanedBy.textProperty().bindBidirectional(detailViewModel.getLoanerNameProperty());
        titleField.textProperty().bindBidirectional(detailViewModel.getTitleFieldProperty());
        artistField.textProperty().bindBidirectional(detailViewModel.getArtistFieldProperty());
        yearField.textProperty().bindBidirectional(
                detailViewModel.getYearFieldProperty(),
                new utility.StringConverter()
        );

        detailViewModel.getAddingProperty().addListener((obs, oldValue, newValue) -> {
            titleField.setDisable(!newValue);
            artistField.setDisable(!newValue);
            yearField.setDisable(!newValue);
            submitButton.setDisable(!newValue);
            reservedBy.setDisable(!newValue);
            loanedBy.setDisable(!newValue);
        });
    }

    public void reset()
    {
        detailViewModel.reset();
    }

    public Region getRoot()
    {
        return root;
    }

    @FXML private void submitButtonPressed()
    {
        boolean check = detailViewModel.submit();
        if (check)
        {
            viewHandler.openView("list");
        }
    }

    @FXML private void cancelButtonPressed()
    {
        viewHandler.openView("list");
    }




















}
