public enum Colors {
    BLUE("\u001B[34m"),
    WHITE("\u001B[30m"),
    YELLOW("\u001B[33m"),
    BLACK("\u001B[37m"),
    RED("\u001B[31m");

    private final String color;

    Colors(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
