package com.github.ayongw.jpushreceiver;

public interface JPushMessageCenterConts {
    /**
     * 操作类消息holder 也相当于一个路由的名称
     */
    String OPERATE_MESSAGE_HOLDER = "cn.jpush.android.service.JPushMessageReceiver";
    /**
     * 主要的消息holder
     */
    String JPUSH_API_MESSAGE_HOLDER = "cn.jpush.android.api.JPushInterface";

    String MSG_ON_TAG_OPERATOR_RESULT = "jpush.onTagOperatorResult";

    String MSG_ON_CHECK_TAG_OPERATOR_RESULT = "jpush.onCheckTagOperatorResult";

    String MSG_ON_ALIAS_OPERATOR_RESULT = "jpush.onAliasOperatorResult";

    String MSG_ON_MOBILE_NUMBER_OPERATOR_RESULT = "jpush.onMobileNumberOperatorResult";

    String MSG_ON_RECEIVE = "jpushapi.onReceive";



    String FIELD_SMC_MSG_NAME = "smcMsgName";
    String FIELD_SMC_MSG_HOLDER = "smcMsgHolder";

    String FIELD_ERROR_CODE = "errorCode";
    String FIELD_SEQUENCE = "sequence";
    String FIELD_TAG_CHECK_STATE_RESULT = "tagCheckStateResult";
    String FIELD_ALIAS = "alias";
    String FIELD_CHECK_TAG = "checkTag";
    String FIELD_MOBILE_NUMBER = "mobileNumber";
    String FIELD_TAGS = "tags";

    String FIELD_RECEIVE_INTENT = "receiveIntent";
}
