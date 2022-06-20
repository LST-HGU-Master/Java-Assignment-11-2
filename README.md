# 課題11-2: カプセル化

### 課題の説明
１）Swordクラスに以下の変更を加えなさい。
 - カプセル化する
 - コンストラクタやSetterから剣の名前を代入するときに２文字以下であれば `名無し剣` とする

２）課題11-1で作成したHeroクラスにSword型のフィールドswordを追加し、swordをカプセル化をしなさい。

３）最後にProgB2.mainメソッドに変更を加えて、カプセル化したコードで実行例のように動作するようにしなさい。

(注意)この課題では、Swordクラスのカプセル化並びにHeroクラスのカプセル化のために、ProgB2.main()からのアクセスが正しく変更されないと全てのテストでコンパイルエラーとなる

### Swordクラス（変更前）
```java
public class Sword
{
    String name; // 剣の名前

    public Sword(String name)
    {
        this.name = name;
    }
}
```
### Heroクラス（参考：カプセル化前のHeroクラスにSword型変数swordを追加した状態）
```java
public class Hero
{
    String name = "??";
    int hp = 0;
    Sword sword;

    public void run()
    {
        System.out.println(this.name + "は逃げ出した！");
    }
}
```

### ProgB2クラス（指示にあるカプセル化やフィールドの追加後も同様の結果が得られるように変更する）
```java
public class ProgB2 {
    public static void main(String[] args) {
        Hero h = new Hero();
        h.name = "太郎";
        h.hp = 100;

        System.out.println("勇者" + h.name + " (HP:" + h.hp + ") が誕生した！");

        Sword sword = new Sword("こんぼう");
        h.sword = sword;

        System.out.println("勇者は" + h.sword.name + "を装備した！");
    }
}

```

### 実行例
```
勇者太郎 (HP:100) が誕生した！
勇者はこんぼうを装備した！
```