class Spreadsheet {
    private Map<String, Integer> grid;
    private int numRows;

    public Spreadsheet(int rows) {
        grid = new HashMap<>();
        this.numRows = rows;
    }

    public void setCell(String cell, int value) {
        grid.put(cell, value);
    }

    public void resetCell(String cell) {
        grid.put(cell, 0);
    }

    public int getValue(String formula) {
        formula = formula.substring(1);
        String[] operands = formula.split("\\+");
        int result = 0;
        for (String operand : operands) {
            operand = operand.trim();
            if (isCellReference(operand)) {
                result += grid.getOrDefault(operand, 0);
            } else {
                result += Integer.parseInt(operand);
            }
        }
        return result;
    }

    private boolean isCellReference(String str) {
        return str.matches("[A-Z]+[1-9][0-9]*");
    }

}
