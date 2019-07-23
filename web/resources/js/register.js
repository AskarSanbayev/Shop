$(document).ready(function () {
    $("body").on("blur", "#email", function (e) {
        $('#email_error').hide();
        $.ajax({
            type: "POST",
            url: "http://localhost:8888/authServlet",
            data: $('#register').serialize(),
            dataType: "html",
            headers: {
                'Access-Control-Allow-Origin': '*'
            },
            cache: false,
            success: function (msg) {
                $('#email_error').show();
                $("#email_error").html(msg);
                if (msg === "<span style='color:red;'>Login unavailable</span>") {
                    $("#submitbutton").attr("disabled", true);
                } else {
                    $("#submitbutton").removeAttr("disabled");
                    $("#submitbutton").attr("disable", false)
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#email_error').show();
                $("#email_error").html(textStatus + " " + errorThrown);
            }
        });
    });
});