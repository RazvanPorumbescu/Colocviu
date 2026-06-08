package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Judet> judete = new ArrayList<>();

        try (Scanner sc = new Scanner(new File("judete.txt"))) {

            while (sc.hasNext()) {

                String iso = sc.next();
                String nume = sc.next();
                String regiune = sc.next();
                int nrLocuitori = sc.nextInt();
                int suprafata = sc.nextInt();

                judete.add(
                        new Judet(
                                iso,
                                nume,
                                regiune,
                                nrLocuitori,
                                suprafata
                        )
                );
            }

        } catch (FileNotFoundException e) {
            System.out.println("Nu exista judete.txt");
            return;
        }

        judete.sort(
                Comparator.comparingDouble(Judet::getDensitate)
                        .reversed()
        );

        StringBuilder out = new StringBuilder();

        out.append("LISTA JUDETELOR ORDONATA DUPA DENSITATE\n");

        for (Judet j : judete) {
            out.append(j).append("\n");
        }

        out.append("\n");

        String searchText;

        try (Scanner sc = new Scanner(new File("search.txt"))) {
            searchText = sc.nextLine().toLowerCase();
        } catch (FileNotFoundException e) {
            System.out.println("Nu exista search.txt");
            return;
        }

        out.append("REZULTAT CAUTARE: ")
                .append(searchText)
                .append("\n");

        for (Judet j : judete) {

            if (j.getIso().toLowerCase().contains(searchText)
                    || j.getNume().toLowerCase().contains(searchText)
                    || j.getRegiune().toLowerCase().contains(searchText)) {

                out.append(j).append("\n");
            }
        }

        boolean scrieInFisier = true;

        Printer printer;

        if (scrieInFisier) {
            printer = new FilePrinter("output.txt");
        } else {
            printer = new ConsolePrinter();
        }

        printer.print(out.toString());
    }
}