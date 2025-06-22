package proxyPattern;

public class ImageViewerTest {
    public static void main(String[] args) {
        Image aadhaarImage = new ProxyImage("aadhaar_card_1234.png");
        System.out.println("Accessing image for the first time:");
        aadhaarImage.display();
        System.out.println("\nAccessing image again:");
        aadhaarImage.display();
    }
}

