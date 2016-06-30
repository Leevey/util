import com.jingsky.util.lang.DecryptionUtils;
import org.apache.shiro.codec.H64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.hash.Md5Hash;

import java.security.Key;

/**
 * Created by jing on 6/30/16.
 */
public class DecryptionUtilsTest {

    public void a(){
        ;
        String password = "123456";
        ;
        String cipherText = DecryptionUtils.encryptHex(password);
        System.out.println(password + "hex加密之后的密文是：" + cipherText);
        String decrptPassword= DecryptionUtils.decryptHex(cipherText);
        System.out.println(cipherText + "hex解密之后的密码是：" + decrptPassword);
        String cipherText_base64 = DecryptionUtils.encryptBase64(password);
        System.out.println(password + "base64加密之后的密文是：" + cipherText_base64);
        String decrptPassword_base64= DecryptionUtils.decryptBase64(cipherText_base64);
        System.out.println(cipherText_base64 + "base64解密之后的密码是：" + decrptPassword_base64);
        String h64=  H64.encodeToString(password.getBytes());
        System.out.println(h64);
        String salt="admin";
        String cipherText_md5= new Md5Hash(password,salt,2).toHex();
        System.out.println(password+"通过md5加密之后的密文是："+cipherText_md5);
        System.out.println("==========================================================");
        AesCipherService aesCipherService=new AesCipherService();
        aesCipherService.setKeySize(128);
        Key key=aesCipherService.generateNewKey();
        String aes_cipherText= aesCipherService.encrypt(password.getBytes(),key.getEncoded()).toHex();
        System.out.println(password+" aes加密的密文是："+aes_cipherText);
        String aes_mingwen=new String(aesCipherService.decrypt(Hex.decode(aes_cipherText),key.getEncoded()).getBytes());
        System.out.println(aes_cipherText+" aes解密的明文是："+aes_mingwen);
    }
}
