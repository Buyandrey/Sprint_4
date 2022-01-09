import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountSpaceCountTest {

    private String name;
    private boolean isOk;

    public AccountSpaceCountTest(String name,boolean isOk){
        this.name=name;
        this.isOk=isOk;
    }

    @Step("Выбор тестовых данных")
    @Parameterized.Parameters
    public static Object[][] getNames() {
        return new Object[][] {
                {"stringwith onespace",true},
                {" stringwithonespace",true},
                {"stringwithonespace ",true},
                {"stringwithoutspace",false},
                {"stringwith two space",false},
        };
    }

    @DisplayName("Проверка количества пробелов")
    @Description("Параметризованный тест, проверяющий метод проверки количества пробелов")
    @Test
    public void onlyOneSpaceInTheStringTest(){
        Account account = new Account(name);
        assertEquals("Удовлетворительное количество пробелов",isOk,account.checkThatIsOnlyOneSpaceInTheString());
    }
}
