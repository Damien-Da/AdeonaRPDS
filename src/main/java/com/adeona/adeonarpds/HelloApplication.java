package com.adeona.adeonarpds;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private Stage mainStage;
    private BorderPane rootLayout;
    private Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        /*FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("rootLayout.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 1000);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();*/
        this.mainStage = stage;
        this.mainStage.setResizable(false);
        initRootLayout();
        //displayResearchMenu();
        //displayTripPage(1);
        //displayTripComposition(0);
        displayHostProfile(0);
        displayTripCreationPage();
    }

    public void initRootLayout()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloApplication.class.getResource("rootLayout.fxml"));

            rootLayout = (BorderPane) loader.load();

            scene = new Scene(rootLayout);
            mainStage.setScene(scene);
            mainStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void displayResearchMenu()
    {
        try {
            //charger le fichier fxml associé
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloApplication.class.getResource("")); //on charge la vue souhaitée
            AnchorPane menuOverview = (AnchorPane) loader.load();


            this.mainStage.setTitle("Adeonas - Menu"); //on choisi le titre de la fenêtre

            //on charge le controlleur associé a la vue
            //MenuController controller = loader.getController();
            //controller.setMainApp(this);

            //on met la vue au centre de la scene

            rootLayout.setCenter(menuOverview);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayTripPage(int tripID) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloApplication.class.getResource("stay-details.fxml"));
            ScrollPane stayView = (ScrollPane) loader.load();

            TripDetailsController controller = loader.getController();
            controller.setMainApp(this, tripID);

            mainStage.setWidth(1000);
            mainStage.setHeight(900);
            rootLayout.setCenter(stayView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayTripCreationPage()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("composition.fxml"));
            AnchorPane view = loader.load();

            CompositionController controller = loader.getController();
            controller.setMainApp(this);

            mainStage.setWidth(600);
            mainStage.setHeight(645);
            rootLayout.setCenter(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void displayHostProfile(int userID)
    {
        try
        {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("profilPage-view.fxml"));
        AnchorPane view = loader.load();

        ProfilPageController controller = loader.getController();
        controller.setMainApp(this);
        controller.loadUserData(userID);

        mainStage.setWidth(1000);
        mainStage.setHeight(681);
        rootLayout.setCenter(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayHostProfileEdit(int userID)
    {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("profilEditPage-view.fxml"));
            AnchorPane view = loader.load();

            ProfilEditPageController controller = loader.getController();
            controller.loadUserData(userID);
            controller.setMainApp(this);

            mainStage.setWidth(1000);
            mainStage.setHeight(681);
            rootLayout.setCenter(view);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayHostReservation(int hostID)
    {

    }

    public void displayTripComposition(int userID)
    {
        try
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloApplication.class.getResource("tripCompositionPage-view.fxml"));
            AnchorPane stayView = (AnchorPane) loader.load();

            TripCompositionController controller = loader.getController();
            controller.setMainApp(this, userID);

            mainStage.setWidth(1000);
            mainStage.setHeight(800);
            rootLayout.setCenter(stayView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setTitle(String title)
    {
        this.mainStage.setTitle(title);
    }

    public static void main(String[] args) {
        launch();
    }
}