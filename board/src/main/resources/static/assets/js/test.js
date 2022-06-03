console.log("test module............");
let testService = (function(){
    function test1(callback) {
        console.log("test1!!!!");
        $.ajax({
            url:"/rest/test1",
            type: "get",
            success: function(result){
                if(callback){ callback(result); }
            }
        });
    }

    function test2(text, callback){
        console.log("test2!!!!");
        console.log(text);
        $.ajax({
            url : "/rest/test2/" + text,
            type: "get",
            success: function(result){
                if(callback){ callback(result); }
            }
        });
    }

    function test3(callback){
        console.log("test3!!!!!!!");
        $.ajax({
            url : "/rest/test3",
            type : "post",
            success: function (result) {
                if(callback){
                    callback(result)
                }
            }
        })
    }

    function test4(info, callback){
        console.log("test4!!!!!!!");
        $.ajax({
            url:"/rest/test4",
            type:"post",
            data: JSON.stringify(info),
            contentType: "application/json",
            dataType: "json",
            success: function(result){
                if(callback){ callback(result); }
            }
        })
    }

    function test5(val, callback){
        console.log("test5!!!!!!!!");
        $.ajax({
            url: "/rest/test5/"+ val.a+"/" + val.b + "/" + val.c,
            type:"post",
            dataType: "json",
            success:function(result){
            if(callback){ callback(result); }
        }
        })
    }

    return {test1:test1, test2:test2, test3:test3, test4:test4, test5:test5};
})();