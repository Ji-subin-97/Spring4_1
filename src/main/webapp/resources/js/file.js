/**
 * 
 */
 
 let file = '<div class="col-md-12 mb-3 mx-auto">';
	 file = file + '<input type="file" id="f" name="photo" class="form-control">';
	 file = file + '</div>';
 
$("#add").click(function(){
	$("#addResult").append(file);
});