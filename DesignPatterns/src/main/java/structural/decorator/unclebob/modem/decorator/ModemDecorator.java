package structural.decorator.unclebob.modem.decorator;

import structural.decorator.unclebob.modem.Modem;
import structural.decorator.unclebob.modem.PhoneNumber;

public class ModemDecorator implements Modem {
    protected Modem realModem;

    ModemDecorator(Modem realModem) {
        this.realModem = realModem;
    }

    @Override
    public void dial(PhoneNumber number) {
        realModem.dial(number);
    }

    @Override
    public void hangUp() {
        realModem.hangUp();
    }

    @Override
    public void send() {
        realModem.send();
    }

    @Override
    public void receive() {
        realModem.receive();
    }

    @Override
    public void setSpeakerVolume(int vol) {
        realModem.setSpeakerVolume(vol);
    }
}
