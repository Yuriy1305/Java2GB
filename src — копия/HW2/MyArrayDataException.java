package HW2;

public class MyArrayDataException extends Exception {
    private int i;
    private int j;
    private String e;

    public MyArrayDataException(int i, int j, NumberFormatException nfe) {
        this.i = i;
        this.j = j;
        this.e = nfe.getMessage();
    }

    public String getMessage() {
        return "нечисло в ячейке [" + i + "," + j + "] (" + e.substring(e.indexOf('"')) + ")";
    }
}