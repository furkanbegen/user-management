$(document).ready(function () {
    $("#userTable").hide();
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/user',
        data: {
            contentType: 'application/json',
            responseType: 'application/json'
        },
        error: function (data) {
            $('.error').html('<p>' + data + '</p>');
        },
        dataType: 'json',
        success: function (data) {
            $("#userTable").show();
            $.each(data, function(key, value) {
                $("#userTable tbody").append("<tr> <td>" + value.firstName + "</td>\n" +
                     "            <td>" + value.lastName + "</td>\n" +
                     "            <td><a href='"+ value.id +"' class='updateUser'><i class=\"fa fa-cog\" ></i></a></td>\n" +
                     "            <td><a href='"+ value.id +"' class='deleteUser'><i class=\"fa fa-times\n\"></i></a></td></tr>\n");
            });
            console.log(typeof data);
        },
    }, 3000);

    $(document).on ("click", ".updateUser", function () {
        event.preventDefault();
        $("#updateUserModal").modal('show');
        var userId = $(this).attr('href');
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/user/'+ userId,
            data: {
                contentType: 'application/json',
                responseType: 'application/json'
            },
            beforeSend: function () {
                $(".loading").show();
            },
            error: function (e) {
                $('.error').html('<p>' + e + '</p>');
            },
            dataType: 'json',
            success: function (data) {
                $('input[name=updateFirstName]').val(data.firstName);
                $('input[name=updateLastName]').val(data.lastName);
                $('input[name=updatePhoneNumber]').val(data.phoneNumber);
                $('input[name=userId]').val(userId);
            },
        }, 3000);
    });

    $(document).on ("click", ".deleteUser", function () {
        event.preventDefault();
        $("#deleteUserModal").modal('show');
        var userId = $(this).attr('href');
        $('input[name=deleteUserId]').val(userId);
    });

    $('#createNewUserButton').click(function (event) {
        event.preventDefault();
        var firstName  = $("#firstName").val();
        var lastName  = $("#lastName").val();
        var phoneNumber  = $("#phoneNumber").val();
        var formData = {
            "firstName" : firstName,
            "lastName" : lastName,
            "phoneNumber" : phoneNumber
        };
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/user/',
            data: JSON.stringify(formData),
            contentType: "application/json",
            beforeSend: function () {
                $("#loading").show();
            },
            error: function (textStatus, jqXHR) {
                $(".error").html("");
                $.each(textStatus.responseJSON, function(key, value) {
                    $(".error").append("<p>" + value.defaultMessage + "</p>");
                });
            },
            success: function () {
                $("#loading").hide();
                location.reload();
            },

        }, 3000);
    });

    $('#updateUserButton').click(function (event) {
        event.preventDefault();
        var firstName  = $("#updateFirstName").val();
        var lastName  = $("#updateLastName").val();
        var phoneNumber  = $("#updatePhoneNumber").val();
        var userId  = $("#userId").val();
        var formData = {
            "firstName" : firstName,
            "lastName" : lastName,
            "phoneNumber" : phoneNumber
        };
        $.ajax({
            type: 'PUT',
            url: 'http://localhost:8080/user/'+ userId,
            data: JSON.stringify(formData),
            contentType: "application/json",
            beforeSend: function () {
                $("#loading").show();
            },
            error: function (textStatus) {
                $.each(textStatus.responseJSON, function(key, value) {
                    $(".error").append("<p>" + value.defaultMessage + "</p>");
                });
            },
            success: function () {
                $("#loading").hide();
                location.reload();
            },

        },3000);
    });

    $('#deleteUserButton').click(function (event) {
        event.preventDefault();
        var userId  = $("#deleteUserId").val();
        $.ajax({
            type: 'DELETE',
            url: 'http://localhost:8080/user/'+ userId,
            contentType: "application/json",
            beforeSend: function () {
                $(".loading").show();
            },
            error: function (e) {
                $('.error').html('<p>' + e + '</p>');
            },
            success: function () {
                $("#loading").hide();
                location.reload();
            },

        }, 3000);
    });

    $(document).ajaxStart(function () {
        $(".loading").show();
    }).ajaxStop(function () {
        $(".loading").hide();
    });
});