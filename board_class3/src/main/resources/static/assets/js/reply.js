/*
*   reply module
* */

console.log("Reply Module......");
let replyService = (function(){

    function add(reply, callback, error){
        console.log("add reply..........");
        $.ajax({
            url: "/reply/new",
            type: "post",
            data: JSON.stringify(reply),
            contentType: "application/json",
            success: function(result){
               if(callback){
                   callback(result);
               }
            },
            error: function(xhr, status, er){
                if(error){
                    error(xhr, status, er);
                }
            }
        });
    }

    //댓글 한 개 정보 가져오기
    function get(rno, callback, error){
        $.ajax({
            url: "/reply/" + rno,
            type: "get",
            dataType: "json",
            success: function(reply){
                if(callback){
                    callback(reply);
                }
            }
        })
    }

    //댓글 삭제
    function remove(rno, callback, error){
        $.ajax({
            url: "/reply/" + rno,
            type: "delete",
            success: function(result){
                if(callback){
                    callback(result);
                }
            }
        });
    }

    // 댓글 수정
    function modify(reply, callback){
        $.ajax({
            url: "/reply/" + reply.rno,
            type: "patch",
            data: JSON.stringify(reply),
            contentType: "application/json; charset=utf-8;",
            success: function(result){
                if(callback){
                    callback(result);
                }
            }
        });
    }

    //댓글 목록
    function getList(param, callback){
        $.ajax({
            url: "/reply/list/" + param.bno + "/" + param.page,
            type: "get",
            dataType: "json",
            success: function(replyPageDTO){
                if(callback){
                    callback(replyPageDTO.total, replyPageDTO.list);
                }
            }
        });
    }


    return {add: add, get: get, remove: remove, modify: modify, getList: getList};
})();