import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;
import io.qameta.allure.junit4.DisplayName;

@RunWith(Parameterized.class)
public class AccountNotNullTest {


    private String name;
    private boolean isOk;

    public AccountNotNullTest(String name, boolean isOk){
        this.name=name;
        this.isOk=isOk;
    }
    @Step("Выбор тестовых данных")
    @Parameterized.Parameters
    public static Object[][] getNames() {
        return new Object[][] {
                {null ,false},//null
                {""   , true},//0
                {" "  , true},//1
        };
    }
    @DisplayName("Проверка что строка не null")
    @Description("Параметризованный тест, проверяющий метод проверки стркои на null")
    @Test
    public void LengthOfTheStringMoreThenThreeAndLessThenNineteenTest(){
        Account account = new Account(name);
        assertEquals("Проверка что строка не null",isOk,account.checkThatStringIsNotNull());
    }
}
