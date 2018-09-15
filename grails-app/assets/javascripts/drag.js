function guid() {
    function s4() {
        return Math.floor((1 + Math.random()) * 0x10000)
            .toString(16)
            .substring(1);
    }
    return s4() + s4() + '-' + s4() + '-' + s4() + '-' + s4() + '-' + s4() + s4() + s4();
}

var imageName = guid();
console.log(imageName)

function allowDrop(ev) {
    ev.preventDefault();
}

function drag(ev) {
    ev.dataTransfer.setData("text", ev.target.id);
}


function readerHandler(e2)
{
    var div = document.getElementById('img');
    div.innerHTML=e2.target.result.split("\n").join("<br>");
}

function drop(ev) {
    ev.stopPropagation();
    ev.preventDefault();
    var data = ev.dataTransfer.files[0];
    document.getElementById('file').files = ev.dataTransfer.files;
    console.log(data.name)
    document.getElementById("nameImg").innerText = data.name;
    var img = document.getElementById("img");
    var reader = new FileReader();
    reader.addEventListener("load", function () {
        console.log(reader.result);
        img.src = reader.result;
    }, false);

    if (data) {
        reader.readAsDataURL(data);
    }
}

function load() {
    document.getElementById('file').click();
    reader.addEventListener("load", function () {
        console.log("READ")
    }, false);
}


function afterLoad(files) {
    var img = document.getElementById("img");
    console.log(files[0])
    var name = files[0].name;
    var reader = new FileReader();
    reader.readAsDataURL(files[0]);
    reader.addEventListener("load", function () {
        img.src = reader.result;
        console.log(reader.result);
    }, false);
    document.getElementById("nameImg").innerText = name;
}

/*function send() {
    var file = document.getElementById("file").files[0];
    var form = new FormData();
    form.append("image", file);
    form.append("username", "nameOfUser");
    console.log(form.get("username"));
    var user = {};
  //  user.img = img.src;
    //console.log(img.src);
    var formData = new FormData();
    formData.append('image', file, 'image.png')
    $.ajax("http://localhost:8081/mbdstp/user/saveImage", {type: "POST", contentType: false, cache: false, processData: false, data: form});
}*/


// Envoyé l'image au serveur au moment du drop
$(".file").change(function() {
    var file = document.getElementById("file").files[0];
    imageName += file.name;
    document.getElementById("imageName").value = imageName;
    var form = new FormData();
    form.append("image", file);
    form.append("imageName", imageName);
    $.ajax("http://localhost:8081/mbdstp/user/saveImage", {type: "POST", contentType: false, cache: false, processData: false, data: form});
});