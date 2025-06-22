package proxyPattern;
public class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromRemoteServer();
    }

    private void loadFromRemoteServer() {
        System.out.println("Loading image from UIDAI server: " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying Aadhaar image: " + fileName);
    }
}

