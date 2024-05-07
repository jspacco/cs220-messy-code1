package ex3;

public class Guild
{
    private String guildName;
    private Ninja[] ninjas;
    private int count;

    public Guild(String guildName, Ninja[] ninjas)
    {
        this.guildName = guildName;
        this.ninjas = ninjas;
    }

    public Guild(String guildName)
    {
        // this() calls other constructors
        // so Guild(guildName) calls Guild(guildName, new Ninja[4])
        this(guildName, new Ninja[4]);
    }

    public void addNinja(Ninja ninja)
    {
        resize();
        ninjas[count] = ninja;
        count++;
    }

    private void resize()
    {
        if (count == ninjas.length)
        {
            Ninja[] newNinjas = new Ninja[ninjas.length * 2];
            for (int i = 0; i < count; i++)
            {
                newNinjas[i] = ninjas[i];
            }
            ninjas = newNinjas;
        }
    }

    public int getNinjaCount()
    {
        return count;
    }

    public String getGuildName()
    {
        return guildName;
    }

    public void printNinjas()
    {
        for (int i = 0; i < count; i++)
        {
            System.out.println(ninjas[i].getName() + " " + ninjas[i].getHonor());
        }
    }

}
