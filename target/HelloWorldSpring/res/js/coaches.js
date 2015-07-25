/**
 * Created by Khemrayev A.K. on 29.04.2015.
 */
/**
 * Created by 1 on 27.04.2015.
 */
findAllCoaches = function() {
    $.ajax(
        {
            url: "/admin/coaches/allCoaches",
            dataType: "json",
            contentType: "application/json",
            success: function (result) {
                $("#coachesTable tbody tr").remove();
                $.each(result, function(i, coach) {
                    $("#coachesTable tbody").append(
                        "<tr " +
                        "class='clickable-row' data-toggle='modal' data-target='#editModal'" +
                        ">" +

                            "<td>" + coach.id + "</td>" +
                            "<td>" + coach.name +"</td>" +
                            "<td>" + coach.surname +"</td>" +
                            "<td>" + coach.phone +"</td>" +
                            "<td>" + coach.phone2 +"</td>" +
                            "<td>" + coach.phone3 +"</td>" +
                            "<td>" + coach.email +"</td>" +
                            "<td>" + coach.email2 +"</td>" +
                            "<td>" + coach.socialLinks +"</td>" +
                            "<td>" + coach.currency +"</td>" +
                            "<td>" + coach.rate +"</td>" +
                            "<td>" + coach.creationTime +"</td>" +
                            "<td>" + coach.modificationTime +"</td>" +
                        "</tr>");
                });

            },
            error: function (xhr, ajaxOptions, thrownError) {
                alert(xhr.status);
                alert(thrownError);
            }
        });
}

findCoachByCondition = function() {
    var namePattern = $("#name").val();
    var surnamePattern = $("#surname").val();
    var phonePattern = $("#phone").val();
    var emailPattern = $("#email").val();
    $.ajax(
        {
            url: "/admin/coaches/coachSearch?namePattern=" + namePattern +
            "&surnamePattern=" + surnamePattern +
            "&phonePattern=" + phonePattern +
            "&emailPattern=" + emailPattern,
            dataType: "json",
            contentType: "application/json",
            success: function (result) {
                $("#coachesTable tbody").empty();
                $.each(result, function(i, coach) {
                    $("#coachesTable tbody").append(
                        "<tr " +
                        "class='clickable-row' data-toggle='modal' data-target='#editModal'" +
                        ">" +

                            "<td>" + coach.id + "</td>" +
                            "<td>" + coach.name +"</td>" +
                            "<td>" + coach.surname +"</td>" +
                            "<td>" + coach.phone +"</td>" +
                            "<td>" + coach.phone2 +"</td>" +
                            "<td>" + coach.phone3 +"</td>" +
                            "<td>" + coach.email +"</td>" +
                            "<td>" + coach.email2 +"</td>" +
                            "<td>" + coach.socialLinks +"</td>" +
                            "<td>" + coach.currency +"</td>" +
                            "<td>" + coach.rate +"</td>" +
                            "<td>" + coach.creationTime +"</td>" +
                            "<td>" + coach.modificationTime +"</td>" +
                        "</tr>");
                });

            },
            error: function (xhr, ajaxOptions, thrownError) {
                alert(xhr.status);
                alert(thrownError);
            }
        });
}

saveCoach = function() {
    $.ajax(
        {
            url: "/admin/coaches/addNewCoach",
            type: "POST",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(
                {
                    name: $("#registerName").val(),
                    surname:$("#registerSurname").val(),
                    creationTime: new Date(),
                    modificationTime: new Date(),
                    email: $("#registerEmail").val(),
                    email2: $("#registerEmail2").val(),
                    phone: $("#registerPhone").val(),
                    phone2: $("#registerPhone2").val(),
                    phone3: $("#registerPhone3").val(),
                    socialLinks: $("#registerSocialLinks").val(),
                    currency: $("#registerCurrency").val(),
                    rate: $("#registerRate").val()
                }
            ),
            success: function (result) {
                if(result) {
                    alert(result.status)
                }
            },
            error: function (xhr, ajaxOptions, thrownError) {
                alert(xhr.status);
                alert(thrownError);
            }
        });
}

updateCoach = function() {
    $.ajax(
        {
            url: "/admin/coaches/updateCoach",
            type: "POST",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(
                {
                    id: $("#updateId").val(),
                    name: $("#updateName").val(),
                    surname:$("#updateSurname").val(),
                    modificationTime: new Date(),
                    email: $("#updateEmail").val(),
                    email2: $("#updateEmail2").val(),
                    phone: $("#updatePhone").val(),
                    phone2: $("#updatePhone2").val(),
                    phone3: $("#updatePhone3").val(),
                    socialLinks: $("#updateSocialLinks").val(),
                    currency: $("#updateCurrency").val(),
                    rate: $("#updateRate").val()
                }
            ),
            success: function (result) {
                if(result) {
                    alert(result.status)
                }
            },
            error: function (xhr, ajaxOptions, thrownError) {
                alert(xhr.status);
                alert(thrownError);
            }
        });
}

deleteCoach = function() {
    $.ajax(
        {
            url: "/admin/coaches/deleteCoach?id=" + $("#updateId").val(),
            type: "POST",
            success: function (result) {
                if(result) {
                    alert(result.status)
                }
            },
            error: function (xhr, ajaxOptions, thrownError) {
                alert(xhr.status);
                alert(thrownError);
            }
        });
}