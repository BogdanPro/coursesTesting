/**
 * Created by 1 on 05.05.2015.
 */
/**
 * Created by 1 on 05.05.2015.
 */
getListOfCoahes = function() {
    $.ajax(
        {
            url: "/admin/groups/getListCoaches",
            dataType: "json",
            contentType: "application/json",
            success: function (result) {
                $.each(result, function(i, coachName) {
                    $("#registerCoach").append(
                       "<option value = \"" + coachName + "\">" + coachName + "</option>"
                    );

                    $("#updateCoach").append(
                        "<option value = \"" + coachName + "\">" + coachName + "</option>"
                    );
                });
            },
            error: function (xhr, ajaxOptions, thrownError) {
                alert(xhr.status);
                alert(thrownError);
            }
        });
}

getListOfPlaces = function() {
    $.ajax(
        {
            url: "/admin/groups/getListPlaces",
            dataType: "json",
            contentType: "application/json",
            success: function (result) {
                $.each(result, function(i, placeName) {
                    $("#registerPlace").append(
                        "<option value = " + placeName + ">" + placeName + "</option>"
                    );

                    $("#updatePlace").append(
                        "<option value = " + placeName + ">" + placeName + "</option>"
                    );
                });
            },
            error: function (xhr, ajaxOptions, thrownError) {
                alert(xhr.status);
                alert(thrownError);
            }
        });
}

getListOfCourses = function() {
    $.ajax(
        {
            url: "/admin/groups/getListCourses",
            dataType: "json",
            contentType: "application/json",
            success: function (result) {
                $.each(result, function(i, courseName) {
                    $("#registerCourse").append(
                        "<option value = \"" + courseName + "\">" + courseName + "</option>"
                    );

                    $("#updateCourse").append(
                        "<option value = \"" + courseName + "\">" + courseName + "</option>"
                    );
                });
            },
            error: function (xhr, ajaxOptions, thrownError) {
                alert(xhr.status);
                alert(thrownError);
            }
        });
}



findAllGroups = function() {
    $.ajax(
        {
            url: "/admin/groups/allGroups",
            dataType: "json",
            contentType: "application/json",
            success: function (result) {
                $("#groupsTable tbody").empty();
                $.each(result, function(i,group) {

                    var coachName = (group.coach == null) ? "None" : group.coach.name;
                    var placeName = (group.place == null) ? "None" : group.place.name;
                    var courseName = (group.course == null) ? "None" : group.course.name;

                    $("#groupsTable tbody").append(
                        "<tr " +
                        "class='clickable-row' data-toggle='modal' data-target='#editModal'" +
                        ">" +

                            "<td>" + group.id + "</td>" +
                            "<td>" + group.name +"</td>" +
                            "<td>" + group.comment +"</td>" +
                            "<td>" + coachName +"</td>" +
                            "<td>" + placeName + "</td>" +
                            "<td>" + courseName +"</td>" +
                            "<td>" + group.creationTime +"</td>" +
                            "<td>" + group.modificationTime +"</td>" +
                        "</tr>");
                });

            },
            error: function (xhr, ajaxOptions, thrownError) {
                alert(xhr.status);
                alert(thrownError);
            }
        });
}

findGroupByCondition = function() {
    var namePattern = $("#name").val();
    $.ajax(
        {
            url: "/admin/groups/groupSearch?namePattern=" + namePattern,
            dataType: "json",
            contentType: "application/json",
            success: function (result) {
                $("#groupsTable tbody").empty();
                $.each(result, function(i,group) {

                    var coachName = (group.coach == null) ? "Not determined" : group.coach.name;
                    var placeName = (group.place == null) ? "Not determined" : group.place.name;
                    var courseName = (group.course == null) ? "Not determined" : group.course.name;

                    $("#groupsTable tbody").append(
                        "<tr " +
                        "class='clickable-row' data-toggle='modal' data-target='#editModal'" +
                        ">" +

                        "<td>" + group.id + "</td>" +
                        "<td>" + group.name +"</td>" +
                        "<td>" + group.comment +"</td>" +
                        "<td>" + coachName +"</td>" +
                        "<td>" + placeName + "</td>" +
                        "<td>" + courseName +"</td>" +
                        "<td>" + group.creationTime +"</td>" +
                        "<td>" + group.modificationTime +"</td>" +
                        "</tr>");
                });

            },
            error: function (xhr, ajaxOptions, thrownError) {
                alert(xhr.status);
                alert(thrownError);
            }
        });
}

saveGroup = function() {
    $.ajax(
        {
            url: "/admin/groups/addNewGroup",
            type: "POST",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(
                {
                    name: $("#registerName").val(),
                    comment:$("#registerComment").val(),
                    creationTime: new Date(),
                    modificationTime: new Date(),
                    coach: {
                            name: $("#registerCoach option:selected").text()
                            },
                    place: {
                            name: $("#registerPlace option:selected").text()
                            },
                    course: {
                            name: $("#registerCourse option:selected").text()
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

updateGroup = function() {
    $.ajax(
        {
            url: "/admin/groups/updateGroup",
            type: "POST",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(
                {
                    id: $("#updateId").val(),
                    name: $("#updateName").val(),
                    comment:$("#updateComment").val(),
                    modificationTime: new Date(),
                    coach: $("#updateCoach option:selected").text(),
                    place: $("#updatePlace option:selected").text(),
                    course: $("#updateCourse option:selected").text()
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

deleteGroup = function() {
    $.ajax(
        {
            url: "/admin/groups/deleteGroup?id=" + $("#updateId").val(),
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