# 課題11-2: カプセル化

### 課題の説明
課題11-1で作成したプログラムに、以下のSwordクラスを追加したい。
Swordクラスに以下の変更を加えなさい。
- Swordクラスをカプセル化する
- コンストラクタやSetterから剣の名前を代入するときに２文字以下であれば `名無し剣` とする
またHeroクラスにSword型のフィールドを追加し、カプセル化すること。

### Swordクラス
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

### ProgB2.java
```java
public class ProgB2 {
    public static void main(String[] args) {
        Hero h = new Hero();
        h.name = "太郎";
        h.hp = 100;

        System.out.println("勇者" + h.name + " (HP:" + h.hp + ") が誕生した!");

        Sword sword = new Sword("こんぼう");
        h.sword = sword;

        System.out.println("勇者は" + h.sword.name + "を装備した!");
    }
}

```

### 実行例
```
勇者太郎 (HP:100) が誕生した!
勇者はこんぼうを装備した!
```