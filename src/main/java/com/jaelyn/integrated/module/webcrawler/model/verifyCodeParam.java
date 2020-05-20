package com.jaelyn.integrated.module.webcrawler.model;

/**
 * TODO
 *
 * @author jaelynz@gamil.com
 * @date 2020-05-20 15:40
 **/
public class verifyCodeParam {

    /**
     * platform : 4
     * fingerprint : {"innerHeight":667,"innerWidth":375,"devicePixelRatio":2,"availHeight":667,"availWidth":375,"height":667,"width":375,"colorDepth":24,"locationHerf":"http://yangkeduo.com/login.html?from=http%3A%2F%2Fyangkeduo.com%2Fpersonal.html%3Frefer_page_name%3Dindex%26refer_page_id%3D10002_1589958562831_fyd4rjpk99%26refer_page_sn%3D10002&refer_page_name=personal&refer_page_id=10001_1589958578435_cm63q9uid5&refer_page_sn=10001","referer":"personal","timezoneOffset":-480,"navigator":{"appCodeName":"Mozilla","appName":"Netscape","hardwareConcurrency":8,"language":"zh-CN","cookieEnabled":true,"platform":"Win32","doNotTrack":null,"ua":"Mozilla/5.0 (iPhone; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Mobile/15E148 Safari/604.1","vendor":"Google Inc.","product":"Gecko","productSub":"20030107"}}
     * touchevent : {"mobileInputEditStartTime":1589958602300,"mobileInputKeyboardEvent":"0|0|0|1090","mobileInputEditFinishTime":1589958603917,"sendSmsButtonTouchPoint":"334,87","sendSmsButtonClickTime":1589958828038,"smsInputEditStartTime":1589958828039,"smsInputKeyboardEvent":"0|0|0|","smsInputEditFinishTime":1589958828108}
     * mobile : 17605085072
     * screen_token : 0aoAfxsUHOcYY9dVUr-wvq39ZoTzG_KjOGJnKLg2UdSpvKTY3wskwX7Zv1i5fnK6nOaDG7K9L2VoEPvJUyCqEEn0r9BozHCok_Fs_FP_tXbmrbrbRN6wbQG9AwWTCiFaoZib_B89MFEWEQCtJtsizaXUiPomFV9rj0jgDasrlPz4iXHGD1waJc6MaBrwL9LdRwD7tZsS0XRqEOlF1ewl9WbpJhmx6XTWlW81NqSTAjWw5Rl50Sq-VD7iR47YeuqSibvSJiblppoWRDpn6JS_wXLL9jSFYzZBojFPl1adlxMoi4aMYp0xVT1JBK28AwI2cvbpfnasnI2BvR9-oMykzGsuSNkSpjU2vaMSduQ4-IK5ah-rDSZxLf1tdT80ttpU1K5aWPMMKEmaTQ0-BYEVamn_ymXtVmQzfIwIYaVbvtNIBcEzl3oVguBa5qxBokEwYgR0iCu6NXa8gAX8HdByS-cgmzTnkjUUctF2ONUcPL3pVbc9ZxZE_2JtheY3HZi3VnntalnJGGIc5q7Qmyox89n5uamxXlKqmXnu0tkphrT71ldh-KBKxoPDP-PHI0XuhOw_2rfOuyNJWoHLGTs2vc1VEz90k5TOnyKxvow1MgmY4byBZxv_5PwsvgVoMG53vbqAijmWdGuTDTZuQVoz2wt4VeFgThnHorUtzw0Y7_VDWOjoIZ9fZ1oVZD5epQjOStJO-7thegK-YW-M1doKy71nGO-cjhHA77My4oMvdbM3T7O-4n5_UR4-c71nDoAF2Ov-hT83n6UiDl0cCPGtQ6hRAAIowxtXJ9LxXbcyyZLI77tN7ZRHvQOIzNhDNeDyv3FrCcvnTk6
     */

    private String platform;
    private String fingerprint;
    private String touchevent;
    private String mobile;
    private String screen_token;

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public String getTouchevent() {
        return touchevent;
    }

    public void setTouchevent(String touchevent) {
        this.touchevent = touchevent;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getScreen_token() {
        return screen_token;
    }

    public void setScreen_token(String screen_token) {
        this.screen_token = screen_token;
    }
}
