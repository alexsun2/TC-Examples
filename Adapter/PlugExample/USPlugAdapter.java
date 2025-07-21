package Adapter.PlugExample;

// The Adapter
public class USPlugAdapter implements EUPlug {
    private USPlug usPlug;

    public USPlugAdapter(USPlug usPlug) {
        this.usPlug = usPlug;
    }

    @Override
    public void connectToEUPlug() {
        System.out.print("Using adapter: ");
        usPlug.connectToUSPlug();
    }
}
