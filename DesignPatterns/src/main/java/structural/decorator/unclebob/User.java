package structural.decorator.unclebob;

import structural.decorator.unclebob.modem.Modem;
import structural.decorator.unclebob.modem.decorator.LoudDialModem;
import structural.decorator.unclebob.modem.decorator.QuietDialModem;
import structural.decorator.unclebob.modem.factory.ModemFactory;

public class User {
    private Modem modem;
    private UserPreferences userPreferences;

    public User(UserPreferences userPreferences) {
        this.userPreferences = userPreferences;
    }

    public void procureModem() {
        Modem modem = ModemFactory.INSTANCE.makeModem();
        if (userPreferences.loudModem) {
            modem = new LoudDialModem(modem);
        } else {
            modem = new QuietDialModem(modem);
        }
    }
}
