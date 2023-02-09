package edu.escuelaing.arem.ASE.app;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;

public class JpgService implements Service{
    @Override
    public String getHeader() {
        return "";
    }

    @Override
    public String getResponse() {
        String file;
        try {
            file = "HTTP/1.1 200 OK\r\n"
                    + "Content-Type: image/jpg\r\n"
                    + "\r\n";
            BufferedImage bufferedImage = ImageIO.read(new File("src/main/resources/imagen.jpg"));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            HttpServer server = HttpServer.getInstance();
            DataOutputStream dataOutputStream = new DataOutputStream(server.getOutputStream());
            ImageIO.write(bufferedImage, "jpg", byteArrayOutputStream);
            dataOutputStream.writeBytes(file);
            dataOutputStream.write(byteArrayOutputStream.toByteArray());;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file;
    }

}
