package com.github.ayongw.jpushreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.github.ayongw.simplemessagecenter.SimpleMessageCenter;

import java.util.HashMap;
import java.util.Map;

/**
 * JPush服务接口主要的消息接受类
 * <p> </p>
 * 可以使用此类，也可以使用自定的TS注册方式
 *
 * <p> </p>
 * <ul>
 * <li>用户接收sdk注册消息</li>
 * <li>sdk发送的消息</li>
 * <li>sdk发送的通知消息</li>
 * <li>网络连接变化信息等</li>
 * </ul>
 */
public class MessageCenterJPushApiReceiver extends BroadcastReceiver {
    /**
     * 定义的本消息的holder
     */
    public static final String MSG_HOLDER = JPushMessageCenterConts.JPUSH_API_MESSAGE_HOLDER;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (null == intent || TextUtils.isEmpty(intent.getAction())) {
            return;
        }

        //会获取所有的Intent中的扩展参数。
        Map<String, Object> userInfo = getUserInfo(intent);

        String msgName = JPushMessageCenterConts.MSG_ON_JPUSH_ACTION_PREFIX + intent.getAction();

        userInfo.put(JPushMessageCenterConts.FIELD_SMC_MSG_HOLDER, MSG_HOLDER);
        userInfo.put(JPushMessageCenterConts.FIELD_SMC_MSG_NAME, msgName);
        userInfo.put(JPushMessageCenterConts.FIELD_INTENT_ACTION, intent.getAction());

        SimpleMessageCenter.getDefaultCenter()
                .postMessage(msgName, MSG_HOLDER, userInfo);
    }

    /**
     * 从Intent中获取用户参数信息
     *
     * @param intent
     * @return
     */
    private Map<String, Object> getUserInfo(Intent intent) {
        Bundle extras = intent.getExtras();
        Map<String, Object> userInfo = new HashMap<>();
        if (null == extras || extras.size() == 0) {
            return userInfo;
        }

        for (String key : extras.keySet()) {
            Object obj = extras.get(key);
            if (null != obj) {
                userInfo.put(key, obj);
            }
        }
        return userInfo;
    }
}
