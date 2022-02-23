package HW2;

    public class MyArraySizeException extends Exception {
        private int i;
        private int j;

        public MyArraySizeException(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public String getMessage() {
            return i + " на " + j;
        }
    }

