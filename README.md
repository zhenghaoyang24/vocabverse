# vocabverse(Werse词境)
一个单词记忆网站。
## 实现功能🎖️
1. **邮箱注册与登录**：使用邮箱服务协议实现发送邮箱验证码注册；用户密码加密。
2. **单词学习**：利用[SuperMemo2算法](https://supermemo.guru/wiki/SuperMemo_1.0_for_DOS_(1987)#Algorithm_SM-2)思想实现基于单词难易度、掌握程度、复习天数推荐复习单词。
3. 每日**学习情况统计**；**每日打卡**。
4. **单词规划**：将单词加入或移除学习计划，标记或移除熟知。
5. **单词例句**：为单词添加例句，编辑或删除添加的例句；设置单词复习提示例句；单词例句点赞。
6. **词库管理**：添加私有或公有词库，编辑词库信息，添加或删除词库单词。
7. 单词**查询**与句子**翻译**：单词中英文动态查询，句子多语言翻译。
8. **AI助学**：AI单词造句，写作，句子润色，英语知识问答；AI回答反馈。
9. **数据统计**与**个人信息修改**：统计学习情况，学习量变化，更改个人信息与密码。
## 开发技术与环境🔬
前端：vue
后端：SSM框架，java8 1.8.0
数据库：MySQL 5.7.37
## 注意❗
 1.句子翻译使用了[百度通用文本翻译API](https://api.fanyi.baidu.com/product/113)，需在controller/TranslateController下，将appId与秘钥更改为自己的id与秘钥。
 2.AI功能使用了[文心一言API](https://cloud.baidu.com/doc/WENXINWORKSHOP/s/clntwmv7t)，需在utils/ERNIEBotUtils将API_Key与Secret_Key更改为自己的key。
 3.由于数据库单词量大（单词10万+，例句14万+），导入数据库会花费较多时间。
## 页面🪟
![image](https://github.com/zhenghaoyang24/vocabverse/assets/95458562/81fb1141-2e53-4b82-9d8b-3ab0ddb9f2b2)
![image](https://github.com/zhenghaoyang24/vocabverse/assets/95458562/2d207acb-e87f-4b81-9c48-6f03548e61bc)
![image](https://github.com/zhenghaoyang24/vocabverse/assets/95458562/03ee35ce-6af5-4545-aaac-037b8ee2c52e)
![image](https://github.com/zhenghaoyang24/vocabverse/assets/95458562/19601848-e5b4-4e64-afaa-610c61027e9b)
![image](https://github.com/zhenghaoyang24/vocabverse/assets/95458562/9aea1d67-1fd6-488a-8f00-07b1ebd2c594)




