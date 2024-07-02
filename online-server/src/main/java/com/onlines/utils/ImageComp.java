package com.onlines.utils;

import com.onlines.controller.OnlinesSaleController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;

public class ImageComp {
    private static final Logger logger= LoggerFactory.getLogger(OnlinesSaleController.class);
    // 改变成二进制码
    public static String[][] getPX(String args) throws MalformedURLException {
        logger.info("getPX:" + args);
//        URL url = new URL(args);//a服务器取图片使用方法
        int[] rgb = new int[3];

        File file = new File(args);//1、使用本地图片调试
        BufferedImage bi = null;
        try {
//            bi = ImageIO.read(url);//服务器上获取图片使用方法和a一起使用
            bi = ImageIO.read(file);//本地调试使用方法和1一起使用
        } catch (Exception e) {
            e.printStackTrace();
        }

        int width = bi.getWidth();
        int height = bi.getHeight();
        int minx = bi.getMinX();
        int miny = bi.getMinY();
        //获取图片每个像素的rgb
        String[][] list = new String[width][height];
        for (int i = minx; i < width; i++) {
            for (int j = miny; j < height; j++) {
                int pixel = bi.getRGB(i, j);
                rgb[0] = (pixel & 0xff0000) >> 16;
                rgb[1] = (pixel & 0xff00) >> 8;
                rgb[2] = (pixel & 0xff);
                list[i][j] = rgb[0] + "," + rgb[1] + "," + rgb[2];

            }
        }
        return list;
    }

    /**
     * 分析图片相似度
     * @param imgPath1
     * @param imgPath2
     * @return
     * @throws MalformedURLException
     */
    public String compareImage(String imgPath1, String imgPath2) throws MalformedURLException {
        String[] images = {imgPath1, imgPath2};
        if (images.length == 0) {
            logger.info("Usage >java BMPLoader ImageFile.bmp");
            System.exit(0);
        }

        // 获取图片每个像素的rbg数组
        logger.info("list0");
        String[][] list1 = getPX(images[0]);
        logger.info("list1");
        String[][] list2 = getPX(images[1]);
        logger.info("list2");
        int xiangsi = 0;
        int busi = 0;
        int i = 0, j = 0;
        //遍历图片的宽和高，比较每个像素的rgb
        for (String[] strings : list1) {
            if ((i + 1) == list1.length) {
                continue;
            }
            for (int m = 0; m < strings.length; m++) {
                try {
                    String[] value1 = list1[i][j].toString().split(",");
                    String[] value2 = list2[i][j].toString().split(",");
                    int k = 0;
                    //比较每个像素的rbg
                    for (int n = 0; n < value2.length; n++) {
                        if (Math.abs(Integer.parseInt(value1[n]) - Integer.parseInt(value2[n])) < 5) {
                            xiangsi++;
                        } else {
                            busi++;
                        }
                    }
                } catch (RuntimeException e) {
                    continue;
                }
                j++;
            }
            i++;
        }

        String baifen = "";
        try {
            //获取相似度/(相似度+不相似) 的占比
            baifen = ((Double.parseDouble(xiangsi + "") / Double.parseDouble((busi + xiangsi) + "")) + "");
            baifen = baifen.substring(baifen.indexOf(".") + 1, baifen.indexOf(".") + 3);
        } catch (Exception e) {
            baifen = "0";
        }
        if (baifen.length() <= 0) {
            baifen = "0";
        }
        if (busi == 0) {
            baifen = "100";
        }

        logger.info("相似像素数量：" + xiangsi + " 不相似像素数量：" + busi + " 相似率：" + Integer.parseInt(baifen) + "%");
        logger.info(baifen);
        return baifen;

    }

    public static void main(String[] args) throws MalformedURLException {
//        new ImageComp().compareImage("https://lupic.cdn.bcebos.com/20220812/3087527850_14_600_429.jpg", "https://lupic.cdn.bcebos.com/20200412/3027404477_14_747_533.jpg");//不相同图片
//        new ImageComp().compareImage("https://lupic.cdn.bcebos.com/20220812/3087527850_14_600_429.jpg", "https://lupic.cdn.bcebos.com/20220812/3087527850_14_600_429.jpg");//相同图片
    }

}
