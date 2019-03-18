# jpush-receiver
[ ![Download](https://api.bintray.com/packages/ayongw/maven/jpush-android-receiver/images/download.svg) ](https://bintray.com/ayongw/maven/jpush-android-receiver/_latestVersion)

对JPush推送服务Broadcast类的封装，将直接调用，改为通过消息中心发送消息。

## 项目依赖

    mplementation 'com.github.ayongw:simple-message-center:1.1.0'
    compileOnly 'cn.jiguang.sdk:jpush:3.1.8'  // 此处以JPush 3.1.1 版本为例。
    compileOnly 'cn.jiguang.sdk:jcore:1.2.7'  // 此处以JCore 1.1.9 版本为例。

## 使用配置
在AndroidManifest.xml文件中添加相应的Broadcast配置即可。
```
<!--用于接收种操作返回-->
<receiver android:name="com.github.ayongw.jpushreceiver.MessageCenterJPushOperateMessageReceiver">
    <intent-filter>
        <action android:name="cn.jpush.android.intent.RECEIVE_MESSAGE" />

        <category android:name="YOUR_APP_PACKAGE" />
    </intent-filter>
</receiver>
```
以上配置，会将各操作返回，以消息的发式发送到消息中 SimpleMessageCenter
发出的消息Holder为
    cn.jpush.android.service.JPushMessageReceiver
    
发出的消息类型有
    * "jpush.onTagOperatorResult"
    * "jpush.onCheckTagOperatorResult"
    * "jpush.onAliasOperatorResult"
    * "jpush.onMobileNumberOperatorResult"


```
<!--JPush api核心消息接受器-->
<receiver android:name="com.github.ayongw.jpushreceiver.MessageCenterJPushApiReceiver"
    android:exported="false"
    android:enabled="true">
    <intent-filter>
        <action android:name="cn.jpush.android.intent.REGISTRATION" /> <!--Required  用户注册SDK的intent-->
        <action android:name="cn.jpush.android.intent.MESSAGE_RECEIVED" /> <!--Required  用户接收SDK消息的intent-->
        <action android:name="cn.jpush.android.intent.NOTIFICATION_RECEIVED" /> <!--Required  用户接收SDK通知栏信息的intent-->
        <action android:name="cn.jpush.android.intent.NOTIFICATION_OPENED" /> <!--Required  用户打开自定义通知栏的intent-->
        <action android:name="cn.jpush.android.intent.CONNECTION" /><!-- 接收网络变化 连接/断开 since 1.6.3 -->

        <category android:name="YOUR_APP_PACKAGE" />
    </intent-filter>
</receiver>
```
发出的消息Holder为
    cn.jpush.android.api.JPushInterface
    
发出的消息类型有
    * "jpushapi.onReceive"