$(document).ready(function () {
    $("body").on("change", "#email", function (e) {
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
                if (!$("#email").val()) {
                    $('#email_error').hide();
                    $("#submitbutton").removeAttr("disabled");
                    $("#submitbutton").attr("disable", false)
                } else {
                    $('#email_error').show();
                    $("#email_error").html(msg);
                    if (msg === "<span style='color:red;'>Login unavailable</span>") {
                        $("#submitbutton").attr("disabled", true);
                    } else {
                        $("#submitbutton").removeAttr("disabled");
                        $("#submitbutton").attr("disable", false)
                    }
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#email_error').show();
                $("#email_error").html(textStatus + " " + errorThrown);
            }
        });
    });
});