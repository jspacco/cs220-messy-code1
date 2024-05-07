package ex5;

import java.util.ArrayList;
import java.util.List;

public class Swiftie
{
    private String name;
    private String favoriteSong;
    private List<Ticket> tickets = new ArrayList<Ticket>();

    public Swiftie(String name, String favoriteSong)
    {
        this.name = name;
        this.favoriteSong = favoriteSong;
    }

    public String getName() {
        return name;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public String getFavoriteSong() {
        return favoriteSong;
    }

    public int getNumTickets() {
        return tickets.size();
    }

}
