$(document).ready(function(){
    $('.modal').modal();
});

seminar = {
    save : function () {
        var listSeminar = {
            nameSeminar: $('#createName').val()
        };

        $.ajax({
            url: '/api/v1/seminars',
            type: 'post',
            data: JSON.stringify(listSeminar),
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
        }).done(function () {
            location.href="/api/v1/seminars/?page=1";
        }).fail(function () {
            alert('Please try again');
        });
    }
};

function save() {
    seminar.save();
}