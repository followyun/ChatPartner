/**
 * 后台执行删除多条记录的方法
 * @param path: 项目的基本路径
 * @returns
 */
function deletecommands(path) {
	if(confirm("确定要删除？")==true) {
		$("#commandlistForm").attr("action", path+"admin/deleteCommands");
		$("#commandlistForm").submit();
	}
}

function deleteOneCommandContent(path, id) {
	if(confirm('确定要删除？')==true){
		location=path+"/admin/deleteOneCommandContent?id="+id;
	}
}

function checkIsNum(val) {
	 var re = /^[1-9]+[0-9]*]*$/; 
     if (!re.test(val)) {
        return false;
     }
     return true;
}

function gotoThePage(path) {
	
	var isNum = checkIsNum($("#inputPage").val());
	if(isNum == false) {
		alert("请输入数字");
		$("#inputPage").val("");
		return;
	}
	
	location=path+"/admin/queryMessageByPage?" +
	"currentPage="+$("#inputPage").val();
}