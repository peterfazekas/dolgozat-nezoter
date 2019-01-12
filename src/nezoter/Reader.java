package nezoter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Reader {

    public List<Line> getData(String fileName) {
        return parse(read(fileName));
    }

    private List<Line> parse(List<String> lista) {
        return lista.stream().map(this::createLine).collect(Collectors.toList());
    }

    private Line createLine(String sor) {
        return new Line(sor);
    }

    private List<String> read(String fileName) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            lines = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

}
