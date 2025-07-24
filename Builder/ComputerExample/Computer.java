package Builder.ComputerExample;

/**
 * Example of Builder Pattern: Computer class.
 */
public class Computer {
    // Required parameters
    private final String cpu;
    private final int ramGB;

    // Optional parameters
    private final int storageGB;
    private final boolean hasGraphicsCard;
    private final String os;

    // Private constructor to enforce use of builder
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ramGB = builder.ramGB;
        this.storageGB = builder.storageGB;
        this.hasGraphicsCard = builder.hasGraphicsCard;
        this.os = builder.os;
    }

    @Override
    public String toString() {
        return "Computer [cpu=" + cpu + ", ramGB=" + ramGB +
                ", storageGB=" + storageGB + ", hasGraphicsCard=" + hasGraphicsCard +
                ", os=" + os + "]";
    }

    // Static Builder class
    public static class Builder {
        // Required fields
        private final String cpu;
        private final int ramGB;

        // Optional fields - initialized to default values
        private int storageGB = 256;
        private boolean hasGraphicsCard = false;
        private String os = "Linux";

        public Builder(String cpu, int ramGB) {
            this.cpu = cpu;
            this.ramGB = ramGB;
        }

        public Builder storageGB(int storageGB) {
            this.storageGB = storageGB;
            return this;
        }

        public Builder hasGraphicsCard(boolean hasGraphicsCard) {
            this.hasGraphicsCard = hasGraphicsCard;
            return this;
        }

        public Builder os(String os) {
            this.os = os;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    // Example usage
    public static void main(String[] args) {
        Computer gamingPC = new Computer.Builder("Intel i9", 32)
                .storageGB(2000)
                .hasGraphicsCard(true)
                .os("Windows 11")
                .build();

        System.out.println(gamingPC);

        Computer cheapPC = new Computer.Builder("Intel i3", 8)
                .build();

        System.out.println(cheapPC);
    }
}
