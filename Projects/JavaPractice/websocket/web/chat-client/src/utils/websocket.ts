export function webSocketInit() {
    var websocket = new WebSocket("ws://127.0.0.1:8080/ws/serverTwo");

    //成功建立连接
    websocket.onopen = function () {
        websocket.send("成功连接到服务器");
    };

    //接收到消息
    websocket.onmessage = function (event) {
        console.log(event.data)
    };

    //连接发生错误
    websocket.onerror = function () {
        alert("WebSocket连接发生错误");
    };

    //连接关闭
    websocket.onclose = function () {
        alert("WebSocket连接关闭");
    };

    //监听窗口关闭事件，当窗口关闭时，主动关闭websocket连接
    window.onbeforeunload = function () {
        websocket.close()
    };

    return websocket;
}