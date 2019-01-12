package nezoter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Facade {

    private static final String NEW_LINE = "\r\n";
    private final List<Line> foglaltsag;
    private final List<Line> kategoria;
    int[] soldTickets = new int[5];
    int[] categories = {5000, 4000, 3000, 2000, 1500};

    public Facade(List<Line> foglaltsag, List<Line> kategoria) {
        this.foglaltsag = foglaltsag;
        this.kategoria = kategoria;

    }

    public String getChairInfo(int sor, int szek) {
        return foglaltsag.get(sor-1).getSor()[szek-1];
    }

    public Integer soldTicket() {
        int x=0;

        for(int i=0; i<15; i++) {
            for(int j=0; j<20; j++) {
                if (foglaltsag.get(i).getSor()[j].equals("x")) {
                    x++;
                }
            }
        }

        return x;
    }

    public int mostSold() {
        int[] counter = new int[5];

        for(int i=0; i<15; i++) {
            for(int j=0; j<20; j++) {
                if (foglaltsag.get(i).getSor()[j].equals("x")) {
                    int x = Integer.parseInt(kategoria.get(i).getSor()[j]);

                    counter[x-1]++;
                }

            }
        }
        soldTickets = counter;
        List<Integer> list = Arrays.stream(counter).boxed().collect(Collectors.toList());

        return list.indexOf(list.stream().max(Comparator.comparing(Integer::valueOf)).get())+1;
    }

    public int allIncome() {
        int sum = 0;
        for(int i=0; i<5; i++) {
            sum += soldTickets[i]*categories[i];
        }

        return sum;
    }

    public int singleChair() {
        int counter = 0;

        for(int i=0; i<15; i++) {
            for(int j=0; j<20; j++) {

                if (j == 0 && foglaltsag.get(i).getSor()[j].equals("o") && foglaltsag.get(i).getSor()[j+1].equals("x")) {
                    counter++;
                } else if (j == 19 && foglaltsag.get(i).getSor()[j].equals("o") && foglaltsag.get(i).getSor()[j-1].equals("x")) {
                    counter++;
                } else if (j!=0 && j!=19 && foglaltsag.get(i).getSor()[j].equals("o") && foglaltsag.get(i).getSor()[j-1].equals("x") && foglaltsag.get(i).getSor()[j+1].equals("x")) {
                    counter++;
                }

            }
        }

        return counter;
    }

    public String makeText() {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<15; i++) {
            for(int j=0; j<20; j++) {
                String f = foglaltsag.get(i).getSor()[j];
                String k = kategoria.get(i).getSor()[j];

                if (f.equals("x")) {
                    sb.append(f);
                } else {
                    sb.append(k);
                }
            }

            sb.append(NEW_LINE);
        }

        return sb.toString();
    }

}
