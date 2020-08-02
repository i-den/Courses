package structural.decorator.unclebob.modem;

public interface Modem {
    public void dial(PhoneNumber number);
    public void hangUp();
    public void send();
    public void receive();
    public void setSpeakerVolume(int vol);
}
