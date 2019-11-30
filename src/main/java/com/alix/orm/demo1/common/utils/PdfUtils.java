package com.alix.orm.demo1.common.utils;

import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import com.spire.pdf.graphics.PdfMargins;

import java.awt.geom.Point2D;

/**
 * @author 杨安星(Alix)
 * @create 2019-11-29 10:39
 */
public class PdfUtils {

    /**
     * 分割pdf文件
     *
     * @param pdfPath 文件路径
     * @param size    分割每页的大小
     */
    public static void spiltPdf(String pdfPath, double size) {
        //加载PDF文档
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(pdfPath);
        //获取页数
        int count = doc.getPages().getCount();
        double fileCount = count/size;
        double fullPage = Math.floor(fileCount); //完整也
        System.out.println(count+"/"+size+"="+Math.ceil(fileCount));
        int i=0;
        PdfDocument newPdf;
        PdfPageBase page;
        for (int index=0;index<count;index++){
            newPdf = new PdfDocument();
            page = newPdf.getPages().add(doc.getPages().get(index).getSize(), new PdfMargins(0));
            doc.getPages().get(i).createTemplate().draw(page, new Point2D.Float(0,0));
            i++;
            if(i==4){
                int name = (index+1)/5+1;
                newPdf.saveToFile("split/"+String.valueOf(name)+".pdf");
                i=0;
                newPdf = new PdfDocument();
            }
            if(index == count-1){
               int name = (index+1)/5+1;
               newPdf.saveToFile("split/"+String.valueOf(name)+".pdf");
            }
        }
    }


    public static void f(){
        PdfDocument document = new PdfDocument();
        document.loadFromFile("C:\\Users\\PC\\Desktop\\pdf\\费率表.pdf");
    }

    public static void main(String[] args) {
        PdfUtils.spiltPdf("C:\\Users\\PC\\Desktop\\pdf\\费率表.pdf",5.0);
    }
}
