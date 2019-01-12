package nezoter;

public class Line {

    private String[] sor = new String[20];

    public Line(String s) {
        this.sor = s.split("(?!^)");
    }

    public String[] getSor() {
        return sor;
    }
}
