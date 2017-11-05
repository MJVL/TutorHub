import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

//import org.opencv.core.*;
//import org.opencv.highgui.Highgui;
//import org.opencv.imgproc.*;

public class ImageProcessing {
    private ImageIcon imgquestion = new ImageIcon();

    public ImageProcessing(){
        imgquestion = new ImageIcon();
        //System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        
    }

    public ImageProcessing(ImageIcon imgquestion){
        this.imgquestion = imgquestion;
    }

    public ImageIcon getImgquestion(){
        return imgquestion;
    }

    public void setImgquestion(ImageIcon imgquestion) {
        this.imgquestion = imgquestion;
    }



    public String textquestion(){
        String txtquestion = "";

        return txtquestion;
    }
}