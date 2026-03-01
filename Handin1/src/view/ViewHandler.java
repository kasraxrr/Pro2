package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import viewmodel.ViewModelFactory;

public class ViewHandler
{
    private Scene currentScene;
    private Stage primaryStage;
    private ViewModelFactory viewModelFactory;
    private DetailViewController detailViewController;
    private MainViewController mainViewController;

    public ViewHandler(ViewModelFactory viewModelFactory)
    {
        this.viewModelFactory = viewModelFactory;
        currentScene = new Scene(new Region());
    }

    public void start(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        openView("list");
    }

    public void openView(String id)
    {
        Region root = null;
        switch (id)
        {
            case "list":
                root = loadMainView("MainView.fxml");
                break;
            case "detail":
                root = loadDetailView("DetailView.fxml");
                break;
        }
        currentScene.setRoot(root);
        String title = "";
        if (root.getUserData() != null)
        {
            title += root.getUserData();
        }
        primaryStage.setTitle(title);
        primaryStage.setScene(currentScene);
        primaryStage.setWidth(root.getPrefWidth());
        primaryStage.setHeight(root.getPrefHeight());
        primaryStage.show();
    }

    public void closeView()
    {
        primaryStage.close();
    }

    private Region loadMainView(String fxmlFile)
    {
        if (mainViewController == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                mainViewController = loader.getController();
                mainViewController
                        .init(this, viewModelFactory.getListMainViewModel(), root);
                mainViewController.reset();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            mainViewController.reset();
        }
        return mainViewController.getRoot();
    }

    private Region loadDetailView(String fxmlFile)
    {
        if (detailViewController == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                detailViewController = loader.getController();
                detailViewController
                        .init(this, viewModelFactory.getDetailViewModel(), root);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            detailViewController.reset();
        }
        return detailViewController.getRoot();
    }
}