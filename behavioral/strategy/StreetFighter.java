package behavioral.strategy;

interface KickBehavior {
    public void kick();
}

interface JumpBehavior {
    public void jump();
}

class LightningKick implements KickBehavior
{
    public void kick() {
        System.out.println("Lightning Kick");
    }
}

class TornadoKick implements KickBehavior
{
    public void kick() {
        System.out.println("Tornado Kick");
    }
}

class ShortJump implements JumpBehavior
{
    public void jump() {
        System.out.println("Short Jump");
    }
}
class LongJump implements JumpBehavior
{
    public void jump() {
        System.out.println("Long Jump");
    }
    
}

abstract class Fighter {
    KickBehavior kickBehavior;
    JumpBehavior jumpBehavior;

    Fighter(KickBehavior kickBehavior, JumpBehavior jumpBehavior) {
        this.jumpBehavior = jumpBehavior;
        this.kickBehavior = kickBehavior;
    }

    public void punch() {
        System.out.println("Default Punch");
    }

    public void roll() {
        System.out.println("Default Roll");
    }

    public void kick() {
        // delegate to kick behavior
        kickBehavior.kick();
    }

    public void jump() {
        jumpBehavior.jump();
    }

    public void setKickBehavior(KickBehavior kickBehavior) {
        this.kickBehavior = kickBehavior;
    }

    public void setJumpBehavior(JumpBehavior jumpBehavior) {
        this.jumpBehavior = jumpBehavior;
    }

    public abstract void display();
}

class Ryu extends Fighter {
    public Ryu(KickBehavior kickBehavior, JumpBehavior jumpBehavior) {
        super(kickBehavior,jumpBehavior);
    }
    public void display() {
        System.out.println("Ryu");
    }
}

class Ken extends Fighter {
    public Ken(KickBehavior kickBehavior, JumpBehavior jumpBehavior) {
        super(kickBehavior, jumpBehavior);
    }
    public void display() {
        System.out.println("Ken");
    }
}

class ChunLi extends Fighter {
    public ChunLi(KickBehavior kickBehavior, JumpBehavior jumpBehavior) {
        super(kickBehavior,jumpBehavior);
    }
    public void display()
    {
        System.out.println("ChunLi");
    }
}

class StreetFighter {
    public static void main(String[] args) {
        // let us make some behaviors first
        JumpBehavior shortJump = new ShortJump();
        JumpBehavior LongJump = new LongJump();
        KickBehavior tornadoKick = new TornadoKick();

        // Make a fighter with desired behaviors
        Fighter ken = new Ken(tornadoKick, shortJump);
        ken.display();

        // Test behaviors
        ken.punch();
        ken.kick();
        ken.jump();

        // Change behavior dynamically (algorithms are
        // interchangeable)
        ken.setJumpBehavior(LongJump);
        ken.jump();
    }
}

