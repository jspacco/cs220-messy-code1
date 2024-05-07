package ex5;

public class Ticket
{
    // total number of tickets given out so far
    private static int ticketCounter = 0;
    
    private int ticketNumber;

    public static int getTicketCounter()
    {
        return ticketCounter;
    }

    public Ticket()
    {
        // using static for the win!
        ticketNumber = ticketCounter;
        ticketCounter++;
    }

    public int getTicketNumber()
    {
        return ticketNumber;
    }

}
