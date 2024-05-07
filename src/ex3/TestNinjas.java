package ex3;

import org.junit.Test;

public class TestNinjas
{

    @Test
    public void testNinja()
    {
        Ninja n = new Ninja("Naruto", 100);
        assert n.getName().equals("Naruto");
        assert n.getHonor() == 100;
    }

    @Test
    public void testGuild()
    {
        Ninja n1 = new Ninja("Naruto", 100);
        Ninja n2 = new Ninja("Sasuke", 90);
        Ninja n3 = new Ninja("Sakura", 80);
        Ninja n4 = new Ninja("Kakashi", 70);
        Ninja n5 = new Ninja("Jiraiya", 60);
        Ninja n6 = new Ninja("Orochimaru", 50);
        Ninja n7 = new Ninja("Itachi", 40);
        Ninja n8 = new Ninja("Kisame", 30);
        Ninja n9 = new Ninja("Deidara", 20);
        Ninja n10 = new Ninja("Hidan", 10);
        Ninja n11 = new Ninja("Kakuzu", 0);

        Guild g = new Guild("Galesburg Assassins");
        assert g.getGuildName().equals("Galesburg Assassins");
        assert g.getNinjaCount() == 0;

        g.addNinja(n1);
        g.addNinja(n2);
        g.addNinja(n3);
        g.addNinja(n4);
        g.addNinja(n5);
        g.addNinja(n6);
        g.addNinja(n7);
        g.addNinja(n8);
        g.addNinja(n9);
        g.addNinja(n10);
        g.addNinja(n11);

        // this should make sure resizing works
        assert g.getNinjaCount() == 11;
    }

}
