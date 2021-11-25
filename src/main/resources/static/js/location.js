$('document').ready(function(){
    $('.editButton').on('click',function(e){
    e.preventDefault();
     let href = $(this).attr('href');

     $.get(href,function(location,status){
     $('#editId').val(location.id);
     $('#editDetails').val(location.details);
     $('#editCountry').val(location.countryid);
     $('#editDescription').val(location.description);
     $('#editState').val(location.stateid);
     $('#editAddress').val(location.address);
     $('#editCity').val(location.city);

     })
    $('#editModal').modal();


    })

    $('.deleteButton').on('click', function(e){
        e.preventDefault();

        let href = $(this).attr('href');

        $('#confirmDelete').attr('href', href);
        $('#deleteModal').modal();

    })


})