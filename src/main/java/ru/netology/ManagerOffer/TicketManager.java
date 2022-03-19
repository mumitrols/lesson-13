package ru.netology.ManagerOffer;

import ru.netology.domain.TicketOffer;
import ru.netology.repository.RepoTicket;

public class TicketManager {
    private final RepoTicket repo;

    public TicketManager(RepoTicket repo){
        this.repo = repo;
    }

    public void add(TicketOffer ticket){
        this.repo.save(ticket);
    }

    public TicketOffer[] searchTicketByAirport(String airportFrom, String airportTo){
        TicketOffer[] tickets = this.repo.listAll();
        TicketOffer[] result = new TicketOffer[0];
        for (TicketOffer ticket : tickets) {
            if (matches(ticket, airportFrom, airportTo)) {
                TicketOffer[] temp = new TicketOffer[result.length + 1];
                System.arraycopy(result, 0, temp, 0, result.length);
                temp[temp.length - 1] = ticket;
                result = temp;
            }
        }
        return result;
    }

    public boolean matches(TicketOffer ticket, String airportFrom, String airportTo) {
        if ((ticket.getAirportFrom().contains((airportFrom))) && (ticket.getAirportTo().contains((airportTo))) ) {
            return true;
        }
        return false;
    }

}
