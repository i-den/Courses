package structural.decorator.diveintodspt.decorator;

import structural.decorator.diveintodspt.DataSource;

public class CompressionDataSourceDecorator extends DataSourceDecorator {
    public CompressionDataSourceDecorator(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void writeData() {
        // compress
        super.writeData();
    }

    @Override
    public void readData() {
        // extract
        super.readData();
    }
}
