package pages.phpTravels;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class PageObject {
    WebDriver driver;

    PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    void captureElementScreenshot(WebElement elementToCapture, String fileName) throws IOException {
        // Capture entire page screenshot
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Get height, width and location (x,y) of element
        int elementToCaptureWidth = elementToCapture.getSize().getWidth();
        int elementToCaptureHeight = elementToCapture.getSize().getHeight();

        // Read full image screenshot
        BufferedImage img = ImageIO.read(screen);

        // Get size of image
        int imageWidth = img.getWidth();

        // Cut image
        BufferedImage dest = img.getSubimage( (imageWidth-elementToCaptureWidth)/2,0, (imageWidth+elementToCaptureWidth)/2 - 100, elementToCaptureHeight);
        ImageIO.write(dest, "png", screen);

        // Save screenshot
        FileUtils.copyFile(screen, new File("./" + fileName + ".png"));
    }

    void captureScreenshot(String fileName) throws IOException {
        // Capture entire page screenshot
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Read full image screenshot
        BufferedImage img = ImageIO.read(screen);

        // Get size of image
        int imageWidth = img.getWidth();
        int imageHeight = img.getHeight();

        // Cut image
        BufferedImage dest = img.getSubimage(100,0, imageWidth - 200, imageHeight);
        ImageIO.write(dest, "png", screen);

        // Save screenshot
        FileUtils.copyFile(screen, new File("./" + fileName + ".png"));
    }

}
