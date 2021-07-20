import com.kaung.Util.TokenUtil;
import com.kaung.pogo.User;
import com.kaung.service.UserService;
import org.junit.Test;


public class tokenTest {

    public static void main(String[] args) {
        String username = "123";
        String token = TokenUtil.sign(username);
        System.out.println(token);
        boolean status;
        if (TokenUtil.verify(token)) {
            status = true;
        } else {
            status = false;
        }
        System.out.println(status);
    }





}
