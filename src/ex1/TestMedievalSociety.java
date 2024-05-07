package ex1;

import org.junit.Assert;
import org.junit.Test;

public class TestMedievalSociety
{

    @Test
    public void testMedievalSociety1()
    {
        Society society = new Society();
        society.addPerson(new MedievalPerson("John the Bald", MedievalType.NOBILITY));
        society.addPerson(new MedievalPerson("Bartholomew the Terrible", MedievalType.NOBILITY));
        society.addPerson(new MedievalPerson("Jane the Rich", MedievalType.NOBILITY));
        
        society.addPerson(new MedievalPerson("Jill", MedievalType.PEASANT));
        society.addPerson(new MedievalPerson("Jim", MedievalType.PEASANT));
        society.addPerson(new MedievalPerson("Jenny", MedievalType.PEASANT));

        assert society.getNobilityCount() == 3;
        assert society.getPeasantCount() == 3;

        assert society.getHungryNobilityCount() == 3;
        assert society.getHungryPeasantCount() == 3;

        int leftoverFood = society.feast(4);

        assert society.getHungryNobilityCount() == 0;
        assert society.getHungryPeasantCount() == 2;

        Assert.assertEquals(0, leftoverFood);
    }

    @Test
    public void testMedievalSociety2()
    {
        Society society = new Society();
        society.addPerson(new MedievalPerson("John the Bald", MedievalType.NOBILITY));
        society.addPerson(new MedievalPerson("Bartholomew the Terrible", MedievalType.NOBILITY));
        society.addPerson(new MedievalPerson("Jane the Rich", MedievalType.NOBILITY));
        
        society.addPerson(new MedievalPerson("Jill", MedievalType.PEASANT));
        society.addPerson(new MedievalPerson("Jim", MedievalType.PEASANT));
        society.addPerson(new MedievalPerson("Jenny", MedievalType.PEASANT));

        MedievalPerson john = society.get("John the Bald");
        john.eat();
        MedievalPerson bart = society.get("Bartholomew the Terrible");
        bart.eat();

        assert society.getNobilityCount() == 3;
        assert society.getPeasantCount() == 3;

        assert society.getHungryNobilityCount() == 1;
        assert society.getHungryPeasantCount() == 3;

        int leftoverFood = society.feast(4);

        assert society.getHungryNobilityCount() == 0;
        assert society.getHungryPeasantCount() == 0;

        Assert.assertEquals(0, leftoverFood);
    }

    
    
}
