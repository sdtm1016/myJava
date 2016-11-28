package security;

import java.security.MessageDigest;
import java.util.Arrays;

import org.junit.Test;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
/**
 * eclipse中导入Base64如果保存请在项目remove掉jre,然后重新导入jre即可
 */
public class MDTest {
	@Test
	public void testMD() {
		try {
			String username = "Vicky";
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(username.getBytes());
			//(messageDigest.digest()得到的是个二进制byte数组
			System.out.println(Arrays.toString(messageDigest.digest()));
			//有可能某些byte是不可打印的字符,我们可以使用Base64来处理byte[]
			System.out.println(Base64.encode(messageDigest.digest()));

			//System.out.println(toHex(messageDigest.digest()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
