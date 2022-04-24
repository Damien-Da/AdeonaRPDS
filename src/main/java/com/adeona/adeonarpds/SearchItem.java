package com.adeona.adeonarpds;

import eu.hansolo.tilesfx.Tile;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchItem implements Initializable {

    Class<?> clazz = this.getClass();

    InputStream imageItem;


    String titleItem;
    String locationItem;
    String hostItem;

    @FXML
    private Label title = null;

    @FXML
    private Label location = null;

    @FXML
    private Label host = null;

    @FXML
    private Image image = null;

    @FXML
    private ImageView urlProfile = null;

    public SearchItem(String title, String location, String host, String img) {
        this.titleItem = title;
        this.locationItem = location;
        this.hostItem = host;
        this.imageItem = clazz.getResourceAsStream(img);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.title.setText(this.titleItem);
        this.location.setText(this.locationItem);
        this.host.setText(this.hostItem);
        this.image = new Image(this.imageItem);
        this.urlProfile.setImage(this.image);
    }
}