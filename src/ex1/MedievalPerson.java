package ex1;

public class MedievalPerson
{
    private String name;
    private MedievalType type;
    private boolean isHungry;

    public MedievalPerson(String name, MedievalType type)
    {
        this.name = name;
        this.type = type;
        this.isHungry = true;
    }

    public String getName()
    {
        return name;
    }

    public MedievalType getType()
    {
        return type;
    }


    public boolean isHungry()
    {
        return isHungry;
    }

    public void eat()
    {
        isHungry = false;
    }

}
