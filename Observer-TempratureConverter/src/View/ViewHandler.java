package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.TemperatureModel;

public class ViewHandler {

    private Stage primaryStage;
    private Scene currentScene;
    private TemperatureViewController temperatureViewController;
    private TemperatureModel temperatureModel;

    public ViewHandler(TemperatureModel model)
    {
        this.temperatureModel = model;
        this.currentScene = new Scene(new Region());
    }

    public void start(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        openView("TemperatureView");
    }

    public void openView(String id)
    {
        Region root = null;
        switch (id)
        {
            case "TemperatureView":
                root = loadTemperatureView(id +".fxml");
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

    public Region loadTemperatureView(String fxmlFile)
    {
        if (temperatureViewController == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();

                temperatureViewController = loader.getController();
                temperatureViewController.init(this, temperatureModel, root);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            temperatureViewController.reset();
        }
        return temperatureViewController.getRoot();
    }

}
