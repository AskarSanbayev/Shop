$(document).ready(function () {
    $("body").on("blur", "#inputPassword", function (e) {
        $('#error_message').hide();
        if ($("#inputEmail").val() && $("#inputPassword").val()) {
            $.ajax({
                type: "POST",
                url: "http://localhost:8888/login",
                data: $('#form-signin').serialize(),
                dataType: "html",
                headers: {
                    'Access-Control-Allow-Origin': '*'
                },
                cache: false,
                success: function (msg) {
                    if (msg === "<span style='color:red;'>Login or password is wrong</span>") {
                        $('#submitter').attr("disabled", true);
                        $('#error_message').show();
                        $("#error_message").html(msg);

                    } else {
                        $('#submitter').removeAttr("disabled");
                        $('#submitter').attr("disabled", false)
                        $('#error_message').hide()
                    }
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    $('#email_error').show();
                    $("#email_error").html(textStatus + " " + errorThrown);
                }
            });
        }
    });
});