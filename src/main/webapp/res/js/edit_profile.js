/**
 * Created by 1 on 25.05.2015.
 */
saveNames = function() {
    $.ajax(
        {
            url: "/client/editProfile/changeName",
            type: "POST",
            data: {
                    "username": $("#username").val(),
                    "firstName":$("#first_name").val(),
                    "lastName": $("#last_name").val()
                },
            success: function (result) {

                switch (result.type) {
                    case "SUCCESS":
                        $("#alert_message").attr('class', 'alert alert-success');
                        break;
                    case "ERROR":
                        $("#alert_message").attr("class", "alert alert-danger");
                        break;
                    default:
                        alert(result.type);
                }

                $("#alert_message").attr("style", "display:block");
                $("#alert_message").text(result.status);
            },
            error: function (xhr, ajaxOptions, thrownError) {
                alert(xhr.status);
                alert(thrownError);
            }
        });
}


savePhones = function() {
    $.ajax(
        {
            url: "/client/editProfile/changePhones",
            type: "POST",
            data: {
                    "phone1": $("#phone1").val(),
                    "phone2":$("#phone2").val(),
                    "phone3": $("#phone3").val()
            },
            success: function (result) {

                switch (result.type) {
                    case "SUCCESS":
                        $("#alert_message").attr('class', 'alert alert-success');
                        break;
                    case "ERROR":
                        $("#alert_message").attr("class", "alert alert-danger");
                        break;
                    default:
                        alert(result.type);
                }

                $("#alert_message").attr("style", "display:block");
                $("#alert_message").text(result.status);
            },
            error: function (xhr, ajaxOptions, thrownError) {
                alert(xhr.status);
                alert(thrownError);
            }
        });
}

saveSocials = function() {
    $.ajax(
        {
            url: "/client/editProfile/changeSocials",
            type: "POST",
            dataType: "json",
            //contentType: "application/json",
            data: {
                "socials": $("#social_links").val()
            },
            success: function (result) {

                switch (result.type) {
                    case "SUCCESS":
                        $("#alert_message").attr('class', 'alert alert-success');
                        break;
                    case "ERROR":
                        $("#alert_message").attr("class", "alert alert-danger");
                        break;
                    default:
                        alert(result.type);
                }

                $("#alert_message").attr("style", "display:block");
                $("#alert_message").text(result.status);
            },
            error: function (xhr, ajaxOptions, thrownError) {
                alert(xhr.status);
                alert(thrownError);
            }
        });
}

saveEmail = function() {
    $.ajax(
        {
            url: "/client/editProfile/changeEmail",
            type: "POST",
            dataType: "json",
            data: {
                "email": $("#email").val()
            },
            success: function (result) {

                switch (result.type) {
                    case "SUCCESS":
                        $("#alert_message").attr('class', 'alert alert-success');
                        break;
                    case "ERROR":
                        $("#alert_message").attr("class", "alert alert-danger");
                        break;
                    default:
                        alert(result.type);
                }

                $("#alert_message").attr("style", "display:block");
                $("#alert_message").text(result.status);
            },
            error: function (xhr, ajaxOptions, thrownError) {
                alert(xhr.status);
                alert(thrownError);
            }
        });
}

$(document).ready(function() {
    $("#save_names").click(function() {
        saveNames();
    });

    $("#save_phones").click(function() {
        savePhones();
    })

    $("#save_socials").click(function() {
        saveSocials();
    })

    $("#save_email").click(function() {
        saveEmail();
    })
})