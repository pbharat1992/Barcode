package com.barcodetest;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.zxing.client.j2se.BufferedImageLuminanceSource;

public class BarcodeTest {
	
	
	@Test
	public void barcodeTest() throws IOException {
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver_win32\\chromedriver.exe");
           WebDriver driver=new ChromeDriver();
           driver.get("https://barcode.tec-it.com/en");
           
           String barcodeURL=driver.findElement(By.tagName("img")).getAttribute("src");
           System.out.println(barcodeURL);
           
           URL url=new URL(barcodeURL);
          BufferedImage bufferedimage=ImageIO.read(url);
          
         LuminanceSource luminanceSource=new BufferedImageLuminanceSource(bufferedimage);
          BinaryBitmap binaryBitmap=new BinaryBitmap(new HybridBinarizer(luminanceSource));
          
          Result result=new MultiFormatReader().decode(binaryBitmap);
	          System.out.println(result.getText());
	}

}
