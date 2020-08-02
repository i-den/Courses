package structural.decorator.diveintodspt.decorator;

import structural.decorator.diveintodspt.DataSource;

public class DataSourceDecorator implements DataSource {
    private DataSource dataSource;

    public DataSourceDecorator(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void writeData() {
        dataSource.writeData();
    }

    @Override
    public void readData() {
        dataSource.writeData();
    }
}
