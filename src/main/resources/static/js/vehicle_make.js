$('document').ready(function(){
    $('.editButton').on('click',function(e){
    e.preventDefault();
     let href = $(this).attr('href');

     $.get(href,function(vehicle_make,status){
     $('#editId').val(vehicle_make.id);
     $('#editDescription').val(vehicle_make.description);
     $('#editDetails').val(vehicle_make.details);


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