package ex5;



public class TestTicketMaster
{

    public static void main(String[] args)
    {
        int num = 1000000;

        System.out.println("HELLO");
        
        TicketMaster ticketMaster = new TicketMaster(num + 1);

        // put 1,000,000 swifties in line for tickets
        for (int i=0; i<num; i++) {
            Swiftie swiftie = new Swiftie("Taylorfan"+i, "Love Story");
            ticketMaster.add(swiftie);
        }

        // now add Travis Kelce to the line
        ticketMaster.add(new Swiftie("Travis", "all of them"));

        long start = System.currentTimeMillis();
        for (int i=0; i<num; i++){
            ticketMaster.remove();
        }
        long end = System.currentTimeMillis();
        System.out.println("Time to process " + num + " tickets: " + (end-start)/1000 + "sec");

        Swiftie swiftie = ticketMaster.remove();
        
        // Travis should be the last one in line
        // this assertion will throw an exception if it's not Travis
        if (!swiftie.getName().equals("Travis")) {
            throw new RuntimeException("Travis should be the last one in line!");
        }



    }

}
