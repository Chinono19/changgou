package com.chinono.weixin;

import com.github.wxpay.sdk.WXPayConfig;

import java.io.InputStream;

/**
 * Created by liangtong.
 */
public class MyWXPayConfig implements WXPayConfig {
    @Override
    public String getAppID() {      //应用ID
        return "wx8397f8696b538317";
    }

    @Override
    public String getMchID() {      //商户ID
        return "1473426802";
    }

    @Override
    public String getKey() {        //秘钥
        return "T6m9iK73b0kn9g5v426MKfHQH7X8rKwb";
    }

    @Override
    public InputStream getCertStream() {
        return null;
    }

    @Override
    public int getHttpConnectTimeoutMs() {
        return 0;
    }

    @Override
    public int getHttpReadTimeoutMs() {
        return 0;
    }
}
