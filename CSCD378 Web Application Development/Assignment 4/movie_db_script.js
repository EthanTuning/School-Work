$(document).ready(init);

function init() {

    popupNewForm();
    selectCall();
    $('#add-ok').click(insertCall);
    $('#refresh-btn').click(selectCall);
    $('body').on('click', '.delete-btn', delCall);
    $('body').on('click', '.edit-btn', popupUpdateForm);
    $('#update-ok').click(updateCall);
}

function insertCall() {

    $.post('insert.php', $('#add-form').serializeArray());
}

function delCall(evt) {

    $.post('delete.php', {
        movie_id: evt.target.id
    });
}

function updateCall() {

    $.post('update.php', $('#update-form').serializeArray());
}

function selectCall() {

    clear();
    $.ajaxSetup({
        headers: {
            "Accept": "application/json"
        }
    });

    $.getJSON('select.php', function (data) {
        console.log(data);
        formatData(data);
    });
}

function formatData(data) {

    var finalData = parseJSONintoTable(data);
    $('#data').append(finalData.toString());
}

function parseJSONintoTable(data) {

    var str = '';

    data.map(function (movie) {
        str += "<tr id='" + movie.movie_id + "'>" + "<td>" + movie.movie_name + "</td>" +
            "<td>" + movie.movie_year + "</td>" +
            "<td>" + movie.movie_studio + "</td>" +
            "<td>" + movie.movie_desc + "</td>" +
            "<td>" + movie.movie_price + "</td>" +
            "<td><button id='" + movie.movie_id + "'class='edit-btn'>Edit</button></td>" +
            "<td><button id='" + movie.movie_id + "'class='delete-btn'>Delete</button></td>" +
            "</tr>";
    });
    return str;
}

function clear() {

    $('#data').empty();
}

function popupNewForm() {

    $('#new-btn').click(function () {

        $('#add-form-container').fadeToggle();
    })

    $(document).mouseup(function (e) {
        var container = $("#add-form-container");

        if (!container.is(e.target) && container.has(e.target).length === 0) {
            container.fadeOut();
        }
    });
}

function popupUpdateForm(evt) {

    $('#update-id').val(evt.target.id);
    $('#update-form-container').fadeToggle();
    
    $(document).mouseup(function (e) {
        var container = $("#update-form-container");

        if (!container.is(e.target) && container.has(e.target).length === 0) {
            container.fadeOut();
        }
    });
}
