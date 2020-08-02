package creational.factory.method.wiki;

import creational.factory.method.wiki.room.Room;

import java.util.ArrayList;
import java.util.List;

public abstract class RoomApp {

    private final List<Room> rooms = new ArrayList<>();

    public RoomApp() {
        Room room1 = createRoom();
        Room room2 = createRoom();

        room1.connect(room2);

        rooms.add(room1);
        rooms.add(room2);
    }

    public abstract Room createRoom();
}
