package test;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import static java.lang.System.*;

public class Main {

    public static void main(String[] args) throws IOException {

        out.println("Répertoire courant : " + System.getProperty("user.dir"));

        File rep = new File(".");
        out.println("Chemin relatif : " + rep.getPath());
        out.println("Chemin absolu : " + rep.getAbsolutePath());

        File[] elements = rep.listFiles();

        if (elements == null) {
            out.println("Erreur : impossible de lire le répertoire.");
            return;
        }

        for (File element : elements) {
            out.println("Racine : " + element);
        }

        out.println("\n--- Répertoires ---");
        for (File element : elements) {
            if (element.isDirectory()) {
                out.print(element.getName() + "\t");

                if (element.getName().length() < 8) {
                    out.print("\t");
                }

                out.println("<REP>");
            }
        }

        out.println("\n--- Fichiers ---");
        for (File element : elements) {
            if (element.isFile()) {
                out.print(element.getName() + "\t");

                if (element.getName().length() < 8) {
                    out.print("\t");
                }

                out.printf("%tc", new Date(element.lastModified()));
                out.printf("\t%10d octets\n", element.length());
            }
        }
    }
}