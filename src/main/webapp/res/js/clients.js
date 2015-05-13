/**
 * Created by 1 on 27.04.2015.
 */

getListOfGroups = function() {
    $.ajax(
        {
            url: "/admin/groups/getListGroupNames",
            dataType: "json",
            contentType: "application/json",
            success: function (result) {
                $.each(result, function(i, groupName) {
                    $("#registerGroup").append(
                        "<option value = \"" + groupName + "\">" + groupName + "</option>"
                    );
                });
            },
            error: function (xhr, ajaxOptions, thrownError) {
                alert(xhr.status);
                alert(thrownError);
            }
        });
}

findAllClients = function() {
    $.ajax(
        {
            url: "/admin/clients/allClients",
            dataType: "json",
            contentType: "application/json",
            success: function (result) {
                $("#clientsTable tbody tr").remove();
                $.each(result, function(i, client) {

                    var groupName = (client.group == null) ? "None" : client.group.name;

                    $("#clientsTable tbody").append(
                        "<tr " +
                        "class='clickable-row' data-toggle='modal' data-target='#editModal'" +
                        ">" +

                        "<td>" + client.id + "</td>" +
                        "<td>" + client.name +"</td>" +
                        "<td>" + client.surname +"</td>" +
                        "<td>" + groupName +"</td>" +
                        "<td>" + client.phone +"</td>" +
                        "<td>" + client.phone2 +"</td>" +
                        "<td>" + client.phone3 +"</td>" +
                        "<td>" + client.email +"</td>" +
                        "<td>" + client.socialLinks +"</td>" +
                        "<td>" + client.otherNames +"</td>" +
                        "<td>" + client.tags +"</td>" +
                        "<td>" + client.comment +"</td>" +
                        "<td>" + client.id1 +"</td>" +
                        "<td>" + client.id2 +"</td>" +
                        "<td>" + client.id3 +"</td>" +
                        "<td>" + client.creationTime +"</td>" +
                        "<td>" + client.modificationTime +"</td>" +
                        "<td>" + client.password +"</td>" +
                        "</tr>");
                });

            },
            error: function (xhr, ajaxOptions, thrownError) {
                alert(xhr.status);
                alert(thrownError);
            }
        });
}

findByCondition = function() {
    var groupSelect = $("#groupSelection option:selected").text();
    if(groupSelect == "All") {
        groupSelect = "";
    } else if (groupSelect = "None") {
        groupSelect = null;
    }
    var namePattern = $("#name").val();
    var surnamePattern = $("#surname").val();
    var phonePattern = $("#phone").val();
    var emailPattern = $("#email").val();
    var tagsPattern = $("#tags").val();
    $.ajax(
        {
            url: "/admin/clients/clientsSearch?groupSelect=" + groupSelect +
            "&namePattern=" + namePattern +
            "&surnamePattern=" + surnamePattern +
            "&phonePattern=" + phonePattern +
            "&emailPattern=" + emailPattern +
            "&tagsPattern=" + tagsPattern,
            dataType: "json",
            contentType: "application/json",
            success: function (result) {
                $("#clientsTable tbody").empty();
                $.each(result, function(i, client) {

                    var groupName = (client.group == null) ? "None" : client.group.name;

                    $("#clientsTable tbody").append(
                        "<tr " +
                        "class='clickable-row' data-toggle='modal' data-target='#editModal'" +
                        ">" +

                        "<td>" + client.id + "</td>" +
                        "<td>" + client.name +"</td>" +
                        "<td>" + client.surname +"</td>" +
                        "<td>" + groupName +"</td>" +
                        "<td>" + client.phone +"</td>" +
                        "<td>" + client.phone2 +"</td>" +
                        "<td>" + client.phone3 +"</td>" +
                        "<td>" + client.email +"</td>" +
                        "<td>" + client.socialLinks +"</td>" +
                        "<td>" + client.otherNames +"</td>" +
                        "<td>" + client.tags +"</td>" +
                        "<td>" + client.comment +"</td>" +
                        "<td>" + client.id1 +"</td>" +
                        "<td>" + client.id2 +"</td>" +
                        "<td>" + client.id3 +"</td>" +
                        "<td>" + client.creationTime +"</td>" +
                        "<td>" + client.modificationTime +"</td>" +
                        "<td>" + client.password +"</td>" +
                        "</tr>");
                });

            },
            error: function (xhr, ajaxOptions, thrownError) {
                alert(xhr.status);
                alert(thrownError);
            }
        });
}

saveClient = function() {
    $.ajax(
        {
            url: "/admin/clients/addNewClient",
            type: "POST",
            dataType: "json",
//                      mimeType: 'application/json',
//                      headers: {
//                          'Accept': 'application/json'
//                      },
            contentType: "application/json",
            data: JSON.stringify(
                {
                    name: $("#registerName").val(),
                    surname:$("#registerSurname").val(),
                    creationTime: new Date(),
                    modificationTime: new Date(),
                    email: $("#registerEmail").val(),
                    phone: $("#registerPhone").val(),
                    phone2: $("#registerPhone2").val(),
                    phone3: $("#registerPhone3").val(),
                    socialLinks: $("#registerSocialLinks").val(),
                    otherNames: $("#registerOtherNames").val(),
                    tags: $("#registerTags").val(),
                    comment: $("#registerComment").val(),
                    id1: $("#registerId1").val(),
                    id2: $("#registerId2").val(),
                    id3: $("#registerId3").val(),
                    password: $("#registerPassword").val(),
                    group: {
                        name: $("#registerGroup option:selected").text()
                    }
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

updateClient = function() {
    $.ajax(
        {
            url: "/admin/clients/updateClient",
            type: "POST",
            dataType: "json",
//                      mimeType: 'application/json',
//                      headers: {
//                          'Accept': 'application/json'
//                      },
            contentType: "application/json",
            data: JSON.stringify(
                {
                    id: $("#updateId").val(),
                    name: $("#updateName").val(),
                    surname:$("#updateSurname").val(),
                    modificationTime: new Date(),
                    email: $("#updateEmail").val(),
                    phone: $("#updatePhone").val(),
                    phone2: $("#updatePhone2").val(),
                    phone3: $("#updatePhone3").val(),
                    socialLinks: $("#updateSocialLinks").val(),
                    otherNames: $("#updaterOtherNames").val(),
                    tags: $("#updateTags").val(),
                    comment: $("#updateComment").val(),
                    id1: $("#updateId1").val(),
                    id2: $("#updateId2").val(),
                    id3: $("#updateId3").val(),
                    password: $("#updatePassword").val()
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

deleteClient = function() {
    $.ajax(
        {
            url: "/admin/clients/deleteClient?id=" + $("#updateId").val(),
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