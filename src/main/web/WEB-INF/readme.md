## 网站信息
zhenghaoyang24@foxmail.com
123456
### 色调

黑色:#1a1a1a
绿色:#00e57b  了如指掌
蓝色:#50a7ff  恍然大悟
橙色:#ff9000  模模糊糊
红色:#ff0000  茫无所知

## 开发中的问题

### 1. 利用form的action执行网络接口，无法接受返回值

**时间**
2023-12-12

**问题说明：** 若要利用input的自动检测功能（例如required="required"、type="email"
），则必须利用form的action执行网络接口，且提交方式为type="submit"，
但是action执行网络接口无法接受返回值， 导致无法接收如登录注册功能服务端响应的结果
。若舍弃input的自动表单验证，手写每个表单的验证很麻烦，因此要解决利用form
提交表单数据无法接收返回数据的问题

**解决方法：** 利用iframe标签将form绑定，返回值将返回位在iframe上的页面，再获取页面中body的内容，即返回数据。

**步骤与代码**

1. 利用iframe标签将form绑定，iframe标签的id与name要与form标签的target的值相同

```html

<form class="input-form" method="post" action="user/userSignIn" target="signInIframe">
    <iframe name="signInIframe" id="signInIframe" style="display: none"></iframe>
```

2. 若不想利用iframe直接显示返回结果，则利用js获取iframe的body的内容，将获取的内容赋值给一个vue创建的变量，则可对返回值进行其他处理

```js
setSignInMsg()
{
    var iframe = document.getElementById("signInIframe")
    var iframeDocument = iframe.contentDocument
    var iframeBody = iframeDocument.body
    this.otherMsg = iframeBody.innerHTML;
}
```

**强调：** 这个过程很有可能发生由于异步导致第一次获取不到iframe的内容，因此需要可以setTimeout处理。

```js
setTimeout(() => {
    // 对变量进行其他处理
}, 1200);
setTimeout(() => {
    // 获取iframe的body的内容，并赋值给vue创建的变量
}, 500);
```


