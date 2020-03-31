package com.chinono.config;

import com.chinono.utils.RasUtils;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.security.PrivateKey;
import java.security.PublicKey;

@Component
@ConfigurationProperties(prefix = "sc.jwt")
@Data
public class JwtProperties {

    private String secret;//密钥
    private String pubKeyPath;//公钥
    private String priKeyPath; //私钥
    private int expire; //token过期时间

    private PublicKey publicKey; //公钥对象
    private PrivateKey privateKey; //私钥对象

    /* @PostConstruct 是SpringBean生命周期的注解 */
    @PostConstruct
    public void init(){
        File pubFIle = new File(this.pubKeyPath);
        File priFIle = new File(this.priKeyPath);
        //2)校验文件,不存在生产公钥和私钥
        if (!pubFIle.exists() || !priFIle.exists()){
            try {
                RasUtils.generateKey(this.pubKeyPath,this.priKeyPath,this.secret);
                this.publicKey = RasUtils.getPublicKey(this.pubKeyPath);
                this.privateKey = RasUtils.getPrivateKey(this.priKeyPath);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
