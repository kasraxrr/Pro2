package view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import viewmodel.MainViewModel;
import viewmodel.SimpleLPViewModel;

public class MainViewController {
    @FXML private TableView<SimpleLPViewModel> table;
    @FXML private TableColumn<SimpleLPViewModel, String> titleColumn;
    @FXML private TableColumn<SimpleLPViewModel, String> artistColumn;
    @FXML private TableColumn<SimpleLPViewModel, String> yearColumn;
    @FXML private TableColumn<SimpleLPViewModel, String> stateColumn;
    @FXML private TableColumn<SimpleLPViewModel, String> LoanedByColumn;
    @FXML private TableColumn<SimpleLPViewModel, String> ReservedByColumn;
    @FXML private TableColumn<SimpleLPViewModel, Boolean> flaggedColumn;
    @FXML private Label errorLabel;
    @FXML private Button addButton;
    @FXML private Button removeButton;
    @FXML private Button loanButton;
    @FXML private Button reserveButton;
    @FXML private Button cancelButton;
    @FXML private Button returnButton;
    private Region root;
    private ViewHandler viewHandler;
    private MainViewModel mainViewModel;

    public void init(ViewHandler viewHandler,
                     MainViewModel mainViewModel, Region root)
    {
        this.viewHandler = viewHandler;
        this.mainViewModel = mainViewModel;
        this.root = root;

        errorLabel.textProperty().bind(mainViewModel.getErrorProperty());

        titleColumn.setCellValueFactory(
                cellData -> cellData.getValue().getTitleProperty());
        artistColumn.setCellValueFactory(
                cellData -> cellData.getValue().getArtistProperty());
        ReservedByColumn.setCellValueFactory(
                cellData -> cellData.getValue().getReservedByProperty());
        LoanedByColumn.setCellValueFactory(
                cellData -> cellData.getValue().getLoanedToProperty());

        yearColumn.setCellValueFactory(
                cellData -> cellData.getValue().getYearProperty().asObject().asString()
        );

        stateColumn.setCellValueFactory(
                cellData -> cellData.getValue().getStateProperty());
        flaggedColumn.setCellValueFactory(
                cellData -> cellData.getValue().getFlaggedProperty());

        removeButton.setDisable(true);
        loanButton.setDisable(true);
        reserveButton.setDisable(true);
        cancelButton.setDisable(true);
        returnButton.setDisable(true);

        table.setItems(mainViewModel.getAll());
        table.getSelectionModel().selectedItemProperty()
                .addListener((obs, oldSelection, newSelection) -> {
                    mainViewModel.setSelected(newSelection);

                    removeButton.setDisable(true);
                    loanButton.setDisable(true);
                    reserveButton.setDisable(true);
                    cancelButton.setDisable(true);
                    returnButton.setDisable(true);

                    if (newSelection == null)
                    {
                        addButton.setText("Add");
                    }
                    else
                    {
                        addButton.setText("Details");

                        removeButton.setDisable(false);
                        if(newSelection.getFlaggedProperty().get())
                        {
                            removeButton.setText("Unflag");
                        }else
                        {
                            removeButton.setText("Flag");
                        }

                        switch (newSelection.getStateProperty().get())
                        {
                            case "LoanedAndReserved":
                                cancelButton.setDisable(false);
                                returnButton.setDisable(false);
                                break;
                            case "Loaned":
                                reserveButton.setDisable(false);
                                returnButton.setDisable(false);
                                break;
                            case "Reserved":
                                loanButton.setDisable(false);
                                cancelButton.setDisable(false);
                                break;
                            case "Available":
                                removeButton.setText("Remove");
                                reserveButton.setDisable(false);
                                loanButton.setDisable(false);
                                break;
                        }
                    }
                });
    }

    public void reset()
    {
   mainViewModel.loadFromModel();
    }

    public Region getRoot()
    {
        return root;
    }

    @FXML private void addButtonPressed()
    {
        viewHandler.openView("detail");
    }

    @FXML private void removeButtonPressed()
    {
        mainViewModel.remove();
    }

    @FXML private void loanButtonPressed()
    {
        mainViewModel.loan();
    }
    @FXML private void reserveButtonPressed()
    {
        mainViewModel.reserve();
    }

    @FXML private void cancelButtonPressed()
    {
        mainViewModel.cancel();
    }

    @FXML private void returnButtonPressed()
    {
        mainViewModel.returnLP();
    }



















}

