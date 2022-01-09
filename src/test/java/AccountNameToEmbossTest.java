
import io.qameta.allure.Description;
        import io.qameta.allure.Step;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.junit.runners.Parameterized;
        import static org.junit.Assert.assertEquals;
        import io.qameta.allure.junit4.DisplayName;

@RunWith(Parameterized.class)
public class AccountNameToEmbossTest {


    private String name;
    private boolean isOk;

    public AccountNameToEmbossTest(String name, boolean isOk){
        this.name=name;
        this.isOk=isOk;
    }
    @Step("Выбор тестовых данных")
    @Parameterized.Parameters
    public static Object[][] getNames() {
        return new Object[][] {
                {"Тимоти Шаломе", true},
                {" ТимотиШаломе", false},
                {"ТимотиШаломе ", false},
                {" ТимотиШаломе ", false},
                {"ТимотиШаломе", false},
                {null, false},
                {"",false},
                {"Т", false}
        };
    }
    @DisplayName("Проверка метода checkNameToEmboss")
    @Description("Параметризованный тест, проверяющий метод checkNameToEmboss класса Account" +
            " на наборе имён")
    @Test
    public void checkNameToEmbossTest(){
        Account account = new Account(name);
        assertEquals("Проверка метода checkNameToEmboss",isOk,account.checkNameToEmboss());
    }
}
