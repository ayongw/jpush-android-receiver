package com.github.ayongw.jpushreceiver;

import android.content.Context;

import com.github.ayongw.simplemessagecenter.SimpleMessageCenter;
import com.github.ayongw.simplemessagecenter.SimpleUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import cn.jpush.android.api.JPushMessage;
import cn.jpush.android.service.JPushMessageReceiver;

/**
 * 将JPush接受的操作消息反馈，转换到SimpleMessageCenter中，
 */
public class MessageCenterJPushOperateMessageReceiver extends JPushMessageReceiver {
    /**
     * 定义的本消息的holder
     */
    public static final String MSG_HOLDER = JPushMessageCenterConts.JPUSH_API_MESSAGE_HOLDER;

    @Override
    public void onTagOperatorResult(Context context, JPushMessage jPushMessage) {
        super.onTagOperatorResult(context, jPushMessage);
        String msgName = JPushMessageCenterConts.MSG_ON_TAG_OPERATOR_RESULT;

        SimpleMessageCenter.getDefaultCenter()
                .postMessage(msgName,
                        MSG_HOLDER,
                        getUserInfo(jPushMessage, msgName));
    }

    @Override
    public void onCheckTagOperatorResult(Context context, JPushMessage jPushMessage) {
        super.onCheckTagOperatorResult(context, jPushMessage);
        String msgName = JPushMessageCenterConts.MSG_ON_CHECK_TAG_OPERATOR_RESULT;

        SimpleMessageCenter.getDefaultCenter()
                .postMessage(msgName,
                        MSG_HOLDER,
                        getUserInfo(jPushMessage, msgName));
    }

    @Override
    public void onAliasOperatorResult(Context context, JPushMessage jPushMessage) {
        super.onAliasOperatorResult(context, jPushMessage);
        String msgName = JPushMessageCenterConts.MSG_ON_ALIAS_OPERATOR_RESULT;
        SimpleMessageCenter.getDefaultCenter()
                .postMessage(msgName,
                        MSG_HOLDER,
                        getUserInfo(jPushMessage, msgName));
    }

    @Override
    public void onMobileNumberOperatorResult(Context context, JPushMessage jPushMessage) {
        super.onMobileNumberOperatorResult(context, jPushMessage);

        String msgName = JPushMessageCenterConts.MSG_ON_MOBILE_NUMBER_OPERATOR_RESULT;
        SimpleMessageCenter.getDefaultCenter()
                .postMessage(msgName,
                        MSG_HOLDER,
                        getUserInfo(jPushMessage, msgName));
    }

    /**
     * 根据JPush消息，
     *
     * @param jPushMessage 收到的JPush操作通知原始消息
     * @param smcMsgName   消息的事件名称
     * @return 回调中使用的用户信息
     */
    private Map<String, Object> getUserInfo(JPushMessage jPushMessage, String smcMsgName) {
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put(JPushMessageCenterConts.FIELD_SMC_MSG_NAME, smcMsgName);
        userInfo.put(JPushMessageCenterConts.FIELD_SMC_MSG_HOLDER, MSG_HOLDER);
        userInfo.put(JPushMessageCenterConts.FIELD_ERROR_CODE, jPushMessage.getErrorCode());
        userInfo.put(JPushMessageCenterConts.FIELD_SEQUENCE, jPushMessage.getSequence());
        userInfo.put(JPushMessageCenterConts.FIELD_TAG_CHECK_STATE_RESULT, jPushMessage.getTagCheckStateResult());

        if (!SimpleUtils.isBlank(jPushMessage.getAlias())) {
            userInfo.put(JPushMessageCenterConts.FIELD_ALIAS, jPushMessage.getAlias());
        }
        if (!SimpleUtils.isBlank(jPushMessage.getCheckTag())) {
            userInfo.put(JPushMessageCenterConts.FIELD_CHECK_TAG, jPushMessage.getCheckTag());
        }
        if (!SimpleUtils.isBlank(jPushMessage.getMobileNumber())) {
            userInfo.put(JPushMessageCenterConts.FIELD_MOBILE_NUMBER, jPushMessage.getMobileNumber());
        }

        Set<String> tags = jPushMessage.getTags();
        if (null != tags && tags.size() > 0) {
            userInfo.put(JPushMessageCenterConts.FIELD_TAGS, tags);
        }


        return userInfo;
    }


}