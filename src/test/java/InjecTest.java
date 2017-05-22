import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by howeTong on 2017/5/22 0022.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml",
"classpath:servlet-dispatcher.xml"})
public class InjecTest {

    @Value("${ly.key}")
    private String key;

    @Test
    public void test(){
        System.out.println("*********"+key);
    }
}
