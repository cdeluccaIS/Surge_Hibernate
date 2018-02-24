/* 
Validate User Login - SCC
*/

$(document).ready(function() {
    console.log("Can see Validate File");

    $("input#username") .on("blur", function() {
        var user = $(this).val();
        if(user.length > 0)
        {
            // Additional Validation to check if Username is in the correct expression.
        }
        else {
            $("#validateLogin").modal();
        }
    });
    
    $("input#inputPassword") .on("blur", function() {
        var passwd = $(this).val();
        if(passwd.length > 0)
        {
            // Additional Validation to check if Username is in the correct expression.
        }
        else {
            $("#validateLogin").modal();
        }
    });
}); 


