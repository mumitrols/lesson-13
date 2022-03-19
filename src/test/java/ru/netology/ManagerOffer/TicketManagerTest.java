package ru.netology.ManagerOffer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.TicketOffer;
import ru.netology.repository.RepoTicket;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    private final TicketOffer firstTicket = new TicketOffer(0, 800, "DME", "VIE", 2);
    private final TicketOffer secondTicket = new TicketOffer(1, 200, "GVA", "SVO", 3);
    private final TicketOffer thirdTicket = new TicketOffer(2, 1000, "SVO", "GVA", 3);
    private final TicketOffer fourthTicket = new TicketOffer(3, 100, "DME", "VIE", 2);
    private final TicketOffer fifthTicket = new TicketOffer(4, 900, "DME", "VIE", 2);
    private final TicketOffer sixthTicket = new TicketOffer(5, 850, "SVO", "GVA", 3);
    private final TicketOffer seventhTicket = new TicketOffer(6, 350, "DME", "VIE", 2);
    private final TicketOffer eighthTicket = new TicketOffer(7, 300, "DME", "VIE", 2);
    private final TicketOffer ninthTicket = new TicketOffer(8, 300, "SVO", "GVA", 3);
    private final TicketOffer tenthTicket = new TicketOffer(9, 600, "DME", "VIE", 2);
    private final TicketOffer elevenTicket = new TicketOffer(10, 100, "GVA", "SVO", 3);
    private final TicketOffer twelveTicket = new TicketOffer(11, 700, "DME", "VIE", 2);

    private final TicketManager manager = new TicketManager(new RepoTicket());

    @BeforeEach
    void setDataOffers() {
        manager.add(firstTicket);
        manager.add(secondTicket);
        manager.add(thirdTicket);
        manager.add(fourthTicket);
        manager.add(fifthTicket);
        manager.add(sixthTicket);
        manager.add(seventhTicket);
        manager.add(eighthTicket);
        manager.add(ninthTicket);
        manager.add(tenthTicket);
        manager.add(elevenTicket);
        manager.add(twelveTicket);
    }

    @Test
    public void searchTicketByDestination_Gva_Svo() {
        TicketOffer[] expected = {elevenTicket, secondTicket};
        TicketOffer[] actual = manager.searchTicketByAirport("GVA", "SVO");
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);

    }

    @Test
    public void searchTicketByDestination_Dme_Vie() {
        TicketOffer[] expected = {fourthTicket, eighthTicket, seventhTicket, tenthTicket, twelveTicket, firstTicket, fifthTicket};
        TicketOffer[] actual = manager.searchTicketByAirport("DME", "VIE");
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);

    }
}