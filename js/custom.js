/* 
 */
$(document).ready(function () {
    $('[data-toggle="tooltip"]').tooltip();
    //load function
    suspendUser();
});

function suspendUser() {
    
    //on modal load 
    $("#suspendModalCenter").on("show.bs.modal", function(e) {
        $('#selectedUsers').empty();
        /* look for all checkboes */
        $(".usercheck:checked").each(function () {
            $('#selectedUsers').append('<li value='+$(this).val()+'>'+$(this).val()+'</li>');
        });
    });
    //on submit check value
    $("#suspendUser").submit(function (event) {
        event.preventDefault();
        //check value of explination
        var just = $('#justification').val();
        if (just.length <= 0) {
            $("#validateJustification").modal();
        }
        else {
            //Do Submit
        }
    });
}
    