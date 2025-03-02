# Vocabverse (词境)

一个专注于单词记忆的网站。

## 实现功能 🎖

1. **邮箱注册与登录**：
   - 使用邮箱服务协议发送验证码进行注册。
   - 用户密码加密存储，确保安全性。

2. **单词学习**：
   - 基于 [SuperMemo2 算法](https://supermemo.guru/wiki/SuperMemo_1.0_for_DOS_(1987)#Algorithm_SM-2) 实现单词复习推荐。
   - 根据单词难易度、掌握程度和复习天数动态调整学习计划。

3. **学习统计与打卡**：
   - 每日学习情况统计，帮助用户了解学习进度。
   - 每日打卡功能，激励用户坚持学习。

4. **单词规划**：
   - 将单词加入或移除学习计划。
   - 标记或移除已熟知的单词。

5. **单词例句**：
   - 为单词添加、编辑或删除例句。
   - 设置单词复习时的提示例句。
   - 例句点赞功能，帮助用户筛选优质例句。

6. **词库管理**：
   - 添加私有或公有词库。
   - 编辑词库信息，添加或删除词库中的单词。

7. **单词查询与句子翻译**：
   - 单词中英文动态查询。
   - 句子多语言翻译功能。

8. **AI 助学**：
   - AI 单词造句、写作、句子润色及英语知识问答。
   - 用户可对 AI 回答进行反馈，帮助优化 AI 表现。

9. **数据统计与个人信息管理**：
   - 统计学习情况，展示学习量变化。
   - 支持修改个人信息与密码。

## 开发技术与环境 🔬

- **前端**：Vue.js
- **后端**：SSM 框架（Spring + Spring MVC + MyBatis），Java 8 (1.8.0)
- **数据库**：MySQL 5.7.37

## 注意事项 (必读) ❗

### 翻译功能  
使用了 [百度通用文本翻译 API](https://api.fanyi.baidu.com/product/113)。  
需在 `controller/TranslateController` 中，将 `appId` 和 `秘钥` 替换为自己的 ID 和秘钥。

```java
// 
public String translate(String inputText,String toLanguageEn){
   //appid
   String appId="XXX";
   //秘钥
   String userCode="XXX";  
   // ......
}
```

### AI 功能  
使用了 [文心一言 API](https://cloud.baidu.com/doc/WENXINWORKSHOP/s/clntwmv7t)。   
需在 `utils/ERNIEBotUtils` 中，将 `API_Key` 和 `Secret_Key` 替换为自己的 Key。

```java
// utils/ERNIEBotUtils
public class ERNIEBotUtils {
   private static String API_Key = "XXX";
   private static String Secret_Key = "XXX";
   // ......
}
```

### 邮箱注册功能
需要开启邮箱的 `POP3/SMTP/IMAP` 服务。  
在 `utils/SendMailCodeUtil.java` 中，将 `String myEmailAddr = "XXX@mail.com";` 替换为自己的邮箱地址，`transport.connect("smtp.qq.com", myEmailAddr, "XXXXXXX");` 替换为自己的邮箱授权码。  
开启 `QQ 邮箱` 服务的教程可参考 [此链接](https://blog.csdn.net/qq_42263280/article/details/129584017)。

```java
public static void  sendMail(String to, String code) {
    // 邮箱
    String myEmailAddr = "XXX@mail.com";
    try {
        //授权码
        transport.connect("smtp.qq.com", myEmailAddr, "XXXXXXX");
    }
}
```

### 数据库导入
由于数据库单词量较大（单词 10 万+，例句 14 万+），导入数据库可能需要较长时间。

## 页面预览 👀

![image](https://github.com/zhenghaoyang24/vocabverse/assets/95458562/81fb1141-2e53-4b82-9d8b-3ab0ddb9f2b2)  
![image](https://github.com/zhenghaoyang24/vocabverse/assets/95458562/2d207acb-e87f-4b81-9c48-6f03548e61bc)  
![image](https://github.com/zhenghaoyang24/vocabverse/assets/95458562/03ee35ce-6af5-4545-aaac-037b8ee2c52e)  
![image](https://github.com/zhenghaoyang24/vocabverse/assets/95458562/19601848-e5b4-4e64-afaa-610c61027e9b)  
![image](https://github.com/zhenghaoyang24/vocabverse/assets/95458562/9aea1d67-1fd6-488a-8f00-07b1ebd2c594)
