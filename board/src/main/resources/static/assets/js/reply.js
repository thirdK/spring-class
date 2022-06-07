/*
*   reply module
* */

console.log("Reply Module......");
let replyService = (function () {

    function add(reply, callback, error) {
        console.log("add reply..........");
        $.ajax({
            url: "/reply/new",
            type: "post",
            data: JSON.stringify(reply), //전달할 data
            contentType: "application/json", //전달할 data의 타입
            success: function (result) {
                if (callback) {
                    callback(result);
                }
            },
            error: function (xhr, status, er) {
                if (error) {
                    error(er);
                }
            }
        });
    }

    function get(rno, callback) {
        console.log("read reply.........");
        $.ajax({
            url: "/reply/" + rno,
            type: "get",
            dataType: "json",
            success: function (result) {
                if (callback) {
                    callback(result);
                }
            }

        });
    }

    function remove(rno, callback) {
        $.ajax({
            url: "/reply/" + rno,
            type: "delete",
            success: function (result) {
                if (callback) {
                    callback(result);
                }
            }
        });
    }

    function modify(reply, callback) {
        $.ajax({
            url: "/reply/" + reply.replyNumber,
            type: "patch",
            data: JSON.stringify(reply),
            contentType: "application/json",
            success: function (result) {
                if (callback) {
                    callback(result);
                }
            }
        });
    }

    function getList(param, callback, error) {
        let page = param.page || 1;
        $.getJSON("/reply/list/" + param.bno + "/" + page, function (replyPageDTO) {
            if(callback){
                callback(replyPageDTO.total, replyPageDTO.list);
            }
        }).fail(function(xhr, status, er){
            if(error){
                error(er);
            }
        });
        // $.ajax({
        //     url: "/reply/list/" + param.bno + "/" + page,
        //     type: "get",
        //     dataType: "json",
        //     success: function (replyPageDTO) {
        //         if (callback) {
        //             callback(replyPageDTO.total, replyPageDTO.list);
        //         }
        //     }
        // });
    }

    //댓글 작성 시간(Javascript)
    function getReplyDateByJavascript(replyDate){
        let today = new Date();
        let rDate = new Date(replyDate);
        let gap = today.getTime() - rDate.getTime();

        if(gap < 1000 * 60 * 60 * 24){
            let h = rDate.getHours();
            let m = rDate.getMinutes();
            let s = rDate.getSeconds();

            return [(h < 10 ? '0' : '') + h, (m < 10 ? '0' : '') + m, (s < 10 ? '0' : '') + s].join(":");
        }else {
            let y = rDate.getFullYear();
            let m = rDate.getMonth() + 1;
            let d = rDate.getDate();

            return [y, (m < 10 ? '0' : '') + m, (d < 10 ? '0' : '') + d].join("-");
        }

    }

    return {add: add, get: get, remove: remove, modify: modify, getList: getList, getReplyDateByJavascript:getReplyDateByJavascript};
})();