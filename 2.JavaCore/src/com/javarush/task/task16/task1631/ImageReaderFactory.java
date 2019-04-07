package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes it){
        ImageReader ir = null;
        if(it==ImageTypes.BMP){
            ir = new BmpReader();
        } else if (it == ImageTypes.JPG){
            ir = new JpgReader();
        } else if (it == ImageTypes.PNG){
            ir = new PngReader();
        } else {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
        return ir;
    }
}
