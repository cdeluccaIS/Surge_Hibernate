/* 
 */
$(document).ready(function () {
    $('[data-toggle="tooltip"]').tooltip();
    //load function
    register();
    login();
    suspendUser();
    approveUser();
    deleteUser();
});


function register() {
    $("#addUser").submit(function (event) {
        event.preventDefault();
        var username = $('#username').val();
        
        //#fake out for testing porpuses
        if(username==='admin'){
            $("#userExists").modal();
        }else{
            $("#registerModalCenter").modal();
        }
    });
}

function login() {
    $("#login").submit(function (event) {
        event.preventDefault();
        var user = $('#usernamelogin').val();
        var passwd = $('#inputPassword').val();
        if ((user.length > 0) && (passwd.length > 0)) {
            //fake wrong login #must be removed 
            if(user=='wrong'){
                $("#loginFailed").modal();
            }
            //fake wrong login #must be removed 
            else if(user=='3'){
                $("#toManyLogin").modal();
            }
            else{
                //Redirect
                $( location ).attr("href", "admin_home_page.html");
            }
        }
        else {
            $("#validateLogin").modal();
        }
    });
}

function suspendUser() {
    //on modal load 
    $("#suspendModalCenter").on("show.bs.modal", function (e) {
        $('#selectedUsers').empty();
        /* look for all checkboes */
        $(".usercheck:checked").each(function () {
            $('#selectedUsers').append('<li value=' + $(this).val() + '>' + $(this).val() + '</li>');
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

function approveUser() {
    //on modal load 
    $("#approveModalCenter").on("show.bs.modal", function (e) {
        $('#selectedUsersForApproval').empty();
        /* look for all checkboes */
        $(".usercheck:checked").each(function () {
            $('#selectedUsersForApproval').append('<li value=' + $(this).val() + '>' + $(this).val() + '</li>');
        });
    });
    //on submit check value
    $("#approveUser").submit(function (event) {
        event.preventDefault();
        //check value of explination
        //TODO check if any of the is already approved
        $("#isApproved").modal();
    });
}

function deleteUser() {
    //on modal load 
    $("#deleteModalCenter").on("show.bs.modal", function (e) {
        $('#selectedUsersForDelete').empty();
        /* look for all checkboes */
        $(".usercheck:checked").each(function () {
            $('#selectedUsersForDelete').append('<li value=' + $(this).val() + '>' + $(this).val() + '</li>');
        });
    });
}