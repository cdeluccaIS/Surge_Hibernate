/* 
Validating info pulled from Account table Info.
Call api to get Login info.
Match User info return true or false.
 */


$(document).ready(function(){
    console.log("Found file to login");
    
    $('#scLogin').on('click', function(){
        console.log("Submit button clicked");
        
        var user = $('#usernameLogin').val();
        var passwd = $('#inputPassword').val();
        if (typeof user !== 'undefined' && typeof passwd !== 'undefined'){
            //Make ajax call
            console.log("Making an ajax call");
            $.ajax({
                dataType: "json",
                method:"post",
                url: 'http://localhost:8081',
                data: { "username" : user, "password": passwd },
                success: function (response) {
                    // redirect must be defined and must be true
                    if (response.redirect !== undefined && response.redirect) {
                        window.location.href = "admin_home_page.html";
                    }
                }
              });
              
        }
        else {
            
            console.log("User and Password are Empty or Null");
        };
    });
});