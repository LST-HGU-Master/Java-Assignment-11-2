import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
/**
 * @version (20220610)
 */
public class SwordTest {
    @Test
    public void testPrivate() {
        try{
            // action
            Sword s = new Sword("こんぼう");
            Field name = s.getClass().getDeclaredField("name");

            assertEquals(Modifier.PRIVATE, name.getModifiers(),"Swordクラスのフィールドnameがprivate宣言されていません!");

        } catch (NoSuchFieldException e) {
            fail("Swordクラスのフィールドとして name が定義されていません!");
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

            assertEquals("銅の剣", name.get(s),"setName()の処理が不正です!");

        } catch (NoSuchMethodException nsme) {
            fail("SwordクラスにsetName()が定義されていない、もしくはpublic宣言されていません! ");
        } catch (IllegalAccessException iae) {
            fail("SwordクラスのsetName()がpublic宣言されていません! ");
        } catch (java.lang.reflect.InvocationTargetException ite) {
            fail("setName()内で例外が発生しました"); // 教員対応
        } catch (NoSuchFieldException nsfe) {
            fail("nameが宣言されていません!"); // これは発生しえない
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

            assertEquals("名無し剣", name.get(s), "２文字以下でのsetName()の処理が不正です!");
        } catch (Exception e) {
            // NoSuchMethodException, IllegalAccessException iae はtestSetter()でチェックしているので、ここでは無視
            fail();
        }
    }

    @Test
    public void testSetter3() {
        try{
            // action
            Sword s = new Sword("こ");

            Field name = s.getClass().getDeclaredField("name");
            name.setAccessible(true);

            assertEquals("名無し剣", name.get(s), "コンストラクタでの２文字以下でのフィールドnameの処理が不正です!");
        } catch (Exception e) {
            // NoSuchMethodException, IllegalAccessException iae はtestSetter()でチェックしているので、ここでは無視
            fail();
        }
    }

    @Test
    public void testGetter() {
        try{
            // action
            Sword s = new Sword("壊れた剣");
            Method getName = s.getClass().getMethod("getName");

            assertEquals("壊れた剣", getName.invoke(s),"getName()の戻り値が不正です!");

        } catch (NoSuchMethodException nsme) {
            fail("SwordクラスにgetName()が定義されていない、もしくはpublic宣言されていません! ");
        } catch (IllegalAccessException iae) {
            fail("SwordクラスのgetName()がpublic宣言されていません! ");
        } catch (java.lang.reflect.InvocationTargetException ite) {
            fail("getName()内で例外が発生しました"); // 教員対応
        }
    }
}
