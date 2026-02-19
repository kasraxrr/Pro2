package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import viewmodel.ViewModelFactory;

public class ViewHandler {
    private Stage primaryStage;
    private Scene currentScene;
    private ConvertViewController convertViewController;
    private ViewModelFactory viewModelFactory;

    public ViewHandler(ViewModelFactory viewModelFactory){
        this.viewModelFactory=viewModelFactory;
        this.currentScene=new Scene(new Region());

    }

    public void start(Stage primaryStage){
        this.primaryStage=primaryStage;
        openView("ConvertView");
    }

    public void openView(String id){
        Region root=null;

        switch (id)
        {
            case "ConvertView":
                root = loadConvertView(id +".fxml");
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
    public Region loadConvertView(String fxmlFile){

        if (convertViewController==null){
            try {
                FXMLLoader loader=new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root=loader.load();
                convertViewController=loader.getController();
                convertViewController.init(this,viewModelFactory.getConvert(),root);
            }catch (Exception e){
                throw new RuntimeException();
            }
        }
        else
        {
            convertViewController.reset();
        }
        return convertViewController.getRoot();
    }


}
