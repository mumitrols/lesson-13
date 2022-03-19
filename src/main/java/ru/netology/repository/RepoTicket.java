package ru.netology.repository;

import ru.netology.domain.NotFoundException;
import ru.netology.domain.TicketOffer;

public class RepoTicket {
    private TicketOffer[] tickets = new TicketOffer[0];

    public void save(TicketOffer ticket){
        TicketOffer[] temp = new TicketOffer[tickets.length + 1];
        System.arraycopy(tickets, 0, temp, 0, tickets.length);
        temp[temp.length - 1] = ticket;
        this.tickets = temp;
    }

    public TicketOffer[] listAll() {
        return this.tickets;
    }

    public TicketOffer findById(long id) {
        for (TicketOffer ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public void removeById(long id) {

        if (findById(id) == null) throw new NotFoundException("Element with id: " + id + " not found");

        TicketOffer[] temp = new TicketOffer[tickets.length - 1];
        int index = 0;
        for (TicketOffer ticket : tickets) {
            if (ticket.getId() != id) {
                temp[index] = ticket;
                index++;
            }
            if (findById(id) == null) {
                return;
            }
        }
        tickets = temp;
    }


}
