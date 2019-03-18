package com.github.ayongw.jpushreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

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
        String msgName = JPushMessageCenterConts.MSG_ON_RECEIVE;

        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put(JPushMessageCenterConts.FIELD_SMC_MSG_HOLDER, msgName);
        userInfo.put(JPushMessageCenterConts.FIELD_SMC_MSG_NAME, MSG_HOLDER);
        userInfo.put(JPushMessageCenterConts.FIELD_RECEIVE_INTENT, intent);
        SimpleMessageCenter.getDefaultCenter()
                .postMessage(msgName, MSG_HOLDER, userInfo);
    }

}
