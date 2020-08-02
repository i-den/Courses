package structural.decorator.unclebob.modem.decorator;

import structural.decorator.unclebob.modem.Modem;
import structural.decorator.unclebob.modem.PhoneNumber;

public class LoudDialModem extends ModemDecorator {
    public LoudDialModem(Modem realModem) {
        super(realModem);
    }

    @Override
    public void dial(PhoneNumber number) {
        realModem.setSpeakerVolume(10);
        realModem.dial(number);
    }
}
