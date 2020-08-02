package creational.factory.method.wiki;

import creational.factory.method.wiki.room.NormalRoom;
import creational.factory.method.wiki.room.Room;

public class NormalRoomApp extends RoomApp {
    @Override
    public Room createRoom() {
        return new NormalRoom();
    }
}
