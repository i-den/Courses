package structural.decorator.diveintodspt.decorator;

import structural.decorator.diveintodspt.DataSource;

public class EncryptionDataSourceDecorator extends DataSourceDecorator {
    public EncryptionDataSourceDecorator(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void writeData() {
        // encrypt
        super.writeData();
    }

    @Override
    public void readData() {
        // decrypt
        super.readData();
    }
}
