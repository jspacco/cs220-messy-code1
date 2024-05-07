package ex4;

import java.util.Random;
import org.junit.Test;

public class BattleTest
{
    @Test
    public void testBattle()
    {
        NinjaGuild ng = new NinjaGuild();
        ng.addNinja("Naruto", 100, 100, 100);
        ng.addNinja("Sasuke", 90, 90, 90);
        ng.addNinja("Sakura", 80, 80, 80);
        ng.addNinja("Kakashi", 70, 70, 70);
        ng.addNinja("Jiraiya", 60, 60, 60);
        ng.addNinja("Orochimaru", 50, 50, 50);
        ng.addNinja("Itachi", 40, 40, 40);
        ng.addNinja("Kisame", 30, 30, 30);
        ng.addNinja("Deidara", 20, 20, 20);
        ng.addNinja("Hidan", 10, 10, 10);
        ng.addNinja("Kakuzu", 0, 0, 0);

        assert ng.getNinjaCount() == 11;

        assert ng.getHonor("Naruto") == 100;
        assert ng.getStrength("Naruto") == 100;
        assert ng.getHealth("Naruto") == 100;

        assert ng.getHonor("Sasuke") == 90;
        assert ng.getStrength("Sasuke") == 90;
        assert ng.getHealth("Sasuke") == 90;

        assert ng.getHonor("Sakura") == 80;
        assert ng.getStrength("Sakura") == 80;
        assert ng.getHealth("Sakura") == 80;

        assert ng.getHonor("Kakashi") == 70;
        assert ng.getStrength("Kakashi") == 70;
        assert ng.getHealth("Kakashi") == 70;

        assert ng.getHonor("Jiraiya") == 60;
        assert ng.getStrength("Jiraiya") == 60;
        assert ng.getHealth("Jiraiya") == 60;

        assert ng.getHonor("Orochimaru") == 50;
        assert ng.getStrength("Orochimaru") == 50;
        assert ng.getHealth("Orochimaru") == 50;
    }

    @Test
    public void testBattle1()
    {
        String p1 = "Ryu";
        String p2 = "Liu Kang";

        NinjaGuild guild = new NinjaGuild();
        guild.addNinja(p1, 100, 10, 100);
        guild.addNinja(p2, 90, 10, 100);

        String first = p1;
        String second = p2;
        Random r = new Random();
        while (guild.getHealth(p1) > 0 && guild.getHealth(p2) > 0)
        {
            // randomly decide who attacks first
            if (r.nextBoolean())
            {
                first = p1;
                second = p2;
            }
            else
            {
                first = p2;
                second = p1;
            }
            guild.setHealth(first, guild.getHealth(first) - guild.makeAttack(second, r));
            if (guild.isAlive(second))
                guild.setHealth(second, guild.getHealth(second) - guild.makeAttack(first, r));
        }

        if (guild.getHealth(p1) > 0)
        {
            assert guild.getHonor(p1) == 100;
            assert guild.getStrength(p1) == 10;
            assert guild.getHonor(p2) == 90;
            assert guild.getStrength(p2) == 10;
            // p2 should be dead
            assert guild.getHealth(p2) <= 0;
        }
        else
        {
            assert guild.getHonor(p1) == 100;
            assert guild.getStrength(p1) == 10;
            // p1 should be dead
            assert guild.getHealth(p1) <= 0;
            assert guild.getHonor(p2) == 90;
            assert guild.getStrength(p2) == 10;
            assert guild.getHealth(p2) > 0;
        }

    }

}
