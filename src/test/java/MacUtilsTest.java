import com.jingsky.util.os.MacUtils;

/**
 * Created by jing on 6/30/16.
 */
public class MacUtilsTest {

    public String a;
    public String b;

    public void a() throws Exception {
        System.out.println("mac: " + MacUtils.getMac());
		System.out.println("mac: " + MacUtils.getMACAddress());
    }
}
