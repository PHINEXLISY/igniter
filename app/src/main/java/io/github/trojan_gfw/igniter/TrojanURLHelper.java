package io.github.trojan_gfw.igniter;

import java.net.URI;

/*
* Torjan链接辅助
* */
public class TrojanURLHelper {
    public static String GenerateTrojanURL(TrojanConfig trojanConfig) {

        URI trojanUri;
        try {
            trojanUri = new URI("trojan",
                    trojanConfig.getPassword(),
                    trojanConfig.getRemoteAddr(),
                    trojanConfig.getRemotePort(),
                    null, null, null);
        } catch (java.net.URISyntaxException e) {
            e.printStackTrace();
            return null;
        }

        return trojanUri.toString();
    }

    public static TrojanConfig ParseTrojanURL(String trojanURLStr) {
        URI trojanUri;
        try {
            trojanUri = new URI(trojanURLStr);
        } catch (java.net.URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
        String scheme = trojanUri.getScheme();//获取URI资源的协议
        if (scheme == null) {
            return null;
        }
        if (!scheme.equals("trojan"))
            return null;
        String host = trojanUri.getHost();//获取主机名
        int port = trojanUri.getPort();//获取端口
        String userInfo = trojanUri.getUserInfo();//获取user信息(密码)

        TrojanConfig retConfig = new TrojanConfig();
        retConfig.setRemoteAddr(host);
        retConfig.setRemotePort(port);
        retConfig.setPassword(userInfo);
        return retConfig;
    }
}
