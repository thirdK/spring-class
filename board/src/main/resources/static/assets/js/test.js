console.log("Test Module.......");
let callback = (function(result){
    $(".input1").val(result);
})();

let test1 = (function(){

    function run(callback){
        console.log("run.......");
        $.ajax({
           url: "/test/test1",
           type: "get",
            success : function (result){
               if(callback){
                   callback(result);
               }
            },
            error : function (){
               alert("aa");
            }
        });
    }
})();



let testService = (function () {

    function add(reply, callback){
        console.log("add reply.......");
        $.ajax({
            url: "/test/new",
            type: "post",
            data: JSON.stringify(reply),
            contentType: "application/json",
            success : function (result) {
                if(callback){
                    callback(result);
                }
            },
            error: function(){

            }
        });
    }
})();