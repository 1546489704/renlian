<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/10
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>人脸识别-登陆</title>
    <style type="text/css">
        *{
            padding: 0;
            margin: 0;
        }
        body{
            background: url("images/bj.jpg");
        }
        h1{
            color: #ff3d33;
            text-align: center;
            margin-top: 40px;
        }
        #media{
            height: 300px;
            width: 400px;
            margin: 100px auto 0;
            border-radius: 20px;
            overflow: hidden;
            opacity: 0.9;
        }
        #btn{
            width: 160px;
            height: 50px;
            background-color: #ff3d33;
            margin:80px auto 0;
            text-align: center;
            line-height: 50px;
            color: white;
            border-radius: 40px;
        }
        #canvas{
            display: none;
        }
    </style>
</head>
<body>
    <h1>风风博客后台管理系统</h1>
    <div id="media">
        <video id="video" width="400" height="300" autoplay></video>
        <canvas id="canvas" width="400" height="300"></canvas>
    </div>
    <div id="btn" onclick="query()">登陆</div>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
    var video = document.getElementById("video");
    var context = canvas.getContext("2d");
    //媒体数据
    var con = {
        audio:false,
        video:{
            width:1920,
            height:1080,
        }
    };
    //获取用户媒体对象
    navigator.mediaDevices.getUserMedia(con).then(function (stream) {
        video.src=window.URL.createObjectURL(stream);
        video.onloadmetadata=function (e) {
            video.play();
        }
    }).catch(function (err) {
        console.log(err.name+":"+err.message);
    });
    $("#btn").click(function () {
        location.href="login.jsp";''
    });
    function query() {
        //把流媒体数据滑到canvas画布上
        context.drawImage(video,0,0,400,300);
        var base=getBase64();
        $.ajax({
            type:"post",
            url:"query",
            data:{"base":base},
            success:function (data) {

            }
        })
    }
    function getBase64() {
        var imgSrc = document.getElementById("canvas").toDataURL("image/png");
        return imgSrc.split("base64,")[1];
    }
</script>
</body>
</html>
