package structural.decorator.unclebob.modem.decorator;

import structural.decorator.unclebob.modem.Modem;
import structural.decorator.unclebob.modem.PhoneNumber;

public class QuietDialModem extends ModemDecorator {
    public QuietDialModem(Modem realModem) {
        super(realModem);
    }

    @Override
    public void dial(PhoneNumber number) {
        realModem.setSpeakerVolume(0);
        realModem.dial(number);
    }
}
