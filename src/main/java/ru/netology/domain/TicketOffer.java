package ru.netology.domain;

public class TicketOffer implements Comparable<TicketOffer> {
    private long id;
    private int price;
    public String airportFrom;
    public String airportTo;
    public int travelTime;

    public TicketOffer() {
    }

    public TicketOffer(int id, int price, String airportFrom, String airportTo, int travelTime) {
        this.id = id;
        this.price = price;
        this.airportFrom = airportFrom;
        this.airportTo = airportTo;
        this.travelTime = travelTime;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAirportFrom(String airportFrom) {
        this.airportFrom = airportFrom;
    }

    public void setAirportTo(String getAirportTo) {
        this.airportTo = airportTo;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    public long getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getAirportFrom() {
        return airportFrom;
    }

    public String getAirportTo() {
        return airportTo;
    }

    public int getTravelTime() {
        return travelTime;
    }

    @Override
    public int compareTo(TicketOffer o) {
        return this.price - o.price;
    }
}
