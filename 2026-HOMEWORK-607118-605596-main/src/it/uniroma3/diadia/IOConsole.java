package it.uniroma3.diadia;

import java.util.Scanner;

/**
 * Implementazione dell'interfaccia IO che interagisce con la console standard.
 */
public class IOConsole implements IO {

    @Override
    public void mostraMessaggio(String msg) {
        System.out.println(msg);
    }

    @Override
    public String leggiRiga() {
        Scanner scannerDiLinee = new Scanner(System.in);
        // Non chiudiamo lo scanner qui altrimenti chiuderemmo System.in
        return scannerDiLinee.nextLine();
    }
}