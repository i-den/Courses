import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {
    public Object getRandomElement() {
        Object o = this.get(new Random().nextInt(this.size()));
        this.remove(o);
        return o;
    }
}
