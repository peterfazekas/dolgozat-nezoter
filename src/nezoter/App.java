package nezoter;

public class App {

    private final Reader reader;
    private final Facade test;
    private final Console console;
    private final Writer writer;

    public App() {
        console = new Console();
        reader = new Reader();
        test = new Facade(reader.getData("foglaltsag.txt"), reader.getData("kategoria.txt"));
        writer = new Writer("szabad.txt");
    }

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        System.out.println("1. feladat: Az adatok beolvasása.\n");
        int sor = console.readInt("2.feladat: Kérem az ülőhely adatait. Sor: ");
        int szek = console.readInt("Székszám: ");
        if (test.getChairInfo(sor, szek).equals("x")) {
            System.out.println("A ülőhely foglalt.\n");
        } else {
            System.out.println("Az ülőhely szabad.\n");
        }
        System.out.println("3.feladat: Az előadásra eddig " + test.soldTicket() + " jegyet adtak el, ez a nézőtér "+ Math.round(((double)test.soldTicket()/(20*15))*100) + "%-a.\n");
        System.out.println("4.feladat: A legtöbb jegyet a(z) " + test.mostSold() + ". árkategóriában értékesítették.\n");
        System.out.println("5. feladat: Az eddigi teljes bevétel " + test.allIncome() + " Ft.-\n");
        System.out.println("6. feladat: Összesen " + test.singleChair() + " darab 'egyedülálló' üres hely van a nézőtéren.\n");
        System.out.println("7. feladat: A szabad.txt előállítása.");
        writer.printAll(test.makeText());
    }
}
