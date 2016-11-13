package security;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.junit.Test;

import java.security.MessageDigest;
import java.util.Arrays;

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
