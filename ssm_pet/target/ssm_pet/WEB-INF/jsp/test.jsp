
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<input type="button" onclick="pefile()" value="提交" />
<input type="file" multiple="multiple" id="fileDate" onchange="oncg(this)">
<div style="width: 3em">
    <img src="" alt="">
</div>

<div>
    <div>
        <p></p>
    </div>
    <div>
        <p></p>
    </div>
    <div>
        <p></p>
    </div>
    <div>
        <p></p>
    </div>
    <div>
        <p></p>
    </div>
</div>


<script src="/js/jquery.js"></script>
<script>

    function previewWithObjectURL() {
        var target = event.target.files[0];
        var url = URL.createObjectURL(target);
        myBatis.src = url;
        myMusic.play();
        console.log(url);
    }

    function toDataURL(file) {
        var reader = new FileReader();
        reader.getElementById(event.target.fileg[0]);
        reader.onloadend = function (event) {
            console.log(event.target.result);
            var musicController = doucument.getElementById("myMusic");
            musicController.src = event.target.result;
            musicController.play();
        }
    }
    
    var file = function () {
        
    }


</script>


</body>
</html>
