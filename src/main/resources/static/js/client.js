$('document').ready(function(){
    $('.editButton').on('click',function(e){
    e.preventDefault();
     let href = $(this).attr('href');

     $.get(href,function(client,status){
     $('#editId').val(client.id);
     $('#editName').val(client.name);
     $('#editDetails').val(client.details);
     $('#editCountry').val(client.countryid);

     $('#editState').val(client.stateid);
     $('#editAddress').val(client.address);
     $('#editCity').val(client.city);
     $('#editEmail').val(client.email);
     $('#editPhone').val(client.phone);
     $('#editMobile').val(client.mobile);
     $('#editWebsite').val(client.website);

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