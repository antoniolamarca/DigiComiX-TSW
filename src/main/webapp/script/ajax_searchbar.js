

function ajax_searchbar() {
    var xhttp = new XMLHttpRequest();
    var text = document.getElementById("searchbar").value;
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            document.getElementById("catalogo").innerHTML = xhttp.responseText;
        } else if (this.readyState === 4) {
        }
    };

    var url = getContextPath() + "/CercaArticoli";

    xhttp.open("GET", url + "?text=" + text);
    xhttp.send();
}

function getContextPath() {
    var path = window.location.pathname;
    return path.substring(0, path.indexOf('/', 1));
}