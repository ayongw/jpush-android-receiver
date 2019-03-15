# jpush-receiver
对JPush推送服务Broadcast类的封装，将直接调用，改为通过消息中心发送消息。

## 项目依赖

    mplementation 'com.github.ayongw:simple-message-center:1.1.0'
    compileOnly 'cn.jiguang.sdk:jpush:3.1.8'  // 此处以JPush 3.1.1 版本为例。
    compileOnly 'cn.jiguang.sdk:jcore:1.2.7'  // 此处以JCore 1.1.9 版本为例。

## 使用配置
在AndroidManifest.xml文件中添加相应的Broadcast配置即可。

