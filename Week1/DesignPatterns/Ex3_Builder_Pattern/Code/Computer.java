package builderPattern;

public class Computer {
    private final String cpu;
    private final int ram;
    private final int storage;
    private final boolean hasGraphicsCard;
    private final boolean hasBluetooth;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.hasGraphicsCard = builder.hasGraphicsCard;
        this.hasBluetooth = builder.hasBluetooth;
    }

    @Override
    public String toString() {
        return "Computer {" +
               "CPU='" + cpu + '\'' +
               ", RAM=" + ram + "GB" +
               ", Storage=" + storage + "GB" +
               ", GraphicsCard=" + hasGraphicsCard +
               ", Bluetooth=" + hasBluetooth +
               '}';
    }

    public static class Builder {
        private String cpu;
        private int ram;
        private int storage;
        private boolean hasGraphicsCard;
        private boolean hasBluetooth;

        public Builder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder setRam(int ram) {
            this.ram = ram;
            return this;
        }

        public Builder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(boolean hasGraphicsCard) {
            this.hasGraphicsCard = hasGraphicsCard;
            return this;
        }

        public Builder setBluetooth(boolean hasBluetooth) {
            this.hasBluetooth = hasBluetooth;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
