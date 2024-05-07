package ex5;

import java.util.ArrayList;
import java.util.List;

public class TicketMaster
{
    // everyone waiting in line for tickets
    private List<Swiftie> line = new ArrayList<Swiftie>();

    private int numTickets = 0;

    public TicketMaster(int numTickets)
    {
        this.numTickets = numTickets;
    }

    public void add(Swiftie swiftie)
    {
        line.add(swiftie);
    }
    
    public Swiftie remove()
    {
        // remove them from the line
        Swiftie s = line.remove(0);

        if (numTickets == 0) {
            // no more tickets, so return null
            return null;
        }
        // there are tickets left! So, give them a ticket
        s.addTicket(new Ticket());

        // decrement the number of tickets left
        this.numTickets--;

        // then return them
        return s;
    }

}
