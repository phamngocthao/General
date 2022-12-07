<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">
function showConfirmInfoSweetMessageWithAnyText(callBackIftrue,anytext) {
	  Swal.fire({
	    title: anytext,
	    text: "Xóa có thể ảnh hưởng đến dữ liệu!",
	    icon: 'warning',
	    showCancelButton: true,
	    confirmButtonColor: '#3085d6',
	    cancelButtonColor: '#d33',
	    confirmButtonText: 'Đồng ý!'
	    }).then((result) => {
	    if (result.isConfirmed) {
	        callBackIftrue();
	        Swal.fire(
	        'Xóa thành công!',
	        'Dữ liệu đã được xóa!',
	        'success'
	        )
	    }
	})
}
	
openModalConfirmDelete = function(id){
	
	/* $('.main-section').attr("formaction","computer/delete-computer/"+id); */
	
    if(showConfirmInfoSweetMessageWithAnyText){
    	
        showConfirmInfoSweetMessageWithAnyText(function(){
        	
        	$.ajax({
        		type: "POST",
        		url: `computer/delete-computer/`+id,
        		success: function () {
        			setInterval(() => {
        				window.location.href = 'computer/list-computer';
					}, 2000);
				},
				error : function (responseData) {
					if (responseData.responseCode) {
			            console.error(responseData.responseCode);
			        }
				}
        	})
            
           
        },'Bạn có muốn xóa không');
    }
    else{
        Swal.getCloseButton();
    }

    
}
</script>