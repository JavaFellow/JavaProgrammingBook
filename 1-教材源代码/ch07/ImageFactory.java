package ch07;

import javax.swing.ImageIcon;

public class ImageFactory {
    private static final String ROOT = "images/";
    private static final ClassLoader LOADER = ImageFactory.class.getClassLoader();

    // 根据图片文件名创建图片对象
    public static ImageIcon create(String file) {
        return new ImageIcon(LOADER.getResource(ROOT + file));
    }
}
