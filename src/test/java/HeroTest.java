import org.junit.jupiter.api.Test;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

public class HeroTest {

    @Test
    public void testPrivate() {
        try{
            // action
            Hero h = new Hero();
            Field sword = h.getClass().getDeclaredField("sword");

            assertEquals(Modifier.PRIVATE, sword.getModifiers());

        } catch (Exception e) {
            // なにかしら例外がでたらfailにする
            fail();
        }
    }

    @Test
    public void testSetter() {
        try{
            // action
            Hero h = new Hero();
            Sword s = new Sword("こんぼう");
            Method setSword = h.getClass().getMethod("setSword", Sword.class);
            setSword.invoke(h, s);
            import org.junit.jupiter.api.Test;
            import java.io.*;
            import java.lang.reflect.Field;
            import java.lang.reflect.Method;
            import java.lang.reflect.Modifier;
            
            import static org.junit.jupiter.api.Assertions.*;
            /**
             * @version (20220608)
             */
            public class HeroTest {
            
                @Test
                public void testPrivate() {
                    try{
                        // action
                        Hero h = new Hero();
                        Field sword = h.getClass().getDeclaredField("sword");
            
                        assertEquals(Modifier.PRIVATE, sword.getModifiers(),"Heroクラスのフィールドswordがprivate宣言されていません!");
            
                    } catch (NoSuchFieldException e) {
                        fail("Heroクラスのフィールドとして sword が定義されていません!");
                    }
                }
            
                @Test
                public void testSetter() {
                    try{
                        // action
                        Hero h = new Hero();
                        Sword s = new Sword("こんぼう");
                        Method setSword = h.getClass().getMethod("setSword", Sword.class);
                        setSword.invoke(h, s);
            
                        Field sword = h.getClass().getDeclaredField("sword");
            
                        sword.setAccessible(true);
            
                        assertEquals(s, sword.get(h),"SwordクラスのsetSword()の処理が不正です!");
            
                    } catch (NoSuchMethodException nsme) {
                        fail("HeroクラスにsetSword(String 変数名)が定義されていない、もしくはpublic宣言されていません! ");
                    } catch (IllegalAccessException iae) {
                        // クラスが public でなかったり、別のパッケージに入っていたりするために、実行中のメソッドが指定されたクラスの定義にアクセスできない場合にスローされる例外
                        fail("HeroクラスのsetSword()がpublic宣言されていません! ");
                    } catch (java.lang.reflect.InvocationTargetException ite) {
                        fail("setSword()内で例外が発生しました"); // 教員対応
                    } catch (NoSuchFieldException nsfe) {
                        fail("Heroクラスにフィールド sword が定義されていません! "); //この例外は発生しないはず
                    }
                }
             
                @Test
                public void testGetter() {
                    try{
                        // action
                        Hero h = new Hero();
                        Sword s = new Sword("こんぼう");
                        Method setSword = h.getClass().getMethod("setSword", Sword.class);
                        setSword.invoke(h, s);
            
                        Field sword = h.getClass().getDeclaredField("sword");
                        sword.setAccessible(true);
            
                        Method getSword = h.getClass().getMethod("getSword");
            
                        assertEquals(s, getSword.invoke(h), "Hero.getSwordの戻り値が不正です!");
            
                    } catch (NoSuchMethodException nsme) {
                        fail("HeroクラスにgetSword()が定義されていない、もしくはpublic宣言されていません! ");
                    } catch (IllegalAccessException iae) {
                        fail("HeroクラスのgetSword()がpublic宣言されていません! ");
                    } catch (java.lang.reflect.InvocationTargetException ite) {
                        fail("getSword()内で例外が発生しました"); // 教員対応
                    } catch (NoSuchFieldException nsfe) {
                        fail("Heroクラスにフィールド sword が定義されていません! "); //この例外は発生しないはず
                    }    
                }
            
            }
            
            Field sword = h.getClass().getDeclaredField("sword");

            sword.setAccessible(true);

            assertEquals(s, sword.get(h));

        } catch (Exception e) {
            // なにかしら例外がでたらfailにする
            fail();
        }
    }

    @Test
    public void testGetter() {
        try{
            // action
            Hero h = new Hero();
            Sword s = new Sword("こんぼう");
            Method setSword = h.getClass().getMethod("setSword", Sword.class);
            setSword.invoke(h, s);

            Field sword = h.getClass().getDeclaredField("sword");
            sword.setAccessible(true);

            Method getSword = h.getClass().getMethod("getSword");

            assertEquals(s, getSword.invoke(h));

        } catch (Exception e) {
            // なにかしら例外がでたらfailにする
            fail();
        }
    }

}
