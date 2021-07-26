// init collapsible
var elems = document.querySelectorAll('.collapsible');
var instances = M.Collapsible.init(elems, {});



(function ($) {
  $(function () {

    $('.sidenav').sidenav();

  }); // end of document ready
})(jQuery); // end of jQuery name space
