import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountSpacePlacementTest {

    private String name;
    private boolean isOk;

    public AccountSpacePlacementTest(String name,boolean isOk){
        this.name=name;
        this.isOk=isOk;
    }

    @Step("Выбор тестовых данных")
    @Parameterized.Parameters
    public static Object[][] getNames() {
        return new Object[][] {
                {"spacein therightplace",true},
                {" spaceatthebegining",false},
                {"spaceatattheend ",false}
        };
    }

    @DisplayName("Проверка положения пробела")
    @Description("Параметризованный тест, проверяющий метод проверки пробела в начале и в конце строки")
    @Test
    public void spaceInTheRightPlaceTest(){
        Account account = new Account(name);
        assertEquals("Удовлетворительное положение пробела",isOk,account.checkThatTheOnlyOneSpaceInTheStringNotInTheBeginAndNotInTheEndOfTheString());
    }
}
