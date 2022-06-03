console.log("TBOARD Module..........");

let tboardService = (function(){
    function test1(callback){
        $.ajax({
           url: "/tboard/rest/test1",
            type: "get",
            success : function(result){
               if(callback){ callback(result); }
            }
        });
    }

    function test2(callback){
        $.ajax({
            url: "/tboard/rest/test2",
            type: "get",
            dataType: "json",
            success: function(result){
                if(callback){ callback(result); }
            }
        })
    }

    function test3(number, callback){
        $.ajax({
            url: "/tboard/rest/test3/"+number,
            type: "get",
            success : function(result){
                if(callback){ callback(result); }
            }
        })
    }

    function test4(tboard, callback) {
        $.ajax({
            url: "/tboard/rest/test4",
            type: "post",
            data : JSON.stringify(tboard),
            contentType : "application/json",
            dataType: "json",
            success : function(result){
                if(callback){ callback(result); }
            }
        })
    }

    function test5(info, callback){
        $.ajax({
            url : "/tboard/rest/test5/" + info.writer +"/" + info.re,
            type : "post",
            dataType : "json",
            success : function (result) {
                if(callback){ callback(result); }
            }
        })
    }
    return {test1:test1, test2:test2, test3:test3, test4:test4, test5:test5};
})();