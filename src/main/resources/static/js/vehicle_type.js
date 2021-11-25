$('document').ready(function(){
    $('.editButton').on('click',function(e){
    e.preventDefault();
     let href = $(this).attr('href');

     $.get(href,function(vehicle_type,status){
     $('#editId').val(vehicle_type.id);
     $('#editDescription').val(vehicle_type.description);
     $('#editDetails').val(vehicle_type.details);


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