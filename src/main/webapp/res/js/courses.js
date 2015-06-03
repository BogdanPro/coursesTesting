/**
 * Created by Khemrayev A.K. on 05.05.2015.
 */
findAllCourses = function() {
    $.ajax(
        {
            url: "/admin/courses/allCourses",
            dataType: "json",
            contentType: "application/json",
            success: function (result) {
                $("#coursesTable tbody tr").remove();
                $.each(result, function(i, course) {
                    $("#coursesTable tbody").append(
                        "<tr " +
                        "class='clickable-row' data-toggle='modal' data-target='#editModal'" +
                        ">" +

                            "<td>" + course.id + "</td>" +
                            "<td>" + course.name +"</td>" +
                            "<td>" + course.comment +"</td>" +
                            "<td>" + course.lessons +"</td>" +
                            "<td>" + course.price1 +"</td>" +
                            "<td>" + course.price2 +"</td>" +
                            "<td>" + course.price3 +"</td>" +
                            "<td>" + course.groups +"</td>" +
                            "<td>" + course.creationTime +"</td>" +
                            "<td>" + course.modificationTime +"</td>" +
                        "</tr>");
                });

            },
            error: function (xhr, ajaxOptions, thrownError) {
                alert(xhr.status);
                alert(thrownError);
            }
        });
}

findCourseByCondition = function() {
    var namePattern = $("#name").val();
    $.ajax(
        {
            url: "/admin/courses/courseSearch?namePattern=" + namePattern,
            dataType: "json",
            contentType: "application/json",
            success: function (result) {
                $("#coursesTable tbody").empty();
                $.each(result, function(i, coach) {
                    $("#coursesTable tbody").append(
                        "<tr " +
                        "class='clickable-row' data-toggle='modal' data-target='#editModal'" +
                        ">" +

                            "<td>" + course.id + "</td>" +
                            "<td>" + course.name +"</td>" +
                            "<td>" + course.comment +"</td>" +
                            "<td>" + course.lessons +"</td>" +
                            "<td>" + course.price1 +"</td>" +
                            "<td>" + course.price2 +"</td>" +
                            "<td>" + course.price3 +"</td>" +
                            "<td>" + course.groups +"</td>" +
                            "<td>" + course.creationTime +"</td>" +
                            "<td>" + course.modificationTime +"</td>" +
                        "</tr>");
                });

            },
            error: function (xhr, ajaxOptions, thrownError) {
                alert(xhr.status);
                alert(thrownError);
            }
        });
}

saveCourse = function() {
    $.ajax(
        {
            url: "/admin/courses/addNewCourse",
            type: "POST",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(
                {
                    name: $("#registerName").val(),
                    comment:$("#registerComment").val(),
                    creationTime: new Date(),
                    modificationTime: new Date(),
                    lessons: $("#registerLessons").val(),
                    price1: $("#registerPrice1").val(),
                    price2: $("#registerPrice2").val(),
                    price3: $("#registerPrice3").val()
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

updateCourse = function() {
    $.ajax(
        {
            url: "/admin/courses/updateCourse",
            type: "POST",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(
                {
                    id: $("#updateId").val(),
                    name: $("#updateName").val(),
                    comment:$("#updateComment").val(),
                    modificationTime: new Date(),
                    lessons: $("#updateLessons").val(),
                    price1: $("#updatePrice1").val(),
                    price2: $("#updatePrice2").val(),
                    price3: $("#updatePrice3").val()
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

deleteCourse = function() {
    $.ajax(
        {
            url: "/admin/courses/deleteCourse?id=" + $("#updateId").val(),
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