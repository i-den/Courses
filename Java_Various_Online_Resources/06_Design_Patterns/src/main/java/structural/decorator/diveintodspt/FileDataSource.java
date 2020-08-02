package structural.decorator.diveintodspt;

public class FileDataSource implements DataSource {
    private String filename;

    public FileDataSource(String filename) {
        this.filename = filename;
    }


    @Override
    public void writeData() {

    }

    @Override
    public void readData() {

    }
}
