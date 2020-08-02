package structural.decorator.unclebob.modem.factory;

import structural.decorator.unclebob.modem.HayesModem;
import structural.decorator.unclebob.modem.Modem;
import structural.decorator.unclebob.modem.USRoboticsModem;

public enum ModemFactory {
    INSTANCE;

    public Modem makeModem() {
        if (Math.random() > Math.random())
            return new HayesModem();
        return new USRoboticsModem();
    }
}
