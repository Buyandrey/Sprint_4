import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;
import io.qameta.allure.junit4.DisplayName;

@RunWith(Parameterized.class)
public class AccountLengthTest {

    private String name;
    private boolean isOk;

    public AccountLengthTest(String name,boolean isOk){
        this.name=name;
        this.isOk=isOk;
    }
    @Step("Выбор тестовых данных")
    @Parameterized.Parameters
    public static Object[][] getNames() {
        return new Object[][] {
                {""                         , false},//0
                {"tw"                       , false},//2
                {"thr"                      , true},//3
                {"four"                     , true},//4
                {"eighteenEighteenEi"       , true},//18
                {"nineteenNineteenNin"      , true},//19
                {"twentyTwentyTwentyTw"     , false},//20
        };
    }
    @DisplayName("Проверка длины строки")
    @Description("Параметризованный тест, проверяющий метод проверки длинны строки")
    @Test
    public void LengthOfTheStringMoreThenThreeAndLessThenNineteenTest(){
        Account account = new Account(name);
        assertEquals("Удовлетворительна ли длина",isOk,account.checkLengthOfTheStringMoreThenThreeAndLessThenNineteen());
    }
}
