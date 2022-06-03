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

    function getList(info, callback) {
        $.ajax({
            url: "/reply/list/" + info.bno + "/" + info.page,
            type: "get",
            dataType: "json",
            success: function (result) {
                if (callback) {
                    callback(result)
                }
            }
        });
    }

    return {add: add, get: get, remove: remove, modify: modify, getList: getList};
})();