package creational.factory.method.wiki;

import creational.factory.method.wiki.RoomApp;
import creational.factory.method.wiki.room.MagicRoom;
import creational.factory.method.wiki.room.Room;

public class MagicRoomApp extends RoomApp {
    @Override
    public Room createRoom() {
        return new MagicRoom();
    }
}
