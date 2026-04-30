package it.uniroma3.diadia;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class DiaDiaTest {

    @Test
    public void testPartitaConVittoriaRapida() {
        // Definiamo i comandi per andare dall'Atrio alla Biblioteca (nord) e finire[cite: 6]
        List<String> comandi = Arrays.asList("vai nord", "fine");
        IOSimulator io = new IOSimulator(comandi);
        
        DiaDia gioco = new DiaDia(io);
        gioco.gioca();

        // Verifichiamo se tra i messaggi stampati compare quello di vittoria
        assertTrue(messaggioPresente(io.getMessaggiProdotti(), "Hai vinto!"));
    }

    private boolean messaggioPresente(List<String> messaggi, String target) {
        for (String m : messaggi) {
            if (m.contains(target)) return true;
        }
        return false;
    }
}