package builderPattern;

public class TestBuilder {
    public static void main(String[] args) {
        Computer gamingPC = new Computer.Builder()
                .setCpu("Intel Core i9")
                .setRam(32)
                .setStorage(2000)
                .setGraphicsCard(true)
                .setBluetooth(true)
                .build();
        
        System.out.println(gamingPC.toString());

        Computer officePC = new Computer.Builder()
                .setCpu("Intel Core i5")
                .setRam(8)
                .setStorage(500)
                .setGraphicsCard(false)
                .setBluetooth(false)
                .build();
        System.out.println(officePC.toString());
    }
}

