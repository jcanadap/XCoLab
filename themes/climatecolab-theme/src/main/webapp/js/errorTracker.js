

jQuery( document ).ready(function() {

    var a = ["Portlet unavailable", "Internal error has ocurred, please contact the administrator."]; // Add more error messages here
    a.forEach(function(errorMessage) {
        var body = document.body;
        //Cross browser compatibility
        text = body.textContent || body.innerText;

        if (text.match(errorMessage)){
            jQuery('#popup_error_reporting').show();
        }
    });
});