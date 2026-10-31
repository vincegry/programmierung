public class Bankautomat {
    public static void main(String[] args) { // Bankautomaten Simulation
        int guthaben = 1000;
        while (true) {
            String eingabe = IO.readln("Bitte geben Sie eine Operation (GUTHABEN, EINZAHLEN, ABHEBEN, ZINSESZINS, STOP) ein: ");
            switch (eingabe) {
                case "EINZAHLEN" -> {
                    int betrag = Integer.parseInt(IO.readln("Nennen Sie den Betrag den Sie einzahlen möchten: "));
                    if (betrag < 0) {
                        IO.println("Betrag ist negativ");
                    } else {
                        guthaben = guthaben + (betrag * 95) / 100;
                        IO.println("Ihr aktuallisiertes Guthaben beträgt: " + guthaben);
                    }
                }
                case "ABHEBEN" -> {
                    int betrag = Integer.parseInt(IO.readln("Geben Sie den abzuhebenden Betrag ein: "));
                    if (betrag <= guthaben) {
                        guthaben = guthaben - betrag;
                        IO.println("Ihr neues Guthaben beträgt nun: " + guthaben);
                    } else {
                        IO.println("Sie haben nicht genug Guthaben auf ihrem Konto. \nIhr aktueller Kontostand: " + guthaben);
                    }
                }
                case "GUTHABEN" -> IO.println("Ihr Guthaben beträgt: " + guthaben);
                case "ZINSESZINS" -> {
                    int n = Integer.parseInt(IO.readln("Wieviele Jahre wollen Sie ihr Guthaben verzinsen?"));
                    for (int i = 0; i < n; i++) {
                        guthaben = (int) Math.ceil(guthaben * 1.04) - 2;
                        if (guthaben < 0) {
                            guthaben = 0;
                            i = n;
                        }
                    }
                }
                case "STOP" -> System.exit(1);
                default -> System.exit(1);
            }
        }
    }
}