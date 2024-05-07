package ex4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class NinjaGuild
{
    // nindex is "ninja index"
    private Map<String, Integer> nindex = new HashMap<>();
    private int count = 0;
    private List<Integer> honor = new ArrayList<>();
    private List<Integer> strength = new ArrayList<>();
    private List<Integer> health = new ArrayList<>();

    public void addNinja(String name, int honor, int strength, int health)
    {
        nindex.put(name, count);
        this.honor.add(honor);
        this.strength.add(strength);
        this.health.add(health);
        count++;
    }

    public int getNinjaCount()
    {
        return count;
    }

    public int getHonor(String name)
    {
        return honor.get(nindex.get(name));
    }

    public int getStrength(String name)
    {
        return strength.get(nindex.get(name));
    }

    public int getHealth(String name)
    {
        return health.get(nindex.get(name));
    }

    public void setHonor(String name, int honor)
    {
        this.honor.set(nindex.get(name), honor);
    }

    public void setStrength(String name, int strength)
    {
        this.strength.set(nindex.get(name), strength);
    }

    public void setHealth(String name, int health)
    {
        this.health.set(nindex.get(name), health);
    }

    public boolean isAlive(String name)
    {
        return health.get(nindex.get(name)) > 0;
    }

    public void deleteNinja(String name)
    {
        int index = nindex.get(name);
        if (index == -1)
        {
            throw new IllegalArgumentException("Ninja " +name+ " not found");
        }
        nindex.remove(name);
        honor.remove(index);
        strength.remove(index);
        health.remove(index);
        count--;
    }

    public int makeAttack(String second, Random r) {
        // generates a random number between 1 and the strength of the ninja
        return r.nextInt(strength.get(nindex.get(second))) + 1;
    }

}
