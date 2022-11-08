import java.util.Arrays;
import java.util.List;

public class TestFunctions {
    public static void apiLoop(){
        List<String> email= Arrays.asList("dodo", "moshr", "pp","koko","lolo","ss","so","q","v","v","c","xx","zls");;
        for (int i=0 ;i>20;i++){
            testAPI.PostApi(email.get(i));
        }
    }
}
