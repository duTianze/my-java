package com.dutainze.util;

import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author dutianze
 * @date 2022/3/23
 */
public class PrettyPrinter {
    private static final char BORDER_KNOT = '+';
    private static final char HORIZONTAL_BORDER = '-';
    private static final char VERTICAL_BORDER = '|';

    private static final String DEFAULT_AS_NULL = "(NULL)";

    private final OutputStream out;
    private final String asNull;

    public PrettyPrinter(OutputStream out) {
        this(out, DEFAULT_AS_NULL);
    }

    public PrettyPrinter(OutputStream out, String asNull) {
        if (out == null) {
            throw new IllegalArgumentException("No print stream provided");
        }
        if (asNull == null) {
            throw new IllegalArgumentException("No NULL-value placeholder provided");
        }
        this.out = out;
        this.asNull = asNull;
    }

    public void print(int[][] table) {
        String[][] toArray = Arrays.stream(table)
                                   .map(a -> Arrays.stream(a).mapToObj(Integer::toString).toArray(String[]::new))
                                   .toArray(String[][]::new);
        this.printStringArray(toArray);
    }

    public void printStringArray(String[][] table) {
        if (table == null) {
            throw new IllegalArgumentException("No tabular data provided");
        }
        if (table.length == 0) {
            return;
        }
        final int[] widths = new int[getMaxColumns(table)];
        adjustColumnWidths(table, widths);
        printPreparedTable(table, widths, getHorizontalBorder(widths));
    }

    private void printPreparedTable(String[][] table, int[] widths, String horizontalBorder) {
        final int lineLength = horizontalBorder.length();
        this.println(horizontalBorder);
        for (final String[] row : table) {
            if (row != null) {
                this.println(getRow(row, widths, lineLength));
                this.println(horizontalBorder);
            }
        }
    }

    private String getRow(String[] row, int[] widths, int lineLength) {
        final StringBuilder builder = new StringBuilder(lineLength).append(VERTICAL_BORDER);
        final int maxWidths = widths.length;
        for (int i = 0; i < maxWidths; i++) {
            builder.append(padRight(getCellValue(safeGet(row, i, null)), widths[i])).append(VERTICAL_BORDER);
        }
        return builder.toString();
    }

    private String getHorizontalBorder(int[] widths) {
        final StringBuilder builder = new StringBuilder(256);
        builder.append(BORDER_KNOT);
        for (final int w : widths) {
            builder.append(String.valueOf(HORIZONTAL_BORDER).repeat(Math.max(0, w)));
            builder.append(BORDER_KNOT);
        }
        return builder.toString();
    }

    private int getMaxColumns(String[][] rows) {
        int max = 0;
        for (final String[] row : rows) {
            if (row != null && row.length > max) {
                max = row.length;
            }
        }
        return max;
    }

    private void adjustColumnWidths(String[][] rows, int[] widths) {
        for (final String[] row : rows) {
            if (row != null) {
                for (int c = 0; c < widths.length; c++) {
                    final String cv = getCellValue(safeGet(row, c, asNull));
                    final int l = cv.length();
                    if (widths[c] < l) {
                        widths[c] = l;
                    }
                }
            }
        }
    }

    private static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }

    private static String safeGet(String[] array, int index, String defaultValue) {
        return index < array.length ? array[index] : defaultValue;
    }

    private String getCellValue(Object value) {
        return value == null ? asNull : value.toString();
    }

    private void println(String s) {
        try {
            out.write(s.getBytes(StandardCharsets.UTF_8));
            out.write(System.lineSeparator().getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
