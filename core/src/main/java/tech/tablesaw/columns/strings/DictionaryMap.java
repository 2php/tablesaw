package tech.tablesaw.columns.strings;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import tech.tablesaw.api.BooleanColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.selection.BitmapBackedSelection;
import tech.tablesaw.selection.Selection;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public interface DictionaryMap {

    void sortDescending();

    void sortAscending();

    String getValueForKey(int key);

    int size();

    String getValueForIndex(int rowIndex);

    int countOccurrences(String value);

    Set<String> asSet();

    IntArrayList dataAsIntArray();

    int getKeyForIndex(int i);

    int firstIndexOf(String string);

    Object[] asObjectArray();

    Selection selectIsIn(String... strings);

    void addValuesToSelection(Selection results, short key);

    void append(String value);

    void set(int rowIndex, String stringValue);

    void clear();

    Table countByCategory(String columnName);

    Selection isEqualTo(String string);

    default Selection isNotEqualTo(String string) {
        Selection selection = new BitmapBackedSelection();
        selection.addRange(0, size());
        selection.andNot(isEqualTo(string));
        return selection;
    }

    List<BooleanColumn> getDummies();

    /**
     * Returns the contents of the cell at rowNumber as a byte[]
     */
    public byte[] asBytes(int rowNumber);

    /**
     * Returns the count of missing values in this column
     */
    int countMissing();

    Iterator<String> iterator() ;

    void appendMissing();

    boolean isMissing(int rowNumber);

}
