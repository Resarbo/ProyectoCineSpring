package com.cursojava.curso.dao;
import com.cursojava.curso.models.Asientos;
import com.cursojava.curso.service.WordServiceApi;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
public class WordServiceImp implements WordServiceApi {

    private String txtuser;
    private String txtAsientos;

    public  void gaurdarInfoUsuario(Asientos asientos){
        txtuser = asientos.getIdcliente();
        txtAsientos=asientos.getAsiento();
    }

    @Override
    public void createWord(String title, String imagePath, String fileName) throws IOException, InvalidFormatException {
        var document = new XWPFDocument();
        var titleParagraph = document.createParagraph();
        var titleRun = titleParagraph.createRun();

        titleParagraph.setAlignment(ParagraphAlignment.CENTER);
        titleRun.setText(title);
        titleRun.setColor("000000");
        titleRun.setBold(true);
        titleRun.setFontFamily("Courier");
        titleRun.setFontSize(30);

        var image = document.createParagraph();
        image.setAlignment(ParagraphAlignment.CENTER);

        var imageRun = image.createRun();
        imageRun.setTextPosition(20);
        Path path = Paths.get(imagePath);

        imageRun.addPicture(Files.newInputStream(path), XWPFDocument.PICTURE_TYPE_PNG, path.getFileName().toString(), Units.toEMU(200),Units.toEMU(75));


        var pbody = document.createParagraph();
        var pbodyrun = pbody.createRun();
        pbodyrun.setTextPosition(100);
        pbodyrun.setText("............................................................................................................................................ \n"+
                " Has comprado un ticket de cinerama por medio de nuestra pagina web por lo que la presentación de este ticket esta sujeto a la políticas de privacidad que se ha aceptado anteriormente, \n" +
                "por favor acercarse a la hora correspondiente a su función con este documento sea físico y/o digital.\n" +
                "...............................................................................................................................................\n" +
                "Tu codigo de compra es:"+(this.txtuser) + "Tus asientos son" + (this.txtAsientos));
        pbodyrun.setColor("000000");
        pbodyrun.setBold(true);
        pbodyrun.setFontFamily("Arial");
        pbodyrun.setItalic(true);
        pbodyrun.setFontSize(11);


        FileOutputStream outputStream = new FileOutputStream(new File(System.getProperty("user.home")+File.separator + fileName));
        document.write(outputStream);
        outputStream.close();
        document.close();
    }

}
