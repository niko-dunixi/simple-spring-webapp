// If the enter key is pressed in the input box, we navigate to the greeting page.
$(document).ready(function () {
    $("#name").bind('keypress', function (e) {
        if (e.which == 13) {
            var name = $(this).val();
            window.location = "/greeting?name=" + name;
        }
    });
});