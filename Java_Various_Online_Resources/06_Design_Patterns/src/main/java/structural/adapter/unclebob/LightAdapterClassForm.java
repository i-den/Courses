package structural.adapter.unclebob;

/**
 * Faster, less memory, simple
 * Rigid as Light cannot be changed at runtime
 */
public class LightAdapterClassForm extends Light implements Switchable {
    @Override
    public void turnOn() {
        enable();
    }

    @Override
    public void turnOff() {
        disable();
    }
}
