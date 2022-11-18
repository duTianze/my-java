package com.dutianze.io;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Arrays;
import javax.imageio.ImageIO;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/11/18
 */
public class ReadWriteImageTest {

  private static final String GOOGLE_LOGO =
      "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png";

  @Test
  void readWriteImage() {
    assertDoesNotThrow(() -> {
      URL url = new URL(GOOGLE_LOGO);

      // all supported formats
      String[] writerNames = ImageIO.getWriterFormatNames();
      Arrays.stream(writerNames).forEach(System.out::println);

      // read an image from url
      BufferedImage image = ImageIO.read(url);

      // resize image to 300x150
      Image scaledImage = image.getScaledInstance(300, 150, Image.SCALE_DEFAULT);

      // save the resize image aka thumbnail
      ImageIO.write(convertToBufferedImage(scaledImage), "png",
          Paths.get("src/test/resources/google.png").toFile());
    });
  }

  public static BufferedImage convertToBufferedImage(Image img) {

    if (img instanceof BufferedImage) {
      return (BufferedImage) img;
    }

    // Create a buffered image with transparency
    BufferedImage bi = new BufferedImage(
        img.getWidth(null), img.getHeight(null),
        BufferedImage.TYPE_INT_ARGB);

    Graphics2D graphics2D = bi.createGraphics();
    graphics2D.drawImage(img, 0, 0, null);
    graphics2D.dispose();

    return bi;
  }
}
