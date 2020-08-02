package structural.adapter.unclebob;

/**
 * Flexible, less rigid as Light can be changed
 */
public class LightAdapterObjectForm implements Switchable {

    Light light;

    LightAdapterObjectForm(Light light) {
        this.light = light;
    }

    void setLight(Light light) {
        this.light = light;
    }

    @Override
    public void turnOn() {
        light.enable();
    }

    @Override
    public void turnOff() {
        light.disable();
    }
}
