public class Sword
{
    private String name; // 剣の名前

    public Sword(String namae)
    {
        //コンストラクタでも入力チェックをするためにsetterメソッドを使用する
        setName(namae);
    }

    public String getName(){
        return this.name;
    }

    public void setName(String newNamae){
        if(newNamae.length() <= 2) {
            this.name = "名無し剣";
        } else {
            this.name = newNamae;
        }
    }
}