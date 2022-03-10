import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class SwordTest {
    @Test
    public void testPrivate() {
        try{
            // action
            Sword s = new Sword("こんぼう");
            Field name = s.getClass().getDeclaredField("name");

            assertEquals(Modifier.PRIVATE, name.getModifiers());

        } catch (Exception e) {
            // なにかしら例外がでたらfailにする
            fail();
        }
    }

    @Test
    public void testSetter() {
        try{
            // action
            Sword s = new Sword("こんぼう");
            Method setName = s.getClass().getMethod("setName", String.class);
            setName.invoke(s, "銅の剣");

            Field name = s.getClass().getDeclaredField("name");
            name.setAccessible(true);

            assertEquals("銅の剣", name.get(s));

        } catch (Exception e) {

        }
    }

    @Test
    public void testSetter2() {
        try{
            // action
            Sword s = new Sword("こんぼう");
            Method setName = s.getClass().getMethod("setName", String.class);
            setName.invoke(s, "あ");

            Field name = s.getClass().getDeclaredField("name");
            name.setAccessible(true);

            assertEquals("名無し剣", name.get(s));
        } catch (Exception e) {
            // なにかしら例外がでたらfailにする
            fail();
        }
    }

    @Test
    public void testGetter() {
        try{
            // action
            Sword s = new Sword("壊れた剣");
            Method getName = s.getClass().getMethod("getName");

            assertEquals("壊れた剣", getName.invoke(s));

        } catch (Exception e) {
            // なにかしら例外がでたらfailにする
            fail();
        }
    }
}
