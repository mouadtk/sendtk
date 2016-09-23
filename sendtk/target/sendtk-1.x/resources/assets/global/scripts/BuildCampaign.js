
function inputSelect(){

    if($.fn.select2){
        setTimeout(function () {
            $('#affiliateSelect').each(
            		function(){
		                var sl = $(this);
		            	function format(state){
		            		
		                    var state_id = state.id;
		                    if (!state_id)  return state.text; // optgroup
		                    var res = state_id.split("-");
		                    
		                    if(res[0] == 'image') {
		                        if(res[2]) return "<img class='flag' src='assets/images/flags/" + res[1].toLowerCase() + "-" + res[2].toLowerCase() +".png' style='width:27px;padding-right:10px;margin-top: -3px;'/>" + state.text;
		                        else return "<img class='flag' src='assets/images/flags/" + res[1].toLowerCase() + ".png' style='width:27px;padding-right:10px;margin-top: -3px;'/>" + state.text;
		                    }
		                    else {
		                        return state.text;
		                    }
		                }
		            	
		                $(this).select2({
		                    formatResult	  		: format,
		                    formatSelection	  		: format,
		                    placeholder		  		: $(this).data('placeholder')   	 ? $(this).data('placeholder')  		: '',
		                    allowClear		  		: $(this).data('allowclear') 		 ? $(this).data('allowclear') 			: true,
		                    minimumInputLength		: $(this).data('minimumInputLength') ? $(this).data('minimumInputLength')   : -1,
		                    minimumResultsForSearch : $(this).data('search') 			 ? 1 									: -1,
		                    dropdownCssClass		: $(this).data('style') 			 ? 'form-white' 						: '',
		                    maximumSelectionSize	: 2 // Limit the number max of selection for multiple select
		                });
		                
		            });
        }, 200);

        /* Demo Select Loading Data */
        function repoFormatResult(repo) {
            var markup = '<div class="row">' +
			               '<div class="col-md-10">' +
			                  '<div class="row">' +
			                     '<div class="col-md-4">' + repo.name + '</div>' +
			                     '<div class="col-md-3"><i class="fa fa-flag-checkered"></i>' + repo.reference + '</div>' +
			                     '<div class="col-md-3"><i class="fa fa-code-star"></i>' + repo.vertical + '</div>' +
			                  '</div>';
            if (!repo.description) {
               markup += '<div>' + repo.description + '</div>';
            }
            markup += '</div></div>';
            return markup;
         }
         function repoFormatSelection(repo) {
            return repo.name+" ("+repo.reference+")";
         }

         
       if($('#offername').length) {
            $("#offername").select2({
                placeholder: "Type an offers name...",
                minimumInputLength: 2,
                maximumSelectionLength:5,
            	multiple: true,
                ajax: { // instead of writing the function to execute the request we use Select2's convenient helper
                    url: "/sendtk/Offer/searchOffer",
                    dataType: 'json',
                    quietMillis: 250,
                    data: function (term, page) {
                        return {
                        	affiliate:$('#affiliateSelect').val(),
                            q: term, // search term
                        };
                    },
                    results: function (data, page) { // parse the results into the format expected by Select2.
                        // since we are using custom formatting functions we do not need to alter the remote JSON data
                        return { results: data.items };
                    },
                    cache: true
                },
                initSelection: function(element, callback) {
                    // the input tag has a value attribute preloaded that points to a preselected repository's id
                    // this function resolves that id attribute to an object that select2 can render
                    // using its formatResult renderer - that way the repository name is shown preselected
                    var id = $(element).val();
                    if (id !== "") {
                        $.ajax("/sendtk/Campaign/searchOffer"  , {
                            dataType: "json"
                        }).done(function(data) { callback(data); });
                    }
                },
                formatResult: repoFormatResult, // omitted for brevity, see the source of this page
                formatSelection: repoFormatSelection,  // omitted for brevity, see the source of this page
                //formatSearching: function() {return "";},
                dropdownCssClass: "bigdrop", // apply css that makes the dropdown taller
                escapeMarkup: function (m) { return m; } // we do not want to escape markup since we are displaying html in results
            });
        }
    }
}

function getServersIPs(){	
	 
	 $.ajax({url: "/sendtk/Server/getIPs", 
		 success: function(result){
	        console.log(result);
	    }});
	
}


$(document).ready(function(){
	
    $('#example-multiple-optgroups').multipleSelect();
	inputSelect();
	getServersIPs();
});