/**
 * 
 */
 
 let file = '<div class="mb-3" od="f">';
 file = file + '<label for="addResult" class="form-label">Photo</label>';
 file = file + '<input type="file" id="f" name="photo" class="form-control">';
 file = file + '</div>';
 
$("#add").click(function(){
	$("#files").after(file);
});