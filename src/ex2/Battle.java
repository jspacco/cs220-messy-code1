package ex2;

import java.util.Random;

public class Battle
{
    static Random random = new Random(1);

    public static void attack(Knight attacker, Knight defender)
    {
        int damage = random.nextInt(attacker.strength) + 1;
        defender.health -= damage;
    }

    public static void main(String[] args)
    {
        Knight knight1 = new Knight("Arthur", 10, 100);
        Knight knight2 = new Knight("Lancelot", 10, 100);

        while (knight1.health > 0 && knight2.health > 0)
        {
            attack(knight1, knight2);
            if (knight2.health > 0) attack(knight2, knight1);
        }

        if (knight1.health <= 0)
        {
            System.out.println(knight2.name + " wins! with " + knight2.health + " health left.");
        }
        else
        {
            System.out.println(knight1.name + " wins! with " + knight1.health + " health left.");
        }
    }

}
