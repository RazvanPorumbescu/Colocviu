package org.example;

public class Judet {
    private String iso;
    private String nume;
    private String regiune;
    private int nrLocuitori;
    private int suprafata;

    public Judet(String iso, String nume, String regiune,
                 int nrLocuitori, int suprafata) {
        this.iso = iso;
        this.nume = nume;
        this.regiune = regiune;
        this.nrLocuitori = nrLocuitori;
        this.suprafata = suprafata;
    }

    public String getIso() {
        return iso;
    }

    public String getNume() {
        return nume;
    }

    public String getRegiune() {
        return regiune;
    }

    public int getNrLocuitori() {
        return nrLocuitori;
    }

    public int getSuprafata() {
        return suprafata;
    }

    public double getDensitate() {
        return (double) nrLocuitori / suprafata;
    }

    @Override
    public String toString() {
        return iso + " " +
                nume + " " +
                regiune + " " +
                nrLocuitori + " " +
                suprafata +
                " densitate=" +
                getDensitate();
    }
}
