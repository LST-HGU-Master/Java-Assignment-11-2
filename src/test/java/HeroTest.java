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
