public class Hero
{
    private String name = "??";
    private int hp = 0;
    private Sword sword;

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName(){
        return this.name;
    }

    public int getHp() {
        return this.hp;
    }

    public Sword getSword() { return this.sword; }

    public void setSword(Sword swd)
    {
        this.sword = swd;
    }

    public void run()
    {
        System.out.println(this.name + "は逃げ出した！");
    }
}
