package org.example.CollectMoneyBox;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CollectMoneyStagePaneImageView {
    public ImageView imageView = new ImageView();
    public void CollectMoneyStagePaneImageViewController(){
        Image image1 = new Image(CollectMoneyStagePaneImageView.class.getClassLoader().getResourceAsStream("md5.png"));
        imageView.setFitWidth(400);
        imageView.setFitHeight(500);
        imageView.setImage(image1);
    }
}
