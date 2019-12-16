package sample;

import javafx.scene.image.Image;

public class ImgInfoObject {
    String imgName;
    Image img;

    public ImgInfoObject(String imgName, Image img) {
        this.imgName = imgName;
        this.img = img;
    }

    public String getImgName() {
        return imgName;
    }

    public Image getImg() {
        return img;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public void setImg(Image img) {
        this.img = img;
    }
}
