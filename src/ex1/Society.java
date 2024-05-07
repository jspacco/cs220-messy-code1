package ex1;

import java.util.ArrayList;
import java.util.List;

public class Society
{
    private List<MedievalPerson> nobility = new ArrayList<>();
    private List<MedievalPerson> peasants = new ArrayList<>();

    public void addPerson(MedievalPerson person)
    {
        if (person.getType() == MedievalType.NOBILITY)
        {
            nobility.add(person);
        }
        else
        {
            peasants.add(person);
        }
    }

    public int getNobilityCount()
    {
        return nobility.size();
    }

    public int getPeasantCount()
    {
        return peasants.size();
    }

    public int getHungryNobilityCount()
    {
        int count = 0;
        for (MedievalPerson person : nobility)
        {
            if (person.isHungry()) count++;
        }
        return count;
    }

    public int getHungryPeasantCount()
    {
        // count method returns long so cast to int
        return (int)peasants.stream().filter(p -> p.isHungry()).count();
    }

    public int feast(int amountOfFood)
    {

        if (amountOfFood <= 0)
        {
            // or should we throw an exception?
            return 0;
        }

        // feed the nobility first
        int hungryNobles = getHungryNobilityCount();
        nobility.stream().filter(p -> p.isHungry()).limit(amountOfFood).forEach(p -> p.eat());
        amountOfFood -= hungryNobles;

        if (amountOfFood <= 0)
        {
            // no food left
            return 0;
        }
     
        // ok, now feed the peasants if there's anything left
        int hungryPeasants = getHungryPeasantCount();
        peasants.stream().filter(p -> p.isHungry()).limit(amountOfFood).forEach(p -> p.eat());
        amountOfFood -= hungryPeasants;
        if (amountOfFood < 0)
        {
            // we used all the food
            return 0;
        }
        // we have some leftovers!
        return amountOfFood;
    }

    public MedievalPerson get(String string)
    {
        for (MedievalPerson person : nobility)
        {
            if (person.getName().equals(string))
            {
                return person;
            }
        }
        return null;
    }
    
}
