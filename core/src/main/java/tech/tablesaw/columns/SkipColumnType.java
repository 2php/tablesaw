package tech.tablesaw.columns;

import tech.tablesaw.io.csv.CsvReadOptions;

public class SkipColumnType extends AbstractColumnType {

    private static SkipColumnType INSTANCE;

    private SkipColumnType(int byteSize, String name, String printerFriendlyName) {
        super(byteSize, name, printerFriendlyName);
    }

    public static SkipColumnType instance() {
        if (INSTANCE == null) {
            INSTANCE = new SkipColumnType(0, "SKIP", "Skipped");
        }
        return INSTANCE;
    }
    @Override
    public Column<Void> create(String name) {
        throw new UnsupportedOperationException("Column type " + name() + " doesn't support column creation");
    }

    @Override
    public AbstractParser<?> customParser(CsvReadOptions options) {
        throw new UnsupportedOperationException("Column type " + name() + " doesn't support parsing");
    }

    public static Object missingValueIndicator() {
        throw new UnsupportedOperationException("Column type " + SKIP + " doesn't support missing values");
    }
}
