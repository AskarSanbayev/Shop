$(document).ready(function () {
    $("body").on("click", "#submit_button", function (e) {
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
                        $('#error_message').show();
                        $("#error_message").html(msg);
                        $("#form-signin").removeAttr("action");
                    } else {
                        $('#error_message').hide();
                        $("#form-signin").attr("action", "controller?command=signUser");
                    }
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    $('#error_message').show();
                    $("#error_message").html(textStatus + " " + errorThrown);
                }
            })
        }
    });
});