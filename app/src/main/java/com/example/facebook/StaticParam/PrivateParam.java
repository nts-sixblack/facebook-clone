package com.example.facebook.StaticParam;

import com.example.facebook.Obj.UserV2;

public class PrivateParam {
    private static UserV2 USER;

    public static UserV2 getUSER() {
        return USER;
    }

    public static void setUSER(UserV2 USER) {
        PrivateParam.USER = USER;
    }
}
